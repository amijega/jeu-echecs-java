// === Classe Main ===
//Initialise les joueurs et démarre la partie

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            //Scanner pour les noms des joueurs
        Scanner demarrage = new Scanner(System.in);
            //Présentation
        System.out.println("............................................................"+"\n");
        System.out.println("Bonjour ! Merci d'avoir choisi de jouer à ce jeu d'échec");
            //Initialisation du joueur Blanc
        System.out.println("Qui est le premier JOUEUR ? ");
        String JB = demarrage.nextLine();
        Joueur JOUEURblanc = new Joueur(JB, "blanche");
        System.out.println("Tu auras les pièces blanches");
            //Initialisation du joueur Noir
        System.out.println("Qui est le deuxième JOUEUR ? ");
        String JN = demarrage.nextLine();
        Joueur JOUEURnoir = new Joueur(JN, "noire");
        System.out.println("Tu auras les pièces noires"+"\n");

        System.out.println("Bienvenu à vous deux et que le meilleur gagne !");
        System.out.println("............................................................"+"\n");

	        //Démarrage de la partie
        Partie p = new Partie(JOUEURblanc, JOUEURnoir);
        p.Jouer();
    }

}//fin class Main
    
