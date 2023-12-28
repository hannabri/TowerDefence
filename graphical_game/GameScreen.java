package TowerDefence.graphical_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameScreen extends JFrame {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final int OVAL_SIZE = 20;
    private static final int NUM_OVALS = 5;  // Number of moving ovals

    private Timer timer;
    private List<Oval> ovals;

    public GameScreen() {
        setTitle("Random Ovals");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ovals = new ArrayList<>();

        // Initialize moving ovals to start from the top
        for (int i = 0; i < NUM_OVALS; i++) {
            ovals.add(new MovingOval(0));  // Set y to the top of the frame
        }

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the position of each oval
                for (Oval oval : ovals) {
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
                ovals.add(new StationaryOval(e.getX(), e.getY()));
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
        for (Oval oval : ovals) {
            oval.draw(g);
        }
    }

    private class MovingOval extends Oval {
        public MovingOval(int initialY) {
            super(initialY);
        }

        @Override
        public void updatePosition() {
            // Update the oval position for downward movement
            y += 5;

            // If the oval goes beyond the frame, reset its position
            if (y > FRAME_HEIGHT) {
                y = -size;
                x = getRandomPosition(FRAME_WIDTH);
                size = OVAL_SIZE;
            }
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.WHITE);
            g.drawOval(x, y, size, size);
        }

        private int getRandomPosition(int maxValue) {
            Random random = new Random();
            return random.nextInt(maxValue);
        }
    }

    private class StationaryOval extends Oval {
        public StationaryOval(int x, int y) {
            super(x, y);
        }

        @Override
        public void updatePosition() {
            // Stationary ovals do not move
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.RED); // Change color for stationary ovals
            g.drawOval(x, y, size, size);
        }
    }

    private abstract class Oval {
        protected int x;
        protected int y;
        protected int size;

        public Oval(int initialY) {
            // Initialize the oval position and size
            x = getRandomPosition(FRAME_WIDTH);
            y = initialY;
            size = OVAL_SIZE;
        }

        public Oval(int x, int y) {
            // Initialize the oval position and size based on the click position
            this.x = x;
            this.y = y;
            size = OVAL_SIZE;
        }

        public abstract void updatePosition();

        public abstract void draw(Graphics g);

        private int getRandomPosition(int maxValue) {
            Random random = new Random();
            return random.nextInt(maxValue);
        }
    }
}