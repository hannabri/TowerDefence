package TowerDefence.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class Game {

    // dépend du mode: 5 secondes pour niveau 1, 3 secondes pour niveau 2 et 1 seconde pour niveau 3
    private long speed;
    private int vagues;

    // liste avec toutes les plantes et tous les zombies
    private ArrayList<Plante> plantesMortes = new ArrayList<>();
    private ArrayList<Zombie> zombiesMorts = new ArrayList<>();

    public Game(long speed) {
        this.speed = speed;
        setVagues(3);
    }

    public void setVagues(int v) {
        this.vagues = v;
    }

    public int getVagues() {
        return vagues;
    }

    // méthode pour qu'une plante attaque un zombie et vice versa
    // elle vérifie si la plante / le zombie est mort
    // les objets morts sont stockés dans une liste séparée pour pouvoir les enlever plus tard
    private void attaquer (ArrayList<Plante> plantes, Zombie z) {

        for (Plante p : plantes) {
            if (p.getY() == z.getY()) {

                p.attaquePlante(z);
                z.attaqueZombie(p);

                System.out.println(p.toString());
                System.out.println("");
            }
            if (p.estMort()) {
                this.plantesMortes.add(p);
            }
            if (z.estMort()) {
                this.zombiesMorts.add(z);
            }
        }
    }

    // retourne true si le jeu n'est pas encore fini
    public boolean checkGameEnd(ArrayList<Zombie> zombies) {

        if (zombies.isEmpty()) {
            System.out.println("Les plantes ont gagnées!");
            return false;
        }

        for (Zombie z: zombies) {
            if (z.getX() <= 0) {
                    System.out.println("GAME OVER!");
                    return false;
                }
            }

        return true;

    }

    // fait avancer le zombie, la méthode attaque est exécutée à chaque pas du zombie
    // cette méthode enlève les zombies et plantes mortes de leur liste
    public void attaque_avance(ArrayList<Zombie> zombies, ArrayList<Plante> plantes) {
        System.out.println("");

        for (Zombie z : zombies) {

            z.setX(z.getX() - z.getVitesse());

            attaquer(plantes, z);
            System.out.println(z.toString());

            for (Plante pm : plantesMortes) {
                plantes.remove(pm);
            }
        }

        for (Zombie zm : zombiesMorts) {
            GrilleJeu.grille[zm.getX() + zm.getVitesse()][zm.getY()] = 0;
            zombies.remove(zm);
        }
    }

    // pour une initialisation aléatoire de la liste des zombies
    public void createZombieVague(GrilleJeu gameSet) {
        
        Random rnd = new Random();
        
        for (int i = 0; i < 3; i++) {
            int typeZombie = rnd.nextInt(2);

            switch (typeZombie) {
                case 0:
                    gameSet.createZombie(new SuperZombie());
                    break;
            
                default:
                    gameSet.createZombie(new Zombie());
                    break;
            }
    }
    }

    // gère le jeu dans la console
    public static void console_game(String[] args) throws Exception {
        
        // initialiser la grille du jeu et le jeu lui-même
        GrilleJeu gameSet = new GrilleJeu();
        Game game = new Game(5000);

        // créer un thread séparé pour faire avancer les zombies (sans attendre la réponse de l'utilisateur)
        GameZombie zombieThread = new GameZombie(gameSet, game, game.speed);
        GamePlante plante = new GamePlante(game, gameSet);

            
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
        System.out.println("Vous pouvez placer des plantes à n'importe quel moment. Préciser d'abord le type et ensuite la position x et y.");
        System.out.println("1 - La plante basique coûte 10 et atteint un zombie à 1 avec un dommage de 185");
        System.out.println("2 - La plante carnivore coûte 25 et atteint un zombie à 5 avec un dommage de 50");
        System.out.println("3 - La rose coûte 50 et atteint un zombie à 3 avec un dommage de 75");
        System.out.println("Voulez-vous créer une plante basique - 1, une plante carnivore - 2 ou une rose - 3 ?");
        
        game.createZombieVague(gameSet);
        zombieThread.start();
            
        
            try {
                int v = 0;

                while(game.checkGameEnd(gameSet.getZombies())) {

                    if (gameSet.getZombies().size() < 2 && v < game.getVagues()) {
                        game.createZombieVague(gameSet);
                        v ++;
                    }

                    int typePlante = Integer.valueOf(reader.readLine());
                    int pos_x = Integer.valueOf(reader.readLine());
                    int pos_y = Integer.valueOf(reader.readLine());

                    if (pos_x > 9 || pos_y > 4 || GrilleJeu.grille[pos_x][pos_y] == 1) {
                    System.out.println("La position n'est pas disponible. Entrez une nouvelle position.");
                    pos_x = reader.read();
                    pos_y = reader.read();
                    }

                    plante.createPlante(typePlante, pos_x, pos_y);
                    
            }

            } catch (IOException e) {
            
                e.printStackTrace();

            } finally {
                try {
                    reader.close();
                    zombieThread.interrupt();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }  
                
                
            }
        }
