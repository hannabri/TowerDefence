package TowerDefence.graphical_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JFrame {

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    public static final int OVAL_SIZE = 20;
    public static final int NUM_ROMAINS = 5;  // Number of moving ovals

    public Timer timer;
    public List<Pion> enemis;
    public List<Pion> amis;

    public GameScreen() {
        setTitle("Random Ovals");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        enemis = new ArrayList<>();
        amis = new ArrayList<>();

        // Initialize moving ovals to start from the top
        for (int i = 0; i < NUM_ROMAINS; i++) {
            enemis.add(new Enemi(0));  // Set y to the top of the frame
        }

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the position of each oval
                for (Pion oval : enemis) {
                    oval.updatePosition();
                }

                repaint();
            }
        });
        timer.start();

        // Add a mouse click listener to the frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Add a new stationary oval at the click position
                amis.add(new Ami(e.getX(), e.getY()));
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Clear the frame
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw each oval at its updated position
        for (Pion oval : enemis) {
            oval.draw(g);
        }
        for (Pion oval : amis) {
            oval.draw(g);
        }
    }

}