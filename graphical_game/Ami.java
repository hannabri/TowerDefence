package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Ami extends Pion implements Projectile {

    private int cout;
    private int dommage;
    private double projectileSpeed;
    private int projectileSize = 10; // Set your desired projectile size
    private List<Projectile> projectilesAmis;
    public int length;

    public Ami(int x, int y) {
        super(x, y);
        projectilesAmis = new ArrayList<>();

        setPdv(150);
        setCout(10);
        setDamage(20);
        setReach(1);
        setProjectileSpeed(2.0); // Set your desired projectile speed
    }

    @Override
    public void updatePosition() {
        // Stationary ovals do not move
        for (Projectile projectile : projectilesAmis) {
            projectile.updateProjPosition();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED); // Change color for stationary ovals
        g.drawOval(x, y, size, size);

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
        return this.pv <= 0;
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
    public int getDamage() {
        return dommage;
    }

    @Override
    public void updateProjPosition() {
        // Implement the logic to update the position of Ami's projectile
        y += speed;
    }

    @Override
    public void drawProj(Graphics g) {
        // Example: Draw a blue rectangle for Ami's projectile
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, projectileSize, projectileSize);
    }

    @Override
    public void setSpeed(double speed) {
        this.projectileSpeed = speed;
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 53d71fe9a881968374a5a6f6dd3152cf10451fce
