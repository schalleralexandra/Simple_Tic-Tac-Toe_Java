package tictactoe;

import java.util.Scanner;

public class Player {
    private final int number;
    private final char symbol;
    private final Scanner scanner = new Scanner(System.in);

    public Player(int number, char symbol) {
        this.number = number;
        this.symbol = symbol;
    }
    public int getNumber() {
        return number;
    }
    public char getSymbol() {
        return symbol;
    }

    public void makeMove(Grid grid) {
        boolean moveMade = false;
        while (!moveMade) {
            String coordinates = scanner.nextLine().trim();
            String[] parts = coordinates.split("\\s+");
            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }
            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                boolean success = grid.move(row, col, symbol);
                if (success) {
                    grid.printGrid();
                    moveMade = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
