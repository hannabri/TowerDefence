package TowerDefence.inputs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import TowerDefence.graphical_game.GameScreen;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    private GameScreen frame; // Declare the frame variable

    public MyMouseListener(GameScreen frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Implement the logic for mouse click
        int x = e.getX();
        int y = e.getY();

        // Create a Graphics object from the JFrame's content pane
        Graphics gaulois = frame.getContentPane().getGraphics();

        // Set the color to pink
        gaulois.setColor(Color.PINK);

        // Draw an oval at the clicked location
        int ovalWidth = 10;
        int ovalHeight = 10;
        gaulois.fillOval(x - ovalWidth, y - ovalHeight, ovalWidth, ovalHeight);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

}
