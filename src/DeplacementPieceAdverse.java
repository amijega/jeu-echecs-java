//=== Classe DeplacementPieceAdverse ===
// Exception levée si un joueur essaie de déplacer une pièce de l'adversaire

public class DeplacementPieceAdverse extends Exception {
    //variables
    private String CouleurPiece;
    private String CouleurJoueur;

    //constructeur
    DeplacementPieceAdverse(String piece, String joueur){
        super();
        this.CouleurPiece = piece;
        this.CouleurJoueur = joueur;
    }

    //message d'erreur personnalisé
    public String toString(){
        return "Impossible de bouger une pièce "+CouleurPiece+" alors que vous jouez les pièces "+CouleurJoueur+"s";
    }

}//fin class DeplacementPieceAdverse
