package quizlet;

/**
 * Calculates and displays score results.
 */
public class Score {
    private int correctAnswers;
    private int totalQuestions;

    public Score(int correctAnswers, int totalQuestions) {
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }

    public double getPercentage() {
        if (totalQuestions == 0) {
            return 0.0;
        }
        return (correctAnswers * 100.0) / totalQuestions;
    }

    public void displayScoreSummary() {
        System.out.println("\n==============================");
        System.out.println("Final Score: " + correctAnswers + "/" + totalQuestions);
        System.out.printf("Percentage: %.1f%%\n", getPercentage());
        System.out.println("Performance: " + getPerformanceMessage());
        System.out.println("==============================");
    }

    private String getPerformanceMessage() {
        double percentage = getPercentage();

        if (percentage >= 90) {
            return "Excellent work!";
        } else if (percentage >= 70) {
            return "Good job. Keep practicing.";
        } else if (percentage >= 50) {
            return "Fair attempt. Review the missed concepts.";
        } else {
            return "More practice recommended.";
        }
    }
}
