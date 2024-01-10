package TowerDefence.source;

public class GameZombie extends Thread {

    GrilleJeu gameSet;
    Game game;
    long sleep;
    
    public GameZombie(GrilleJeu gameSet, Game game) {
        
        this.gameSet = gameSet;
        this.game = game;
        this.sleep = game.getSpeed();

    }

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
                Thread.sleep(sleep);
            } catch (Exception e) {
                System.out.println("");
            }

            if (! game.enemyWin(gameSet.getZombies())) {
                System.out.println("GAME OVER!");
                System.out.println("");
                System.out.println("Enter any number to go back to the menu!");
                goOn = false;
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
