import java.util.Scanner;

public class Jeopardy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the game board
        String[][] gameBoard = {
            {"Category 1", "100", "200", "300"},
            {"Category 2", "100", "200", "300"},
            {"Category 3", "100", "200", "300"}
        };

        // Print the game board
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + "\t");
            }
            System.out.println();
        }

        // Ask the player to choose a category and point value
        System.out.print("Choose a category (1-3): ");
        int category = scanner.nextInt();

        System.out.print("Choose a point value (100, 200, 300): ");
        int pointValue = scanner.nextInt();

        // Retrieve the question from the game board
        String question = gameBoard[category - 1][pointValue / 100];

        // Ask the player the question and check the answer
        System.out.print(question + " ");
        String answer = scanner.nextLine();

        // Check the answer
        if (answer.equals("correct answer")) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect.");
        }
    }
}
