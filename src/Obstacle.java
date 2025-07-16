//=== Classe Obstacle ===
// Exception levée lorsqu’une pièce bloque le chemin (sauf pour les cavaliers)

public class Obstacle extends Exception {
    //variables
    private Case destination;
    private Piece piece;

    //constructeur
    Obstacle(Case d, Piece p){
        super();
        this.destination = d;
        this.piece = p;
    }

    //message d'erreur personnalisé
    public String toString(){
        return "Une pièce "+piece.getCouleur()+" bloque le chemin : "+piece.getNom()+" en "+destination;
    }

}//fin class Obstacle
