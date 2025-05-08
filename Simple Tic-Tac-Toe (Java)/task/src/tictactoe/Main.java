package tictactoe;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(1, 'X');
        Player player2 = new Player(2, 'O');
        /*Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        if (input.length() != 9) {
            System.out.println("Invalid input");
        }
        char[] chars = input.toCharArray();*/
        Grid grid = new Grid();
        grid.printGrid();

        boolean gameOver = false;
        Player currentPlayer = player1;
        // Game Loop
        while (!gameOver) {
            currentPlayer.makeMove(grid);
            if (grid.hasWon(currentPlayer.getSymbol()) || !grid.checkEmpty()) {
                grid.checkResult();
                gameOver = true;
            } else {
                // change player
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }


    }


}
