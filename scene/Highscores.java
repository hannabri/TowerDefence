package TowerDefence.scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Highscores extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;

    public Highscores() {
        // Create a button that will navigate to the Menu scene
        JButton menuButton = new JButton("Menu");
        menuButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        menuButton.addActionListener(e -> {
            // Code to re open the menu frame

        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Align the buttons in the center
        panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        // Add the button to the panel
        panel.add(menuButton);

        // If I click on the button, I want to navigate to the Menu scene
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to the Menu scene
                if (e.getSource() == menuButton) {
                    // code to reopen the menu
                    dispose();
                    Menu menu = new Menu();
                    menu.setVisible(true);
                }
            }
        });

        // Add the panel to the frame
        add(panel, BorderLayout.NORTH);

        // Set the size, title, and location
        setSize(largeur, hauteur);
        setTitle("Highscores");
        setLocationRelativeTo(null);

        // Set the text area to be uneditable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
