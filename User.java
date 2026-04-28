package quizlet;

/**
 * Represents the student using the quiz system.
 */
public class User {
    private String userName;
    private int latestScore;

    public User(String userName) {
        this.userName = userName;
        this.latestScore = 0;
    }

    public String getUserName() {
        return userName;
    }

    public int getLatestScore() {
        return latestScore;
    }

    public void setLatestScore(int latestScore) {
        this.latestScore = latestScore;
    }

    public void displayUserResult() {
        System.out.println("Student: " + userName);
        System.out.println("Latest correct answers: " + latestScore);
    }
}
