package TowerDefence.src;

public class Plante {

    // endroit où la plante est plantée
    private int location_x;
    private int location_y;

    // Points de vie de la plante
    private int pdv = 100;
    private boolean estMorte = false;

    // Le dommage qu'elle cause
    private int dommage = 10;
    
    public Plante (int x, int y) {
        this.location_x = x;
        this.location_y = y;
    }

    public String toString () {
        return "La plante se trouve à la position " + getX() + ", " + getY() + " et elle a encore " + getPdv() + " points de vie.";
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

    public void attaque (int d) {
        this.pdv =  this.pdv - d;

        if (this.pdv <= 0) {
            this.estMorte = true;
        }
    }

    public static void main(String[] args) {
        PlanteCarnivore pc = new PlanteCarnivore(4, 0);
        Zombie z = new Zombie();
        GrilleJeu game = new GrilleJeu();
        System.out.println(game.getArgent());
        System.out.println(pc.getPdv());
        pc.attaque(z.getDommage());
        System.out.println(pc.getPdv());
        System.out.println(game.getArgent());
        System.out.println(pc.toString());

    }

}
