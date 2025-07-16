
/* === Classe Partie === */
import java.util.*;

class Partie {
    //variables
    private Joueur Jblanc;
    private Joueur Jnoir;
    private Joueur Jcourant;
    private List<String> logBlanc = new ArrayList<>();    // listes pour enregistrer les mouvements
    private List<String> logNoir = new ArrayList<>();
    private Echiquier echiquier;
    private Scanner entree = new Scanner(System.in); 

   //constructeur, initialise les joueurs et crée un échiquier vide
    public Partie(Joueur blanc, Joueur noir){
        this.Jblanc = blanc;
        this.Jnoir = noir;
        this.Jcourant = this.Jblanc;
        this.echiquier = new Echiquier();
    }
    
    // méthode pour afficher les coups
    public void afficherCoups() {
        System.out.println("Liste des coups joués :");
        System.out.println("N°  Blanc       Noir");
        int nbCoups = Math.max(logBlanc.size(), logNoir.size());
        for (int i = 0; i < nbCoups; i++) {
            String coupBlanc;
            if (i < logBlanc.size()) {
                coupBlanc = logBlanc.get(i);
            } else {
                coupBlanc = "";
            }

            String coupNoir;
            if (i < logNoir.size()) {
                coupNoir = logNoir.get(i);
            } else {
                coupNoir = "";
            }
            System.out.println(i+1+"   "+coupBlanc+"    "+coupNoir);
        }
        System.out.println();
    }

/**
   Initialise toutes les pièces blanches et noires à leur position initiale sur l’échiquier
                                                                           **/

    public void initPieces(Echiquier e) {
        /* Place les pièces blanches */
        e.placerPiece(new Tour("blanche", "Tour"), 0, 0);           // a1
        e.placerPiece(new Cavalier("blanche", "Cavalier"), 1, 0);   // b1
        e.placerPiece(new Fou("blanche", "Fou"), 2, 0);             // c1
        e.placerPiece(new Dame("blanche", "Dame"), 3, 0);           // d1
        e.placerPiece(new Roi("blanche", "Roi"), 4, 0);             // e1
        e.placerPiece(new Fou("blanche", "Fou"), 5, 0);             // f1
        e.placerPiece(new Cavalier("blanche", "Cavalier"), 6, 0);   // g1
        e.placerPiece(new Tour("blanche", "Tour"), 7, 0);           // h1

        /* Place les pions blancs */
        for (int j = 0; j < 8; j++) {
            e.placerPiece(new Pion("blanche", "Pion"), j, 1);       // a2 - h2      
        }

        /* Place les pions noirs */
        for (int j = 0; j < 8; j++) {
            e.placerPiece(new Pion("noire", "Pion"), j, 6);         // a7 - h7
        }

        /* Place les pièces noires */
        e.placerPiece(new Tour("noire", "Tour"), 0, 7);             // a8
        e.placerPiece(new Cavalier("noire", "Cavalier"), 1, 7);     // b8
        e.placerPiece(new Fou("noire", "Fou"), 2, 7);               // c8
        e.placerPiece(new Dame("noire", "Dame"), 3, 7);             // d8
        e.placerPiece(new Roi("noire", "Roi"), 4, 7);               // e8
        e.placerPiece(new Fou("noire", "Fou"), 5, 7);               // f8
        e.placerPiece(new Cavalier("noire", "Cavalier"), 6, 7);     // g8
        e.placerPiece(new Tour("noire", "Tour"), 7, 7);             // h8
    }

/** 
   Fonction permettant de jouer aux échecs
   Conditions de victoires / défaites non inclus
                                            **/
    public void Jouer(){
        boolean fin = false; 
        this.initPieces(echiquier);         //place les pièces sur l'échiquier

        while (fin != true){                //condition de victoire/défaite stop la boucle
            
            //vérification de mat ou pat, non inclus

            /* affichage graphique de la partie */
            echiquier.afficher();
            System.out.println("C'est au tour de "+Jcourant.getNom()+" (pièces "+Jcourant.getCouleur()+"s)");
            System.out.println("Entrez les coordonnées sources");
            System.out.println("=> ");
            String CoordSource = entree.next();      //récupération des coordonnées
           
            System.out.println("Entrez les coordonnées destinations");
            System.out.println("=> ");
            String CoordDest = entree.next();

            try{
                /* récupération des valeur x et y des cases sources 
                   et destination de la pièce à déplacer */
                char ColonneSource = CoordSource.charAt(0);
                int LigneSource = Character.getNumericValue(CoordSource.charAt(1));
                char ColonnedDest = CoordDest.charAt(0);
                int LigneDest = Character.getNumericValue(CoordDest.charAt(1));

                Case source = echiquier.getCase(ColonneSource, LigneSource);      //récupération des Cases source et destination
                Case destination = echiquier.getCase(ColonnedDest, LigneDest);
                echiquier.deplacerPiece(source, destination, Jcourant);           //deplacement de la pièce sur l'échiquier
                
                // Enregistrer le coup dans la liste correspondante dans le format 'Pièces coordonnées sources->coordonnées destinations'
                String coup = destination.getPiece()+" "+source.toString()+"->"+destination.toString();
                if (Jcourant.equals(Jblanc)) {
                    logBlanc.add(coup);
                } else {
                    logNoir.add(coup);
                }

                // Afficher la liste des coups joués
                afficherCoups();
            }

            catch (StringIndexOutOfBoundsException E){
                System.err.println("Coordonnées incorrectes. Réessayez");
                continue;
            }
            catch(ArrayIndexOutOfBoundsException E){
                System.err.println("Coordonnées incorrectes. Réessayez");
                continue;
            }
            catch (CaseVide E){         //les coordonnées source correspondent à une case sans pièce
                System.err.println(E);
                continue;
            }
            catch (DeplacementPieceAdverse E){          //déplacement d'une pièce adverse
                System.err.println(E);
                continue;
            }
            catch (DeplacementInterdit E){          //la pièce ne peut pas se déplacer d'une certaine manière
                System.err.println(E);
                continue;
            }
            catch (DeplacementStatique E){          //Le joueur essaye de déplacer une pièce sans changer de case
                System.err.println(E);
                continue;
            }
            catch (Obstacle E){
                System.err.println(E);          //Une autre pièce bloque le chemin 
                continue;
            }
            catch (CaseOccupee E){              //Le joueur essaye de capturer sa propre pièce 
                System.err.println(E);
                continue;
            }
            
            //Changement de joueur courant après un coup valide
            Jcourant = (Jcourant.equals(Jblanc)) ? Jnoir : Jblanc;

            
        }   
    }
} //fin class Partie
	
