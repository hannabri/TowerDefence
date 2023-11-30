package TowerDefence.src;

import java.util.ArrayList;


public class Game {

    private int vagues;
    private ArrayList<Plante> plantesMortes = new ArrayList<>();
    private ArrayList<Zombie> zombiesMorts = new ArrayList<>();

    public Game() {
        setVagues(3);
    }

    public void setVagues(int v) {
        this.vagues = v;
    }

    public int getVagues() {
        return vagues;
    }

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

    private boolean checkGameEnd(ArrayList<Zombie> zombies) {

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

    private void avancer(ArrayList<Zombie> zombies, ArrayList<Plante> plantes) {
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
            GrilleJeu.grille[zm.getX()][zm.getY()] = 0;
            zombies.remove(zm);
        }
    }


    public static void console_game(String[] args) {
        GrilleJeu gameSet = new GrilleJeu();
        Game game = new Game();

        gameSet.createZombie(new SuperZombie());
        gameSet.createZombie(new Zombie());

        long lastStep = System.currentTimeMillis();
        boolean goOn = true;

        while (goOn) {
            gameSet.createPlante();

            if (System.currentTimeMillis() - lastStep >= 1000) {
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
