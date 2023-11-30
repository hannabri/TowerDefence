package TowerDefence.source;

public class GameZombie implements Runnable {

    GrilleJeu gameSet;
    Game game;
    
    public GameZombie(GrilleJeu gameSet, Game game) {
        this.gameSet = gameSet;
        this.game = game;

    }

    public void run() {
        long lastStep = System.currentTimeMillis();
            boolean goOn = true;

            while (goOn) {
                

                if (System.currentTimeMillis() - lastStep >= 5000) {
                    game.avancer(gameSet.getZombies(), gameSet.getPlantes());

                    gameSet.afficher();
                    System.out.println("");

                    goOn = game.checkGameEnd(gameSet.getZombies());

                    lastStep = System.currentTimeMillis();
                }
            }
            gameSet.afficher();


        }

}
