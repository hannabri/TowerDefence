package TowerDefence.src;

public class PlanteCarnivore extends Plante {

    private int pdv = 150;
    private boolean estMorte = false;

    private int dommage = 100;

    public PlanteCarnivore(int x, int y) {
        super(x, y);
    }

    public int getPdv() {
        return pdv;
    }

    public int getDommage() {
        return dommage;
    }

    public void attaque(int d) {
        this.pdv =  this.pdv - d;

        if (this.pdv <= 0) {
            this.estMorte = true;
        }
    }


}
