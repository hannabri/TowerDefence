package TowerDefence.src;

import java.util.ArrayList;

public class GrilleJeu {
    
    public static int argent = 500; 
    public static int[][] grille = new int [10][5];

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
        for (int i = 0; i < 10; i++) {
            
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
        for (Zombie z : this.zombies) {
            grille[z.getX()][z.getY()] = 2;
            if (z.getX() + z.getVitesse() < 10) {
                grille[z.getX() + z.getVitesse()][z.getY()] = 0;
            }
        }
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
