import javax.swing.*;


interface Player {
    void delay(double n);

    void timer(double k);

    void takePoints(int pointsTaken);


    void givePoints(int points_gained);

    JButton mixAnswers(String question, String[] wrong_answers, String correctAnswer, double time);

    void show(String sentence);


    boolean isCorrectAnswer(JButton button);

    void showMessage(boolean isCorrect);

    void mixColors();

    void end_quiz();


}