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
    public static int selectedMode = -1;
    public static int selectedDifficulty = -1;

    // Ajouter une méthode pour obtenir le mode de jeu sélectionné 0 = marathon, 1 = normal
    public int getSelectedMode() {
        return selectedMode;
    }
    public int getselectedDifficulty() {
        return selectedDifficulty;
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
        JToggleButton mode1 = new JToggleButton("Level 1", true);
        JToggleButton mode2 = new JToggleButton("Level 2", false);
        JToggleButton mode3 = new JToggleButton("Level 3", false);


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

        mode1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDifficulty = 1;
                System.out.println("Mode choisi : Mode 1 " + selectedDifficulty);
            }
        });

        mode2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDifficulty = 2;
                System.out.println("Mode choisi : Mode 2 " + selectedDifficulty);
            }
        });

        mode3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDifficulty = 3;
                System.out.println("Mode choisi : Mode 3 " + selectedDifficulty);
            }
        });


        // Add buttons to a group to make them mutually exclusive
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(normalMode);
        modeGroup.add(marathonMode);

        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(mode1);
        difficultyGroup.add(mode2);
        difficultyGroup.add(mode3);

        // Add components to the panel
        panel.add(normalMode, BorderLayout.CENTER);
        panel.add(marathonMode, BorderLayout.CENTER);
        panel.add(returnButton, BorderLayout.SOUTH);
        panel.add(mode1, BorderLayout.CENTER);
        panel.add(mode2, BorderLayout.CENTER);
        panel.add(mode3, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(panel);
    }
}
