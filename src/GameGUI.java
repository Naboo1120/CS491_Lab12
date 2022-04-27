import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameGUI extends JFrame {
    private JTextField textField1;
    private int compNum;
    private int count = 0;
    private JButton guessButton;
    private JButton GIVEUPButton;
    private JLabel feedback;
    private JLabel Title;
    private JLabel lblEnter;
    private JPanel mainPanel;
    private String Level = "Easy";


    public void checkGuess(){
        //Holds Users Guess
        String userGuess = textField1.getText();
        //Add to count or number of guesses
        count++;
        //Convert types
        int intUserGuess = Integer.parseInt(userGuess);

        try {
            //User input vs comps number
            if (intUserGuess < compNum) {
                feedback.setText("You number " + intUserGuess +" is to low");

            } else if (intUserGuess > compNum) {
                feedback.setText("You number " + intUserGuess +" is to high");
            } else if (count == 3) {
                feedback.setText("You took to many Guesses, Retry!");
                nextGame(Level);
            } else {
                feedback.setText("You Won the number was " + compNum);
                nextGame(Level);
            }
        } catch (Exception e) {
           feedback.setText("Enter a number");
        }
    }

    public void nextGame(String Level){
        if(Level == "Easy"){
            compNum = (int)((Math.random()*10)+1);
        }
        if(Level == "Hard"){
            compNum = (int)((Math.random()*100)+1);
        }
    }

    public GameGUI(String Difficulty){
        super(Difficulty);

        String Level = Difficulty;

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        nextGame(Level);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        GIVEUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessButton.setEnabled(false);
                feedback.setText("You gave UP! The Answer was " + compNum);

            }
        });
    }

}
