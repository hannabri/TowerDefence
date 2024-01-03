package TowerDefence.scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(String imagePath) {
        try {
            // Provide the path to an image file, not a directory
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            // Handle exception
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this); // Draw the image at the top-left corner
        }
    }
}

