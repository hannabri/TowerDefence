package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Action;

public class Enemi extends Pion implements Projectile {



    private int gain = 50;
    private int dommage;
    private double projectileSpeed = 6.0;
    private int projectileSize = 10;
    private int reach;
    private List<Projectile> projectilesEnemis;
    private Timer projectileTimer;
    private int projectileInterval = 2000; // 2 seconds

    public Enemi(int initialY) {
        super(initialY);
        projectilesEnemis = new ArrayList<>();

        setGain(50);
        setPdv(100);
        setDamage(15);
        setReach(1);
        setSpeed(0.5);

        projectileTimer = new Timer();
        projectileTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                createProjectile();
            }
        }, 0, projectileInterval);
    }

    public void actionPerformed(ActionEvent e){
        createProjectile();
    }

    // Methods related to updating the enemy position and its projectiles
    @Override
    public void updatePosition() {
        moveDownward();
        for (Projectile projectile : projectilesEnemis) {
            projectile.updateProjPosition();
        }
    }

    private void moveDownward() {
        y += 5;
    }

    // Methods related to drawing
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(x, y, size, size);

        // Draw PV inside the oval
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(pv), x + 10, y + 20);

        // Draw projectiles
        for (Projectile projectile : projectilesEnemis) {
            projectile.drawProj(g);
        }
    }

    public void createProjectile(){
        Projectile projectile = new EnemiProjectile(x, y);
        projectilesEnemis.add(projectile);
    }

    public boolean estMort() {
        if (this.pv <= 0){
            projectileTimer.cancel();
            return true;
        }
        return false;
    }


    @Override
    public void setPdv(int vie) {
        this.pv = vie;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    @Override
    public void setReach(int reach) {
        this.reach = reach;
    }

    @Override
    public int getDamage() {
        return dommage;
    }

    public void setProjectileSpeed(double speed) {
        this.projectileSpeed = speed;
    }

    @Override
    public double[] getPosition() {
        return new double[]{x, y};
    }

    @Override
    public void setDamage(int damage) {
        this.dommage = damage;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSpeed(double speed) {
        this.projectileSpeed = speed;
    }

    @Override
    public void updateProjPosition() {
        // for downward movement of projectile
       y += speed;
    }

    @Override
    public void drawProj(Graphics g) {
        // Example: Draw a red rectangle for Enemi's projectile
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, projectileSize, projectileSize);
    }

    @Override
    public double getSpeed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpeed'");
    }
}