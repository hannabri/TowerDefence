package TowerDefence.scenes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import TowerDefence.source.Game;

public class Settings extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;
    private JFrame menu;
    private Game game;

    // Variable pour suivre le mode de jeu choisi
    private int selectedMode = -1;

    // Ajouter une méthode pour obtenir le mode de jeu sélectionné 0 = marathon, 1 = normal
    public int getSelectedMode() {
        return selectedMode;
    }

    public Settings() {
        // Create a panel
        JPanel panel = new JPanel();

        // Add the panel to the frame

        // Set the size, title, and location
        setSize(largeur, hauteur);
        setTitle("Settings");
        setLocationRelativeTo(null);

        // Create a button to return to the menu screen
        JButton returnButton = new JButton("Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si le bouton "Menu" est appuyé sans sélection de mode, utilisez le mode normal par défaut
                if (selectedMode == -1) {
                    selectedMode = 1;  // Mode Normal par défaut
                    System.out.println("Aucun mode choisi difficulté par défaut : Normal: " + selectedMode);
                }

                // Add code to return to the menu screen
                menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });

        // Set the two switch buttons, mode normal and mode marathon
        JToggleButton normalMode = new JToggleButton("Normal Mode", true);
        JToggleButton marathonMode = new JToggleButton("Marathon Mode", false);


        // Ajouter des gestionnaires d'événements pour les boutons basculants
        normalMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMode = 1;  // Mode Normal
                System.out.println("Mode choisi : Normal " + selectedMode);
            }
        });

        marathonMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMode = 0;
                System.out.println("Mode choisi : Marathon " + selectedMode);
            }
        });

        // Add buttons to a group to make them mutually exclusive
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(normalMode);
        modeGroup.add(marathonMode);

        // Add components to the panel
        panel.add(normalMode, BorderLayout.CENTER);
        panel.add(marathonMode, BorderLayout.CENTER);
        panel.add(returnButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(panel);
    }
}
