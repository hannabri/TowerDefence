package TowerDefence.scenes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Tower Defence");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to start the game go to the StartGame class
                System.out.println("Starting the game...");
            }
        });

        JButton optionsButton = new JButton("Settings");
        optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code for settings class
                System.out.println("Opening settings...");
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to exit the application
                System.exit(0);
            }
        });

        JButton rulesButton = new JButton("Rules");
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to exit the application
                System.exit(0);
            }
        });
        JButton creditsButton = new JButton("Credits");
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to exit the application
                System.exit(0);
            }
        });

        JButton highscoresButton = new JButton("Highscores");
        highscoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to exit the application
                System.exit(0);
            }
        });

        mainPanel.add(startButton);
        mainPanel.add(optionsButton);
        mainPanel.add(highscoresButton);
        mainPanel.add(rulesButton);
        mainPanel.add(creditsButton);
        mainPanel.add(exitButton);




        getContentPane().add(mainPanel);

        setVisible(true);
    }
}
