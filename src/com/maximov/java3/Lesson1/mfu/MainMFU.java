package com.maximov.java3.Lesson1.mfu;

public class MainMFU {

    public static void main(String[] args) {
        WorkingMFU workingMFU = new WorkingMFU();
        PrinterMFU printerMFU = new PrinterMFU(workingMFU);
        ScannerMFU scannerMFU = new ScannerMFU(workingMFU);

        Thread t1 = new Thread(printerMFU);
        Thread t2 = new Thread(scannerMFU);

        t1.start();
        t2.start();

        while (t2.isAlive() || t1.isAlive()) {
            try {
                Thread.sleep(50);
                System.out.printf("Напечатано %d страниц, отсканированно %d страниц \n", printerMFU.getPrinted(), scannerMFU.getScanned());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
