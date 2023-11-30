package TowerDefence.scene;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_file extends JFrame {
    Highscores h ;
    Game g;
    Settings s;
    Rules r;
    Credits c;

    public void Menu() {

        //  set title
        setTitle("Tower Defense Game");
        setSize(900, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(40, 50, 400, 400);
        this.add(menuPanel);

        // JButton highscoresButton = new JButton("Highscores");
        // highscoresButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        // highscoresButton.setPreferredSize(new Dimension(400, 100));
        // highscoresButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         // Code to navigate to the Start Game scene
        //         h = new Highscores(h);
        //         h.setVisible(true);
        //         setVisible(false);
        //     }
        // });

        // add(highscoresButton);
        // Ajouter le panneau à la fenêtre
        // getContentPane().add(panel);
        // setVisible(true);
    }

}
