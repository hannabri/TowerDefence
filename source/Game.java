package TowerDefence.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class Game {


    private long speed;
    private int vagues;

    // one list with all the flowers and one with all the enmies
    private ArrayList<Plante> plantesMortes = new ArrayList<>();
    private ArrayList<Zombie> zombiesMorts = new ArrayList<>();

    public Game(long speed) {
        this.speed = speed;
    }

    public void setVagues(int v) {
        this.vagues = v;
    }

    public int getVagues() {
        return vagues;
    }

    public void setSpeed(long s) {
        this.speed = s;
    }

    public long getSpeed() {
        return speed; 
    }

    // méthode pour qu'une plante attaque un zombie et vice versa
    // elle vérifie si la plante / le zombie est mort
    // les objets morts sont stockés dans une liste séparée pour pouvoir les enlever plus tard
    private void attaquer (ArrayList<Plante> plantes, Zombie z) {

        for (Plante p : plantes) {
            if (p.getY() == z.getY()) {

                p.attaquePlante(z);
                z.attaqueZombie(p);

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
            return false;
        }

        return true;
    }

    public boolean enemyWin(ArrayList<Zombie> zombies) {

        for (Zombie z: zombies) {
            if (z.getX() <= 0) {
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

            for (Plante pm : plantesMortes) {
                plantes.remove(pm);
            }
        }

        for (Zombie zm : zombiesMorts) {
            GrilleJeu.grille[zm.getX() + zm.getVitesse()][zm.getY()] = ".";
            zombies.remove(zm);
        }
    }

    // pour une initialisation aléatoire de la liste des zombies
    public void createZombieVague(GrilleJeu gameSet) {
        
        Random rnd = new Random();
        
        for (int i = 0; i < 1; i++) {
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

    public void processGameMode(int m) {
        switch (m) {
            case 1:
                System.out.println("You chose the normal mode");
                setVagues(3);
                break;
        
            case 2:
                System.out.println("You chose the marathon mode");
                setVagues(10000);
                break;
        }
    }

    public void processLevel(int l) {
        switch(l){
            case 1:
                System.out.println("You chose the easy level!");
                this.setSpeed(5000); // 5 seconds
                break;
            case 2:
                System.out.println("You chose the medium level!");
                this.setSpeed(3000); // 3 seconds
                break;
            case 3: 
                System.out.println("You chose the difficult level!");
                this.setSpeed(2000); // 2 seconds
                break;
        }
        
    }

    public void processNextStep(int n) throws Exception {
        switch (n) {
            case 1:
                System.out.println("Let's play again!");
                Game.console_game();
                break;
        
            case 2:
                System.out.println("It was nice to play with you!");
                break;
        }
    }

    // gère le jeu dans la console
    public static void console_game() throws Exception {
        
        // initialiser la grille du jeu et le jeu lui-même
        GrilleJeu gameSet = new GrilleJeu();
        Game game = new Game(5000);

        // créer un thread séparé pour faire avancer les zombies (sans attendre la réponse de l'utilisateur)
        GamePlante plante = new GamePlante(game, gameSet);

            
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Do you want to play normal mode - 1 or marathon mode - 2?");
        int playMode = Integer.valueOf(reader.readLine());
        game.processGameMode(playMode);

        System.out.println("");
        System.out.println("Now let's see how good you are! Which level do you want to play? You can chose between level 1, 2 and 3 by entering the corresponding number.");
        int level = Integer.valueOf(reader.readLine());
        game.processLevel(level);
        
        GameZombie zombieThread = new GameZombie(gameSet, game);

        System.out.println("");
        System.out.println("You still have " + gameSet.getArgent() + " money.");
        System.out.println("You can place a flower at any moment of the game. Enter first the flower type and then the x and y position.");
        System.out.println("1 - The basic flower costs 10 and can reach the enemy at 1 with a 185 damage.");
        System.out.println("2 - The carnivore flower costs 25 and can reach the enemy at 5 with a 50 damage.");
        System.out.println("3 - The rose costs 50 and can reach the enemy at 3 with a 75 damage.");
        System.out.println("Do you want to place a basic flower - 1, a carnivore flower - 2 or a rose - 3 ?");
        System.out.println("Press any key to start the game.");
        reader.readLine();
        
        game.createZombieVague(gameSet);
        zombieThread.start();
            
        
            try {

                while(game.checkGameEnd(gameSet.getZombies()) && game.enemyWin(gameSet.getZombies())) {

                    int typePlante = Integer.valueOf(reader.readLine());
                    if (! zombieThread.isAlive()) {
                        break;
                    }
                    int pos_x = Integer.valueOf(reader.readLine());
                    int pos_y = Integer.valueOf(reader.readLine());

                    if (pos_x > 9 || pos_y > 4 || GrilleJeu.grille[pos_x][pos_y] == "P") {
                    System.out.println("This position is already occupied. Please enter a new position.");
                    pos_y = reader.read();
                    pos_x = reader.read();
                    }

                    plante.createPlante(typePlante, pos_x, pos_y);
                    
            }

            System.out.println("What do you want to do?");
            System.out.println("1 - play again");
            System.out.println("2 - exit the game");
            int whatNext = Integer.valueOf(reader.readLine());
            game.processNextStep(whatNext);

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
