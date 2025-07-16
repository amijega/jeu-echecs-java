public class Fou extends Piece {

    //constructeur
	public Fou(String couleur, String nom){
        super(couleur, nom);
    }

    //getters
    public String getCouleur(){
        return super.getCouleur();
    }

    public String getNom(){
        return super.getNom();
    }

    //méthodes, affichage du fou sur l'échiquier
	public String toString(){
        if (this.getCouleur().equals("blanche")){return "♝";}
        else {return "♗";}
    }

    //Le fou se déplace en diagonale, même écarts en lignes et en colonnes
    public boolean deplacement(Case source, Case destination, Echiquier e) {
        return Math.abs(destination.getLigne() - source.getLigne()) == Math.abs(e.getValeur(destination.getColonne()) - e.getValeur(source.getColonne()));
	}

}//fin class Fou

