package ru.nikky.homework.homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeMain {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static int fieldSize;
    private static final char HUMAN_PIECE = 'X';
    private static final char AI_PIECE = 'O';
    private static char EMPTY_PIECE = ' ';

    private static char[][] field;
    private static int winLength;


    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter the field size: ");
            fieldSize = SCANNER.nextInt();
            System.out.print("Enter the win length: ");
            winLength = SCANNER.nextInt();
            loadingImitation();
            initializeGame(fieldSize);
            printField();
            boolean whoGoesFirst = RANDOM.nextBoolean();//random first player (AI or Human)
            while (true) {
                if (whoGoesFirst) {
                    //human turn
                    System.out.println("It's your turn.");
                    humanTurn();
                    printField();
                    if (checkWin(HUMAN_PIECE, winLength)) {
                        System.out.println("You won!");
                        break;
                    }
                    if (checkDraw()) {
                        System.out.println("It's a draw. Well played everyone!");
                        break;
                    }
                } else {
                    whoGoesFirst = true;
                }
                //AI turn
                System.out.println("It's AI turn");
                loadingImitation();
                aiTurn();
                printField();
                if (checkWin(AI_PIECE, winLength)) {
                    System.out.println("You lost!");
                    break;
                }
                if (checkDraw()) {
                    System.out.println("It's a draw. Well played everyone!");
                    break;
                }
            }
            System.out.println("Want to play again? (Y - yes/Any key - no)");
            System.out.print("Type here: ");
            if (SCANNER.next().equalsIgnoreCase("y")) {
                System.out.println("Ok, lets go!");
                SCANNER.nextLine();//clearing clipboard
                loadingImitation();
            } else {
                System.out.println("Good bye!");
                break;
            }
        }
    }

    private static void aiTurn() {
        //into pre win situations next time should be checked if it's possible to win
        //(continuation of line is not blocked)

        //win turn
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == EMPTY_PIECE) {
                    field[y][x] = AI_PIECE;
                    if (checkWin(AI_PIECE, winLength)) {
                        return;
                    } else {
                        field[y][x] = EMPTY_PIECE;
                    }
                }
            }
        }

        //block turn
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == EMPTY_PIECE) {
                    field[y][x] = HUMAN_PIECE;
                    if (checkWin(HUMAN_PIECE, winLength)) {
                        field[y][x] = AI_PIECE;
                        return;
                    } else {
                        field[y][x] = EMPTY_PIECE;
                    }
                }
            }
        }

        //pre win turn
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == EMPTY_PIECE) {
                    field[y][x] = AI_PIECE;
                    if (checkWin(AI_PIECE, winLength - 1)) {
                        return;
                    } else {
                        field[y][x] = EMPTY_PIECE;
                    }
                }
            }
        }

        //pre block turn
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == EMPTY_PIECE) {
                    field[y][x] = HUMAN_PIECE;
                    if (checkWin(HUMAN_PIECE, winLength - 1)) {
                        field[y][x] = AI_PIECE;
                        return;
                    } else {
                        field[y][x] = EMPTY_PIECE;
                    }
                }
            }
        }

        //random turn
        int x, y;
        do{
            x = RANDOM.nextInt(fieldSize);
            y = RANDOM.nextInt(fieldSize);
        } while (!turnIsCorrect(x, y));
        field[y][x] = AI_PIECE;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == EMPTY_PIECE) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char piece, int winLength) {
        int tempCount;
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == piece) {
                    //check right
                    if ((x + winLength) <= fieldSize) {
                        tempCount = 1;
                        for (int i = 1; i < winLength; i++) {
                            if (field[y][x + i] == piece) {
                                tempCount++;
                            } else {
                                break;
                            }
                        }
                        if (tempCount == winLength) return true;
                    }
                    //check down
                    if ((y + winLength) <= fieldSize) {
                        tempCount = 1;
                        for (int i = 1; i < winLength; i++) {
                            if (field[y + i][x] == piece) {
                                tempCount++;
                            } else {
                                break;
                            }
                        }
                        if (tempCount == winLength) return true;
                    }
                    //check right up
                    if ((x + winLength) <= fieldSize && (y - winLength + 1) >= 0) {
                        tempCount = 1;
                        for (int i = 1; i < winLength; i++) {
                            if (field[y - i][x + i] == piece) {
                                tempCount++;
                            } else {
                                break;
                            }
                        }
                        if (tempCount == winLength) return true;
                    }
                    //check right down
                    if ((x + winLength) <= fieldSize && (y + winLength) <= fieldSize) {
                        tempCount = 1;
                        for (int i = 1; i < winLength; i++) {
                            if (field[y + i][x + i] == piece) {
                                tempCount++;
                            } else {
                                break;
                            }
                        }
                        if (tempCount == winLength) return true;
                    }
                }
            }
        }
        return false;
    }

    private static void humanTurn() {
        int xCoord;
        int yCoord;
        do {
            System.out.println("Enter coordinates separated by space(X Y): ");
            xCoord = SCANNER.nextInt() - 1;
            yCoord = SCANNER.nextInt() - 1;
        } while (!turnIsCorrect(xCoord, yCoord));
        field[yCoord][xCoord] = HUMAN_PIECE;
    }

    private static boolean turnIsCorrect(int xCoord, int yCoord) {
        if (xCoord < 0 || xCoord >= fieldSize || yCoord < 0 || yCoord >= fieldSize)
            return false;
        return field[yCoord][xCoord] == EMPTY_PIECE;
    }

    private static void initializeGame(int fieldSize) {
        field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            Arrays.fill(field[i], EMPTY_PIECE);
        }
    }

    private static void printField() {
        //printing head of the field
        printFieldTopAndBottom();
        //printing other part of the field
        for (int y = 0; y < fieldSize; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSize; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println(y + 1);
        }
        //printing bottom of field
        printFieldTopAndBottom();
    }

    private static void printFieldTopAndBottom() {
        System.out.print(" +");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + 1);
            if (i == fieldSize - 1) break;
            System.out.print("-");
        }
        System.out.println("+");
    }

    private static void loadingImitation() {
        ru.nikky.homework.homework3.Main.loadingImitation();
    }
}
