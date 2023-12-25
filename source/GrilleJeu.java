package TowerDefence.source;

import java.util.ArrayList;

public class GrilleJeu {

    public static int argent = 500;
    public static int[][] grille = new int [10][5];

    // listes avec toutes les plantes et tous les zombies
    private ArrayList <Zombie> zombies = new ArrayList<>();
    private ArrayList <Plante> plantes = new ArrayList<>();


    public GrilleJeu() {

        // initialiser la grille du jeu
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                grille[i][j] = 0;
            }
        }
    }

    // affiche la grille du jeu dans le terminal
    public void afficher() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grille[j][i]);
            }
            System.out.println("");
        }
    }

    // encore util?
    public int getArgent() {
        return argent;
    }

    // retourne la liste avec les zombies
    public ArrayList<Zombie> getZombies() {
        for (Zombie z : this.zombies) {
            if (z.getX() >= 0) {
                grille[z.getX()][z.getY()] = 2;
            }
            if (z.getX() + z.getVitesse() < 10) {
                grille[z.getX() + z.getVitesse()][z.getY()] = 0;
            }
        }
        return zombies;
    }

    // retourne la liste avec les plantes
    public ArrayList<Plante> getPlantes() {
        return plantes;
    }

    // ajoute le zombie à la liste et le retourne
    public Zombie createZombie(Zombie z) {
        zombies.add(z);
        return z;
    }
    
    
    


}
