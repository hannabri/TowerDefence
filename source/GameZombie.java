package TowerDefence.source;

public class GameZombie extends Thread {

    GrilleJeu gameSet;
    Game game;
    long sleep;
    
    // the separate enemy thread used in console_game
    public GameZombie(GrilleJeu gameSet, Game game) {
        
        this.gameSet = gameSet;
        this.game = game;
        this.sleep = game.getSpeed();

    }

    // calls attaque_avance every time the thread is executed
    public void avancer() {
    
        game.attaque_avance(gameSet.getZombies(), gameSet.getPlantes());
        System.out.println("");
        gameSet.afficher();
        System.out.println("");

    }

    public void run(){

        boolean goOn = game.checkGameEnd(gameSet.getZombies());
        int v = game.getVagues();
        while (goOn) {
            avancer();
            try {
                // thread stops for a defined period of time (5, 3 or 2 seconds depending on the chosen level)
                Thread.sleep(sleep);
            } catch (Exception e) {
                System.out.println("");
            }

            // if an enemy made it to the other side of the game set, the thread is stopped
            if (! game.enemyWin(gameSet.getZombies())) {
                System.out.println("GAME OVER!");
                System.out.println("");
                System.out.println("Enter any number to go back to the menu!");
                goOn = false;

            // if all enemies have been killed, we have to check if it was the last wave. 
            //If yes, the game is over. If no, the method creates another wave
            } else{
                if (! game.checkGameEnd(gameSet.getZombies())){
                    v --;
                    if (v == 0) {
                        System.out.println("YOU WIN!");
                        System.out.println("");
                        System.out.println("Enter any number to go back to the menu!");
                        goOn = false;
                    } else {
                        game.createZombieVague(gameSet);
                    }
                }
            }
        }
    }

}
