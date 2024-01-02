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
    
    public int vague = 3;
    public Timer timer;
    public List<Pion> enemis;
    public List<Pion> amis;
    public List<Projectile> projectiles;
    public static final int NUM_ENEMIS = 5;  // Number of moving ovals


    public GameScreen() {
        setTitle("Random Ovals");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        enemis = new ArrayList<>();
        amis = new ArrayList<>();
        projectiles = new ArrayList<>();


        startNextWave();


        timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the position of each oval
        
                for (Pion oval : enemis) {
                    oval.updatePosition();
                }

                updateEnemis();



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

    public List<Pion> updateEnemis() {
        for (Pion oval : enemis) {
            if (oval.estMort()) {
                enemis.remove(oval);
            }
        }
        return enemis;
    }

    public boolean hasNextWave(int i) {
        // verify if there is another enemy wave

        if (i >= vague) {
            return false;
        }

        return true;

    }

    public void startNextWave() {
        int w = 1;
        if (enemis.isEmpty()) {
            if (hasNextWave(w)) {
                w ++;
                for (int i = 0; i < NUM_ENEMIS; i++) {
                    enemis.add(new Enemi(0));  // Set y to the top of the frame
                } 
            } else {
                // end the game! --> amis ont gagné!
            }
            
        }
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
        for (Projectile p : projectiles) {
            p.drawProj(g);
        }
    }

}