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
    public static final int NUM_ENEMIS = 5;  // Number of moving ovals

    public Timer timer;
    public List<Pion> enemis;
    public List<Ami> amis;
    public List<Projectile> projectiles;

    public GameScreen() {
        setTitle("Tower Defence Game");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        enemis = new ArrayList<>();
        amis = new ArrayList<>();
        projectiles = new ArrayList<>();

        // Initialize moving ovals to start from the top
        for (int i = 0; i < NUM_ENEMIS; i++) {
            enemis.add(new Enemi(0));  // Set y to the top of the frame
            projectiles.add(new EnemisProjectile(enemis.get(i).getPositionX(), enemis.get(i).getPositionY() ));
        }

        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the position of each oval
                for (Pion oval : enemis) {
                    oval.updatePosition();
                }
                for (Projectile projectile : projectiles) {
                    projectile.updateProjPosition();
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
                Ami ami = new Ami(e.getX(), e.getY());
                amis.add(ami);
                projectiles.add(new AmiProjectile(ami.getPositionX(), ami.getPositionY()));
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
        for (Ami ami : amis) {
            ami.draw(g);
        }
        for (Projectile p : projectiles) {
            p.drawProj(g);
        }
    }
}
