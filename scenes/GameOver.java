package TowerDefence.scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameOver extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;
    private JFrame menu;

    // Declare BufferedImage at the class level
    private BufferedImage image;

    public GameOver() {
        // Set the size, title, and location
        setSize(largeur, hauteur);
        setTitle("GAME OVER");
        setLocationRelativeTo(null);

        // Create an ImagePanel to display an image
        ImagePanel imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.CENTER);

        // Create a button to return to the menu screen
        JButton returnButton = new JButton("Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to return to the menu screen
                menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });

        add(returnButton, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Inner class for ImagePanel
    private class ImagePanel extends JPanel {
        public ImagePanel() {
            importImg();
            loadSprite();
        }

        private void importImg() {
            // Use absolute path to the image file
            try {
                image = ImageIO.read(new File("C:/Users/marie/OneDrive/Documents/JeuJava/TowerDefence/res/gameover.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void loadSprite() {
            // Add your logic to load the sprite if needed
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the image at the top-left corner
            if (image != null) {
                g.drawImage(image, 20, 20, null);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameOver());
    }
}
