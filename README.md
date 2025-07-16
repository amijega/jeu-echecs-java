# Jeu d'Échecs en Java

## Contexte

Ce projet a été réalisé dans le cadre de la SAE R201 du BUT 1 Informatique à l'IUT de Villetaneuse.  
Il s'agit de la modélisation et de l'implémentation d'un programme arbitrant une partie d'échecs entre deux joueurs, en appliquant la programmation orientée objet et l'architecture MVC.

## Objectifs

- Créer une version console du jeu d’échecs, avec affichage de l’échiquier dans le terminal.
- Respecter les déplacements autorisés pour chaque type de pièce selon les règles officielles.
- Gérer les exceptions liées aux coups invalides ou aux contraintes du plateau.

## Fonctionnement

1. Lancer le jeu avec la commande `java Main` dans un terminal.
2. Saisir le nom des deux joueurs (pièces blanches et noires).
3. L’échiquier s’affiche en console, les joueurs jouent chacun leur tour.
4. Pour déplacer une pièce, entrer les coordonnées source et destination au format `ColonneLigne` (ex. `a2 a4`).

Les coups valides sont exécutés, les erreurs sont signalées et doivent être corrigées pour poursuivre.

## Structure du projet

- Langage : Java
- Architecture : Modèle – Vue – Contrôleur (MVC)
- Diagramme UML pour la conception
- 19 classes au total, dont :
  - `Echiquier` : affichage et format graphique
  - `Piece`, `Pion`, `Roi`, `Dame`, `Cavalier`, `Fou`, `Tour` : déplacements et représentation
  - `Joueur`, `Main`, `Partie` : logique de la partie

## Gestion des exceptions

Le programme gère plusieurs types d’exceptions spécifiques :
- Déplacement interdit, déplacement statique, obstacle, case vide, case occupée, pièce adverse.
- Contrôle du format et des limites de l’échiquier.

## Limites

- Les conditions de victoire et de défaite ne sont pas implémentées.
- La partie se déroule en boucle continue, à interrompre manuellement pour quitter.

## Répartition du travail

Projet réalisé en binôme.  
- JEGATHASAN Amirtavarsini : commentaires du code, implémentation de classes majeures (`Echiquier`, `Pion`, `Roi`, `Dame`, `Joueur`, `Main`…), rédaction de la partie pendule.
- Solène Bourg : implémentation des autres classes, diagramme UML version numérique.

## Améliorations possibles

- Intégration d'une interface graphique (IHM) pour remplacer l'affichage console.
- Gestion complète de la pendule et conditions de fin de partie.
- Sauvegarde et reprise de partie.
