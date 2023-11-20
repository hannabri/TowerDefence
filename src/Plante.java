package TowerDefence.src;

import java.util.ArrayList;

public class Plante {

    // endroit où la plante est plantée
    private int location_x;
    private int location_y;

    // Points de vie de la plante
    private int pdv;

    // Le dommage qu'elle cause
    private int dommage;

    // Le coût de la plante
    private int cout;
    private int reach;
    
    public Plante (int x, int y) {
        this.location_x = x;
        this.location_y = y;

        setPdv(100);
        setCout(10);
        setDommage(25);
        setReach(3);

        if (GrilleJeu.argent < getCout()) {
            setPdv(0);
            System.out.println("L'argent n'est pas suffisant pour acheter la planted");
        } else {
            setPdv(200);
            GrilleJeu.argent += getCout();
        }
    }

    public String toString () {
        return "La " + this.getClass() + " se trouve à la position " + getX() + ", " + getY() + " et elle a encore " + getPdv() + " points de vie.";
    }

    public boolean estMort() {
        if (this.pdv <= 0) {
            return true;
        }
        return false;
    }

    public void setPdv(int vie) {
        this.pdv = vie;
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

    // Est-ce qu'il nous faut un getter pour la position?
    public int getX() {
        return location_x;
    }

    public int getY() {
        return location_y;
    }

    public int getPdv () {
        return pdv;
    }

    public int getDommage() {
        return dommage;
    }

    public int getCout() {
        return cout;
    }

    public int getReach() {
        return reach;
    }

    // La plante attque un zombie
    public void attaquePlante (Zombie z) {
        if (! z.estMort() && this.getY() == z.getY() && Math.abs(this.getX() - z.getX()) <= getReach()){
            z.recoitAttaque(this.getDommage());
        }
    }
    
    // La plante est attaquée par un zombie
    public void recoitAttaque (int d) {
        this.pdv =  this.pdv - d;

        if (this.estMort()) {
            System.out.println("Le zombie a gagné");
        }
    }

    
}
