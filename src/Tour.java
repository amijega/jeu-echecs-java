// === Class Tour ===

public class Tour extends Piece {
    //constructeur
    public Tour(String couleur, String nom){
        super(couleur, nom);
    }

    //getters, retourne la couleur de la pièce
    public String getCouleur(){
        return super.getCouleur();
    }

    //retourne le nom de la pièce
    public String getNom(){
        return super.getNom();
    }

    //méthodes, affichage de la tour sur l'échiquier
    public String toString(){
        if (this.getCouleur().equals("blanche")){return "♜";}
        else {return "♖";}
    }

    //La Tour se déplace en ligne droite, soit même ligne, soit même colonne
    public boolean deplacement(Case source, Case destination, Echiquier e){
        int sx = source.getLigne();
        char sy = source.getColonne();
        int dx = destination.getLigne();
        char dy = destination.getColonne();

        return sx == dx || (int)sy == (int)dy;
    }

} //fin class Tour
