package com.maximov.java3.Lesson1;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        Semaphore smp = new Semaphore(CARS_COUNT / 2);
        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(smp), new Road(40));


        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryBuilder()
                .setNameFormat("Car - %s")
                .build());

        List<Callable<Object>> tasks = IntStream.range(0, CARS_COUNT)
                .mapToObj(index -> new Car(race, 20 + (int) (Math.random() * 10), cb, cdl))
                .map(Executors::callable)
                .collect(Collectors.toList());


        executorService.invokeAll(tasks);
        cdl.await();
        executorService.shutdownNow();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
