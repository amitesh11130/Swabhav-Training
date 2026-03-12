package com.swabhav.homework;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesserGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		String playAgain;

		System.out.println("Let's Play Number Guesser!");

		do {
			int randomNumber = rand.nextInt(100) + 1;
			int guess = 0;
			int attempts = 0;
			int maxAttempts = 5;

			System.out.println("\nMaximum possible attempts -> " + maxAttempts);
			System.out.println("Guess a number between 1 and 100");

			while (attempts < maxAttempts) {
				System.out.print("Guess a number: ");

				if (sc.hasNextInt()) {
					guess = sc.nextInt();

					if (guess < 1 || guess > 100) {
						System.out.println("Invalid input! Enter a number between 1 and 100.");
						continue;
					}

					attempts++;

					if (guess < randomNumber) {
						System.out.println("Sorry, Too Low");
					} else if (guess > randomNumber) {
						System.out.println("Sorry, Too High");
					} else {
						System.out.println("You won in attempt: " + attempts);
						break;
					}
				} else {
					System.out.println("Invalid input! Please enter a number.");
					sc.next();
				}
			}

			if (guess != randomNumber) {
				System.out.println("Game Over! The correct number was: " + randomNumber);
			}

			System.out.print("Do you want to play the game again? (yes/no): ");
			playAgain = sc.next().trim().toLowerCase();
			while (!playAgain.equals("yes") && !playAgain.equals("no") && !playAgain.equals("y")
					&& !playAgain.equals("n")) {
				System.out.print("Invalid input! Please enter 'y'/'yes' or 'n'/'no' : ");
				playAgain = sc.next();
			}

		} while (playAgain.equals("yes") || playAgain.equals("y"));

		System.out.println("Thank you for playing!");
		sc.close();
	}
}