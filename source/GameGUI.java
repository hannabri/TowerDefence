package TowerDefence.source;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class GameGUI {
    public static void graphical_game(String[] args) {

        // Créer une fenêtre JFrame
        JFrame frame = new JFrame("Tower Defense Game");

        // Spécifier les opérations par défaut lorsque la fenêtre est fermée
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer un panneau JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //align the buttons in the center
        panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start Game");
        startButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        startButton.setPreferredSize(new Dimension(400, 100));
        JButton settingsButton = new JButton("Settings");
        settingsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        JButton rulesButton = new JButton("Rules");
        rulesButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        JButton creditsButton = new JButton("Credits");
        creditsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        JButton highscoresButton = new JButton("Highscores");
        highscoresButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        JButton quitButton = new JButton("Quit Game");
        quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(100));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(100)); // Espace de 10 pixels
        panel.add(settingsButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(rulesButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(highscoresButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(creditsButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(quitButton);


        // Ajouter le panneau à la fenêtre
        frame.getContentPane().add(panel);

        // Définir la taille de la fenêtre
        frame.setSize(500, 1000);

        // Rendre la fenêtre visible
        frame.setVisible(true);

    }

}