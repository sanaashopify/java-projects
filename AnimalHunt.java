package game;

/* Sanaa Syed
 * 06/05/2018
 * CPT Project - Animal Hunt
 */
import java.io.*;
import java.util.*;

public class AnimalHunt {
	public static int uc = 3, ur = 3;

	public static void main(String[] args) throws IOException {
		// call the method Rules to ask user if they want to see the rules
		Rules();

		int[][] gridI = new int[6][6]; // initializes the inside 2D array grid
		// coding for the inside integer grid
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 6; c++) {
				gridI[r][c] = 0;
			}
		}

		// coding the outside string grid and output the grid to the screen
		String[][] gridO = new String[6][6];
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 6; c++) {
				gridO[r][c] = "X"; 
				// prints a string 2D array grid filled with X
				System.out.print(gridO[r][c] + "    ");
			}
			System.out.println("");
		}
		System.out.println();

		// randomizing the users starting location
		Scanner input = new Scanner(System.in);
		ur = (int) (Math.random() * 6);
		uc = (int) (Math.random() * 6);
		
		String piece; // initializes a variable for the game piece
		
		// ask user to enter a symbol for their game piece
		System.out.print("Enter a symbol as your game piece: ");
		piece = input.next();
		piece = piece.substring(0, 1); // keeps the variable as one character
		System.out.println();

		// outputting the grid again with the users starting location
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 6; c++) {
				if (r == ur && c == uc) {
					gridO[r][c] = piece;
					System.out.print(gridO[r][c] + "    ");
				} else {
					gridO[r][c] = "X";
					System.out.print(gridO[r][c] + "    ");
				}
			}
			System.out.println();
		}

		// randomizing the locations of the five animals present on the inside grid
		int ar, ac;
		for (int i = 1; i <= 5; i++) {
			ar = (int) (Math.random() * 6);
			ac = (int) (Math.random() * 6);
			if (gridI[ar][ac] != 0) {
				i = i - 1;
			} else {
				gridI[ar][ac] = i;
			}
		}
		
		// randomizing the locations of four coins present on the inside grid 
		int cr, cc;
		for (int i = 6; i <= 9; i++){
			cr = (int)(Math.random() * 6);
			cc = (int)(Math.random() * 6);
			if (gridI[cr][cc] != 0){
				i = i - 1;
			} else {
				gridI[cr][cc] = i;
			}
		}

		int lives = 3; // start the player off with three lives
		int coins = 0; // variable that coins the number of coins the player found
		int count = 0; // variable that counts how many animals the player has found
		// create a do while loop to keep the game running while the player has 
		// between 1 and 3 lives
		
		do {
			// calling the playerDirection method to ask user to input their direction
			String direction = playerDirection();
			
			// if the user wants to move north 
			if (direction.equalsIgnoreCase("N")) {
				if (ur > 0) {
					ur = ur - 1;
				}
			}
			
			// if the user wants to move south
			if (direction.equalsIgnoreCase("S")) {
				if (ur < 5) {
					ur = ur + 1;
				}
			}
			
			// if the user wants to move west 
			if (direction.equalsIgnoreCase("W")) {
				if (uc > 0) {
					uc = uc - 1;
				}
			}
			
			// if the user wants to move east 
			if (direction.equalsIgnoreCase("E")) {
				if (uc < 5) {
					uc = uc + 1;
				}
			}
			System.out.println();
			
			// prints the integer grid with the animal spots 
			printGridI(gridI);
			System.out.println();
			
			
			// outputs the string grid again after user has changed their direction
			for (int r = 0; r < 6; r++) { 
				for (int c = 0; c < 6; c++) { 
					if (r== ur && c == uc) { 
						gridO[r][c] = piece;
						System.out.print(gridO[r][c] + "    ");
					} else { 
						gridO[r][c] = "X"; 
						System.out.print(gridO[r][c] + "    "); 
					} 
				} 
				System.out.println(); 
			} 
			System.out.println();
		
			// check if the player has landed on a spot on the grid where an animal is
			if (gridI[ur][uc] == 1) {
				count++;
				lives = animal1(lives);
				System.out.print("You have " + lives + " lives.");
				System.out.println();
			}
			if (gridI[ur][uc] == 2) {
				count++;
				lives = animal2(lives);
				System.out.print("You have " + lives + " lives.");
				System.out.println();
			}
			if (gridI[ur][uc] == 3) {
				count++;
				lives = animal3(lives);
				System.out.print("You have " + lives + " lives.");
				System.out.println();
			}
			if (gridI[ur][uc] == 4) {
				count++;
				lives = animal4(lives);
				System.out.print("You have " + lives + " lives.");
				System.out.println();
			}
			if (gridI[ur][uc] == 5) {
				count++;
				lives = animal5(lives);
				System.out.print("You have " + lives + " lives.");
				System.out.println();
			}
			
			// check if the player has landed on a spot where coins are 
			if (gridI[ur][uc] == 6){
				coins += 3;
				System.out.print("You found a treasure chest with 3 coins!");
				System.out.println();
			}
			if (gridI[ur][uc] == 7){
				coins += 1;
				System.out.print("You found a treasure chest with 1 coin!");
				System.out.println();
			}
			if (gridI[ur][uc] == 8){
				coins += 2;
				System.out.print("You found a treasure chest with 2 coins!");
				System.out.println();
			}
			if (gridI[ur][uc] == 9){
				coins += 4;
				System.out.print("You found a treasure chest with 4 coins!");
				System.out.println();
			} 
			
			// ends the game if the user has found all five animals
			if (count == 5){
				System.out.println("Game over.");
				lives = 0;
			}
		} while (lives > 0 && lives <= 3); // run the program until the player loses all their lives
		
		// outputs the number of coins the player found
		System.out.print("You found " + coins + " coins.");
		System.out.println();
		
		String playAgain; // records response as to whether user wants to play again or not
		
		// ask user if they want to play again, calls the main method
		System.out.println();
		System.out.println("Game over. Would you like to play again?");
		playAgain = input.next();
		
		if (playAgain.equalsIgnoreCase("yes")){
			System.out.println();
			System.out.println();
			main(args);
		} else if (playAgain.equalsIgnoreCase("no")){
			System.out.println("Thanks for playing!");
		} else {
			System.out.println("Invalid answer. Write yes or no.");
			playAgain = input.next();
		} 
	}

	/*
	 * A method that asks the user for the direction they would like to move in on the grid 
	 * Pre: no parameters 
	 * Post: returns one string variable(direction)
	 */
	public static String playerDirection() {
		// ask user to input direction of movement
		String direction;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter the direction you would like to move in (N, S, E, W): ");
		direction = input.next();
		do {
			// check if the user inputted a valid input
			if (direction.equalsIgnoreCase("N")
					|| direction.equalsIgnoreCase("S")
					|| direction.equalsIgnoreCase("E")
					|| direction.equalsIgnoreCase("W")) {
				return direction;
			} else {
				System.out.print("Invalid output. Choose N, S, E or W: ");
				direction = input.next();
			}
		} while (!direction.equalsIgnoreCase("N")
				|| !direction.equalsIgnoreCase("S")
				|| !direction.equalsIgnoreCase("E")
				|| !direction.equalsIgnoreCase("W"));
		return direction; // return the direction
	}

	/*
	 * A method that outputs clues if the player lands on the spot where animal 1 is 
	 * Pre: one integer parameter (lives) 
	 * Post: returns one integer variable (lives left)
	 */
	public static int animal1(int lives) throws IOException {
		Scanner in = new Scanner(new File("Animal1.txt"));
		Scanner input = new Scanner(System.in);
		String a1; // variable that outputs the clues
		String guess; // variable that retrieves the users guess
		System.out.println();
		// outputs the clues from file 
		while (in.hasNextLine()) {
			a1 = in.nextLine();
			System.out.println(a1);
		}

		// ask user to guess the animal
		System.out.print("Enter your guess here: ");
		guess = input.next();

		// if the user guesses correctly, one of these three cases will output
		if (guess.equalsIgnoreCase("elephant")) {
			int n;
			n = (int) (Math.random() * 3 + 1);
			switch (n) {
			case 1:
				System.out.println("Great!");
				break;
			case 2:
				System.out.println("Good Job!");
				break;
			case 3:
				System.out.println("Correct!");
				break;
			}
			return lives;
		} else {
			// if the user did not get it right, one of these three cases will output with the correct answer
			int x;
			x = (int) (Math.random() * 3 + 1);
			switch (x) {
			case 1:
				System.out.println("Incorrect. The animal you found is an elephant.");
				break;
			case 2:
				System.out.println("Nice try! The animal you found is an elephant.");
				break;
			case 3:
				System.out.println("Wrong! The animal you found is an elephant.");
				break;
			}
			lives -= 1; // the player loses a life because they guessed incorrectly
		}
		System.out.println();
		in.close();
		return lives; // return the number of lives the player has left
	}

	/*
	 * A method that outputs questions if the player lands on the spot where animal 2 is 
	 * Pre: one integer parameter (lives) 
	 * Post: returns one integer variable (lives left)
	 */
	public static int animal2(int lives) throws IOException {
		Scanner in = new Scanner(new File("Animal2.txt"));
		Scanner input = new Scanner(System.in);
		String a1; // variable that outputs the clues
		String guess; // variable that retrieves the users guess
		System.out.println();
		// outputs the clues from file 
		while (in.hasNextLine()) {
			a1 = in.nextLine();
			System.out.println(a1);
		}

		// ask user to guess the animal
		System.out.print("Enter your guess here: ");
		guess = input.next();
		
		// if the user guess correctly, one of these three cases will output
		if (guess.equalsIgnoreCase("snake")) {
			int n;
			n = (int) (Math.random() * 3 + 1);
			switch (n) {
			case 1:
				System.out.println("Great!");
				break;
			case 2:
				System.out.println("Good Job!");
				break;
			case 3:
				System.out.println("Correct!");
				break;
			}
			return lives;
		} else {
			// if the user did not get it right, one of these three cases will output with the correct answer
			int x;
			x = (int) (Math.random() * 3 + 1);
			switch (x) {
			case 1:
				System.out.println("Incorrect. The animal you found is a snake.");
				break;
			case 2:
				System.out.println("Nice try! The animal you found is a snake.");
				break;
			case 3:
				System.out.println("Wrong! The animal you found is a snake.");
				break;
			}
			lives -= 1; // the player loses a life because they guessed incorrectly
		}
		System.out.println();
		in.close();
		return lives; // returns the number of lives the player has left
	}

	/*
	 * A method that outputs questions if the player lands on the spot where animal 3 is 
	 * Pre: one integer parameter (lives) 
	 * Post: returns one integer variable (lives left)
	 */
	public static int animal3(int lives) throws IOException {
		Scanner in = new Scanner(new File("Animal3.txt"));
		Scanner input = new Scanner(System.in);
		String a1; // variable that outputs the clues
		String guess; // variable that retrieves the users guess
		System.out.println();
		// outputs the clues from file 
		while (in.hasNextLine()) {
			a1 = in.nextLine();
			System.out.println(a1);
		}
		
		// ask user to guess the animal 
		System.out.print("Enter your guess here: ");
		guess = input.next();
		
		// if the user guess correctly, one of these three cases will output
		if (guess.equalsIgnoreCase("panda")) {
			int n;
			n = (int) (Math.random() * 3 + 1);
			switch (n) {
			case 1:
				System.out.println("Great!");
				break;
			case 2:
				System.out.println("Good Job!");
				break;
			case 3:
				System.out.println("Correct!");
				break;
			}
			return lives;
		} else {
			// if the user did not get it right, one of these three cases will output with the correct answer
			int x;
			x = (int) (Math.random() * 3 + 1);
			switch (x) {
			case 1:
				System.out.println("Incorrect. The animal you found is a panda.");
				break;
			case 2:
				System.out.println("Nice try! The animal you found is a panda.");
				break;
			case 3:
				System.out.println("Wrong! The animal you found is a panda.");
				break;
			}
			lives -= 1; // the player loses a life because they guessed incorrectly
		}
		System.out.println();
		in.close();
		return lives; // returns the number of lives the player has left
	}

	/*
	 * A method that outputs questions if the player lands on the spot where animal 4 is 
	 * Pre: one integer parameter (lives) 
	 * Post: returns one integer variable (lives left)
	 */
	public static int animal4(int lives) throws IOException {
		Scanner in = new Scanner(new File("Animal4.txt"));
		Scanner input = new Scanner(System.in);
		String a1; // variable that outputs the clues
		String guess; // variable that retrieves the users guess
		System.out.println();
		// outputs the clues from file 
		while (in.hasNextLine()) {
			a1 = in.nextLine();
			System.out.println(a1);
		}
		
		// asks user to guess the animal
		System.out.print("Enter your guess here: ");
		guess = input.next();
		
		// if the user guess correctly, one of these three cases will output
		if (guess.equalsIgnoreCase("coyote")) {
			int n;
			n = (int) (Math.random() * 3 + 1);
			switch (n) {
			case 1:
				System.out.println("Great!");
				break;
			case 2:
				System.out.println("Good Job!");
				break;
			case 3:
				System.out.println("Correct!");
				break;
			}
			return lives;
		} else {
			// if the user did not get it right, one of these three cases will output with the correct answer
			int x;
			x = (int) (Math.random() * 3 + 1);
			switch (x) {
			case 1:
				System.out.println("Incorrect. The animal you found is a coyote.");
				break;
			case 2:
				System.out.println("Nice try! The animal you found is a coyote.");
				break;
			case 3:
				System.out.println("Wrong! The animal you found is a coyote.");
				break;
			}
			lives -= 1; // the player loses a life because they guessed incorrectly
		}
		System.out.println();
		in.close();
		return lives; // returns the number of lives the player has left
	}

	/*
	 * A method that outputs questions if the player lands on the spot where animal 5 is 
	 * Pre: one integer parameter (lives) 
	 * Post: returns one integer variable (lives left)
	 */
	public static int animal5(int lives) throws IOException {
		Scanner in = new Scanner(new File("Animal5.txt"));
		Scanner input = new Scanner(System.in);
		String a1; // variable that outputs the clues
		String guess; // variable that retrieves the users guess
		System.out.println();
		// outputs the clues from file 
		while (in.hasNextLine()) {
			a1 = in.nextLine();
			System.out.println(a1);
		}
		
		// asks user to guess the animal
		System.out.print("Enter your guess here: ");
		guess = input.next();
		
		// if the user guess correctly, one of these three cases will output
		if (guess.equalsIgnoreCase("horse")) {
			int n;
			n = (int) (Math.random() * 3 + 1);
			switch (n) {
			case 1:
				System.out.println("Great!");
				break;
			case 2:
				System.out.println("Good Job!");
				break;
			case 3:
				System.out.println("Correct!");
				break;
			}
			return lives;
		} else {
			// if the user did not get it right, one of these three cases will output with the correct answer
			int x;
			x = (int) (Math.random() * 3 + 1);
			switch (x) {
			case 1:
				System.out.println("Incorrect. The animal you found is a horse.");
				break;
			case 2:
				System.out.println("Nice try! The animal you found is a horse.");
				break;
			case 3:
				System.out.println("Wrong! The animal you found is a horse.");
				break;
			}
			lives -= 1; // the player loses a life because they guessed incorrectly
		}
		System.out.println();
		in.close();
		return lives; // returns the number of lives the player has left
	}

	/* Method that prints the inside integer grid with the animal and coin locations
	 * Pre: integer 2D array (grid)
	 * Post: no return value
	 */
	public static void printGridI(int[][] grid) {
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 6; c++) {
				System.out.print(grid[r][c] + " ");
			}
			System.out.println();
		}
	}

	/* A method that outputs the rules if the player wants to see them 
	 * Pre: no parameters 
	 * Post: no return variable
	 */
	public static void Rules() throws IOException {
		// outputting the rules from a file in the method Rules
		String rules, answer;
		Scanner in = new Scanner(new File("Hunt Rules.txt"));
		Scanner input = new Scanner(System.in);
		System.out.print("Would you like to see the rules? Answer yes or no: ");
		answer = input.nextLine();
		do {
			if (answer.equalsIgnoreCase("yes")) {
				while (in.hasNextLine()) {
					rules = in.nextLine();
					System.out.println(rules);
				}
				System.out.println();
				return;
			} else if (answer.equalsIgnoreCase("no")) {
				System.out.println("Here is the grid (6x6): ");
				System.out.println();
				return;
			} else {
				System.out.print("Invalid answer. Write yes or no: ");
				answer = input.nextLine();
			}
			in.close();
			input.close();
		} while (!answer.equalsIgnoreCase("yes") || !answer.equalsIgnoreCase("no"));
	}
}
