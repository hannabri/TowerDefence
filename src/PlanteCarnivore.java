package TowerDefence.src;

public class PlanteCarnivore extends Plante {

    public PlanteCarnivore(int x, int y) {
        super(x, y);
        setPdv(150);
        setDommage(30);
        setCout(15);
        setReach(3);
    }


}
