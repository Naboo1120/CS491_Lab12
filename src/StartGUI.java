import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI extends JFrame{
    private JButton startGameButton;
    private JRadioButton easyRadioButton;
    private JRadioButton hardRadioButton;
    private JLabel LevelLbl;
    private JLabel Titlelbl;
    private JPanel mainPanel;

    String Difficulty = "";


    public StartGUI(String Titlelbl) {
        super(Titlelbl);

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(easyRadioButton.isSelected()){
                    Difficulty = "Easy";
                    dispose();
                    JFrame GameGUI = new GameGUI(Difficulty);
                    GameGUI.setVisible(true);

                }
                if(hardRadioButton.isSelected()){
                    Difficulty = "Hard";
                    dispose();
                    JFrame GameGUI = new GameGUI(Difficulty);
                    GameGUI.setVisible(true);

                }

                else{
                    LevelLbl.setText("Please Select A Level, again...");
                }

            }
        });
    }


    public static void main(String[] args) {
        JFrame startPage = new StartGUI("Number Guessing Game");
        startPage.setVisible(true);

    }

}

