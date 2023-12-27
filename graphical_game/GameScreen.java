package TowerDefence.graphical_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import TowerDefence.inputs.MyMouseListener;

public class GameScreen extends JFrame {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;


    public GameScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Create an instance of MyMouseListener and pass the GameScreen instance
        MyMouseListener mouseListener = new MyMouseListener(this);

        // Add the mouse listener to the frame
        addMouseListener(mouseListener);

        // Add the JPanel for drawing purposes (optional)
        JPanel drawingPanel = new JPanel();
        drawingPanel.setBackground(Color.BLACK);
        drawingPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(drawingPanel, BorderLayout.CENTER);

        JPanel settings = new JPanel();
        settings.setBackground(Color.BLACK);
        // settings.get

        // Make the frame visible
        setVisible(true);
    }

}
