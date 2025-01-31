	/*	
	 * Program to record the birds names and the cases of their observations.
	 * Program flow: - declare a map to save the birds names as keys and their Latin
	 * names as values - create menu of options with add, observation, all, one,
	 * quit - prompt to the user to enter the command - if command is 'add': add the
	 * names to the map if the name is empty - handle - if command is 'observation':
	 * enter a name and increment the cases of observation - if command is 'all':
	 * iterate the map and print names - if command is 'one': prompt for a name and
	 * print the bird's name, Latin name and number of observations; - if command is
	 * 'quit' - exit the program
	 */

package birdObservations;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

	// Create Map
	private static Map<String, String> birdMap = new HashMap<>();
	private static Map<String, Integer> birdObservations = new HashMap<>();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

	

		// Options
		System.out.println("Enter a command: ");
		System.out.println("Add - adds a bird");
		System.out.println("Observation - adds an observation");
		System.out.println("All - prints all birds");
		System.out.println("One - prints one bird");
		System.out.println("Quit - ends the program");

		// prompt to the user to choose a command
		while (true) {
			System.out.println("?");
			String command = scan.nextLine().strip().toLowerCase();

			if (command.equals("add")) {
				addBird();

			} else if (command.equals("observation")) {
				observations();
			} else if (command.equals("all")) {
				allBirds();
			} else if (command.equals("one")) {
				oneBird();
			} else if (command.equals("quit")) {
				break; // exit the program
			} else {
				System.out.println("Invalid command");
			}
		}
	}

	public static void addBird() {
		System.out.println("Name: ");
		String birdName = scan.nextLine().strip();
		if (birdName.isEmpty()) {
			System.out.println("Bird name cannot be empty");
			return;
		}

		System.out.println("Name in Latin: ");
		String latinName = scan.nextLine().strip();
		if (latinName.isEmpty()) {
			System.out.println("Name cannot be empty");
			return;
		}

		// Record the bird with name and Latin name; start observations with 0
		birdMap.put(birdName, latinName);
		birdObservations.put(birdName, 0); // start observations
	}

	// Method to record an observations for a bird
	public static void observations() {
		System.out.println("Bird? ");
		String birdName = scan.nextLine().strip();

		if (!birdMap.containsKey(birdName)) {
			System.out.println("Not a bird!");
			return;
		}

		int currentCount = birdObservations.get(birdName);
		birdObservations.put(birdName, currentCount + 1); // Increment the observations for each bird

	}

	// Method to print all birds' details
	public static void allBirds() {
		if (birdMap.isEmpty()) {
			System.out.println("No birds added");
			return;
		}
		System.out.println("All birds");
		for (Map.Entry<String, String> entry : birdMap.entrySet()) {
			String birdName = entry.getKey();
			String latinName = entry.getValue();
			int observationsCount = birdObservations.get(birdName);
			System.out.println(birdName + " (" + latinName + "): " + observationsCount + " observations");
		}

	}

	// Method to print one bird's details
	public static void oneBird() {
		System.out.println("Bird: ");
		String birdName = scan.nextLine().strip();

		if (!birdMap.containsKey(birdName)) {
			System.out.println("No bird");
			return;
		}
		String latinName = birdMap.get(birdName);
		int observationsCount = birdObservations.get(birdName);
		System.out.println(birdName + " (" + latinName + "): " + observationsCount + " observations");
	}
}
