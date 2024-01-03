package TowerDefence.scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;
    private JFrame menu;

    public GameOver() {
        // Set the size, title, and location
        setSize(largeur, hauteur);
        setTitle("GAME OVER");
        setLocationRelativeTo(null);

        // Create an ImagePanel to display an image
        ImagePanel imagePanel = new ImagePanel("C:/Users/marie/OneDrive/Documents/eveil musical/ombre.jpg");
        add(imagePanel, BorderLayout.CENTER);

        // Create a button to return to the menu screen
        JButton returnButton = new JButton("Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to return to the menu screen
                menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });

        add(returnButton, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
