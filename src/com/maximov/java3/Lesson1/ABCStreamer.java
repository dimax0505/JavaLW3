package com.maximov.java3.Lesson1;




public class ABCStreamer {


    public static void main(String[] args) {
        MyList myList = new MyList();
        Printer printer1 = new Printer('A', myList);
        Printer printer2 = new Printer('B', myList);
        Printer printer3 = new Printer('C', myList);

        new Thread(printer1).start();
        new Thread(printer2).start();
        new Thread(printer3).start();

        LineWriterInFile lineWriterInFile1 = new LineWriterInFile(myList);
        LineWriterInFile lineWriterInFile2 = new LineWriterInFile(myList);
        LineWriterInFile lineWriterInFile3 = new LineWriterInFile(myList);

        new Thread(lineWriterInFile1).start();
        new Thread(lineWriterInFile2).start();
        new Thread(lineWriterInFile3).start();
    }


}

