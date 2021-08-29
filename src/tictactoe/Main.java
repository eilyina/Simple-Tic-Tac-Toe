package tictactoe;

import java.util.Scanner;

public class Main {
    private static boolean checkWinX(String str) {
        boolean finished = false;
        for (int i = 0; i < 9; i = i + 3) {
            if (str.substring(0 + i, 3 + i).equals("XXX")) {

                finished = true;
                break;
            }

        }
        for (int i = 0; i < 3; i++) {

            if (str.charAt(0 + i) == 'X' && str.charAt(3 + i) == 'X' && str.charAt(6 + i) == 'X') {

                finished = true;
                break;
            }
        }
        if (str.charAt(0) == 'X' && str.charAt(4) == 'X' && str.charAt(8) == 'X') {

            finished = true;

        }
        if (str.charAt(2) == 'X' && str.charAt(4) == 'X' && str.charAt(6) == 'X') {

            finished = true;

        }

        return finished;
    }

    private static boolean checkWinO(String str) {
        boolean finished = false;
        for (int i = 0; i < 9; i = i + 3) {
            if (str.substring(0 + i, 3 + i).equals("OOO")) {
                System.out.println("O wins");
                finished = true;
                break;
            }

        }
        for (int i = 0; i < 3; i++) {

            if (str.charAt(0 + i) == 'O' && str.charAt(3 + i) == 'O' && str.charAt(6 + i) == 'O') {

                finished = true;
                break;
            }
        }
        if (str.charAt(0) == 'O' && str.charAt(4) == 'O' && str.charAt(8) == 'O') {
            finished = true;

        }
        if (str.charAt(2) == 'O' && str.charAt(4) == 'O' && str.charAt(6) == 'O') {

            finished = true;

        }

        return finished;
    }

    private static void printGrid(String str) {
        System.out.println("---------");
        for (int i = 0; i < 9; i = i + 3) {
            System.out.print("| " + str.charAt(i) + " ");
            System.out.print(str.charAt(i + 1) + " ");
            System.out.print(str.charAt(i + 2) + " |");
            System.out.println("");

        }
        System.out.println("---------");
    }


    public static String modifyStr(String str, int x, int y, String symbol) {
        int position = x * 3 - 3 + y;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.replace(position - 1, position, symbol);
        return strBuilder.toString();
    }

    private static boolean isBusyCell(String str, int x, int y) {
        int position = x * 3 - 3 + y;
        if (str.charAt(position - 1) == ' ') {
            return true;
        } else {

            return false;
        }
    }


    public static void main(String[] args) {
        printGrid("         ");
        Scanner scanner = new Scanner(System.in);
        String str = "         ";
        int count = 0;
        while (!checkWinX(str) || !checkWinO(str)) {

            System.out.println("Enter the coordinates:");
            String x1 = scanner.next();
            String y1 = scanner.next();
            String Symbol = count % 2 == 0 ? "X" : "O";
            try {

                int x = Integer.parseInt(x1);
                int y = Integer.parseInt(y1);
                while (x <= 0 || x > 3 || y <= 0 || y > 3 || !isBusyCell(str, x, y)) {
                    while (x <= 0 || x > 3 || y <= 0 || y > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        System.out.println("Enter the coordinates:");
                        x = scanner.nextInt();
                        y = scanner.nextInt();
                    }
                    while (!isBusyCell(str, x, y)) {
                        System.out.println("This cell is occupied! Choose another one!");
                        System.out.println("Enter the coordinates:");
                        x = scanner.nextInt();
                        y = scanner.nextInt();
                    }
                }
                str = modifyStr(str, x, y, Symbol);
                printGrid(modifyStr(str, x, y, Symbol));
                if (checkWinX(str)) {
                    System.out.println("X wins");
                    break;
                }
                if (checkWinO(str)) {
                    System.out.println("O wins");
                    break;
                }
                if (!checkWinO(str) && !checkWinO(str) && !str.contains(" ")) {
                    System.out.println("Draw");
                    break;
                }
                count++;

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }

        }
    }
}


