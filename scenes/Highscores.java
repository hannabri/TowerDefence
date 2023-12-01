package TowerDefence.scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Highscores extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;
    private JFrame menu;

    public Highscores() {
        // Create a panel
        JPanel panel = new JPanel();

        // Add the panel to the frame
        add(panel, BorderLayout.NORTH);

        // Set the size, title, and location
        setSize(largeur, hauteur);
        setTitle("Highscores");
        setLocationRelativeTo(null);

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

        //  Get the previous scores from the file
        add(returnButton, BorderLayout.SOUTH);
        // Set the text area to be uneditable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(panel);
    }
}
