package quizlet;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private int score;
    
    public User (String name){
        this.name = name;
        this.score = 0;
    }
    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for score
    public int getScore() {
        return score;
    }

    // Setter for score
    public void setScore(int score) {
        this.score = score;
    }

    // Method to display user results
    public void displayResult() {
        System.out.println("User: " + name);
        System.out.println("Score: " + score);
    }
}
