package ru.nikky.homework.homework3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        boolean fExit = false;

        System.out.println("Welcome to the game club!");
        System.out.println("Choose game, that you want to play.");
        System.out.println("===================================");

        while (!fExit) {
            showMenu();
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();//clear clipboard
                switch (num) {
                    case 0:
                        fExit = true;
                        System.out.println("See you next time \u263a");
                        break;
                    case 1:
                        System.out.println("Good choice!");
                        loadingImitation();
                        guessTheNumberGame();
                        break;
                    case 2:
                        System.out.println("Nice one!");
                        loadingImitation();
                        guessTheWordGame();
                        break;
                    default:
                        System.out.println("There's no game with this number in library.\nLet's play another one!");
                }
            } else {
                System.out.println("Incorrect input, try again!");
                scanner.nextLine();//clear clipboard
            }
            System.out.println("===================================");
        }
    }

    private static void showMenu() {
        System.out.println("1 - Guess the number game.");
        System.out.println("2 - Guess the word game.");
        System.out.println("0 - Exit");
        System.out.print("Type here:");
    }

    public static void loadingImitation() {
        int time = random.nextInt(5) + 2;
        System.out.print("Loading");
        for (int i = 0; i < time; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private static boolean wantToPlayAgain(){
        System.out.println("Want to play again? (1 - yes, 0 - no)");
        while (true) {
            if (scanner.hasNextInt()) {
                int answer = scanner.nextInt();
                scanner.nextLine();
                if (answer == 1) {
                    loadingImitation();
                    return false;
                } else if (answer == 0) {
                    System.out.println("Exiting game");
                    loadingImitation();
                    return true;
                } else {
                    System.out.println("There're only two options: 1 or 0.");
                }
            } else {
                System.out.println("Enter 1 or 0!");
                scanner.nextLine();
            }
        }
    }

    private static void guessTheNumberGame() {
        boolean fExit = false;
        while (!fExit) {
            int playerNumber;
            int guessedNumber;

            int bound = 10;//exclusive
            int attempts = 3;

            guessedNumber = random.nextInt(bound);

            System.out.printf("You have %d attempts to guess the number between 0 and %d (inclusive).\n",
                    attempts, bound - 1);
            while (attempts > 0) {
                System.out.println("===================================");
                System.out.printf("Attempts left: %d\n", attempts);
                System.out.print("Your guess: ");
                if (scanner.hasNextInt()) {
                    playerNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (playerNumber < guessedNumber) {
                        System.out.println("The target number is greater!");
                    } else if (playerNumber > guessedNumber) {
                        System.out.println("The target number is less!");
                    } else {
                        System.out.println("Congratulations!!! You guessed the number!");
                        break;
                    }
                    attempts--;
                } else {
                    System.out.println("You should enter integer numbers! Try again.");
                    scanner.nextLine();
                }

            }
            if (attempts == 0) {
                System.out.printf("You lost this game :(\nThe target number was %d\n", guessedNumber);
            }

            fExit = wantToPlayAgain();
        }
    }

    private static void guessTheWordGame() {
        boolean fExit = false;
        int latticesAmount = 15;//amount of '#' in hint
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        while (!fExit) {
            String guessedWord = words[random.nextInt(words.length)];
            String playerWord;
            System.out.println("I thought of something edible, guess it!");
            do{
                System.out.print("Guess the word: ");
                playerWord = scanner.next();
                scanner.nextLine();//clear clipboard
                if (playerWord.equals(guessedWord)) {
                    break;
                }
                StringBuilder hint = new StringBuilder();
                for (int i = 0; i < latticesAmount; i++) {
                    if (i < guessedWord.length() && i < playerWord.length() &&
                            guessedWord.charAt(i) == playerWord.charAt(i)){
                        hint.append(guessedWord.charAt(i));
                    } else {
                        hint.append('#');
                    }
                }
                System.out.println("You didn't guess my word :(");
                System.out.printf("Here are the letters you guessed: %s\n", hint.toString());
                System.out.println("===================================");

            } while (true);

            System.out.println("Congratulations!!! You guessed the word! :D");
            fExit = wantToPlayAgain();
        }
    }
}
