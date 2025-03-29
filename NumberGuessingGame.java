import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        //Step.1 Generate a ramdon number btw 1 to 100
        int targetNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int userGuess = 0;

        System.out.println("WELCOME TO THE NUMBER GUESSING GAME!");
        System.out.println("I have chosen number btw 1 to 100. Try to guess it!");

        //Step.2:Start the game loop
        while(userGuess != targetNumber){
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            //Step 3: Compare the user's guess with the target number
            if(userGuess > targetNumber){
                System.out.println("Too High! Try again.");
            }else if(userGuess < targetNumber){
                System.out.println("Too low! try again.");
            }else{
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            }
        }

        //Step 4: End the game
        System.out.println("Game Over! Thanks for playing.");
        scanner.close();
    }
}