package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemi extends Pion implements Projectile {

    private int gain;
    private double projectileSpeed;
    private int projectileSize = 10;
    private int dommage;
    

    public Enemi(int initialY) {
        super(initialY);
        // Additional initialization if needed
        setPdv(100); // Adjust initial health as needed
        setDamage(15); // Adjust initial damage as needed
        setReach(1); // Adjust initial reach as needed
        setSpeed(1.5); // Set your desired speed for Enemi's projectiles    
    }

    @Override
    public void updatePosition() {
        // TODO BREAK THE GAME
        // Update the oval position for downward movement
        y += 5;

        // If the oval goes beyond the frame, reset its position
        if (y > FRAME_HEIGHT) {
            y = -size;
            x = getRandomPosition(FRAME_WIDTH);
            size = PION_SIZE;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(x, y, size, size);
    }

    public boolean estMort() {
        if (this.pv <= 0) {
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

    @Override
    public double[] getPosition() {
        return new double[]{x, y};
    }

    @Override
    public double getSpeed() {
        return projectileSpeed;
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
        // Implement the logic to update the position of Enemi's projectile
       y += projectileSpeed;
    }

    @Override
    public void drawProj(Graphics g) {
        // Example: Draw a red rectangle for Enemi's projectile
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, projectileSize, projectileSize);
    }

    private int getRandomPosition(int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue);
    }
}
