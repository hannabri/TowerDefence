package TowerDefence.source;

public class SuperZombie extends Zombie { 

    public SuperZombie() {
        super();
        setPdv(150);
        setDommage(60);
        setVitesse(2);
        setGain(30);
        setReach(2);
    }

    // public String toString() {
    //     return "Le super zombie se trouve à la position " + getX() + ", " + getY() + " et il a encore " + getPdv() + " points de vie.";
    // }
    
}
