package TowerDefence.graphical_game;

import javax.swing.*;

import org.w3c.dom.ranges.Range;

import TowerDefence.scenes.GameOver;
import TowerDefence.scenes.Win;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JFrame {

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    public static final int OVAL_SIZE = 55;
    public static final int NUM_ENEMIS = 5;  // Number of moving ovals

    public int vague = 3;
    public Timer timer;
    public List<Enemi> enemis;
    public List<Ami> amis;
    public List<EnemiProjectile> projectilesEnemis;
    public List<AmiProjectile> projectilesAmis;


    public GameScreen() {
        setTitle("Tower Defence");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        enemis = new ArrayList<>();
        amis = new ArrayList<>();
        projectilesEnemis = new ArrayList<>();
        projectilesAmis = new ArrayList<>();

        startNextWave();


        timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Update the position of each oval
                
                updatePositionEnemi();

                updatePositionEnemiProj();

                updatePositionAmiProj();
                
                // updateEnemis();

                // updateAmi();

                startNextWave();

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
                amis.add(ami);
                projectilesAmis.add(new AmiProjectile(ami.getPositionX(), ami.getPositionY()));
                repaint();
            }
        });
    }

    public void updatePositionEnemi() {
        for (Pion oval : enemis) {
            oval.updatePosition();
            if (oval.getPositionY() > FRAME_HEIGHT) {
                timer.stop();
                System.out.println("Game Over");
                GameOver gameOver = new GameOver();
                gameOver.setVisible(true);
                break;
            }
        }
    }

    public void updatePositionEnemiProj() {

        for (Projectile projectile : projectilesEnemis){
            projectile.updateProjPosition();

            for (Ami ami : amis) {
                if (collideWithAmi(projectile, ami)) {
                    enemiProjCollideAmi(projectile, ami);
                    System.out.println(ami + " a perdu " + projectile.getDamage() + " points de vie. Il lui reste " + ami.pv + " points de vie.");
                }
            }

        }
    }

    public void updatePositionAmiProj() {

        for (Projectile projectile : projectilesAmis) {
            projectile.updateProjPosition();

            for (Enemi enemi : enemis) {
                if (collideWithEnemi(projectile, enemi)) {
                    AmiProjCollideEnemi(projectile, enemi);
                    System.out.println(enemi + " a perdu " + projectile.getDamage() + " points de vie. Il lui reste " + enemi.pv + " points de vie.");
                }
            }
        }
    }

    public boolean collideWithAmi(Projectile p, Ami a) {
        final ValueRange rangeX = ValueRange.of((int)p.getPosition()[0] - 25, (int)p.getPosition()[0] + 75);
        final ValueRange rangeY = ValueRange.of(a.getPositionX() - 4, a.getPositionX() + 4);

        if (rangeY.isValidIntValue((int) p.getPosition()[1]) && rangeX.isValidIntValue(a.getPositionX())) {
            System.out.println("Position proj: " + ((int) p.getPosition()[0] + 4) + ", " + ((int) p.getPosition()[1] + 4) + "Position Ami: " + a.getPositionX() + " , " + a.getPositionY());
            return true;
        }
        System.out.println("Position proj: " + p.getPosition()[0] + ", " + p.getPosition()[1] + " , " + "Position Ami: " + a.getPositionX() + " , " + a.getPositionY());
        return false;
    }

    public boolean collideWithEnemi (Projectile p, Enemi e) {
        final ValueRange rangeX = ValueRange.of((int)p.getPosition()[0] - 25, (int)p.getPosition()[0] + 75);
        final ValueRange rangeY = ValueRange.of(e.getPositionX() - 4, e.getPositionX() + 4);

        if (rangeY.isValidIntValue((int) p.getPosition()[1]) && rangeX.isValidIntValue(e.getPositionX())) {
            return true;
        }
        return false;
    }

    public void enemiProjCollideAmi(Projectile p, Ami a) {
        a.setPdv(a.pv - p.getDamage());
    }

    public void AmiProjCollideEnemi(Projectile p, Enemi e) {
        e.setPdv(e.pv - p.getDamage());
    }

    public List<Enemi> updateEnemis() {
        for (Pion oval : enemis) {
            if (oval.estMort()) {
                enemis.remove(oval);
            }
        }
        return enemis;
    }

    public List<Ami> updateAmi() {
        for (Pion oval : amis) {
            if (oval.estMort()) {
                amis.remove(oval);
            }
        }
        return amis;
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
                    projectilesEnemis.add(new EnemiProjectile(enemi.getPositionX(), enemi.getPositionY()));  // Set y to the top of the frame
                }
            } else {
                timer.stop();
                System.out.println("You won!");
                Win win = new Win();
                win.setVisible(true);
            }

        }
    }

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
        for (Enemi oval : enemis) {
            oval.draw(g);
        }
        for (Ami oval : amis) {
            oval.draw(g);
        }
        for (Projectile p : projectilesEnemis) {
            p.drawProj(g);
        }

        for (Projectile p : projectilesAmis) {
            p.drawProj(g);
        }

    }

}