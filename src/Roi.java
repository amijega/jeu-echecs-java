public class Roi extends Piece {

    //constructeur
	public Roi(String couleur, String nom){
        super(couleur, nom);
    }

    //getters
    public String getCouleur(){
        return super.getCouleur();
    }

    public String getNom(){
        return super.getNom();
    }

    //méthodes, affichage du roi sur l'échiquier
	public String toString(){
        if (this.getCouleur().equals("blanche")){return "♚";}
        else {return "♔";}
    }

    // Le roi peut se déplacer d'une case dans toutes les directions autour de lui
    public boolean deplacement(Case source, Case destination, Echiquier e) {
    	int dx = Math.abs(e.getValeur(destination.getColonne()) - e.getValeur(source.getColonne()));
    	int dy = Math.abs(destination.getLigne() - source.getLigne());
    	return dx <= 1 && dy <= 1;
	}
}
