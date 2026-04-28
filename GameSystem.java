package quizlet;

import java.util.Scanner;

/**
 * Main application class for the Quizlet-style educational game.
 */
public class GameSystem {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println(" Quizlet-Style Educational Game");
        System.out.println(" Computer Architecture & Data Structures");
        System.out.println("============================================");

        System.out.print("Enter your name: ");
        String userName = inputScanner.nextLine().trim();

        if (userName.isEmpty()) {
            userName = "Student";
        }

        User currentUser = new User(userName);

        QuestionSet selectedQuestionSet = chooseStudyTopic(inputScanner);
        String selectedMode = chooseQuizMode(inputScanner);

        if (selectedMode.equals("Challenge")) {
            selectedQuestionSet.shuffleQuestions();
        }

        System.out.println("\nSelected topic: " + selectedQuestionSet.getTopicName());
        System.out.println("Selected mode: " + selectedMode);

        Quiz quiz = new Quiz();
        for (Question question : selectedQuestionSet.getQuestions()) {
            quiz.addQuestion(question);
        }

        int finalScoreValue = quiz.runQuiz(inputScanner);
        currentUser.setLatestScore(finalScoreValue);

        Score scoreSummary = new Score(finalScoreValue, selectedQuestionSet.getQuestionCount());
        scoreSummary.displayScoreSummary();
        currentUser.displayUserResult();

        System.out.print("\nWould you like to review your answers? (Y/N): ");
        String reviewChoice = inputScanner.nextLine().trim();
        if (reviewChoice.equalsIgnoreCase("Y")) {
            quiz.displayReview();
        }

        System.out.println("\nThank you for using the Quizlet-Style Educational Game!");
        inputScanner.close();
    }

    private static QuestionSet chooseStudyTopic(Scanner inputScanner) {
        while (true) {
            System.out.println("\nChoose a study topic:");
            System.out.println("1. Data Structures");
            System.out.println("2. Computer Architecture");
            System.out.println("3. Mixed Review");
            System.out.print("Enter choice: ");

            String choice = inputScanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return QuestionSet.createDataStructuresSet();
                case "2":
                    return QuestionSet.createComputerArchitectureSet();
                case "3":
                    return QuestionSet.createMixedSet();
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static String chooseQuizMode(Scanner inputScanner) {
        while (true) {
            System.out.println("\nChoose quiz mode:");
            System.out.println("1. Practice Mode (questions stay in normal order)");
            System.out.println("2. Challenge Mode (questions are shuffled)");
            System.out.print("Enter choice: ");

            String choice = inputScanner.nextLine().trim();

            if (choice.equals("1")) {
                return "Practice";
            } else if (choice.equals("2")) {
                return "Challenge";
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }
}
