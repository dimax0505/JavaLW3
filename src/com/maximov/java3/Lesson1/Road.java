package com.maximov.java3.Lesson1;


public class Road extends Stage {
    Road(int length) {

        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (c.getCdl()) {
            System.out.println(c.getName() + " закончил этап: " + description);
            if (c.getStage() == c.getStageCount() - 1) {
                c.getCdl().countDown();
                c.isWin();
            }
        }


    }
}