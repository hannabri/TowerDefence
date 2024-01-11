package TowerDefence.scenes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import TowerDefence.graphical_game.GameScreen;

public class StartGame extends JFrame{
    public StartGame() {
        // Create the GameScreen
        // new GameScreen();
        SwingUtilities.invokeLater(() -> {
            GameScreen gameScreen = new GameScreen();
            gameScreen.setVisible(true);
        });


    }
}