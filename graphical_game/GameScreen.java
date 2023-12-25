package TowerDefence.graphical_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;  // Correct import

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TowerDefence.scenes.Menu;
import TowerDefence.scenes.Settings;
import TowerDefence.source.GrilleJeu;

public class GameScreen extends JFrame {

    private static final int GRID_SIZE = 15;
    private static final int CELL_SIZE = 32;
    private JFrame menu;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private GameScreen gameScreen;
    private Gaulois1 currentGaulois;
    private int argent = GrilleJeu.argent;
    private int selectedMode = Settings.selectedMode;

    public GameScreen() {
        // Set up the frame
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panels
        JPanel gamePanel = new JPanel();
        JPanel menuPanel = new JPanel();
        JPanel gauloisPanel = new JPanel();

        // Set the layout of the panels
        gamePanel.setSize(WIDTH, HEIGHT);
        // put gride inside the game panel
        gamePanel.setBackground(Color.LIGHT_GRAY);



        // my menu panel contains the button to go back to the menu frame
        // my plant panel contains the buttons to buy plants
        // my game panel contains the grid and the game elements
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
        menuPanel.add(returnButton); // add the button to go back to the menu frame

        // add to the label my variable static argent in grille jeu

        JLabel argent = new JLabel("Argent :" + GrilleJeu.argent);
        menuPanel.add(argent); // add the label to the menu panel

        if (selectedMode == 0){
            JLabel selectedMode = new JLabel("Mode : Marathon");
            menuPanel.add(selectedMode);

        }else {
            JLabel selectedMode = new JLabel("Mode : Normal");
            menuPanel.add(selectedMode); // add the label to the menu panel
        }

        JButton Gaulois2 = new JButton("Gaulois 2");
        JButton Gaulois3 = new JButton("Gaulois 3");
        JButton Gaulois1 = new JButton("Gaulois 1");
        Gaulois1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a mouse listener to the GamePanel for handling mouse clicks
                gamePanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        // when my mouse is pressed on the component I want to be able to have a gaulois and put it on my grid (game panel)
                        Gaulois1 currentGaulois = new Gaulois1(0, 0); // Fix: Added variable declarator id
                        // Set the location of the Gaulois based on the mouse click
                        int gridX = e.getX() / CELL_SIZE;
                        int gridY = e.getY() / CELL_SIZE;
                        currentGaulois.setLocation(gridX, gridY);

                        // Trigger a repaint to update the display
                        gamePanel.repaint();
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // Remove the MouseListener after releasing the mouse
                        gamePanel.removeMouseListener(this);
                    }
                });
            ;
            };
        });
        gauloisPanel.add(Gaulois1);  // add the button to buy a gaulois
        gauloisPanel.add(Gaulois2);  // add the button to buy a gaulois
        gauloisPanel.add(Gaulois3);  // add the button to buy a gaulois
        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(gauloisPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }
}