package TowerDefence.graphical_game;

import java.awt.Color;
import java.awt.Graphics;

public class Gaulois extends Oval {
    // Points de vie de l'ami
    private int pv;

    // Dommage qu'il cause
    private int dommage;

    // Le coùt
    private int cout;

    // La portée
    private int reach;

    public Gaulois(int x, int y) {
         super(x, y);
    }

    public Gaulois(int initialY) {
        super(initialY);

        setPdv(150);
        setCout(10);
        setDommage(20);
        setReach(1);
    }

    @Override
    public void updatePosition() {
        // Stationary ovals do not move
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED); // Change color for stationary ovals
        g.drawOval(x, y, size, size);
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

    public void setDommage(int d){
        this.dommage = d;
    }

    public void setCout(int argent) {
        this.cout = argent;
    }

    public void setReach(int r) {
        this.reach = r;
    }
}
