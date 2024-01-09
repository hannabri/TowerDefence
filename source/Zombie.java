package TowerDefence.source;
import java.util.Random;


public class Zombie {

    // Je crois qu'on les initialise dès le début psk ils partent tout du même endroit.
    private int location_x;
    private int location_y;

    // Vie du zombie
    private int pdv;
    private int gain;

    // Dommage qu'il cause
    private int dommage;
    private int reach;

    // Vitesse d'avancement
    private int vitesse;

    public Zombie() {

        // initialisation au hasard des zombies
        this.location_x = 9;
        Random r = new Random();
        this.location_y = r.nextInt(5);

        setPdv(100);
        setDommage(10);
        setVitesse(1);
        setGain(15);
        setReach(1);
    }

    public String toString() {
        return "The " + this.getClass() + " is at " + getX() + ", " + getY() + " and it still has " + getPdv() + " health points.";
    }

    public boolean estMort() {
        if (this.pdv <= 0) {
            return true;
        }
        return false;
    }

    public void setX(int x) {
        this.location_x = x;
    }

    public void setPdv(int vie) {
        this.pdv = vie;
    }

    public void setDommage(int d) {
        this.dommage = d;
    }

    public void setVitesse(int v) {
        this.vitesse = v;
    }

    public void setGain(int g) {
        this.gain = g;
    }

    public void setReach(int r) {
        this.reach = r;
    }

    public int getX() {
        return location_x;
    }

    public int getY() {
        return location_y;
    }

    public int getPdv() {
        return pdv;
    }

    public int getDommage() {
        return dommage;
    }

    public int getGain() {
        return gain;
    }

    public int getReach() {
        return reach;
    }

    public int getVitesse() {
        return vitesse;
    }

    // le zombie attque une plante
    public void attaqueZombie (Plante p) {
        if (! p.estMort() && this.getY() == p.getY() && Math.abs(this.getX() - p.getX()) <= getReach()) {
            System.out.println("ENEMY ATTACK!");
            p.recoitAttaque(this.getDommage());
        }
    }

    // attaque d'une plante, le zombie perd des points de vie et rapporte de l'argent s'il est mort
    public void recoitAttaque(int d) {
        this.pdv = this.pdv - d;

        if (this.estMort()) {
            GrilleJeu.argent += getGain();
            System.out.println("The flower wins!");
        }
    }

    public void setY(int y) {
        this.location_y = y;

    }

}
