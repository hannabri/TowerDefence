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
       
        game.createPlante(new PlanteCarnivore(0, 0));
        game.createPlante(new Rose(1, 2));
        game.createPlante(new Rose(4, 4));
        // game.createZombie(new SuperZombie());
        // game.createZombie(new Zombie());

        Zombie z = new Zombie();
        PlanteCarnivore pc = new PlanteCarnivore(2, 1);

        System.out.println(game.getArgent());

        game.afficher();

        System.out.println(z.toString());
        
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
