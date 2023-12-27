package TowerDefence.scenes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel currentPanel; // Track the current panel

    public Menu() {
        setTitle("Tower Defence");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        currentPanel = createMainMenuPanel();
        getContentPane().add(currentPanel);

        setVisible(true);
    }

    private JPanel createMainMenuPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));


        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to start the game go to the StartGame class
                StartGame sg = new StartGame();
                // gg.setVisible(true);
                mainPanel.setVisible(false);
            }
        });

        JButton optionsButton = new JButton("Settings");
        optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code for settings class
                if (e.getSource() == optionsButton) {
                    // code to reopen the menu
                    Settings s = new Settings();
                    mainPanel.setVisible(false);
                }
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
                // Add code to navigates throught the rules class
                if (e.getSource() == rulesButton) {
                    // code to reopen the menu
                    Rules r = new Rules();
                    mainPanel.setVisible(false);
                }
            }
        });
        JButton creditsButton = new JButton("Credits");
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to exit the application
                 if (e.getSource() == creditsButton) {
                    // code to reopen the menu
                    Credits c = new Credits();
                    mainPanel.setVisible(false);
                }
            }
        });

        JButton highscoresButton = new JButton("Highscores");
        highscoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to navigates throught the highscores class
                if (e.getSource() == highscoresButton) {
                    // code to reopen the menu
                    Highscores h = new Highscores();
                    mainPanel.setVisible(false);
                }
                // System.exit(0);
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
        return mainPanel;
    }
}

