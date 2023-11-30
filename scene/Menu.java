package TowerDefence.scene;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public static void graphical_game(String[] args) {
        // Créer une fenêtre JFrame
        JFrame menu = new JFrame("Tower Defense Game");

        // Spécifier les opérations par défaut lorsque la fenêtre est fermée
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer un panneau JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //align the buttons in the center
        panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start Game");
        startButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        startButton.setPreferredSize(new Dimension(400, 100));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to the Start Game scene
            }
        });

        JButton settingsButton = new JButton("Settings");
        settingsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to the Settings scene
            }
        });

        JButton rulesButton = new JButton("Rules");
        rulesButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        rulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to the Rules scene
            }
        });

        JButton creditsButton = new JButton("Credits");
        creditsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        creditsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to the Credits scene
            }
        });

        JButton highscoresButton = new JButton("Highscores");
        highscoresButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        highscoresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (arg0.getSource() == highscoresButton) {
                    // Code to navigate to the Highscores scene
                    JFrame highscores = new Highscores();
                    highscores.setVisible(true);
                    // and the menu scene closes
                    //menu.setVisible(false);
                }

            }
        });

        //Quit game
        JButton quitButton = new JButton("Quit Game");
        quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to quit the game
                System.exit(0);
            }
        });

        panel.add(Box.createVerticalStrut(90));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(90)); // Espace de 10 pixels
        panel.add(settingsButton);
        panel.add(Box.createVerticalStrut(90));
        panel.add(rulesButton);
        panel.add(Box.createVerticalStrut(90));
        panel.add(highscoresButton);
        panel.add(Box.createVerticalStrut(90));
        panel.add(creditsButton);
        panel.add(Box.createVerticalStrut(90));
        panel.add(quitButton);

        // Ajouter le panneau à la fenêtre
        menu.getContentPane().add(panel);
        // Définir la taille de la fenêtre
        menu.setSize(500, 1000);
        // Rendre la fenêtre visible
        menu.setVisible(true);

    }

    public void setVisible(boolean b) {
    }



}


