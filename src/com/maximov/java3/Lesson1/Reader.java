package com.maximov.java3.Lesson1;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    private static final String FILE_TXT = "fileTxt.txt";//имя читаемого файла
    private static int number;
    //параметры вывода страницы в консоль
    private static int stringLenght = 100; //количество символов в строке
    private static int listHeight = 18; //количество строк
    private static int listSyze = 1800; //количество символов на странице

    public static void main(String[] args) {
        RequestOfNumber();
        long time = System.currentTimeMillis();
        randomAccess(number, FILE_TXT);
        time = (System.currentTimeMillis() - time);
        System.out.printf("Время выполнения запроса: %.3f сек", (double) time / 1000);

    }

    private static void RequestOfNumber() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите номер страницы: ");

            try {
                number = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Вводим только числа типа Integer");
            }
        }
        while (!isValidNumber(number, FILE_TXT));
    }

    private static boolean isValidNumber(int number, String file) {
        number *= listSyze;
        try (FileInputStream in = new FileInputStream(file)) {
            if (in.available() - listSyze > number) return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void randomAccess(int pos, String file) {
        pos *= listSyze;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            for (int j = 0; j < listHeight; j++) {
                for (int i = (j * stringLenght); i < ((j * stringLenght) + stringLenght); i++) {
                    raf.seek(pos + i);
                    System.out.print((char) raf.read());
                }
                System.out.println();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
