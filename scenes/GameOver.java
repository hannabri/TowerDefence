package TowerDefence.scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GameOver extends JFrame {
    private static final int largeur = 300;
    private static final int hauteur = 200;
    private JFrame menu;
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
        }

        private void importImg() {
            try (InputStream is = getClass().getResourceAsStream("../res/GameOver.jpg")) {
                if (is != null) {
                    image = ImageIO.read(is);
                } else {
                    System.err.println("Image not found: /GameOver.jpg");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
}
