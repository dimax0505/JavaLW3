package com.maximov.java3.Lesson1;

import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_BYTE_TXT = "fileByte.txt";
    private static final String[] FILE_BYTE_TXT_FIVE = {"fileByte1.txt", "fileByte2.txt", "fileByte3.txt", "fileByte4.txt", "fileByte5.txt"};
    private static final String FILE_COMBINE = "fileCombine.txt";
    private static final String FILE_TXT = "fileTxt.txt";


    public static void main(String[] args) throws IOException {
        SequenceInputStream seq = null;
        //   File fileByte = new File(FILE_BYTE_TXT);

        makeFileByte(50, FILE_BYTE_TXT); //делаем файл 50 байт
        System.out.println(Arrays.toString(readFileByte(FILE_BYTE_TXT))); //читаем из сделанного ранее файла все байты и выводим в консоль
        for (String aFILE_BYTE_TXT_FIVE : FILE_BYTE_TXT_FIVE) {
            makeFileByte(100, aFILE_BYTE_TXT_FIVE); //делаем пять файлов по 100 байт
            System.out.println(Arrays.toString(readFileByte(aFILE_BYTE_TXT_FIVE)));//и выводим их поочереди в кончоль
        }
        combineFile(seq);//собираем пять файлов в один

        System.out.println(Arrays.toString(readFileByte(FILE_COMBINE)));//выводим собранный файл в консоль

        makeFileTxt(FILE_TXT);//создаем текстовый файл 15 Мб
    }

    private static void makeFileTxt(String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            //char [] ch = new char[100];
            for (int i = 0; i < 15000000; i++)
                out.write(randomACSIICharacter());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static void combineFile(SequenceInputStream seq) throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();
        try {
            for (String aFILE_BYTE_TXT_FIVE : FILE_BYTE_TXT_FIVE) {
                FileInputStream input = new FileInputStream(aFILE_BYTE_TXT_FIVE);
                al.add(input);
            }
            Enumeration<InputStream> e = Collections.enumeration(al);
            seq = new SequenceInputStream(e);
            FileOutputStream out = new FileOutputStream(FILE_COMBINE);
            int rb;
            while ((rb = seq.read()) != -1) {
                out.write(rb);
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            seq.close();
        }
    }

    private static byte[] readFileByte(String fileName) {
        try (FileInputStream in = new FileInputStream(fileName)) {
            byte[] bytes = new byte[in.available()];
            System.out.printf("прочитали %d байт\n", in.read(bytes));
            return (bytes);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return null;
    }

    private static void makeFileByte(int syze, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            out.write(makeByteArray(syze));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static byte[] makeByteArray(int syze) {
        byte[] bytes = new byte[syze];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (i - 128);
        }
        return bytes;
    }

    public static char randomACSIICharacter() {
        Random r = new Random();
        return (char) (48 + r.nextInt(47));
    }
}
