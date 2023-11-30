package TowerDefence.source;

import java.util.Scanner;

public class GamePlante implements Runnable {
    
    Game game; 
    GrilleJeu gameSet;

    public GamePlante(Game g, GrilleJeu gs) {
        this.game = g;
        this.gameSet = gs;
    }

    private Plante processUserResponse(int typePlante, int pos_x, int pos_y) {
        Plante p;

        switch (typePlante) {


            case 1:
                p = new Plante(pos_x, pos_y);
                System.out.println("Une Plante a été créée.");
                break;

            case 2:
                p = new PlanteCarnivore(pos_x, pos_y);
                System.out.println("Une plante carnivore a été créée.");
                break;

            case 3:
                p = new Rose(pos_x, pos_y);
                System.out.println("Une rose a été créée.");
                break;

            default:
                System.out.println("Aucune plante n'a été créée.");
                p = null;
                break;
        }

        return p;
    }

    public void createPlante() {

        Scanner in = new Scanner(System.in);

            System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
            System.out.println("Vous voulez créer un plante ? (y / n)");

            while (game.checkGameEnd(gameSet.getZombies())) {
                System.out.println("1 - La plante basique coûte 10 et atteint un zombie à 1 avec un dommage de 185");
                System.out.println("2 - La plante carnivore coûte 25 et atteint un zombie à 5 avec un dommage de 50");
                System.out.println("3 - La rose coûte 50 et atteint un zombie à 3 avec un dommage de 75");
                System.out.println("Voulez-vous créer une plante basique - 1, une plante carnivore - 2 ou une rose - 3 ?");


                int typePlante = in.nextInt();


                System.out.println("Où vous voulez placer votre plante ? Donne deux entier pour x (entre 0 et 9) et y (entre 0 et 4).");
                int pos_x = in.nextInt();
                int pos_y = in.nextInt();

                if (pos_x > 9 || pos_y > 4 || GrilleJeu.grille[pos_x][pos_y] == 1) {
                    System.out.println("La position n'est pas disponible. Entrez une nouvelle position.");
                    pos_x = in.nextInt();
                    pos_y = in.nextInt();
                }

                in.nextLine();



                Plante p = processUserResponse(typePlante, pos_x, pos_y);

                if (p != null) {
                    gameSet.getPlantes().add(p);
                    GrilleJeu.grille[pos_x][pos_y] = 1;
                }


                gameSet.afficher();

                // if (GrilleJeu.argent <= 0) {
                //     newPlante = false;
                // }

                System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
                // System.out.println("Vous voulez créer une autre plante ? (y / n)");


                // String reponse = in.nextLine();
                // if (reponse.equals("n")) {
                //     newPlante = false;
                // }

            }
    }

    public void run() {
        createPlante();
    }
}
