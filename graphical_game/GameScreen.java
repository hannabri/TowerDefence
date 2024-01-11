package TowerDefence.graphical_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JFrame {
    // Make all the components appears on the frame

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    public static final int OVAL_SIZE = 55;
    public static final int NUM_ENEMIS = 5;  // Number of moving enemis

    private Timer timer;
    private LogicalGame logicalGame; // Reference to the logical game

    public GameScreen() {
        // Set up the frame
        setTitle("Tower Defence");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Pass the reference to this GameScreen instance
        logicalGame = new LogicalGame(this);
    }

    // Draw the line for the enemis to go down only on those line
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Clear the frame
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw line to separate the paths
        for (int l = 1; l < 8; l++) {
            Graphics2D g2 = (Graphics2D) g;
            Line2D lin = new Line2D.Float(l*100, 0, l*100, FRAME_HEIGHT);
            g2.setColor(Color.GRAY);
            g2.draw(lin);
        }

        logicalGame.drawGameElements(g);
    }
}
