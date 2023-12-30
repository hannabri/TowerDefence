package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemi extends Pion {

    // ce qu'il nous rapporte
    private int gain;


    public Enemi(int initialY) {
        super(initialY);
    }

    @Override
    public void updatePosition() {
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

    private int getRandomPosition(int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue);
    }

    public boolean estMort() {
        if (this.pv <= 0) {
            return true;
        }
        return false;
    }

    public void setPdv(int vie) {
        this.pv = vie;
    }

    public void setDommage(int d) {
        this.dommage = d;
    }

    public void setGain(int g) {
        this.gain = g;
    }

    public void setReach(int r) {
        this.reach = r;
    }
}
