package TowerDefence.src;

import java.util.Scanner;


public class main_file {
    public static void main(String[] args) {
        System.out.println("**********Menu**********\n1. Terminal mode \n2. Graphical mode \nIf not specified it will be terminal mode \n************************");
        System.out.println("Press the number of the mode you want to play and then press Enter \n************************");
        Scanner in = new Scanner(System.in);
        int displaymode = in.nextInt();

        switch (displaymode) {
            case 1:
                System.out.println("You have chosen terminal mode\n");
                Game.console_game(args);
                break;
            case 2:
                System.out.println("Tou have chosen Graphical mode\n");
                //make a function for graphical mode for example
                //Game.graphical_game(args);
                break;
            default:
                System.out.println("Default mode is terminal mode\n");
                //lanunch the game in terminal mode
                Game.console_game(args);
        }
    }

}


