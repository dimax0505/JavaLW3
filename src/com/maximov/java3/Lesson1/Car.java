package com.maximov.java3.Lesson1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private int stage;
    private CyclicBarrier cb;
    private CountDownLatch cdl;


    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    int getStage(){return stage;}

    int getStageCount(){
        return race.getStages().size();
    }

    CountDownLatch getCdl(){return cdl;}

    Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl) {
        this.cdl = cdl;
        this.cb = cb;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            if (cb.getNumberWaiting() == cb.getParties() - 1)
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            stage = i;
            race.getStages().get(i).go(this);

        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
         void isWin(){
            if ((Main.CARS_COUNT - cdl.getCount()) == 1) System.out.println(this.name + " Занял 1-e место");
                else if((Main.CARS_COUNT - cdl.getCount()) == 2)System.out.println(this.name + " Занял 2-e место");
               else if((Main.CARS_COUNT - cdl.getCount()) == 3) System.out.println(this.name + " Занял 3-e место");
            }
        }
