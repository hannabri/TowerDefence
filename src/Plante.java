package TowerDefence.src;

import java.time.temporal.ValueRange;

import org.w3c.dom.ranges.Range;

public class Plante {

    // endroit où la plante est plantée
    private int location_x;
    private int location_y;

    // Points de vie de la plante
    private int pdv;
    private boolean estMort = false;

    // Le dommage qu'elle cause
    private int dommage;

    // Le coût de la plante
    private int cout;
    private int reach;
    
    public Plante (int x, int y) {
        this.location_x = x;
        this.location_y = y;

        this.pdv = 100;

        setPdv(100);
        setCout(10);
        setDommage(10);
        setReach(1);
    }

    public String toString () {
        return "La plante se trouve à la position " + getX() + ", " + getY() + " et elle a encore " + getPdv() + " points de vie.";
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
        if (this.getY() == z.getY() && this.getX() - z.getX() <= getReach()) {
            z.recoitAttaque(this.getDommage());
        }
    }
    
    // La plante est attaquée par un zombie
    public void recoitAttaque (int d) {
        this.pdv =  this.pdv - d;

        if (this.pdv <= 0) {
            this.estMort = true;
        }
    }

    public static void main(String[] args) {
        PlanteCarnivore pc = new PlanteCarnivore(2, 3);
        SuperZombie z = new SuperZombie();
        GrilleJeu game = new GrilleJeu();
        System.out.println(game.getArgent());
        pc.attaquePlante(z);
        System.out.println(game.getArgent());
        System.out.println(pc.toString());
        System.out.println(z.toString());

    }

}
