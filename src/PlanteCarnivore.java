package TowerDefence.src;

public class PlanteCarnivore extends Plante {

    private int pdv;
    private boolean estMort = false;

    private int dommage;

    private int cout;

    public PlanteCarnivore(int x, int y) {
        super(x, y);
        setPdv(150);
        setDommage(150);
        setCout(15);
        setReach(2);
    }


}
