package TowerDefence.source;

public class GamePlante{
    
    Game game; 
    GrilleJeu gameSet;

    public GamePlante(Game g, GrilleJeu gs) {
        this.game = g;
        this.gameSet = gs;
    }

    // crée une plante selon la réponse de l'utilisateur dans la méthode consol_game dans Game
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

    // crée la plante et l'ajoute dans la liste des plantes
    public void createPlante(int typePlante, int pos_x, int pos_y) {

                Plante p = processUserResponse(typePlante, pos_x, pos_y);

                if (p != null) {
                    gameSet.getPlantes().add(p);
                    GrilleJeu.grille[pos_x][pos_y] = 1;
                }

                gameSet.afficher();

                System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
            }
}

