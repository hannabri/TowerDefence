package TowerDefence.src;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.sasl.SaslException;


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
    
    public boolean avancer(ArrayList<Zombie> zombies, ArrayList<Plante> plantes) {
        boolean goOn = true;
            
                ArrayList<Zombie> zombiesMorts = new ArrayList<>();
                ArrayList<Plante> plantesMortes = new ArrayList<>();
                
                
                System.out.println("");

                for (Zombie z : zombies) {
                    
                    
                    z.setX(z.getX() - z.getVitesse());
                    System.out.println(z.toString());

                    for (Plante p : plantes) {
                        if (p.getY() == z.getY()) {
                            
                            p.attaquePlante(z);
                            z.attaqueZombie(p);

                            System.out.println(p.toString());
                            System.out.println("");
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
                    GrilleJeu.grille[zm.getX()][zm.getY()] = 0;
                    zombies.remove(zm);


                }

                if (zombies.isEmpty()) {
                    System.out.println("Les plantes ont gagnées!");
                    goOn = false;
                }
            return goOn;
    }


    public static void main(String[] args) {
        GrilleJeu gameSet = new GrilleJeu();
        // System.out.println(gameSet.getArgent());
        Game game = new Game();
       
        // gameSet.createPlante(new PlanteCarnivore(0, 0));
        // gameSet.createPlante(new PlanteCarnivore(0, 1));
        // gameSet.createPlante(new Rose(1, 2));
        // gameSet.createPlante(new Plante(2, 3));
        // gameSet.createPlante(new Rose(4, 4));
        // gameSet.createPlante(new Plante(4, 4));
        gameSet.createZombie(new SuperZombie());
        gameSet.createZombie(new Zombie());

        Scanner in = new Scanner(System.in);

        // Zombie z = new Zombie();
        // PlanteCarnivore pc = new PlanteCarnivore(2, 1);

        // System.out.println(gameSet.getArgent());
        // System.out.println(gameSet.getPlantes());

        
        long lastStep = System.currentTimeMillis();
        boolean goOn = true;
        while(goOn){
            
            boolean newPlante = true;
            
            System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
            System.out.println("Vous voulez créer un plante ? (y / n)");

            if (in.nextLine().equals("n")) {
                newPlante = false;
            }

            while (newPlante) {

                System.out.println("Où vous voulez placer votre plante ? Donne deux entier pour x (entre 0 et 9) et y (entre 0 et 4).");
                int pos_x = in.nextInt();
                int pos_y = in.nextInt();

                if (pos_x > 9 || pos_y > 4 || GrilleJeu.grille[pos_x][pos_y] == 1) {
                    System.out.println("La position n'est pas disponible. Entrez une nouvelle position.");
                    pos_x = in.nextInt();
                    pos_y = in.nextInt();
                }

                System.out.println("Voulez-vous créer une plante basique - 1, une plante carnivore - 2 ou une rose - 3 ?");

                int typePlante = in.nextInt();
                in.nextLine();

                switch (typePlante) {
                    case 1:
                        gameSet.createPlante(new Plante(pos_x, pos_y));
                        System.out.println("Une Plante a été créée.");
                        break;

                    case 2: 
                        gameSet.createPlante(new PlanteCarnivore(pos_x, pos_y));
                        System.out.println("Une plante carnivore a été créée.");
                        break;

                    case 3:
                        gameSet.createPlante(new Rose(pos_x, pos_y));
                        System.out.println("Une rose a été créée.");
                        break;
                
                    default:
                        System.out.println("Aucune plante n'a été créée.");
                        break;
                }

                gameSet.afficher();

                if (GrilleJeu.argent <= 0) {
                    newPlante = false;
                }

                System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
                System.out.println("Vous voulez créer une autre plante ? (y / n)");


                String reponse = in.nextLine();
                if (reponse.equals("n")) {
                    newPlante = false;
                }

            }

            if (System.currentTimeMillis() - lastStep >= 1000) {
                
                if (! game.avancer(gameSet.getZombies(), gameSet.getPlantes())) {
                    goOn = false;
                }

                gameSet.afficher();
                System.out.println("");
                
                lastStep = System.currentTimeMillis();
            }
        }
        gameSet.afficher();
        // System.out.println(gameSet.getPlantes());
        
        
        }

}
