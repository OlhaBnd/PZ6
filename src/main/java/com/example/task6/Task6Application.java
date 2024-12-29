package com.example.task6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Scanner;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Task6Application {

	private static final TaskService taskService = new TaskService();

	public static void main(String[] args) {
		SpringApplication.run(Task6Application.class, args);


		Scanner scanner = new Scanner(System.in);
		System.out.println("Чи хочете виконувати задачу кожні 10 секунд? (Y/N)");


		taskService.executeRandomTimeTask();

		String userChoice;
		while (true){
			userChoice = scanner.nextLine();

			if ("Y".equalsIgnoreCase(userChoice)) {
				taskService.executeRepeatedTask();
			} else {
				System.out.println("Задача пропущена.");
			}

		}

	}




}
