package com.petscare.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class CSVUpdater {
    private static final String INDEX_FILE = "src/test/resources/index.txt";

    public static void updateCSVFile() {

        String tempFile = "src/test/resources/csvFiles/newUserRegistrationNew.csv";
        String filePath = "src/test/resources/csvFiles/newUserRegistrationNew.csv";
        String usedEmailsFile = "src/test/resources/csvFiles/usedEmails.csv";

        int currentIndex = getCurrentIndex(); // Получаем текущий индекс
        System.out.println("Текущий индекс: " + currentIndex); // Выводим текущий индекс для отладки

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lines.isEmpty()) {
            System.out.println("Ошибка: CSV-файл пуст или не удалось его прочитать.");
            return;
        }

        System.out.println("Количество строк в файле: " + lines.size());

        if (currentIndex >= lines.size()) {
            System.out.println("Достигнут конец файла. Сбрасываю индекс до 0.");
            currentIndex = 0;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
             BufferedWriter usedEmailsWriter = new BufferedWriter(new FileWriter(usedEmailsFile, true))) {

            for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
                String line = lines.get(lineNumber);
                System.out.println("Чтение строки #" + lineNumber + ": " + line); // Выводим информацию о строке

                if (lineNumber == currentIndex) {
                    String emailName = line.trim();

                    // Проверка наличия числовой части
                    String numericPart = emailName.replaceAll("\\D+", "");
                    String namePart = emailName.replaceAll("\\d+", "");
                    long number;
                    try {
                        number = numericPart.isEmpty() ? 0 : Long.parseLong(numericPart);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка преобразования числа для строки: " + emailName);
                        writer.write(line);
                        if (lineNumber < lines.size() - 1) writer.newLine(); // Добавляем перенос строки, если не последняя строка
                        continue; // Пропускаем текущую строку, если не удалось преобразовать число
                    }

                    number++;
                    String newEmail = namePart + number;

                    System.out.println("Обновление строки: " + emailName + " -> " + newEmail);

                    writer.write(newEmail);

                    usedEmailsWriter.write(emailName);
                    usedEmailsWriter.newLine();

                    currentIndex++; // Обновляем индекс для следующего прохода
                } else {
                    writer.write(line);
                }

                // Добавляем перенос строки, если это не последняя строка
                if (lineNumber < lines.size() - 1) {
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

// Проверка наличия временного файла и его размера перед заменой основного файла
        File temp = new File(tempFile);
        if (temp.exists() && temp.length() > 0) {
            try {
                Files.move(Paths.get(tempFile), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Ошибка: временный файл пуст или не был создан.");
        }

        saveCurrentIndex(currentIndex); // Сохраняем обновленный индекс
    }

    private static int getCurrentIndex() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INDEX_FILE))) {
            String index = reader.readLine();
            return index == null ? 0 : Integer.parseInt(index);
        } catch (IOException e) {
            System.out.println("Не удалось прочитать index.txt, начинаю с 0");
            return 0;
        }
    }

    private static void saveCurrentIndex(int index) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INDEX_FILE))) {
            writer.write(String.valueOf(index));
            System.out.println("Сохранение индекса: " + index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
