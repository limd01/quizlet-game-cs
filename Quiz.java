package quizlet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controls the quiz flow, validates input, checks answers, and stores review data.
 */
public class Quiz {
    private ArrayList<Question> quizQuestions;
    private ArrayList<Character> userAnswers;
    private int correctAnswerCount;

    public Quiz() {
        quizQuestions = new ArrayList<>();
        userAnswers = new ArrayList<>();
        correctAnswerCount = 0;
    }

    public void addQuestion(Question question) {
        quizQuestions.add(question);
    }

    public int runQuiz(Scanner inputScanner) {
        System.out.println("\nStarting quiz...");

        for (int questionIndex = 0; questionIndex < quizQuestions.size(); questionIndex++) {
            Question currentQuestion = quizQuestions.get(questionIndex);

            System.out.println("\nQuestion " + (questionIndex + 1) + " of " + quizQuestions.size());
            currentQuestion.displayQuestion();

            char userAnswer = readAnswerChoice(inputScanner);
            userAnswers.add(userAnswer);

            if (currentQuestion.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                correctAnswerCount++;
            } else {
                System.out.println("Incorrect.");
                System.out.println("Correct answer: " + currentQuestion.getCorrectOption() + ". "
                        + currentQuestion.getCorrectAnswerText());
            }

            System.out.println("Explanation: " + currentQuestion.getExplanation());
        }

        return correctAnswerCount;
    }

    private char readAnswerChoice(Scanner inputScanner) {
        while (true) {
            System.out.print("Enter your answer (A, B, C, or D): ");
            String userInput = inputScanner.nextLine().trim().toUpperCase();

            if (userInput.length() == 1) {
                char answerChoice = userInput.charAt(0);
                if (answerChoice >= 'A' && answerChoice <= 'D') {
                    return answerChoice;
                }
            }

            System.out.println("Invalid input. Please enter A, B, C, or D.");
        }
    }

    public void displayReview() {
        System.out.println("\nAnswer Review");
        System.out.println("-------------");

        for (int index = 0; index < quizQuestions.size(); index++) {
            Question currentQuestion = quizQuestions.get(index);
            char userAnswer = userAnswers.get(index);
            boolean isCorrect = currentQuestion.checkAnswer(userAnswer);

            System.out.println((index + 1) + ". " + currentQuestion.getQuestionText());
            System.out.println("   Your answer: " + userAnswer);
            System.out.println("   Correct answer: " + currentQuestion.getCorrectOption()
                    + ". " + currentQuestion.getCorrectAnswerText());
            System.out.println("   Result: " + (isCorrect ? "Correct" : "Incorrect"));
        }
    }
}
