package TowerDefence.src;

public class SuperZombie extends Zombie { 

    // Vie du zombie
    private int pdv;
    private boolean estMort;
    
    // Dommage qu'il cause
    private int dommage;

    // Vitesse d'avancement
    private double vitesse;


    public SuperZombie() {
        super();
        setPdv(150);
        setDommage(60);
        setVitesse(1000);
        setGain(15);
        setReach(2);
    }
    
}
