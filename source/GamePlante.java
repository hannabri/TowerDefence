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
                System.out.println("You created a flower.");
                break;

            case 2:
                p = new PlanteCarnivore(pos_x, pos_y);
                System.out.println("You created a carnivore flower.");
                break;

            case 3:
                p = new Rose(pos_x, pos_y);
                System.out.println("You created a rose.");
                break;

            default:
                System.out.println("No flower has been created.");
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
                    if (p.getClass()== PlanteCarnivore.class) {
                        GrilleJeu.grille[pos_x][pos_y] = "C";
                    } else {
                        if (p.getClass() == Rose.class) {
                            GrilleJeu.grille[pos_x][pos_y] = "R";
                        } else {
                            GrilleJeu.grille[pos_x][pos_y] = "P";
                        }
                    }
                }

                gameSet.afficher();

                System.out.println("You still have " + gameSet.getArgent() + " money.");
            }
}

