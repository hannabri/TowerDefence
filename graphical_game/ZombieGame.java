package TowerDefence.graphical_game;

import javax.swing.*;

import TowerDefence.source.Zombie;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ZombieGame extends JFrame {

    private JPanel[][] gridCells;
    private Timer zombieMoveTimer;
    private Zombie[] zombies;

    public ZombieGame() {
        setLayout(new BorderLayout());

        initializeGrid();
        initializeZombies();

        startZombieMoveTimer();

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeGrid() {
        int rows = 5;
        int cols = 10;
        gridCells = new JPanel[rows][cols];

        JPanel gridPanel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gridCells[i][j] = new JPanel();
                gridCells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(gridCells[i][j]);
            }
        }
        add(gridPanel, BorderLayout.CENTER);
    }

    private void initializeZombies() {
        zombies = new Zombie[5]; // Adjust the number of zombies as needed
        for (int i = 0; i < zombies.length; i++) {
            zombies[i] = new Zombie();
        }
    }

    private void startZombieMoveTimer() {
        zombieMoveTimer = new Timer();
        zombieMoveTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                moveZombies();
                updateGrid();
            }
        }, 0, 1000); // Adjust the delay (in milliseconds) as needed
    }

    private void moveZombies() {
        Random random = new Random();
        for (Zombie zombie : zombies) {
            // Simulate random movement
            int moveDirection = random.nextInt(4); // 0: up, 1: down, 2: left, 3: right
            switch (moveDirection) {
                case 0:
                    zombie.setY(Math.max(0, zombie.getY() - 1));
                    break;
                case 1:
                    zombie.setY(Math.min(gridCells.length - 1, zombie.getY() + 1));
                    break;
                case 2:
                    zombie.setX(Math.max(0, zombie.getX() - 1));
                    break;
                case 3:
                    zombie.setX(Math.min(gridCells[0].length - 1, zombie.getX() + 1));
                    break;
            }
        }
    }

    private void updateGrid() {
        for (JPanel[] row : gridCells) {
            for (JPanel cell : row) {
                cell.setBackground(Color.WHITE); // Reset cell colors
            }
        }

        for (Zombie zombie : zombies) {
            int x = zombie.getX();
            int y = zombie.getY();
            gridCells[y][x].setBackground(Color.RED); // Set zombie color
        }
    }
}