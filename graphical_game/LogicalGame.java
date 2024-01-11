package TowerDefence.graphical_game;

import javax.swing.*;

import TowerDefence.scenes.GameOver;
import TowerDefence.scenes.Win;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

public class LogicalGame {

    // The logic of the game is implemented here

    private Timer timer;
    private List<Enemi> enemis;
    private List<Ami> amis;
    private List<EnemiProjectile> projectilesEnemis;
    private List<AmiProjectile> projectilesAmis;

    public static final int OVAL_SIZE = 55;
    public static final int NUM_ENEMIS = 5;  // Number of moving ovals

    public int vague = 3;
    private GameScreen gameScreen; // Reference to the GameScreen instance

    public LogicalGame(GameScreen gameScreen) {
        // Pass as argument the game screen to be able to create a connexion
        // between the logical game and the game screen
        this.gameScreen = gameScreen;

        enemis = new ArrayList<>();
        amis = new ArrayList<>();
        projectilesEnemis = new ArrayList<EnemiProjectile>();
        projectilesAmis = new ArrayList<AmiProjectile>();

        initializeGameScreenListeners();

        startNextWave();

        timer = new Timer(100, e -> {
            updateGameLogic();
            gameScreen.repaint();
        });

        timer.start();
    }

    // Method to add to the game screen the clic of the mouse
    private void initializeGameScreenListeners() {
        gameScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClicked(e);
            }
        });
    }


    // Method : if the mouse is clicked, then an ami will appear and a projectil
    // will be drawn
    public void handleMouseClicked(MouseEvent e) {
        if (Ami.argent >= Ami.cout) {
            Ami ami = new Ami(e.getX(), e.getY());
            Ami.argent -= Ami.cout;
            amis.add(ami);
            projectilesAmis.add(new AmiProjectile(ami.getPositionX(), ami.getPositionY()));
        } else if (Ami.argent < Ami.cout) {
            JOptionPane.showMessageDialog(null, "Not enough money to create an Ami!", "Insufficient Funds", JOptionPane.WARNING_MESSAGE);
        }
    }

    // instanciate all the method to the updateGameLogic method
    public void updateGameLogic() {
        updatePositionEnemi();
        updatePositionEnemiProj();
        updatePositionAmiProj();
        updateEnemis();
        updateAmi();
        startNextWave();
    }

    // Draw all the element on the frame
    public void drawGameElements(Graphics g) {
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

    // If an enemi have reach the bottom of the frame, then the game stop and the
    // "game over" scene will appear
    private void updatePositionEnemi() {
        for (Pion oval : enemis) {
            oval.updatePosition();

            if (oval.getPositionY() >= GameScreen.FRAME_HEIGHT) {
                timer.stop();
                GameOver gameOver = new GameOver();
                gameOver.setVisible(true);
                break;
            }
        }
    }


    // Method to update the position of the projectile ami's that implement
    // the method that is inside the AmiProjectile class
    private void updatePositionAmiProj() {
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

    // Method for an projectile enemis who collide with an ami
    private boolean collideWithAmi(Projectile p, Ami a) {
        final ValueRange rangeX = ValueRange.of((int) p.getPosition()[0] - 25, (int) p.getPosition()[0] + 75);
        final ValueRange rangeY = ValueRange.of(a.getPositionX() - 4, a.getPositionX() + 4);
        return rangeY.isValidIntValue((int) p.getPosition()[1]) && rangeX.isValidIntValue(a.getPositionX());
    }

    // Method for an projectile ami who collide with an enemi
    private boolean collideWithEnemi(Projectile p, Enemi e) {
        final ValueRange rangeX = ValueRange.of((int) p.getPosition()[0] - 25, (int) p.getPosition()[0] + 75);
        final ValueRange rangeY = ValueRange.of(e.getPositionX() - 4, e.getPositionX() + 4);
        return rangeY.isValidIntValue((int) p.getPosition()[1]) && rangeX.isValidIntValue(e.getPositionX());
    }

    // If an enemis projectile has collide with an ami, then ami has less pv
    private void enemiProjCollideAmi(Projectile p, Ami a) {
        a.setPdv(a.pv - p.getDamage());
    }

    // If an ami projectile has collide with an enemi, then the enemi has less pv
    private void AmiProjCollideEnemi(Projectile p, Enemi e) {
        e.setPdv(e.pv - p.getDamage());
    }

    // If an enemi is dead, add it to the list of dead enemi, and then remove the
    // list of the frame to make them disapear.
    private void updateEnemis() {
        List<Enemi> enemiesToRemove = new ArrayList<>();
        for (Enemi enemi : enemis) {
            if (enemi.estMort()) {
                enemiesToRemove.add(enemi);
            }
        }
        enemis.removeAll(enemiesToRemove);
        enemiesToRemove.clear();
    }

    // If an ami is dead, add it to the list of dead amis, and then remoce the
    // list of the frame to make them disapear.
    private void updateAmi() {
        List<Ami> amisToRemove = new ArrayList<>();
        for (Ami ami : amis) {
            if (ami.estMort()) {
                amisToRemove.add(ami);
            }
        }
        amis.removeAll(amisToRemove);
        amisToRemove.clear();
    }

    // To know if we have set another wave
    private boolean hasNextWave(int i) {
        return i < vague;
    }

    // Start the next wave of enemis if there is no longer enemis on the frame
    public void startNextWave() {
        int w = 1;
        if (enemis.isEmpty()) {
            if (hasNextWave(w)) {
                w ++;
                for (int i = 0; i < NUM_ENEMIS; i++) {
                    Enemi enemi = new Enemi(0);
                    enemis.add(enemi);
                    projectilesEnemis.add(new EnemiProjectile(enemi.getPositionX(), enemi.getPositionY()));
                }
            } else {
                timer.stop();
                Win win = new Win();
                win.setVisible(true);
            }

        }
    }
}


