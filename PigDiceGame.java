package com.swabhav.homework;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int totalScore = 0;
		int turnNumber = 0;

		System.out.println("Let's Play PIG Dice!");
		System.out.println("* See how many turns it takes you to get to 20.");
		System.out.println("* Turn ends when you hold or roll a 1.");
		System.out.println("* If you roll a 1, you lose all points for the turn.");
		System.out.println("* If you hold, you save all points for the turn.");

		while (totalScore < 20) {

			turnNumber++;
			int turnScore = 0;
			boolean turnOver = false;

			System.out.println("TURN " + turnNumber);

			while (!turnOver) {

				System.out.print("Roll or hold? (r/h): ");
				String choice = scanner.nextLine().toLowerCase();

				if (!choice.equals("r") && !choice.equals("h")) {
					System.out.println("Invalid input! Please enter 'r' to roll or 'h' to hold.");
					continue;
				}

				if (choice.equals("r")) {
					int die = random.nextInt(6) + 1;
					System.out.println("Die: " + die);

					if (die == 1) {
						turnScore = 0;
						System.out.println("Turn over. No score.");
						turnOver = true;
					} else {
						turnScore += die;
					}
				} else {
					totalScore += turnScore;
					System.out.println("Score for turn: " + turnScore);
					System.out.println("Total score: " + totalScore );
					turnOver = true;
				}
			}
		}

		System.out.println("You finished in " + turnNumber + " turns!");
		System.out.println("Game over!");

		scanner.close();
	}

}
