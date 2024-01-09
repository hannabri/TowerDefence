package TowerDefence.graphical_game;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.w3c.dom.ranges.Range;

import TowerDefence.scenes.GameOver;
import TowerDefence.scenes.Settings;
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

    // Create a label to display the money
    public JLabel moneyLabel;


    public GameScreen() {
        setTitle("Tower Defence");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        moneyLabel = new JLabel("Money: " + Ami.argent);

        // Add the label to the frame
        add(moneyLabel, BorderLayout.NORTH);



        enemis = new ArrayList<>();
        amis = new ArrayList<>();
        projectilesEnemis = new ArrayList<>();
        projectilesAmis = new ArrayList<>();

        startNextWave();

        // Create a panel to add the money and the level of the game


        timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Update the position of each oval

                updatePositionEnemi();

                updatePositionEnemiProj();

                updatePositionAmiProj();

                updateEnemis();

                updateAmi();

                startNextWave();

                repaint();
            }
        });

        timer.start();




        // Add a mouse click listener to the frame for adding a new ami at the click position
        // it suppose to add multiple projectile but it doesn't work
        // If you pull a new ami to the frame, then your money is argent - cout

        addMouseListener(new MouseAdapter() {
            // Inside your mouseClicked method
        @Override
        public void mouseClicked(MouseEvent e) {
            // Check if you have enough money to create an Ami
            if (Ami.argent >= Ami.cout) {
                Ami ami = new Ami(e.getX(), e.getY());
                // Deduct the cost from your money
                Ami.argent -= Ami.cout;
                // Add the new Ami to the list
                amis.add(ami);
                // Add a new corresponding projectile
                projectilesAmis.add(new AmiProjectile(ami.getPositionX(), ami.getPositionY()));
                repaint();
            } else {
                // Display a message in the JPanel
                JLabel notEnoughMoneyLabel = new JLabel("Not enough money to create an Ami!");
                notEnoughMoneyLabel.setForeground(Color.RED);
            }
        }

        });
    }

    public void updateArgent(){
        // method to update the money Label
        moneyLabel.setText("Money: " + Ami.argent);
    }

    // Update the position of each enemi and check if it is out of the frame
    // If it is out of the frame, stop the timer and show the game over message
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

    // Update the poition of each projectile and check if it collide with an ami
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

    // Update the poition of each projectile and check if it collide with an enemi

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

    // Check if a projectile collide with an ami
    public boolean collideWithAmi(Projectile p, Ami a) {
        final ValueRange rangeX = ValueRange.of((int)p.getPosition()[0] - 25, (int)p.getPosition()[0] + 75);
        final ValueRange rangeY = ValueRange.of(a.getPositionX() - 4, a.getPositionX() + 4);

        if (rangeY.isValidIntValue((int) p.getPosition()[1]) && rangeX.isValidIntValue(a.getPositionX())) {
            return true;
        }
        return false;
    }

    // Check if a projectile collide with an enemi
    public boolean collideWithEnemi (Projectile p, Enemi e) {
        final ValueRange rangeX = ValueRange.of((int)p.getPosition()[0] - 25, (int)p.getPosition()[0] + 75);
        final ValueRange rangeY = ValueRange.of(e.getPositionX() - 4, e.getPositionX() + 4);

        if (rangeY.isValidIntValue((int) p.getPosition()[1]) && rangeX.isValidIntValue(e.getPositionX())) {
            return true;
        }
        return false;
    }

    // If a projectile collide with an ami, the ami lose pv
    public void enemiProjCollideAmi(Projectile p, Ami a) {
        a.setPdv(a.pv - p.getDamage());
    }

    // If a projectile collide with an enemi, the enemi lose pv
    public void AmiProjCollideEnemi(Projectile p, Enemi e) {
        e.setPdv(e.pv - p.getDamage());
    }

    // Remove the dead enemies from the list and from the frame
    public void updateEnemis() {
        List<Enemi> enemiesToRemove = new ArrayList<>();

        for (Enemi enemi : enemis) {
            if (enemi.estMort()) {
                enemiesToRemove.add(enemi);
            }
        }

        enemis.removeAll(enemiesToRemove);
        enemiesToRemove.clear();
    }



    // Remove the dead amis from the list
    public void updateAmi() {

        List<Ami> amisToRemove = new ArrayList<>();

        for (Ami ami : amis) {
            if (ami.estMort()) {
                amisToRemove.add(ami);
            }
        }

        amis.removeAll(amisToRemove);
        amisToRemove.clear();
    }


    public boolean hasNextWave(int i) {
        // Verify if there is another enemy wave

        if (i >= vague) {
            return false;
        }

        return true;

    }

    // Start the next wave of enemis
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