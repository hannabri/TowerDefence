package TowerDefence.graphical_game;

import java.awt.Graphics;
import java.util.Random;

public abstract class Oval {
    public  int FRAME_WIDTH = GameScreen.FRAME_WIDTH;
    public  int OVAL_SIZE = GameScreen.OVAL_SIZE;
    public int FRAME_HEIGHT = GameScreen.FRAME_HEIGHT;

    public int x;
    public int y;
    public int size;

    public int pv; // point de vie



    public Oval(int initialY) {
        // Initialize the oval position and size
        x = getRandomPosition(FRAME_WIDTH);
        y = initialY;
        size = OVAL_SIZE;
        }

        public Oval(int x, int y) {
            // Initialize the oval position and size based on the click position
            this.x = x;
            this.y = y;
            size = OVAL_SIZE;
        }

        public abstract void updatePosition();

        public abstract void draw(Graphics g);

        private int getRandomPosition(int maxValue) {
            Random random = new Random();
            return random.nextInt(maxValue);
        }
    }
