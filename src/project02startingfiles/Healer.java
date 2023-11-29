/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project02startingfiles;

class Healer extends Player {

    @Override
    public String getSpecialMove() {
        return "Use Sleeping Powder";
    }

    @Override
    public void useSpecialMove() {
        System.out.println("The Healer uses sleeping powder!");
    }

    @Override
    public String getPlayerClassName() {
        return "Healer";
    }

    @Override
    public String toString() {
        return "Healer Status:\nHealth: " + getHealth() + "\nScore: " + getScore()
                + "\nThe Healer's special move is '" + getSpecialMove() + "'";
    }
}
