package stringComparer;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Stream;

public class StringComparerApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// A priority queue to save the characters from String 1 and String 2, respectively

		final PriorityQueue<Character> CharString1 = new PriorityQueue<>();
		final PriorityQueue<Character> CharString2 = new PriorityQueue<>();

		System.out.println("How many string comparisons would you like to do? ");
		int comparisons = input.nextInt();


		while(comparisons > 0) {

			// Make sure the the amount of tests doesn't surpass 10 

			if (comparisons > 10) {

				System.out.println("Max. 10 testfall! Försök igen.");
				break;

			}

			// Type in the strings to compare

			System.out.println("Type String 1: ");
			String String1 = input.next();
			System.out.println("Type String 2: ");
			String String2 = input.next();

			// Check that both strings har between 1 - 50 characters 

			if (String1.length() < 1 || String2.length()  < 1 || String1.length()  > 50 || String2.length()  > 50){

				System.out.println("Min. 1 and max. 50 characters! Try again.");
				break;
			}

			//	Check whether the strings contain non-alphanumeric characters 

			if (!String1.matches("[a-zA-Z0-9]*") || !String2.matches("[a-zA-Z0-9]*")) {

				System.out.println("Only letters (a-z, A-Z) or digits (0-9) allowed. Try again!");

				break;

			}

			System.out.println("\nResult: " + "\n" + String1 + "\n" + String2);


			// Add the characters to their priority queues 

			for(int j = 0; j < String1.length(); j++) {

				char char1 = String1.charAt(j);
				char char2 = String2.charAt(j);

				CharString1.offer(char1);
				CharString2.offer(char2);

				Stream.generate(() -> Optional.ofNullable(CharString1.poll()))
				.takeWhile(o -> o.isPresent())
				.map(o -> o.get())
				// Compare the characters in both strings, one by one 
				.forEach(s -> {if (char1 == char2) {

					System.out.print("x");

				}

				else System.out.print("*");

				});
			}

			comparisons--; 

			if(comparisons == 0) {

				System.out.println("\n" + "Welcome back!");

				input.close();

				break;
			}

			else {

				System.out.println("\n" + "Next comparison:");

			}
		}
	}
}

