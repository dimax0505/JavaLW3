package com.maximov.java3.Lesson1;

public class Printer extends Thread implements Runnable {

    MyList myList;
    char print;

    Printer(char print, MyList list) {
        this.myList = list;
        this.print = print;
    }

    public void run() {
        for (int i = 1000; i > 0; i--) {
            myList.print(print);

        }
    }
}


