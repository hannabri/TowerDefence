package TowerDefence.scenes;

import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import TowerDefence.graphical_game.GameScreen;

public class StartGame extends JFrame{
    private GameScreen gameScreen;

    public StartGame() {
        // Create the GameScreen
        new GameScreen();


    }
}