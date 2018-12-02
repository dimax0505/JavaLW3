package com.maximov.java3.Lesson1.mfu;

public class WorkingMFU {
    private int printList = 0;
    private int scanList = 0;

    public synchronized void printing() {
        this.printList++;

    }

    public synchronized void scanning() {
        this.scanList++;

    }

    public int getPrintList() {
        return printList;
    }

    public int getScanList() {
        return scanList;
    }
}



