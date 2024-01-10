# Tower Defence

Ce projet est une implémentation en Java d'un jeu Tower Denfence pour le cours de programmation orientée objet. Initiallement conçu pour les L2 Informatique, les étudiants du Master Linguistique Informatique ont également suivi ce cours.

## Compilation 
Le programme a compilé sur Windows avec la commande suivante: javac ./TowerDefence/source/Main_file.java

## Exécution

Pour lancer le jeu, il faut entrer la commande suivante: java Main_file.java

## Utilisation

Une fois le fichier principal exécuté, il est possible de choisir entre le jeu dans le terminal et le jeu sur l'interface graphique. En tappant 1 le jeu se lance sur le terminal et en tappant 2 le jeu se lance en mode graphique. 

### Jeu terminal

Avant de commencer le jeu terminal, il faut choisir entre le mode normal et le mode marathon en tappant soit 1 soit 2. Selon le chiffre entré le jeu se lancera. Chanque cinq secondes la grille du jeu sera affichée avec les emplacement les plantes créées (si déjà créées) et les enemis qui avancent. Il est possibe de placer des plantes en entrant trois chiffres. Le premier chiffre doit se trouver entre 1 et 3. Il indique le type de plante qui va être créé. Les deux autres chiffres correspondent à la position de la plante sur la grille du jeu. Les plantes peuvent être créées à n'importe quel moment pendant le jeu. À chaque création de plante le monant disponible pour créer des nouvelles plantes est affiché. Une fois des plantes créées et des enemis qui avancent, à chaque nouvelle affichage de la grille du jeu, des éventuelles attaques sont communiqués. 

### Jeu graphique

####  Menu

En choisissant le jeu sur l'interface graphique, tout d'abord le menu s'ouvre. Dans le menu il est possible de choisir les différents modes et niveaux pour le jeu dans l'onglet Settings. Avec l'onglet Rules, le jeueur peut lire les règles du jeu avant de commencer à jouer. En cliquant sur Exit, la fenêtre se ferme et le programme s'arrête. 

#### Jeu
Le premier bouton du menu est intitulé Start Game. Comme le nom l'indique, un clic sur ce bouton ouvre une nouvelle fenêtre sur laquelle le jeu est lancée. 