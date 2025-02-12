document.addEventListener("DOMContentLoaded", function () {
    const textElement = document.querySelector(".hero h1");
    const words = ["QA Tester", "Developer"];
    let wordIndex = 0;
    let charIndex = words[wordIndex].length; // Начинаем с полностью написанного слова
    let isDeleting = true; // Начинаем с удаления

    function typeEffect() {
        let currentWord = words[wordIndex];
        let displayText = currentWord.substring(0, charIndex);
        textElement.textContent = `I'M ${displayText}`;

        if (isDeleting) {
            // Удаляем буквы
            charIndex--;
            if (charIndex === 0) {
                isDeleting = false;
                wordIndex = (wordIndex + 1) % words.length;
            }
        } else {
            // Печатаем буквы
            charIndex++;
            if (charIndex > currentWord.length) {
                setTimeout(() => {
                    isDeleting = true; // Начинаем удаление
                    typeEffect(); // Сразу переходим к удалению
                }, 3000); // Пауза 2 секунды после печати
                return;
            }
        }

        setTimeout(typeEffect, isDeleting ? 150 : 200); // Скорость печати и удаления
    }

    // Запускаем удаление через 2 секунды после загрузки страницы
    setTimeout(typeEffect, 2500);
});
