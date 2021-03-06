package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	Scanner sc = new Scanner(System.in); // creating scanner
	FoodTruck[] foodtrucks = new FoodTruck[5]; // array at class level so it can be seen

	public static void main(String[] args) { // creating main
		FoodTruckApp ftApp = new FoodTruckApp(); // building new class object
		ftApp.begin(); // passing scanner to new object to avoid scope issues and static
	}

	public void begin() { // building new method for intro and to pull user input
		System.out.println(" ____________________________________________________________________");
		System.out.println("|            Welcome to the Food Truck Rating System!                |");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("|     Please enter a review of your own to gain access to others!    |");
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("|       You can enter up to five Food Trucks you have visited.       |");
		System.out.println("|--------------------------------------------------------------------|");
		// iterating loop for possibility of five inputs
		for (int i = 0; i < 5; i++) {
			// prompt the user for the Food Trucks name
			System.out.println("|     What is the name of the Food Truck you would like to review?   |");
			System.out.println("|--------------------------------------------------------------------|");
			System.out.println("");
			if (i >= 1) {
				sc.nextLine();
			} // <<<<<<<<<<<<<<<< This is what I was missing on the first submission. Bug
				// caused ftName = sc.nextLine
			String ftName = sc.nextLine();// to never prompt after first iteration. I imagine it was due to the buffer
											// needing to be flushed.
			if (ftName.equals("quit")) { // loop exit if user enters 'quit'
				break;
			}
			System.out.println("|--------------------------------------------------------------------|");
			System.out.println("|        What is the primary food type this Food Truck offered?      |");
			System.out.println("|--------------------------------------------------------------------|");
			String ftType = sc.nextLine(); // prompt the user asking for a rating
			System.out.println("|--------------------------------------------------------------------|");
			System.out.println("|   On a scale of 1 - 10, how satisfied were you with your visit?    |");
			System.out.println("|--------------------------------------------------------------------|");
			double ftRating = sc.nextInt(); // prompt the user asking for a rating
			FoodTruck newFt = new FoodTruck(ftRating, ftName, ftType);// create new food truck object
			this.foodtrucks[i] = newFt; // assign food new food truck object to array[i]
			System.out.println("|--------------------------------------------------------------------|");
			System.out.println("|  Feel free to stick around and enter more reviews if you have any. |");
			System.out.println("|                  It's how our community grows!                     |");
			System.out.println("|   If you're all done, just type 'quit' in the naming field below!  |");
			System.out.println("|--------------------------------------------------------------------|");
		}
		boolean run = true;
		while (run == true) { // keep running

			System.out.println("Thank you! Your opinion matters! Welcome to the community!");
			System.out.println();
			System.out.println(); // UI
			System.out.println(" ______________________________________________________");
			System.out.println("|            Food Truck Rating System Window           |");
			System.out.println("|       Below, you can select from a few options!      |");
			System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
			System.out.println("|    To see ALL of our community reviews press     [1]!|");
			System.out.println("|------------------------------------------------------|");
			System.out.println("| To see the AVERAGE of our existing ratings press [2]!|");
			System.out.println("|------------------------------------------------------|");
			System.out.println("|   To display the HIGHEST RATED Food Truck press  [3]!|");
			System.out.println("|------------------------------------------------------|");
			System.out.println("|      If you are done for the day, just press     [4]!|");
			System.out.println(" ------------------------------------------------------ ");
			int response = sc.nextInt();
			switch (response) { // pulling to view all trucks
			case 1:
				for (int i = 0; i < foodtrucks.length; i++) {
					if (foodtrucks[i] != null) {
						System.out.println(foodtrucks[i].toString());
					}
				}
				break; // return to UI
			case 2:
				double sumOfRatings = 0; // sum of all trucks calculate + pull
				int count = 0;
				for (int i = 0; i < foodtrucks.length; i++) {
					if (foodtrucks[i] != null) {
						sumOfRatings += foodtrucks[i].getFtRating();
						count++;
					}
				}
				System.out.println((sumOfRatings/count)); // print average of all trucks
				break; // return to UI //highest rated trucks calculate +pull
			case 3:

				FoodTruck highestRating = foodtrucks[0];
				for (int i = 1; i < foodtrucks.length; i++) {
					if (foodtrucks[i] != null) {
						if (foodtrucks[i].getFtRating() > highestRating.getFtRating()) {
							highestRating = foodtrucks[i];
						}
					} // print highest rating
				}
				System.out.println(highestRating);
				break; // return to UI
			case 4:
				System.out.println(" Thanks for stopping by, we can't wait to see you soon!");
				System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				run = false;
				break; // exit
			}
		}
	}
}
