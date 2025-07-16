// === Classe Piece ===

public abstract class Piece {
    // variables, couleur de la pièce “blanche” ou “noire”
    private String couleur;
    private String nom;       //nom de la pièce (tour, dame…)

    //constructeur, initialise une pièce  avec sa couleur et son nom
    public Piece(String couleur, String nom){
        this.couleur = couleur;
        this.nom = nom;
    }

    //getters, renvoie la couleur de la pièce
    public String getCouleur(){
        return this.couleur;
    }

    //renvoie le nom de la pièce
    public String getNom(){
        return this.nom;
    }

    //méthodes, chaque sous-classe doit redéfinir la toString() et définir sa propre logique de déplacement
    public String toString(){
        return "Je suis une pièce du jeu d'échec";
    }

    public abstract boolean deplacement(Case source, Case destination, Echiquier echiquier);

}//fin class Piece
