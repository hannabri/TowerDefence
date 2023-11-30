package TowerDefence.source;

public class Rose extends Plante {

    public Rose(int x, int y) {
        super(x, y);

        setDommage(75);
        setCout(40);
        setReach(3);
        if (GrilleJeu.argent < getCout()) {
            setPdv(0);
            System.out.println("L'argent n'est pas suffisant pour acheter la plante");
        } else {
            setPdv(200);
            GrilleJeu.argent -= getCout();
        }

    }
}
