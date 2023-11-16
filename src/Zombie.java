package TowerDefence.src;
import java.util.Random;

public class Zombie {

    // Je crois qu'on les initialise dès le début psk ils partent tout du même endroit. 
    private int location_x;
    private int location_y;

    // Vie du zombie
    private int pdv;
    private boolean estMort;
    private int gain;
    
    // Dommage qu'il cause
    private int dommage;
    private int reach;

    // Vitesse d'avancement
    private double vitesse;

    public Zombie() {
        // en foction de la longueur du plateau
        this.location_x = 4;
        // Random r = new Random();
        this.location_y = 3;
        this.estMort = false;

        setPdv(100);
        setDommage(10);
        setVitesse(1000);
        setGain(10);
        setReach(1);
    }

    public String toString() {
        return "Le zombie se trouve à la position " + getX() + ", " + getY() + " et il a encore " + getPdv() + " points de vie.";
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

    // Le zombie attque une plante
    public void attaqueZombie (Plante p) {
        if (this.getY() == p.getY() && this.getX() - p.getX() <= getReach()) {
            System.out.println("ATTAQUE!");
            p.recoitAttaque(this.getDommage());
        }
    }

    // attaque d'une plante, le zombie perd des points de vie et rapporte de l'argent s'il est mort
    public void recoitAttaque(int d) {
        this.pdv = this.pdv - d;

        if (this.pdv <= 0) {
            this.estMort = true;
            GrilleJeu.argent += getGain();
        }
    }

    public void avancer() {
        
        long lastStep = System.currentTimeMillis();

         // là faut voir comment on règle l'avancement du zombie. Mais je crois que c'est le principe. 
        while (this.location_x > 0) {
            if (System.currentTimeMillis() - lastStep >= vitesse) {
           
                this.location_x -= 1; 
                lastStep = System.currentTimeMillis();
            }
        }
    }
}
