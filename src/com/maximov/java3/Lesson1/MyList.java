package com.maximov.java3.Lesson1;

import java.io.*;


public class MyList {
    char print = 0;
    char previousprint = 0;
    BufferedWriter bw=null;


    public synchronized void print(char print) {
        if (print == 'C') System.out.println();
        while (print == this.print || print == this.previousprint) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(print);
        this.previousprint = this.print;
        this.print = print;
        notifyAll();
    }


    public synchronized void makeFileTxt(String fileName, LineWriterInFile lineWriterInFile) {

        while (lineWriterInFile.getLock()){
            try {
                wait();
                lineWriterInFile.setLock(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            try  {
                bw = new BufferedWriter(new FileWriter(fileName, true));
                   bw.write(Thread.currentThread().getName() + "\n");
                   bw.close();
            } catch(IOException e){
                e.printStackTrace();
            }
         //   notifyAll();
    }
}
