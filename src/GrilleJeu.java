package TowerDefence.src;

import java.util.ArrayList;

public class GrilleJeu {
    
    public static int argent = 500; 
    private int[][] grille = new int [10][5];

    private ArrayList <Zombie> zombies = new ArrayList<>();
    private ArrayList <Plante> plantes = new ArrayList<>();
    
    // ajouter pas 2 plantes au mm endroit

    public GrilleJeu() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grille[i][j] = 0;
            }
        }
    }

    public void afficher() {
        for (int i = 0; i < grille[0].length; i++) {
            
            for (int j = 0; j < grille[1].length; j++) {
                System.out.print(grille[i][j]);
            }
            System.out.println("");
        }
    }

    public int getArgent() {
        return argent;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public ArrayList<Plante> getPlantes() {
        return plantes;
    }

    public Zombie createZombie(Zombie z) {
        zombies.add(z);
        return z;
    }

    public Plante createPlante(Plante p) {
        plantes.add(p);
        grille[p.getX()][p.getY()] = 1;
        return p;
    }

    
}
