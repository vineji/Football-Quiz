import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.ButtonUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import javax.swing.JFrame;

class Quiz implements Player {
    Color dark_blue = new Color(20, 30, 50);
    Color blue = new Color(4, 136, 204);
    Color LIME = new Color(174, 243, 89);
    Color RED = new Color(255, 64, 64);
    Color ORANGE = new Color(243, 133, 0);
    Color YELLOW = new Color(253, 215, 0);

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton[] buttons;
    private JButton correctButton;
    private JLabel messageArea;
    private JLabel timer;
    private JLabel score;
    int Score = 0;
    boolean button_enabled = false;


    public Quiz(PrintStream ps, InputStream is) {


        JFrame fb = new JFrame();
        fb.setLocationRelativeTo(null);


        // Create a panel with background colour dark blue
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(dark_blue);

        ///////////////////// Buttons /////////////////////////////////////////////
        ButtonUI customButtonUI = new BasicButtonUI() {
            private final int cornerRadius = 10;

            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setPaint(c.getBackground());
                g2.fillRect(0, 0, c.getWidth(), c.getHeight());

                g2.dispose();

                super.paint(g, c);
            }
        };
        Font newFont = new Font("Arial", Font.BOLD, 22); // Font name, style, and size

        button4 = new JButton("");
        button4.setBackground(LIME);
        button4.setOpaque(true);
        button4.setPreferredSize(new Dimension(200, 200));
        GridBagConstraints cGreen = new GridBagConstraints();
        cGreen.gridx = 2; // positions the button on x-axis 2
        cGreen.gridy = 2; // positions button on y-axis -2
        cGreen.anchor = GridBagConstraints.EAST;
        cGreen.insets = new Insets(50, 50, 50, 50); // some padding
        panel.add(button4, cGreen);
        button4.setUI(customButtonUI); // This sets the button to the background colour and the appropriate size
        button4.setFont(newFont);

        button4.addMouseListener(new MouseAdapter() { // When the mouse hovers over the buttons a blue border shows up so the user
                                                      // knows that they are over that button
            @Override
            public void mouseEntered(MouseEvent e) {


                Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
                Border border = BorderFactory.createLineBorder(blue, 10); //
                Border compoundBorder = BorderFactory.createCompoundBorder(border, emptyBorder);
                button4.setBorder(compoundBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button4.setBorder(null);
            }
        });


        button3 = new JButton("");
        button3.setBackground(ORANGE);
        button3.setOpaque(true);
        button3.setPreferredSize(new Dimension(200, 200));
        button3.setUI(customButtonUI);
        GridBagConstraints cTangerine = new GridBagConstraints();
        cTangerine.gridx = 2;
        cTangerine.gridy = 1;
        cTangerine.anchor = GridBagConstraints.EAST;
        cTangerine.insets = new Insets(50, 50, 50, 50); // Add some padding
        panel.add(button3, cTangerine);
        button3.setFont(newFont);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
                Border border = BorderFactory.createLineBorder(blue, 10); //
                Border compoundBorder = BorderFactory.createCompoundBorder(border, emptyBorder);

                button3.setBorder(compoundBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button3.setBorder(null);
            }
        });


        button1 = new JButton("");
        button1.setBackground(RED);
        button1.setOpaque(true);
        button1.setPreferredSize(new Dimension(200, 200));
        GridBagConstraints cRed = new GridBagConstraints();
        cRed.gridx = 0;
        cRed.gridy = 1;
        cRed.anchor = GridBagConstraints.WEST;
        cRed.insets = new Insets(50, 50, 50, 50); // Add some padding
        panel.add(button1, cRed);
        button1.setUI(customButtonUI);
        button1.setFont(newFont);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
                Border border = BorderFactory.createLineBorder(blue, 10); //
                Border compoundBorder = BorderFactory.createCompoundBorder(border, emptyBorder);

                button1.setBorder(compoundBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBorder(null);
            }
        });


        button2 = new JButton("");
        button2.setBackground(YELLOW);
        button2.setOpaque(true);
        button2.setPreferredSize(new Dimension(200, 200));
        GridBagConstraints cYellow = new GridBagConstraints();
        cYellow.gridx = 0;
        cYellow.gridy = 2;
        cYellow.anchor = GridBagConstraints.SOUTHWEST;
        cYellow.insets = new Insets(50, 50, 50, 50); // Add some padding
        panel.add(button2, cYellow);
        button2.setUI(customButtonUI);
        button2.setFont(newFont);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
                Border border = BorderFactory.createLineBorder(blue, 10); //
                Border compoundBorder = BorderFactory.createCompoundBorder(border, emptyBorder);

                button2.setBorder(compoundBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button2.setBorder(null);
            }
        });

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage(isCorrectAnswer(button1)); // everytime the button is pressed it checks whether the answer
            }                                          // on that button is correct
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage(isCorrectAnswer(button2));
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage(isCorrectAnswer(button3));
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage(isCorrectAnswer(button4));
            }
        });
        buttons = new JButton[]{button1, button2, button3, button4};
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        messageArea = new JLabel(""); // This where the instructions, rules and questions will show up.
        messageArea.setFont(messageArea.getFont().deriveFont(25f));
        messageArea.setHorizontalAlignment(JLabel.CENTER);
        messageArea.setBackground(blue);
        messageArea.setOpaque(true);
        messageArea.setPreferredSize(new Dimension(200, 100));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 2.0;
        c.weighty = 2.0;
        c.insets = new Insets(50, 50, 50, 50); // Add some padding
        panel.add(messageArea, c);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        timer = new JLabel("Timer"); // This shows the user how many seconds left to memorise and select answers
        timer.setFont(timer.getFont().deriveFont(30f));
        timer.setHorizontalAlignment(JLabel.CENTER);
        timer.setBackground(blue);
        timer.setOpaque(true);
        timer.setPreferredSize(new Dimension(200, 100));

        GridBagConstraints cTimer = new GridBagConstraints();
        cTimer.gridx = 0;
        cTimer.gridy = 0;
        cTimer.anchor = GridBagConstraints.NORTHWEST;
        cTimer.insets = new Insets(50, 50, 50, 50); // Add some padding
        panel.add(timer, cTimer);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        score = new JLabel("2"); //This shows the user's  score
        score.setFont(score.getFont().deriveFont(25f));
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setBackground(blue);
        score.setOpaque(true);
        score.setPreferredSize(new Dimension(200, 100));

        GridBagConstraints cScore = new GridBagConstraints();
        cScore.gridx = 2;
        cScore.gridy = 0;
        cScore.anchor = GridBagConstraints.NORTHEAST;
        cScore.insets = new Insets(50, 50, 50, 50); // Padding

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        panel.add(score, cScore);

        fb.pack();
        fb.getContentPane().add(panel);
        fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fb.setVisible(true);

    }

    public void timer(double k) {

        for (double i = k; i >= 0; i--) {
            timer.setText(String.valueOf(i));
            try {
                Thread.sleep((long) (k * 100));// Wait for 10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public void mixColors(){

        // This method is to change the colour of the buttons to confuse the user
        
        button1.setBackground(ORANGE);
        button2.setBackground(RED);
        button3.setBackground(LIME);
        button4.setBackground(YELLOW);
        delay(0.5);
        
        button1.setBackground(YELLOW);
        button2.setBackground(ORANGE);
        button3.setBackground(RED);
        button4.setBackground(LIME);
        delay(0.5);
        
        button1.setBackground(LIME);
        button2.setBackground(YELLOW);
        button3.setBackground(ORANGE);
        button4.setBackground(RED);
        delay(0.5);
        
        button1.setBackground(RED);
        button2.setBackground(LIME);
        button3.setBackground(YELLOW);
        button4.setBackground(ORANGE);
        delay(0.5);
        
        button1.setBackground(YELLOW);
        button2.setBackground(ORANGE);
        button3.setBackground(RED);
        button4.setBackground(LIME);
        delay(0.5);
        
        button1.setBackground(LIME);
        button2.setBackground(YELLOW);
        button3.setBackground(ORANGE);
        button4.setBackground(RED);
        delay(0.5);
        
        button1.setBackground(RED);
        button2.setBackground(LIME);
        button3.setBackground(YELLOW);
        button4.setBackground(ORANGE);
        delay(0.5);
        
        button1.setBackground(YELLOW);
        button2.setBackground(ORANGE);
        button3.setBackground(RED);
        button4.setBackground(LIME);
        delay(0.5);
        
        button1.setBackground(LIME);
        button2.setBackground(YELLOW);
        button3.setBackground(ORANGE);
        button4.setBackground(RED);
        delay(0.5);
        
                
                        
    }
    public JButton mixAnswers(String question, String [] wrong_answers, String correctAnswer, double time){

        // This method takes in the question and its answers and then set the correct answer to a random button using a random generator.
        Random random = new Random();
        int random_button = random.nextInt(4);
        correctButton = buttons[random_button];
        int random_n = random.nextInt(2);
        button_enabled = false;

        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");

        // These are the original colours of each button
        button1.setBackground(RED);
        button2.setBackground(YELLOW);
        button3.setBackground(ORANGE);
        button4.setBackground(LIME);


                                
        if (correctButton == button1){
            // In this scenario the correct button is button 1.
            if (random_n == 0){
                button1.setText(wrong_answers[2]);
                button2.setText(wrong_answers[0]);
                button3.setText(wrong_answers[1]);
                button4.setText(correctAnswer);// The correct answer will be shown on button 4 with the colour lime.
                timer(time);

                // The answers disappear, the colours change and the question is shown
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                delay(0.5);
                show(question);
                mixColors();

                // The user has to choose the colour which had the correct answer which in this case was lime.
                button1.setBackground(LIME);// Therefore button 1 will have background colour lime.
                button2.setBackground(RED);
                button3.setBackground(YELLOW);
                button4.setBackground(ORANGE);
                
            }
            else if (random_n == 1){
                button1.setText(wrong_answers[2]);
                button2.setText(correctAnswer);
                button3.setText(wrong_answers[0]);
                button4.setText(wrong_answers[1]);
                timer(time);

                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                delay(0.5);
                show(question);
                mixColors();
                
                button1.setBackground(YELLOW);
                button2.setBackground(LIME);
                button3.setBackground(RED);
                button4.setBackground(ORANGE);
                
            }
            
        }
        else if (correctButton == button2)
        {
            if (random_n == 0){
                button1.setText(correctAnswer);
                button2.setText(wrong_answers[0]);
                button3.setText(wrong_answers[1]);
                button4.setText(wrong_answers[2]);

                timer(time);

                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                
                delay(0.5);
                show(question);
                mixColors();
                
                button1.setBackground(ORANGE);
                button2.setBackground(RED);
                button3.setBackground(LIME);
                button4.setBackground(YELLOW);
                
            }
            else if (random_n == 1){

                button1.setText(wrong_answers[1]);
                button2.setText(wrong_answers[2]);
                button3.setText(correctAnswer);
                button4.setText(wrong_answers[0]);

                timer(time);

                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                
                delay(0.5);
                show(question);
                mixColors();
                
                button1.setBackground(RED);
                button2.setBackground(ORANGE);
                button3.setBackground(LIME);
                button4.setBackground(YELLOW);
                
            }
        }
        else if (correctButton == button3) {

            if (random_n == 0){
                button1.setText(wrong_answers[1]);
                button2.setText(correctAnswer);
                button3.setText(wrong_answers[0]);
                button4.setText(wrong_answers[2]);

                timer(time);
                
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                
                delay(0.5);
                show(question);
                mixColors();
                
                button1.setBackground(ORANGE);
                button2.setBackground(LIME);
                button3.setBackground(YELLOW);
                button4.setBackground(RED);
                
            }
            else if (random_n == 1){

                button1.setText(correctAnswer);
                button2.setText(wrong_answers[0]);
                button3.setText(wrong_answers[2]);
                button4.setText(wrong_answers[1]);

                timer(time);
                
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                
                delay(0.5);
                show(question);
                mixColors();
                
                button1.setBackground(LIME);
                button2.setBackground(YELLOW);
                button3.setBackground(RED);
                button4.setBackground(ORANGE);
                
            }
            
        }
        else if (correctButton == button4) {
            
            if (random_n == 0){
                button1.setText(wrong_answers[1]);
                button2.setText(wrong_answers[0]);
                button3.setText(wrong_answers[2]);
                button4.setText(correctAnswer);
                
                timer(time);
                
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                
                delay(0.5);
                show(question);
                mixColors();
                
                button1.setBackground(ORANGE);
                button2.setBackground(RED);
                button3.setBackground(YELLOW);
                button4.setBackground(LIME);
                
                                    }
            else if (random_n == 1){
                button1.setText(wrong_answers[2]);
                button2.setText(wrong_answers[1]);
                button3.setText(correctAnswer);
                button4.setText(wrong_answers[0]);
                
                timer(time);
                
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");

                delay(0.5);
                show(question);
                mixColors();
                
                button1.setBackground(LIME);
                button2.setBackground(YELLOW);
                button3.setBackground(RED);
                button4.setBackground(ORANGE);
            }
        }
        button_enabled = true;
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        timer(10);
        show("");
        
        return null;
        
    }
    public void delay(double n) {
        // To give time for user to read instructions, questions and choose answers.
        n = n*1000;
        try {
            Thread.sleep((long) n) ;// Wait for n seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void givePoints(int points_gained){
        // Points rewarded for each correct answer
        Score = Score +  points_gained;
        score.setText("score: " +  String.valueOf(Score));
    }
    public void takePoints(int pointsTaken){
        // Point taken for each wrong answer
        Score = Score - pointsTaken;
        score.setText("score: "+  String.valueOf(Score));
    }

    public boolean isCorrectAnswer(JButton button) {
        //Checks if the button pressed contained the right answer

        return button == correctButton;
    }

    public void showMessage(boolean isCorrect) {
        if (button_enabled == true){
            if (isCorrect) {
                show("Correct answer!");
                givePoints(15);
                button_enabled = false;
                        
            } else {
                show("Wrong answer!");
                takePoints(5);
            }
        }
    }
    public void show(String sentence){
        //Shows the string in messageArea
        messageArea.setText("<html>"+  sentence+  "<html>");
    }

    public void end_quiz (){
        // Shows the user's final score once they have finished the quiz
        messageArea.setText(" You have reached the end of the quiz");
        delay(3);
        score.setText("");
        timer.setText("");
        messageArea.setText(" Your final score was "+  Score+  " points.");
    }
}
