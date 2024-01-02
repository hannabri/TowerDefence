package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;

class EnemisProjectile implements Projectile{

    public int x;
    public int y;
    public double speed = .0;
    public int damage = 20;

    EnemisProjectile(int x, int y) {
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
        // for downward movement
       y += speed;
    }

    @Override
    public void drawProj(Graphics g) {
        // Example: Draw a red rectangle for Enemi's projectile
        g.setColor(Color.BLUE);
        int projectileSize = 10; // Set your desired projectile size
        g.fillRect((int) x, (int) y, projectileSize, projectileSize);
    }

}
