package quizlet;

public class Score {
    private int score;
    private int total;

    public Score(int score, int total) {
        this.score = score;
        this.total = total;
    }

    public void displayScore() {
        System.out.println("Score: " + score + "/" + total);
    }
}