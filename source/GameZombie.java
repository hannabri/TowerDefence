package TowerDefence.source;

public class GameZombie extends Thread {

    GrilleJeu gameSet;
    Game game;
    long sleep;
    
    public GameZombie(GrilleJeu gameSet, Game game, long sleep) {
        
        this.gameSet = gameSet;
        this.game = game;
        this.sleep = sleep;

    }

    public void avancer() {
    
        game.attaque_avance(gameSet.getZombies(), gameSet.getPlantes());

        gameSet.afficher();
        System.out.println("");

    }

    public void run(){

        // boolean goOn = game.checkGameEnd(gameSet.getZombies());
        while (true) {
            avancer();
            try {
                Thread.sleep(sleep);
            } catch (Exception e) {
                System.out.println("FAIL");
            }
            // goOn = game.checkGameEnd(gameSet.getZombies());
        }
    }

}
