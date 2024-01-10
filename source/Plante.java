package TowerDefence.source;


public class Plante {

    // position
    private int location_x;
    private int location_y;

    // health points
    private int pdv;

    // dammage
    private int dommage;

    // cost and reach
    private int cout;
    private int reach;

    public Plante (int x, int y) {
        this.location_x = x;
        this.location_y = y;

        setPdv(150);
        setCout(10);
        setDommage(20);
        setReach(1);

        // checks if the user has enough money to buy a flower
        if (GrilleJeu.argent < getCout()) {
            setPdv(0);
            System.out.println("You do not have enough money to create another flower.");
        } else {
            setPdv(200);
            GrilleJeu.argent -= getCout();
        }
    }

    public String toString () {
        return "The " + this.getClass() + " is at " + getX() + ", " + getY() + ", and it still has " + getPdv() + " health points. It reaches the enemy at " + getReach() + ".";
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

    // the flower attacks an enemy
    public void attaquePlante (Zombie z) {
        int test = Math.abs(this.getX() - z.getX());
        if (! z.estMort() && test <= getReach()){
            System.out.println("FLOWER ATTACK!");
            z.recoitAttaque(this.getDommage());
        }
    }

    // reduce health points when an enemy attacks the flower
    public void recoitAttaque (int d) {
        this.pdv =  this.pdv - d;

        if (this.estMort()) {
            System.out.println("The enemy wins!");
        }
    }


}
