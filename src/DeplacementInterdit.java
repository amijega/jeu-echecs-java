// === Classe DeplacementInterdit ===
//Exception levée lorsqu’un déplacement ne respecte pas les règles de la partie

public class DeplacementInterdit extends Exception {
    //variables
    private Case source;
    private Case destination;
    private Piece piece;

    //constructeur
    DeplacementInterdit(Case s, Case d, Piece p){
        super();
        this.source = s;
        this.destination = d;
        this.piece = p;
    }

    //Message d’erreur personnalisé
    public String toString(){
        return "Déplacement interdit. Vous ne pouvez pas déplacer votre "+piece.getNom()+" de la case "+source+" à "+destination;
    }

}//fin class DeplacementInterdit
