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

    // this method let a enemy attack a flower and vice versa
    // it verifies also if the enemy / flower is dead = has no more health points
    private void attaquer (ArrayList<Plante> plantes, Zombie z) {

        for (Plante p : plantes) {
            if (p.getY() == z.getY()) {

                p.attaquePlante(z);
                z.attaqueZombie(p);

            }

            // the dead objects are put in a list so that they are removed from the original list
            // the objects are removed in attaque_avancer
            if (p.estMort()) {
                this.plantesMortes.add(p);
            }
            if (z.estMort()) {
                this.zombiesMorts.add(z);
            }
        }
    }

    // returns true if the game is not yet finished
    public boolean checkGameEnd(ArrayList<Zombie> zombies) {

        if (zombies.isEmpty()) {
            return false;
        }

        return true;
    }

    //returns true if the enemies are not yet at the end of the game screen
    public boolean enemyWin(ArrayList<Zombie> zombies) {

        for (Zombie z: zombies) {
            if (z.getX() <= 0) {
                    return false;
                }
            }

        return true;

    }

    // this method lets the enemy move forward. At each step, the method attaque is executed
    // this method is called by the method avancer of class GameZombie
    public void attaque_avance(ArrayList<Zombie> zombies, ArrayList<Plante> plantes) {
        System.out.println("");

        for (Zombie z : zombies) {

            z.setX(z.getX() - z.getVitesse());

            attaquer(plantes, z);


            // dead flowers and enemies are removed from the lists
            for (Plante pm : plantesMortes) {
                plantes.remove(pm);
            }
        }

        for (Zombie zm : zombiesMorts) {
            GrilleJeu.grille[zm.getX() + zm.getVitesse()][zm.getY()] = ".";
            zombies.remove(zm);
        }
    }

    // randomly initialize zombies
    public void createZombieVague(GrilleJeu gameSet) {
        
        Random rnd = new Random();
        
        // creates random number that either creates a superZombie (0) or a Zombie (default)
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

    // initiates the number of waves depending on the chose game mode
    // method processes the user response for the game mode in the console_game method
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

    // sets the speed depending on the chosen level
    // method processes user response for the level in the console_game method
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

    // restarts or ends the game depending on user input after the end of the game (GAME OVER or YOU WIN)
    // processes user response given in method console_game
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

    // manages the console_game() with the user input
    public static void console_game() throws Exception {
        
        // initiales the game set and creates a game object
        GrilleJeu gameSet = new GrilleJeu();
        Game game = new Game(5000);

        // creates the object to manage the flowers
        GamePlante plante = new GamePlante(game, gameSet);

            
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // "Menu" questions about mode / level 
        System.out.println("Do you want to play normal mode - 1 or marathon mode - 2?");
        int playMode = Integer.valueOf(reader.readLine());
        game.processGameMode(playMode);

        System.out.println("");
        System.out.println("Now let's see how good you are! Which level do you want to play? You can chose between level 1, 2 and 3 by entering the corresponding number.");
        int level = Integer.valueOf(reader.readLine());
        game.processLevel(level);
        
        // creates separate thread for enemies (they move slower or faster depending on chosen level)
        GameZombie zombieThread = new GameZombie(gameSet, game);

        // Explanation how to play the game
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

                // while neither the flowers nor the enemies won the user will be able to place flowers
                // end of while loop means that the game is over and someone won
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

            // Ask if the user wants to replay or quit the game
            System.out.println("What do you want to do?");
            System.out.println("1 - play again");
            System.out.println("2 - exit the game");
            int whatNext = Integer.valueOf(reader.readLine());
            game.processNextStep(whatNext);

            } catch (IOException e) {
            
                e.printStackTrace();

            } finally {

                // close the input reader and stop the separate zombie thread
                try {
                    reader.close();
                    zombieThread.interrupt();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }  
                
                
            }
        }
