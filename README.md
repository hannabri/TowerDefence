# Tower Defence

Ce projet est une implémentation en Java d'un jeu Tower Denfence pour le cours de programmation orientée objet. Initiallement conçu pour les L2 Informatique, les étudiants du Master Linguistique Informatique ont également suivi ce cours.

## Compilation 
Le programme a compilé sur Windows avec la commande suivante: javac ./TowerDefence/source/Main_file.java
Pour Linux Ubuntu, nous avons créer un dossier build dans lequel nous avons mis tous les fichiers .class de toutes les packages. Pour cela, nous avons défini le classpath au dossier build dans TowerDefence avec la commande: export CLASSPATH=./build/ <br>
Voici la commande qui permet de complier un dossier à partir du dossier TowerDefence: javac -d ./build ./source/*.java (example pour le package source) <br>
Ensuite, nous avons créer des fichiers .jar à partir des dossiers avec les fichers .class. La commande qui le permet est la suivante: jar cf Scenes.jar build/*.class (example pour les fichiers .class du package Scenes)<br>
Nous avons dû compiler dossier par dossier, car certains fichiers utilisent d'autres packages de notre projet. Afin de pouvoir compiler il leur faut le fichier .jar du package.
Pour finir, la derniére commande pour compiler le program complet est : javac ./source/Main_file.java

## Exécution

Pour lancer le jeu, il faut entrer la commande suivante: java Main_file.java pour Windows. 
Sur Ubuntu, la commande java TowerDefence.Source.Main_file permet d'exécuter le jeu sur le terminal.

## Utilisation

Une fois le fichier principal exécuté, il est possible de choisir entre le jeu dans le terminal et le jeu sur l'interface graphique. En tappant 1 le jeu se lance sur le terminal et en tappant 2 le jeu se lance en mode graphique. 

### Jeu terminal

Avant de commencer le jeu terminal, il faut choisir entre le mode normal et le mode marathon en tappant soit 1 soit 2. Selon le chiffre entré le jeu se lancera. Chanque cinq secondes la grille du jeu sera affichée avec les emplacement les plantes créées (si déjà créées) et les enemis qui avancent. Il est possibe de placer des plantes en entrant trois chiffres. Le premier chiffre doit se trouver entre 1 et 3. Il indique le type de plante qui va être créé. Les deux autres chiffres correspondent à la position de la plante sur la grille du jeu. Les plantes peuvent être créées à n'importe quel moment pendant le jeu. À chaque création de plante le monant disponible pour créer des nouvelles plantes est affiché. Une fois des plantes créées et des enemis qui avancent, à chaque nouvelle affichage de la grille du jeu, des éventuelles attaques sont communiqués. 

### Jeu graphique

####  Menu

En choisissant le jeu sur l'interface graphique, tout d'abord le menu s'ouvre. Dans le menu il est possible de choisir les différents modes et niveaux pour le jeu dans l'onglet Settings. Avec l'onglet Rules, le jeueur peut lire les règles du jeu avant de commencer à jouer. En cliquant sur Exit, la fenêtre se ferme et le programme s'arrête. 

#### Jeu

Le jeu dans l’interface graphique se compose de deux cat ́egories de pions : les pions amis et
les pions ennemis. Les pions ennemis (en blanc) descendent par vague de manière aléatoire sur
la largeur de la fenêtre, dans la trajectoire dessinée sur le plateau. Ils lancent des projectiles qui
infligent des dégâts, et à l’intérieur du cercle, on peut voir leurs points de vie. Lorsqu’ils n’ont plus
de points de vie, ils disparaissent de la fenêtre. Pour cela, nous ajoutons les amis et les ennemis qui
n’ont plus de points de vie à une liste, puis nous faisons disparaître cette liste de la fenêtre.
Les amis (en rouge) sont quant à eux positionn ́es sur le plateau grâce au joueur avec une action
de la souris. Lorsque le joueur clique sur la souris, un ami est pos ́e sur le plateau et lance un seul
projectile.
Notre jeu fonctionne avec un système d’argent, nous avons un porte-monnaie de d ́epart contenant 100 pièces, et des amis qui nous coûtes 20 pièces chacun que nous pouvons placer sur le plateau.
L’argent est récolté grâce aux ennemis tués qui rapporte plus ou moins d’argent en fonction de leur
catégorie. Lorsque l’utilisateur n’a plus d’argent, un message d’erreur est affiché jusqu’à ce qu’il
tue un autre ennemis et qu’il puisse remettre des amis sur le plateau. Lorsqu’il n’y a
plus de vague d’ennemis et que tout les ennemis sont morts, le jeu s’arrˆete et une scène ”You Win”
s’affiche. Si les ennemis arrivent à aller jusqu’en bas du plateau de jeu alors vous avez
perdu, et une scène ”Game Over” s’affiche.

#### Règles du jeu 

Le jeu Tower Defense est un jeu de stratégie dont le but est de défendre une base en empêchant les vagues d’ennemis d’y accéder.
Pour jouer à ce jeu, il faut placer les tours de défense le long du chemin emprunté par les ennemis. 
Chaque tour possède plusieurs armes avec un nombre limité de munitions. Ici une seule. 
Les monstres ennemis vont apparaître par vagues successives et ils vont tous suivre le chemin dessiné sur la carte. 
Vise-les avec tes tours pour les éliminer et réduire leur nombre.
À mesure que le niveau de difficulté augmente, le nombre d’ennemis augmente et ils deviennent de plus en plus difficiles à battre.
Les tours vont alors viser et tirer sur les ennemis pour les tuer. Les ennemis tué te rapporteront de l'argent avec lequel tu pourras acheter d'autres tours. 

Il faut absolument empêcher les ennemis d’atteindre ta base pour ne pas perdre.

Tu gagnes la partie lorsque tu auras réussi à tuer tous les ennemis.