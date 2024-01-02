package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;

class EnemiProjectile implements Projectile{

    public int x;
    public int y;
    public double speed = 8.0;
    public int damage = 20;

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

    @Override
    public void updateProjPosition() {
        // for upward movement
       y += speed;
    //    if my porjectile have reach an ami pion, i have to remove the projectile from the list and remove pv to the ami pion



    }

    @Override
    public void drawProj(Graphics g) {
        // Example: Draw a red rectangle for Enemi's projectile
        g.setColor(Color.WHITE);
        int projectileSize = 10; // Set your desired projectile size
        g.fillRect((int) x, (int) y, projectileSize, projectileSize);
    }

}