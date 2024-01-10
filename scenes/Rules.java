package TowerDefence.scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame {
    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 300;
    private JFrame menu;

    public Rules() {
        // Set the size, title, and location
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Rules");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create a button to return to the menu screen
        JButton returnButton = new JButton("Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });


        add(returnButton, BorderLayout.SOUTH);

        // Create a JLabel
        JLabel label = new JLabel();
        label.setVerticalAlignment(JLabel.TOP); // Align text to the top
        label.setFont(new Font("SansSerif", Font.PLAIN, 14)); // Set the font size

        // Add the JLabel to the JPanel
        mainPanel.add(new JScrollPane(label), BorderLayout.CENTER);

        // Set some example rules text
        label.setText("<html><body><p align='justify'>Voici les règles du jeu:<br>" +
                "Le jeu Tower Defense est un jeu de stratégie dont le but est de défendre une base en empêchant les vagues d'ennemis d'y accéder.<br>" + //
                "Pour jouer à ce jeu de récréation en ligne, il faut placer les tours de défense le long du chemin emprunté par les ennemis.<br>" + //
                "Chaque tour possède plusieurs armes avec un nombre limité de munitions. Ici une seule.<br>" + //
                "Les monstres ennemis vont apparaître par vagues successives et ils vont tous suivre le chemin dessiné sur la carte. <br>" + //
                "Vise-les avec tes tours pour les éliminer et réduire leur nombre.<br>" + //
                "À mesure que le niveau de difficulté augmente, le nombre d'ennemis augmente et ils deviennent de plus en plus difficiles à battre.<br>" + //
                "Choisis les tours qui vont attaquer les ennemis et les armes à utiliser. Les tours vont alors viser et tirer sur les ennemis pour les tuer. <br> Les ennemis tués te rapporteront de l'argent avec lequel tu pourras acheter d'autres tours.<br>" + //
                "<br>" + //
                "Il faut absolument empêcher les ennemis d'atteindre ta base pour ne pas perdre.\r\n" + //
                "<br>" + //
                "Tu gagnes la partie lorsque tu auras réussi à tuer tous les ennemis.</p></body></html>");

        // Add the JPanel to the frame
        add(mainPanel);

        setVisible(true);
    }
}
