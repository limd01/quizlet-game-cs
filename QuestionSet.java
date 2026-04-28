package quizlet;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Stores a group of quiz questions for a selected topic.
 */
public class QuestionSet {
    private ArrayList<Question> questionList;
    private String topicName;

    public QuestionSet(String topicName) {
        this.topicName = topicName;
        this.questionList = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public Question getQuestionByIndex(int index) {
        return questionList.get(index);
    }

    public int getQuestionCount() {
        return questionList.size();
    }

    public String getTopicName() {
        return topicName;
    }

    public void shuffleQuestions() {
        Collections.shuffle(questionList);
    }

    public ArrayList<Question> getQuestions() {
        return questionList;
    }

    public static QuestionSet createDataStructuresSet() {
        QuestionSet set = new QuestionSet("Data Structures");

        set.addQuestion(new Question(
                "What principle does a stack follow?",
                new String[] {"FIFO", "LIFO", "Random access", "Priority order"},
                'B',
                "A stack follows LIFO: Last In, First Out."));

        set.addQuestion(new Question(
                "Which data structure is commonly used for BFS?",
                new String[] {"Stack", "Queue", "Heap", "HashMap"},
                'B',
                "Breadth-first search uses a queue to visit nodes level by level."));

        set.addQuestion(new Question(
                "What is the average time complexity of binary search?",
                new String[] {"O(1)", "O(n)", "O(log n)", "O(n^2)"},
                'C',
                "Binary search repeatedly halves the search space, so it is O(log n)."));

        set.addQuestion(new Question(
                "Which structure stores key-value pairs?",
                new String[] {"HashMap", "Stack", "Queue", "Array only"},
                'A',
                "A HashMap stores data using keys and values."));

        set.addQuestion(new Question(
                "Which traversal visits left subtree, root, then right subtree?",
                new String[] {"Preorder", "Inorder", "Postorder", "Level-order"},
                'B',
                "Inorder traversal visits left, root, then right."));

        return set;
    }

    public static QuestionSet createComputerArchitectureSet() {
        QuestionSet set = new QuestionSet("Computer Architecture");

        set.addQuestion(new Question(
                "What does CPU stand for?",
                new String[] {"Central Processing Unit", "Computer Power Utility", "Central Program Unit", "Control Processing User"},
                'A',
                "CPU stands for Central Processing Unit."));

        set.addQuestion(new Question(
                "Which memory is usually fastest?",
                new String[] {"Hard drive", "RAM", "Cache", "DVD"},
                'C',
                "Cache memory is very fast and is located close to the CPU."));

        set.addQuestion(new Question(
                "What does RAM stand for?",
                new String[] {"Random Access Memory", "Read Always Memory", "Rapid Application Module", "Runtime Access Method"},
                'A',
                "RAM stands for Random Access Memory."));

        set.addQuestion(new Question(
                "What is pipelining used for in a CPU?",
                new String[] {"Increasing disk size", "Overlapping instruction stages", "Reducing screen brightness", "Deleting memory"},
                'B',
                "Pipelining improves performance by overlapping stages of instruction execution."));

        set.addQuestion(new Question(
                "What does ALU stand for?",
                new String[] {"Arithmetic Logic Unit", "Advanced Link Utility", "Array Logic User", "Automatic Load Unit"},
                'A',
                "The ALU performs arithmetic and logical operations."));

        return set;
    }

    public static QuestionSet createMixedSet() {
        QuestionSet mixedSet = new QuestionSet("Mixed Review");
        mixedSet.getQuestions().addAll(createDataStructuresSet().getQuestions());
        mixedSet.getQuestions().addAll(createComputerArchitectureSet().getQuestions());
        return mixedSet;
    }
}
