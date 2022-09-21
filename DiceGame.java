/*
* The DiceGame program is a game where the user
* has to guess a number between (1-6)
*
* @author  Daria Bernice Calitis
* @version 1.0
* @since   2022-09-21
*/

// Import Scanner
import java.util.Scanner;

/**
* .Class constructor DiceGame.
*/
final class DiceGame {
    /**
     * Error message.
     */
    public static final String ERR_MSG = "Invalid Input.";

    /**
     * Max dice number.
     */
    public static final int MAX = 6;

    /**
     * Minimum dice number.
     */
    public static final int MIN = 1;

    /**
     * Dice number.
     */
    public static final int DICE_NUMBER = (int) (Math.random() * MAX + MIN);

    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException
     * if this ever is called
     *
     * @throws IllegalStateException
     *
     */
    private DiceGame() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        // Create Scanner Object
        final Scanner scan = new Scanner(System.in);

        int userNumber = 0;
        int tries = 0;

        // The game keeps going until the user gets the correct number.
        while (userNumber != DICE_NUMBER) {
            tries += 1;
            try {
                // Gets the userNumber
                System.out.print("Guess a number between 1 to 6: ");
                userNumber = scan.nextInt();

                if (!(userNumber < MIN || userNumber > MAX)) {
                    if (userNumber == DICE_NUMBER) {
                        System.out.println("You are correct!");
                        System.out.printf("It took you %s tries.\n",
                            String.valueOf(tries)
                        );
                        break;
                    } else if (userNumber > DICE_NUMBER) {
                        System.out.println("Too high!");
                    } else if (userNumber < DICE_NUMBER) {
                        System.out.println("Too low!");
                    }
                } else {
                    System.out.println("The guess must be a number 1 to 6.");
                }

                System.out.println("Guess again.\n");
            } catch (java.util.InputMismatchException error) {
                System.out.println(ERR_MSG);
                break;
            }
        }

        System.out.println("\nDone.");
    }
}
