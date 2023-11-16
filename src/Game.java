package TowerDefence.src;

public class Game {

    private int vagues;
    
    public Game() {
        setVagues(3);
    }

    public void setVagues(int v) {
        this.vagues = v;
    }
    
    public int getVagues() {
        return vagues;
    }

    public static void main(String[] args) {
        GrilleJeu game = new GrilleJeu();
        System.out.println(game.getArgent());
        
        PlanteCarnivore pc = new PlanteCarnivore(0, 3);
        Rose r1 = new Rose(1, 2);
        Plante p = new Plante(0,4);
        Rose r2 = new Rose(1,0);
        SuperZombie z = new SuperZombie();
        Zombie zo = new Zombie();

        System.out.println(game.getArgent());
        
        // System.out.println(game.getArgent());
        // pc.attaquePlante(z);
        // System.out.println(game.getArgent());
        // System.out.println(z.toString());

        
        long lastStep = System.currentTimeMillis();
        while(z.getX() >= 0) {
            if (System.currentTimeMillis() - lastStep >= z.getVitesse()) {

                z.avancer();
                if (! pc.estMort()) {
                    pc.attaquePlante(z);
                    System.out.println(pc.toString());
                    z.attaqueZombie(pc);
                    
                }
                
                if (z.estMort()) {
                    break;
                }

                if (z.getX() == -1) {
                    System.out.println("GAME OVER!");
                    break;
                }
                
                System.out.println(z.toString());


                lastStep = System.currentTimeMillis();
            }
        }
        
    }

}
