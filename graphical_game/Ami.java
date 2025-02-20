package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Ami extends Pion {

    public static int argent = 200;
    public static int cout = 20;
    private int dommage;
    private double projectileSpeed;
    private int projectileSize = 10; // Set your desired projectile size
    private List<Projectile> projectilesAmis;
    public int length;
    private Timer projectileTimer;
    private int projectileInterval = 2000; // 2 seconds

    public Ami(int x, int y) {
        super(x, y);
        projectilesAmis = new ArrayList<>();

        setPdv(150);
        setCout(10);
        setDamage(20);
        setReach(1);
        setProjectileSpeed(2.0); // Set your desired projectile speed

        projectileTimer = new Timer();
        projectileTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                createProjectile();
            }
        }, 0, projectileInterval);
    }

    @Override
    public void updatePosition() {
        // Stationary ovals do not move
        for (Projectile projectile : projectilesAmis) {
            projectile.updateProjPosition();
        }
    }

    public void actionPerformed(ActionEvent e){
        createProjectile();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED); // Change color for stationary ovals
        g.drawOval(x, y, size, size);

        // Draw the PV of the ami
        g.setColor(Color.RED);
        g.drawString(Integer.toString(pv), x + 10, y + 20);

        // Draw projectiles
        for (Projectile projectile : projectilesAmis) {
            projectile.drawProj(g);
        }
    }

    // Method to create a new projectile
    public void createProjectile() {
        Projectile projectile = new AmiProjectile(x, y);
        projectilesAmis.add(projectile);
    }

    public boolean estMort() {
        if (this.pv <= 0){
            projectileTimer.cancel();
            return true;
        }
        return false;
    }

    public void setPdv(int vie) {
        this.pv = vie;
    }

    public void setCout(int argent) {
        this.cout = argent;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public void setProjectileSpeed(double speed) {
        this.projectileSpeed = speed;
    }


    @Override
    public void setDamage(int damage) {
        this.dommage = damage;
    }

    @Override
    public void setSpeed(double speed) {
        this.projectileSpeed = speed;
    }

}

