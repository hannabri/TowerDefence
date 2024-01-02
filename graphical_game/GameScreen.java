package TowerDefence.graphical_game;

import javax.swing.*;

import TowerDefence.scenes.GameOver;
import TowerDefence.scenes.Win;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JFrame {

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
<<<<<<< HEAD
    public static final int OVAL_SIZE = 20;
    public static final int NUM_ENEMIS = 5;  // Number of moving ovals
=======
    public static final int OVAL_SIZE = 50;
    public static final int NUM_ENEMIS = 5;  // Number of moving ovals
    
    public int vague = 3;
    public Timer timer;
    public List<Enemi> enemis;
    public List<Ami> amis;
    public List<Projectile> projectiles;
>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce

    public Timer timer;
    public List<Enemi> enemis;
    public List<Ami> amis;
    public List<Projectile> projectiles;

    public GameScreen() {
<<<<<<< HEAD
        setTitle("Tower Defence Game");
=======
        setTitle("Tower Defence");
>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        enemis = new ArrayList<>();
        amis = new ArrayList<>();
        projectiles = new ArrayList<>();

<<<<<<< HEAD
        // Initialize moving ovals to start from the top
        for (int i = 0; i < NUM_ENEMIS; i++) {
            Enemi enemi = new Enemi(0);
            enemis.add(enemi); projectiles.add(new EnemiProjectile(enemi.getPositionX(), enemi.getPositionY()));   // Set y to the top of the frame
        }
=======
        startNextWave();

>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                // Update the position of each oval and its projectiles
                for (Enemi enemi : enemis) {
                    enemi.updatePosition();
                }
                for (Projectile projectile : projectiles) {
                    projectile.updateProjPosition();
                }

                // Trigger the repaint to draw the updated positions
=======

                // Update the position of each oval
                updateEnemis();

                startNextWave();

                updatePositionEnemi();

>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce
                repaint();
            }
        });
        
        timer.start();

        // Add a mouse click listener to the frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ami ami = new Ami (e.getX(), e.getY()); 
                // Add a new stationary oval at the click position
<<<<<<< HEAD
                Ami ami = new Ami(e.getX(), e.getY());
=======
>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce
                amis.add(ami);
                projectiles.add(new AmiProjectile(ami.getPositionX(), ami.getPositionY()));
                repaint();
            }
        });
    }

<<<<<<< HEAD
=======
    public void updatePositionEnemi() {
        for (Pion oval : enemis) {
            oval.updatePosition(); 
            if (oval.getPositionY() > FRAME_HEIGHT) {
                timer.stop();
                GameOver gameOver = new GameOver();
                gameOver.setVisible(true);
            }
        }

        for (Projectile projectile : projectiles){
            projectile.updateProjPosition();

        }
    }

    
    public List<Enemi> updateEnemis() {
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
                    Enemi enemi = new Enemi(0);
                    enemis.add(enemi);
                    projectiles.add(new EnemiProjectile(enemi.getPositionX(), enemi.getPositionY()));  // Set y to the top of the frame
                } 
            } else {
                timer.stop();
                Win win = new Win();
                win.setVisible(true);
            }
            
        }
    }

>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce
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
        

        // Draw each oval at its updated position
<<<<<<< HEAD
        for (Enemi enemi : enemis) {
            enemi.draw(g);
        }
        for (Ami ami : amis) {
            ami.draw(g);
=======
        for (Enemi oval : enemis) {
            oval.draw(g);
        }
        for (Ami oval : amis) {
            oval.draw(g);
>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce
        }
        for (Projectile p : projectiles) {
            p.drawProj(g);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameScreen().setVisible(true);
            }
        });
    }
}
