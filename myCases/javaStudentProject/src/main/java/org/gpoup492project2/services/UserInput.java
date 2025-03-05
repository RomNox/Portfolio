package org.gpoup492project2.services;

import org.gpoup492project2.entity.Priority;
import org.gpoup492project2.entity.Status;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    public int inputInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int input = scanner.nextInt();
        return input;
    }

    public double inputDouble(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        double input = scanner.nextDouble();
        return input;
    }

    public String inputText(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }

    public Status inputStatus(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();
        Status taskStatus = Status.valueOf(input.toUpperCase());
        return taskStatus;
    }

    public Priority inputPriority(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();
        Priority taskPriority = Priority.valueOf(input.toUpperCase());
        return taskPriority;
    }

    public List<String> inputText1(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();
        return Collections.singletonList(input);
    }

}