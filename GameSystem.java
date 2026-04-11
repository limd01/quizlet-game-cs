package quizlet;

import java.util.Scanner;

public class GameSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        User user = new User(name);

        QuestionSet qs = new QuestionSet();
        qs.addQuestion(new Question("What is a stack?", "LIFO"));
        qs.addQuestion(new Question("What is Big-O of binary search?", "O(log n)"));
        qs.addQuestion(new Question("What does CPU stand for?", "Central Processing Unit"));
        qs.shuffle();

        Quiz quiz = new Quiz();

        for (int i = 0; i < qs.size(); i++) {
            quiz.addQuestion(qs.getQuestion(i));
        }

        int result = quiz.startQuiz();
        user.setScore(result);

        Score finalScore = new Score(result, qs.size());
        finalScore.displayScore();

        user.displayResult();

        sc.close();
    }
}