package com.maximov.java3.Lesson1;

import java.io.IOException;

public class LineWriterInFile extends Thread implements Runnable{
    MyList myList;
    Boolean lock = false;

    LineWriterInFile(MyList myList){
        this.myList=myList;
    }

    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myList.makeFileTxt("fileLine.txt", this);
        }

    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }
}
