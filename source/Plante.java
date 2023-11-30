package TowerDefence.source;


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

        setPdv(150);
        setCout(10);
        setDommage(20);
        setReach(1);

        if (GrilleJeu.argent < getCout()) {
            setPdv(0);
            System.out.println("L'argent n'est pas suffisant pour acheter une plante");
        } else {
            setPdv(200);
            GrilleJeu.argent -= getCout();
        }
    }

    public String toString () {
        return "La " + this.getClass() + " se trouve à la position " + getX() + ", " + getY() + ", elle a encore " + getPdv() + " points de vie elle atteint le zombie à " + getReach() + ".";
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
        int test = Math.abs(this.getX() - z.getX()); 
        if (! z.estMort() && test <= getReach()){
            System.out.println("ATTAQUE PLANTE!");
            z.recoitAttaque(this.getDommage());
            System.out.println(z.toString());
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
