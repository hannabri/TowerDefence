package TowerDefence.src;

import java.util.ArrayList;

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
    
    public void avancer(ArrayList<Zombie> zombies, ArrayList<Plante> plantes) {

        long lastStep = System.currentTimeMillis();

        boolean goOn = true;
        while(goOn){
            if (System.currentTimeMillis() - lastStep >= 1000) {
                ArrayList<Zombie> zombiesMorts = new ArrayList<>();
                ArrayList<Plante> plantesMortes = new ArrayList<>();
                for (Zombie z : zombies) {
                    System.out.println(zombies);
                    z.setX(z.getX() - z.getVitesse());
                    

                    for (Plante p : plantes) {
                        if (p.getY() == z.getY()) {
                            
                            p.attaquePlante(z);
                            z.attaqueZombie(p);

                            System.out.println(p.toString());
                        }
                        if (p.estMort()) {
                            plantesMortes.add(p);
                        }
                        if (z.estMort()) {
                            zombiesMorts.add(z);
                        }
                    }
                        
                    for (Plante pm : plantesMortes) {
                        plantes.remove(pm);
                    }                     


                    if (z.getX() <= 0) {
                        System.out.println("GAME OVER!");
                        goOn = false;
                        break;
                    }

                
                }
                for (Zombie zm : zombiesMorts) {
                    zombies.remove(zm);

                }

                if (zombies.isEmpty()) {
                    System.out.println("Les plantes ont gagnées!");
                    goOn = false;
                }
                // System.out.println(z.toString());
                
                lastStep = System.currentTimeMillis();
            }
        }

    }


    public static void main(String[] args) {
        GrilleJeu gameSet = new GrilleJeu();
        System.out.println(gameSet.getArgent());
        Game game = new Game();
       
        gameSet.createPlante(new PlanteCarnivore(0, 0));
        gameSet.createPlante(new PlanteCarnivore(0, 1));
        gameSet.createPlante(new Rose(1, 2));
        gameSet.createPlante(new Plante(2, 3));
        gameSet.createPlante(new Rose(4, 4));
        gameSet.createPlante(new Plante(4, 4));
        gameSet.createZombie(new SuperZombie());
        gameSet.createZombie(new Zombie());

        // Zombie z = new Zombie();
        // PlanteCarnivore pc = new PlanteCarnivore(2, 1);

        System.out.println(gameSet.getArgent());

        gameSet.afficher();
        game.avancer(gameSet.getZombies(), gameSet.getPlantes());
        // System.out.println(gameSet.getPlantes());
        
        
        }

}
