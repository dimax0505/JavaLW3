package com.maximov.java3.Lesson1.mfu;

public class ScannerMFU extends Thread implements Runnable {
    WorkingMFU workingMFU;


    ScannerMFU(WorkingMFU workingMFU) {
        this.workingMFU = workingMFU;
    }


    public void run() {
        for (int i = 1000; i > 0; i--) {
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            workingMFU.scanning();
        }
    }

    int getScanned() {
        return workingMFU.getScanList();
    }
}
