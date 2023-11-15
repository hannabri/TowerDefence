package TowerDefence.src;

public class Zombie {

    // Je crois qu'on les initialise dès le début psk ils partent tout du même endroit. 
    private int location_x;
    private int location_y;

    // Vie du zombie
    private int pdv = 100;
    private boolean estMort = false;
    
    // Dommage qu'il cause
    private int dommage = 10;

    // Vitesse d'avancement
    private double vitesse = 1500;

    public Zombie() {};

    public String toString() {
        return "Le zombie se trouve à la position " + getX() + ", " + getY() + " et il a encore " + getPdv() + " points de vie.";
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

    // attaque d'une plante, le zombie perd des points de vie et rapporte de l'argent s'il est mort
    public void attaque(int d) {
        this.pdv = this.pdv - d;

        if (this.pdv <= 0) {
            this.estMort = true;
            GrilleJeu.argent += 10;
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
