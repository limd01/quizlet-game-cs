package quizlet;

/**
 * Represents one multiple-choice quiz question.
 */
public class Question {
    private String questionText;
    private String[] answerOptions;
    private char correctOption;
    private String explanation;

    public Question(String questionText, String[] answerOptions, char correctOption, String explanation) {
        this.questionText = questionText;
        this.answerOptions = answerOptions;
        this.correctOption = Character.toUpperCase(correctOption);
        this.explanation = explanation;
    }

    public void displayQuestion() {
        System.out.println("\n" + questionText);
        char optionLetter = 'A';
        for (String option : answerOptions) {
            System.out.println(optionLetter + ". " + option);
            optionLetter++;
        }
    }

    public boolean checkAnswer(char userAnswer) {
        return Character.toUpperCase(userAnswer) == correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public char getCorrectOption() {
        return correctOption;
    }

    public String getCorrectAnswerText() {
        int index = correctOption - 'A';
        if (index >= 0 && index < answerOptions.length) {
            return answerOptions[index];
        }
        return "Unknown";
    }

    public String getExplanation() {
        return explanation;
    }
}
