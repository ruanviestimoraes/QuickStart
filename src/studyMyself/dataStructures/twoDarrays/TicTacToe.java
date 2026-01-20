package studyMyself.dataStructures.twoDarrays;

import java.util.Scanner;

public class TicTacToe {

    static String[][] board = new String[3][3];

    public static void printBoard() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("   1  2  3");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    board[i][j] = " - ";
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" - ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(String playerSymbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals(playerSymbol) && board[i][1].equals(playerSymbol)
                    && board[i][2].equals(playerSymbol)) ||
                    (board[0][i].equals(playerSymbol) && board[1][i].equals(playerSymbol)
                            && board[2][i].equals(playerSymbol))) {
                System.out.println("row/col WIN");
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0].equals(playerSymbol) && board[1][1].equals(playerSymbol) && board[2][2].equals(playerSymbol))
                ||
                (board[0][2].equals(playerSymbol) && board[1][1].equals(playerSymbol)
                        && board[2][0].equals(playerSymbol))) {
            System.out.println("DIAGONAL WIN");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        printBoard();

        while (true) {

            // PLAYER 1
            while (true) {

                System.out.print("\nPlayer 1 (x), enter your move (e.g., A1): ");
                String user1place = sc.nextLine().toUpperCase().trim();

                // Validate format
                if (user1place.length() != 2) {
                    System.out.println("Invalid format. Try again (e.g., A1).");
                    continue;
                }

                int row = user1place.charAt(0) - 'A';
                int col = user1place.charAt(1) - '1';

                // Validate inside board
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid position. Try again.");
                    continue;
                }

                // Check if free
                if (board[row][col].equals(" - ")) {
                    board[row][col] = " x ";
                    break;
                } else {
                    System.out.println("Position already taken, try again.");
                }

            }

            printBoard();
            if (checkWin(" x ")) {
                System.out.println("Player 1 (x) wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a tie");
                break;
            }

            // PLAYER 2
            while (true) {

                System.out.print("\nPlayer 2 (o), enter your move (e.g., A1): ");
                String user2place = sc.nextLine().toUpperCase().trim();

                // Validate format
                if (user2place.length() != 2) {
                    System.out.println("Invalid format. Try again (e.g., A1).");
                    continue;
                }

                int row2 = user2place.charAt(0) - 'A';
                int col2 = user2place.charAt(1) - '1';

                // Validate inside board
                if (row2 < 0 || row2 > 2 || col2 < 0 || col2 > 2) {
                    System.out.println("Invalid position. Try again.");
                    continue;
                }

                // Check if free
                if (board[row2][col2].equals(" - ")) {
                    board[row2][col2] = " o ";
                    break;
                } else {
                    System.out.println("Position already taken, try again.");
                }

            }

            printBoard();

            if (checkWin(" o ")) {
                System.out.println("Player 2 (o) wins!");
                break;
            }

        }

        sc.close();
    }
}
