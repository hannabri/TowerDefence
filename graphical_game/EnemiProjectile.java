package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;

public class EnemiProjectile implements Projectile{

    public int x;
    public int y;
    public double speed = 8.0;
    public int damage = 200;

    EnemiProjectile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double[] getPosition() {
        return new double[]{x, y};
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    // to make the projectile move
    @Override
    public void updateProjPosition() {
        // for upward movement
       y += speed;

    }

    @Override
    public void drawProj(Graphics g) {
        // Example: Draw a red rectangle for Enemi's projectile
        g.setColor(Color.WHITE);
        int projectileSize = 10; // Set your desired projectile size
        g.fillRect((int) x, (int) y, projectileSize, projectileSize);
    }

}