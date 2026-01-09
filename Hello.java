// Simple Java program for Memory Game

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MemoryGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> cards = new ArrayList<>();

        // add card pairs
        cards.add("A"); cards.add("A");
        cards.add("B"); cards.add("B");
        cards.add("C"); cards.add("C");
        cards.add("D"); cards.add("D");

        Collections.shuffle(cards);

        String[] board = new String[cards.size()];
        Arrays.fill(board, " ");

        boolean[] used = new boolean[cards.size()];
        int count = 0;

        System.out.println("Welcome to Memory Game");

        while (count < 4) {

            showBoard(board);

            System.out.println("Enter first index:");
            int i1 = getIndex(sc, board, used);
            board[i1] = cards.get(i1);
            used[i1] = true;
            showBoard(board);

            System.out.println("Enter second index:");
            int i2 = getIndex(sc, board, used);
            board[i2] = cards.get(i2);
            used[i2] = true;
            showBoard(board);

            if (cards.get(i1).equals(cards.get(i2))) {
                System.out.println("Pair matched");
                count++;
            } else {
                System.out.println("Not matched");
                board[i1] = " ";
                board[i2] = " ";
                used[i1] = false;
                used[i2] = false;
            }
        }

        System.out.println("You won the game");
        sc.close();
    }

    public static int getIndex(Scanner sc, String[] board, boolean[] used) {
        int n;
        while (true) {
            n = sc.nextInt();
            if (n < 0 || n >= board.length) {
                System.out.println("Wrong index, try again:");
            } else if (used[n]) {
                System.out.println("Already opened, try again:");
            } else {
                break;
            }
        }
        return n;
    }

    public static void showBoard(String[] board) {
        for (String s : board) {
            System.out.print("| " + s + " ");
        }
        System.out.println("|");
    }
}

System.out.println("New Fork");

