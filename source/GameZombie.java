package TowerDefence.source;

public class GameZombie extends Thread {

    GrilleJeu gameSet;
    Game game;
    
    public GameZombie(GrilleJeu gameSet, Game game) {
        
        this.gameSet = gameSet;
        this.game = game;

    }

    public void avancer() {
    
        game.attaque_avance(gameSet.getZombies(), gameSet.getPlantes());

        gameSet.afficher();
        System.out.println("");

    }

    public void run(){

        boolean goOn = game.checkGameEnd(gameSet.getZombies());
        while (goOn) {
            avancer();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("FAIL");
            }
            goOn = game.checkGameEnd(gameSet.getZombies());
        }
    }

}
