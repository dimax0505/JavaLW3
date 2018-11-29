package com.maximov.java3.Lesson1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class Main {
    private static final String FILE_BYTE_TXT = "fileByte.txt";
    private static final String[] FILE_BYTE_TXT_FIVE = {"fileByte1.txt", "fileByte2.txt", "fileByte3.txt", "fileByte4.txt", "fileByte5.txt"};
    private static final String FILE_COMBINE = "fileCombine.txt";


    public static void main(String[] args)throws IOException {
        SequenceInputStream seq = null;
        File fileByte = new File(FILE_BYTE_TXT);


        makeFileByte(50, FILE_BYTE_TXT); //делаем файл 50 байт
        System.out.println(Arrays.toString(readFileByte(FILE_BYTE_TXT))); //читаем из сделанного ранее файла все байты и выводим в консоль
        for (int i = 0; i < FILE_BYTE_TXT_FIVE.length; i++) {
            makeFileByte(100, FILE_BYTE_TXT_FIVE[i]);
            System.out.println(Arrays.toString(readFileByte(FILE_BYTE_TXT_FIVE[i])));
        }
        combineFile(seq);

        System.out.println(Arrays.toString(readFileByte(FILE_COMBINE)));


        System.out.println(fileByte.exists());

    }

    private static void combineFile(SequenceInputStream seq) throws IOException {

        ArrayList<InputStream> al = new ArrayList<>();
        try {
            for (int i = 0; i < FILE_BYTE_TXT_FIVE.length; i++) {
                FileInputStream input = new FileInputStream(FILE_BYTE_TXT_FIVE[i]);
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
            in.read(bytes);
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
}
