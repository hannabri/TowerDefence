package TowerDefence.source;

import java.util.Scanner;

import TowerDefence.scenes.Menu;

public class Main_file {
    public static void main(String[] args) {
        System.out.println("**********Menu**********\n1. Terminal mode \n2. Graphical mode \nIf not specified, it will be terminal mode \n************************");
        System.out.println("Press the number of the mode you want to play and then press Enter \n************************");

        try (Scanner in = new Scanner(System.in)) {
            int displayMode = in.nextInt();

            switch (displayMode) {
                case 1:
                    System.out.println("You have chosen terminal mode\n");
                    Game.console_game(args);
                    break;
                case 2:
                    System.out.println("You have chosen Graphical mode\n");
                    Menu menu = new Menu();
                    menu.setVisible(true); // set the menu visible
                    break;
                default:
                    System.out.println("Default mode is terminal mode\n");
                    Game.console_game(args);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid mode.");
        }
    }
}
