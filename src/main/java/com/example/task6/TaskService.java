package com.example.task6;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class TaskService {

    private final long startTime; // Стартовий час

    public TaskService() {
        // ініціалізація часу при створенні об'єкта
        this.startTime = System.currentTimeMillis();
    }

    @Async
    public void executeRepeatedTask() {

        try {
            while (true) {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Задача виконана. Кожні 10 секунд.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Scheduled(fixedRate = 1000)  // ми використовуємо fixedRate для того, щоб метод виконувався кожну секунду
    public void executeRandomTimeTask() {
        try {
            // Випадковий час від 1 до 10 секунд
            int delay = new Random().nextInt(10) + 1;
            Thread.sleep(delay * 1000);  // чекаємо випадковий інтервал

            // Виведення часу, що минув з моменту запуску програми
            long elapsedTimeInSeconds = (System.currentTimeMillis() - startTime) / 1000;
            System.out.println("Поточний час виконання: " + elapsedTimeInSeconds + " секунд від запуску.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
