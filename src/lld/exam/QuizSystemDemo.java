package lld.exam;

import java.util.*;

// Custom Exceptions
class InvalidAnswerException extends Exception {
    public InvalidAnswerException(String message) { super(message); }
}

// ----------------- Question Class -----------------
class Question {
    String questionText;
    List<String> options;
    int correctOption; // index starting from 1

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean checkAnswer(int answer) throws InvalidAnswerException {
        if (answer < 1 || answer > options.size()) throw new InvalidAnswerException("Answer out of range!");
        return answer == correctOption;
    }

    public void display() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}

// ----------------- Exam Class -----------------
class Exam {
    String examName;
    List<Question> questions = new ArrayList<>();

    public Exam(String name) { this.examName = name; }

    public void addQuestion(Question q) { questions.add(q); }

    public void showQuestions() {
        System.out.println("--- Exam: " + examName + " ---");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Q" + (i + 1) + ":");
            questions.get(i).display();
        }
    }

    public int getTotalQuestions() { return questions.size(); }
}

// ----------------- Student Class -----------------
class Student {
    String name;
    String studentId;

    public Student(String name) {
        this.name = name;
        this.studentId = UUID.randomUUID().toString();
    }

    public Submission takeExam(Exam exam, Scanner sc) {
        Submission submission = new Submission(this, exam);
        System.out.println("\n--- Starting Exam: " + exam.examName + " ---");

        for (int i = 0; i < exam.getTotalQuestions(); i++) {
            Question q = exam.questions.get(i);
            q.display();
            System.out.print("Your answer (number): ");
            int answer = sc.nextInt();
            try {
                submission.submitAnswer(q, answer);
            } catch (InvalidAnswerException e) {
                System.out.println("❌ " + e.getMessage() + " | Question skipped");
            }
        }
        submission.calculateScore();
        return submission;
    }
}

// ----------------- Submission Class -----------------
class Submission {
    Student student;
    Exam exam;
    Map<Question, Integer> answers = new HashMap<>();
    int score;

    public Submission(Student student, Exam exam) {
        this.student = student;
        this.exam = exam;
        this.score = 0;
    }

    public void submitAnswer(Question q, int answer) throws InvalidAnswerException {
        answers.put(q, answer);
    }

    public void calculateScore() {
        score = 0;
        for (Map.Entry<Question, Integer> e : answers.entrySet()) {
            try {
                if (e.getKey().checkAnswer(e.getValue())) score++;
            } catch (InvalidAnswerException ex) {
                // Already handled while submitting
            }
        }
        System.out.println("\n✅ Student: " + student.name + " | Score: " + score + "/" + exam.getTotalQuestions());
    }
}

// ----------------- Demo / Main -----------------
public class QuizSystemDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Setup Exam
        Exam mathExam = new Exam("Math Quiz");

        mathExam.addQuestion(new Question(
                "2 + 2 = ?", Arrays.asList("3", "4", "5"), 2));

        mathExam.addQuestion(new Question(
                "5 * 3 = ?", Arrays.asList("15", "10", "20"), 1));

        mathExam.addQuestion(new Question(
                "10 / 2 = ?", Arrays.asList("4", "5", "6"), 2));

        // Create Student
        System.out.print("Enter student name: ");
        Student student = new Student(sc.nextLine());

        // Take Exam
        Submission submission = student.takeExam(mathExam, sc);

        // Optionally, show correct answers
        System.out.println("\n--- Correct Answers ---");
        for (Question q : mathExam.questions) {
            System.out.println(q.questionText + " | Correct Option: " + q.correctOption);
        }
    }
}
