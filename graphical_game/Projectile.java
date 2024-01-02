package TowerDefence.graphical_game;

import java.awt.Graphics;

public interface Projectile {
    // Get the current position of the projectile
    double[] getPosition();

    // Set the position of the projectile
    void setPosition(int x, int y);

    // Get the speed of the projectile
    double getSpeed();

    // Get the damage of the projectile
    int getDamage();

    // Update the state of the projectile
    void updateProjPosition();

    // Draw the projectile
    void drawProj(Graphics g);
}