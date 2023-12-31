/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project02startingfiles;

/**
 *
 * @author S559222
 */
//abstract class player
public abstract class Player {

    //Instance variables 
    private int health;
    private int score;

    //All characters start with 10 Health points and a Score of 0.
    public Player() {
        this.health = 10;
        this.score = 0;
    }

    //getter and setter methods
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //Abstract methods
    public abstract String getSpecialMove();

    public abstract void useSpecialMove();

    public abstract String getPlayerClassName();

    /**
     *
     * @return toString
     */
    @Override
    public abstract String toString();
}
