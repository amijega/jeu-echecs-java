public class Pion extends Piece {

    //constructeur
	public Pion(String couleur, String nom){
        super(couleur, nom);
    }

    //getters
    public String getCouleur(){
        return super.getCouleur();
    }

    public String getNom(){
        return super.getNom();
    }

    //méthodes, affichage du pion sur l'échiquier
	public String toString(){
        if (this.getCouleur().equals("blanche")){return "♟";}
        else {return "♙";}
    }

    /**
    *Logique de déplacement du pion : 
    *-Avancer tout droit d’une case 
    *-Avancer de deux cases uniquement depuis sa position de départ (ligne 2 ou 7)
    *-Capture diagonale d’une case
    */
    public boolean deplacement(Case source, Case destination, Echiquier e) {
        //Calcul de la direction du déplacement	
        int dir = this.getCouleur().equals("blanche") ? 1 : -1;

        int dx = Math.abs(e.getValeur(destination.getColonne()) - e.getValeur(source.getColonne()));
        int dy = destination.getLigne() - source.getLigne();

        //Retourne true si l'une des conditions suivantes est remplie, 
        return (dx == 0 && dy == dir) || (dx == 0 && dy == 2 * dir && source.getLigne() == (this.getCouleur().equals("blanche") ? 2 : 7)) || (dx == 1 && dy == dir && destination.getPiece()!=null);
    }

}//fin class Pion
