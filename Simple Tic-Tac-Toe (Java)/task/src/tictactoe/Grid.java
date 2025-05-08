package tictactoe;

public class Grid {
    private Cell[][] grid;
    private final int SIZE = 3;

    public Grid() {
        this.grid = new Cell[SIZE][SIZE];
        initializeGrid();
    }


    private void initializeGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = new Cell(' ');
            }
        }
    }

    private void initializeGrid(char[] input) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = new Cell(input[row * SIZE + col]);
            }
        }
    }



    public void printGrid() {

            for (int col = 0; col < SIZE; col++) {
                System.out.print("---");
            }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print("| ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col].getSymbol() + " ");
            }
            System.out.println("|");
        }
            for (int col = 0; col < SIZE; col++) {
                System.out.print("---");
            }
        System.out.println();
    }


    public void checkResult() {
        int xCount = 0;
        int oCount = 0;
        boolean hasEmpty = false;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char c = grid[row][col].getSymbol();
                if (c == 'X') {
                    xCount++;
                } else if (c == 'O') {
                    oCount++;
                } else if (c == '_'){
                    hasEmpty = true;
                }
            }
        }

        boolean xWon = hasWon('X');
        boolean oWon = hasWon('O');


        if ((oWon && xWon) || Math.abs(xCount - oCount) > 1) {
            System.out.println("Impossible");
            return;
        }
        if (xWon) {
            System.out.println("X wins");
        } else if (oWon) {
            System.out.println("O wins");
        } else if (hasEmpty) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    public boolean checkEmpty() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char c = grid[row][col].getSymbol();
                if (c == ' ') return true;

            }
        }
        return false;
    }

    public boolean hasWon(char player) {
        // check rows
        for (int row = 0; row < SIZE; row++) {
            if (grid[row][0].getSymbol() == player &&
            grid[row][1].getSymbol() == player &&
            grid[row][2].getSymbol() == player) return true;
        }

        // check columns
        for (int col = 0; col < SIZE; col++) {
            if (grid[0][col].getSymbol() == player &&
            grid[1][col].getSymbol() == player &&
            grid[2][col].getSymbol() == player) return true;
        }

        // check diagonals
        if (grid[0][0].getSymbol() == player &&
        grid[1][1].getSymbol() == player &&
        grid[2][2].getSymbol() == player) return true;

        if (grid[0][2].getSymbol() == player &&
        grid[1][1].getSymbol() == player &&
        grid[2][0].getSymbol() == player) return true;

        return false;
    }


    public boolean move(int row, int col, char symbol) {
        row = row -1;
        col = col -1;
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        Cell cell = grid[row][col];
        if (cell.getSymbol() != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        cell.setSymbol(symbol);
        return true;
    }

}
