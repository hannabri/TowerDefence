package TowerDefence.graphical_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.TreeUI;
import java.awt.GridLayout;

import TowerDefence.source.GameGUI;
import TowerDefence.scenes.Menu;




public class GameScreen extends JFrame {

    private static final int GRID_SIZE = 15;
    private static final int CELL_SIZE = 32;
    private JFrame menu;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private GameScreen gameScreen;

    public GameScreen() {
        // Set up the frame
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panels
        JPanel gamePanel = new JPanel();
        JPanel menuPanel = new JPanel();
        JPanel gauloisPanel = new JPanel();

        // my menu panel contains the button to go back to the menu frame
        // my plant panel contains the buttons to buy plants
        // my game panel contains the grid and the game elements
        menuPanel.setBackground(Color.BLUE);
        menuPanel.setSize(10,32);
        gauloisPanel.setBackground(Color.GREEN);
        gamePanel.setBackground(Color.RED);


        // Add the buttons to the gaulois panel
        gauloisPanel.add(new JButton("Gaulois 1"));
        gauloisPanel.add(new JButton("Gaulois 2")); // add the button to but gaulois
        gauloisPanel.add(new JButton("Gaulois 3"));

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

        // JButton Gaulois1 = new JButton("Gaulois 1");
        // Gaulois1.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // when I click on the button I want to set the gaulois on the grid
        //         Gaulois1.addMouseListener(mouseclicked);

        //         mouseclicked = new MouseClicked();
        //         mouserelase = new MouseRelease();
                // add code to set the gaulois on the grid

            }
        });

        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(gauloisPanel, BorderLayout.SOUTH);


        // Make the frame visible
        setVisible(true);
    }
}


