/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project02startingfiles;

//Importing Random and Scanner
import java.util.Random;
import java.util.Scanner;

public class Project02StartingFiles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to JavaQuest!");
        System.out.println("Stay alive and increase your score!");

        //prompting user input
        System.out.println("Choose a character...");
        System.out.print("(k) Knight || (h) Healer || (w) Wizard || (t) Thief \n>>");

        char choice = scanner.next().charAt(0);
        Player player = createPlayer(choice);

        //printing the name of the chosen character
        System.out.println(" ");
        System.out.println("Welcome, " + player.getPlayerClassName() + "!");
        System.out.println(" ");

        char moveChoice;
        //using a do-while loop to move in different directions
        do {
            printMenu();
            moveChoice = scanner.next().charAt(0);

            if (moveChoice == 'n' || moveChoice == 's' || moveChoice == 'e' || moveChoice == 'w') {
                move(player, random, moveChoice);
            } else if (moveChoice == '?') {
                System.out.println(player.toString());
            } else if (moveChoice == 'q') {
                gameOver(player);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (player.getHealth() > 0 && moveChoice != 'q');

        scanner.close();
    }

    //methods
    private static Player createPlayer(char choice) {
        if (choice == 'k') {
            return new Knight();
        } else if (choice == 'h') {
            return new Healer();
        } else if (choice == 'w') {
            return new Wizard();
        } else if (choice == 't') {
            return new Thief();
        } else {
            System.out.println("Invalid character choice. Please choose 'k' for Knight, 'h' for Healer, 'w' for Wizard, or 't' for Thief.");

            return null;
        }
    }

    private static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.print("(?)Status Report || (n)(s)(e)(w) Move 1 Space North, South, East, or west || {q} Quit \n>>");
    }

    private static void move(Player player, Random random, char direction) {
        boolean isAttack = random.nextInt(5) == 0; // 20% chance of attack

        if (isAttack) {
            attack(player, random);
        } else {
            int scoreIncrease = 1;
            player.setScore(player.getScore() + scoreIncrease);
            System.out.println("***************************");
            switch (random.nextInt(4)) {//Using random for choosing scene
                case 0:
                    System.out.println("Nothing here...");
                    break;
                case 1:
                    System.out.println("Nice trees around here...");
                    break;
                case 2:
                    System.out.println("Interesting cottage there...");
                    break;
                case 3:
                    System.out.println("Potty break...");
                    break;
            }
            System.out.println("***************************");
        }

    }

    private static void attack(Player player, Random random) {
        String[] foes = {"zombie", "bandit", "lobbyist"};
        String foe = foes[random.nextInt(3)];//Using random for choosing foe from the list
        System.out.println("Oh no! You are being attacked by a " + foe + "!");

        for (int i = 0; i < 2; i++) {  // Allowing the player 2 chances to enter a valid choice
            System.out.println("How would you like to handle this?");
            System.out.println("(s) Special Move || (r) Run!");

            char attackChoice = new Scanner(System.in).next().charAt(0);
            //selection structure for choice of attack - either specialmove or run
            if (attackChoice == 'r') {
                boolean isRunSuccessful = random.nextBoolean(); // 50% chance of successful run

                if (isRunSuccessful) {
                    int scoreIncrease = 1;
                    player.setScore(player.getScore() + scoreIncrease);
                    System.out.println("You successfully ran away!");
                    return;  // Exit the method after successful run
                } else {
                    System.out.println("Run Unsuccessful");
                    battle(player, foe);
                    return;
                }
            } else if (attackChoice == 's') {
                battle(player, foe);
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    char attackChoice = new Scanner(System.in).next().charAt(0);

    private static void battle(Player player, String foe) {
        System.out.println("Prepare for battle!");
        System.out.println("Press any letter then ENTER to continue...");
        new Scanner(System.in).next();

        Random random = new Random();

        boolean playerWins = random.nextDouble() < 0.6; // 60% chance of player winning

        if (playerWins) {
            int scoreIncrease = 2;
            player.setScore(player.getScore() + scoreIncrease);
            System.out.println("*******************************");
            player.useSpecialMove();
            System.out.println("Player wins! Increase score by 2 points!");
        } else {
            int healthDecrease = 1;
            player.setHealth(player.getHealth() - healthDecrease);
            System.out.println("*********************************");
            System.out.println(player.getPlayerClassName() + "!" + " loses! Health decreased by 1 point.");
        }
        System.out.println(" ");
        System.out.println(player.toString());

        if (player.getHealth() <= 0) {
            gameOver(player);
        }
    }

    private static void gameOver(Player player) {
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("The game has come to an end! Your final stats: ");
        System.out.println(player.toString());
        System.out.println("Thanks for playing!");
        System.exit(0);
    }
}
