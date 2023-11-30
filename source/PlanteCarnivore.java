package TowerDefence.source;

public class PlanteCarnivore extends Plante {

    public PlanteCarnivore(int x, int y) {
        super(x, y);
        setDommage(50);
        setCout(25);
        setReach(5);

        if (GrilleJeu.argent < getCout()) {
            setPdv(0);
            System.out.println("L'argent n'est pas suffisant pour acheter la planted");
        } else {
            setPdv(200);
            GrilleJeu.argent -= getCout();
        }
    }


}
