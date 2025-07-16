// === Classe Case ===

public class Case {
    //variables, coordonnée de la case lettre (colonne) et chiffre (ligne)
    private char colonne;
    private int ligne;
    private Piece piece;       //pièce actuellement présente sur la case (null si vide)

    //constructeur
    public Case(char colonne, int ligne){
        this.colonne = colonne;
        this.ligne = ligne;
    }

    //getters, renvoie la colonne (lettre ‘a’ à ‘h’)
    public char getColonne(){
        return this.colonne;
    }

    //renvoie la ligne (chiffre 1 à 8)
    public int getLigne(){
        return this.ligne;
    }
    
    //renvoie la pièce actuellement sur la case (null si vide)
    public Piece getPiece(){
        return this.piece;
    }

    //setter, permet de placer une pièce sur cette case
    public void setPiece(Piece nouvPiece){
        this.piece = nouvPiece;
    }

    //méthode, affiche le symbole de la pièce ou un "." si vide (utilisé dans affichage de l’échiquier)
    public String afficher(){
        if (this.getPiece() == null){
            return ".";
        }
        return this.getPiece()+"";
    }

    //renvoie les coordonnées de la case au format 'colonneligne'
    public String toString(){
        return colonne+""+ligne;
    }

}//fin class Case

