package TowerDefence.source;

import java.util.ArrayList;

import TD.BatailleNavale.Grille;

public class GrilleJeu {

    // money and game set
    public static int argent = 500;
    public static String[][] grille = new String [10][5];

    // lists with all the flowers and enemies
    private ArrayList <Zombie> zombies = new ArrayList<>();
    private ArrayList <Plante> plantes = new ArrayList<>();


    public GrilleJeu() {

        // nitialise the game set
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                grille[i][j] = ".";
            }
        }
    }

    // print game set in the terminal
    public void afficher() {
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            System.out.print(i);
            for (int j = 0; j < 10; j++) {
                System.out.print(grille[j][i]);
            }
            System.out.println("");
        }
        System.out.println("You still have " + GrilleJeu.argent + (" money."));
    }

    public int getArgent() {
        return argent;
    }

    // returns list with alle the enemies
    public ArrayList<Zombie> getZombies() {
        for (Zombie z : this.zombies) {
            if (z.getX() >= 0) {
                if (z.getClass() == Zombie.class){
                    grille[z.getX()][z.getY()] = "E";
                }else {
                    grille[z.getX()][z.getY()] = "S";
                }
            }
            if (z.getX() + z.getVitesse() < 10) {
                grille[z.getX() + z.getVitesse()][z.getY()] = ".";
            }
        }
        return zombies;
    }

    // returns list with all the flowers
    public ArrayList<Plante> getPlantes() {
        return plantes;
    }

    // adds enemy to the enemy list
    public Zombie createZombie(Zombie z) {
        zombies.add(z);
        return z;
    }
    
    
    


}
