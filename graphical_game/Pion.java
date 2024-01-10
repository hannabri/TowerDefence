package TowerDefence.graphical_game;

import java.awt.Graphics;
import java.util.Random;

public abstract class Pion {
    public  int FRAME_WIDTH = GameScreen.FRAME_WIDTH;
    public  int PION_SIZE = GameScreen.OVAL_SIZE;
    public int FRAME_HEIGHT = GameScreen.FRAME_HEIGHT;

    public int x;
    public int y;
    public int size;
    public double speed;

    public int pv; // point de vie

    public int reach;



    public Pion(int initialY) {
        // Initialize the oval position and size
        x = getRandomPosition(8);
        y = initialY;
        size = PION_SIZE;
    }

    public Pion(int x, int y) {
            // Initialize the oval position and size based on the click position
            this.x = x;
            this.y = y;
            size = PION_SIZE;
    }

    public int getPositionX() {
            return x;
    }

    public int getPositionY() {
            return y;
    }

    public abstract void updatePosition();

    public abstract void draw(Graphics g);

    public abstract boolean estMort();

    public abstract void setPdv(int vie);

    public abstract void setReach(int reach);

    public void setDamage(int dommage) {
        this.pv = dommage;
    }

    public void setSpeed(double speed) {
        this.pv = (int) speed;
    }

    public double getSpeed(){
        return speed;
    }

    private int getRandomPosition(int maxValue) {
        Random random = new Random();
            int randomNumber =  random.nextInt(maxValue);
            return randomNumber * 100 + 25;
    }
}

