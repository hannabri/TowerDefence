package TowerDefence.source;

public class GamePlante{
    
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

    public void createPlante(int typePlante, int pos_x, int pos_y) {

                Plante p = processUserResponse(typePlante, pos_x, pos_y);

                if (p != null) {
                    gameSet.getPlantes().add(p);
                    GrilleJeu.grille[pos_x][pos_y] = 1;
                }

                gameSet.afficher();

                System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
            }


    

    // public void run() {
                    
    //     // Scanner in = new Scanner(System.in);
    //     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //     // System.out.println("Il vous reste " + gameSet.getArgent() + " d'argent.");
    //     // System.out.println("Vous pouvez placer des plantes à n'importe quel moment. Préciser d'abord le type et ensuite la position x et y.");
    //     // System.out.println("1 - La plante basique coûte 10 et atteint un zombie à 1 avec un dommage de 185");
    //     // System.out.println("2 - La plante carnivore coûte 25 et atteint un zombie à 5 avec un dommage de 50");
    //     // System.out.println("3 - La rose coûte 50 et atteint un zombie à 3 avec un dommage de 75");
    //     // System.out.println("Voulez-vous créer une plante basique - 1, une plante carnivore - 2 ou une rose - 3 ?");

    //     // while(game.checkGameEnd(null)){
    //         // try {
    //         //     java.lang.Thread.sleep(1000);
    //         // } catch (InterruptedException e) {
    //         //     e.printStackTrace();
    //         // }

    //         try {
                
    //             int typePlante = reader.read();
    //             int pos_x = reader.read();
    //             int pos_y = reader.read();

    //             if (pos_x > 9 || pos_y > 4 || GrilleJeu.grille[pos_x][pos_y] == 1) {
    //             System.out.println("La position n'est pas disponible. Entrez une nouvelle position.");
    //             pos_x = reader.read();
    //             pos_y = reader.read();
    //             }

    //             reader.readLine();

    //             createPlante(typePlante, pos_x, pos_y);

    //         } catch (IOException e) {
            
    //             System.out.println("FAIL");

    //         } finally {
    //             try {
    //                 reader.close();
    //             } catch (IOException e) {
                    
    //                 e.printStackTrace();
    //             }
    //         }  
    // }

    // @Override
    // protected Object doInBackground() throws Exception {

    // }
}

