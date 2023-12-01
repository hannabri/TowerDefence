package TowerDefence.scenes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rules extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;
    private JFrame menu;

    public Rules() {
        // Create a panel
        JPanel panel = new JPanel();

        // Add the panel to the frame
        add(panel, BorderLayout.NORTH);

        // Set the size, title, and location
        setSize(largeur, hauteur);
        setTitle("Rules");
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

        //  Set the text area to be uneditable
        // set the text for the rules of the game

        add(returnButton, BorderLayout.SOUTH);
        // Set the text area to be uneditable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(panel);
    }
}
