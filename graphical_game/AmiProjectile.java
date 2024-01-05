package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;

class AmiProjectile implements Projectile{

    public int x;
    public int y;
    public double speed = 2.0;
    public int damage = 200;

    AmiProjectile(int x, int y) {
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

    @Override
    public void updateProjPosition() {
        // for upward movement
       y -= 5;
    }

    @Override
    public void drawProj(Graphics g) {
        // Example: Draw a red rectangle for Enemi's projectile
        g.setColor(Color.RED);
        int projectileSize = 10; // Set your desired projectile size
        g.fillRect((int) x, (int) y, projectileSize, projectileSize);
    }

}