public class Cavalier extends Piece {

    //constructeur
	public Cavalier(String couleur, String nom){
        super(couleur, nom);
    }

    //getters
    public String getCouleur(){
        return super.getCouleur();
    }

    public String getNom(){
        return super.getNom();
    }

    //méthodes, affichage du cavalier sur l'échiquier
	public String toString(){
        if (this.getCouleur().equals("blanche")){return "♞";}
        else {return "♘";}
    }

    //Le Cavalier se déplacer en L, soit 1 ou 2 cases dans une direction, 2 ou 1 dans l’autre
    public boolean deplacement(Case source, Case destination, Echiquier e){
        int dx = Math.abs(e.getValeur(destination.getColonne()) - e.getValeur(source.getColonne()));
    	int dy = Math.abs(destination.getLigne() - source.getLigne());
    	return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
	}

} //fin class Cavalier
