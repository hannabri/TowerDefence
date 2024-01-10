package TowerDefence.scenes;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Credits extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;
    private JFrame menu;

    public Credits() {
        // Create a panel
        JPanel panel = new JPanel();

        // Add the panel to the frame
        add(panel, BorderLayout.NORTH);

        // Set the size, title, and location
        setSize(largeur, hauteur);
        setTitle("Credits");
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
        add(returnButton, BorderLayout.SOUTH);

        JLabel label = new JLabel();
        label.setVerticalAlignment(JLabel.TOP); // Align text to the top
        label.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 14)); // Set the font size

        panel.add(new JScrollPane(label), BorderLayout.CENTER);

        label.setText("<html><body><p align='justify'>Remerciements : <br>" +
        "Nous tenions à remercier Alexis Bechet <br> et Marvin Gravert pour leur précieuse <br> aide ainsi que nos cammarades de <br> promotions pour leur soutiens durant <br> le semestre. </p></body></html>");
        // Set the text area to be uneditable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(panel);
    }
}
