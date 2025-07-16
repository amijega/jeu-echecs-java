public class Dame extends Piece {

    //constructeur
	public Dame(String couleur, String nom){
        super(couleur, nom);
    }

    //getters
    public String getCouleur(){
        return super.getCouleur();
    }

    public String getNom(){
        return super.getNom();
    }

    //méthodes, affichage de la dame sur l'échiquier
	public String toString(){
        if (this.getCouleur().equals("blanche")){return "♛";}
        else {return "♕";}
    }

    // La dame combine les déplacements du fou et de la tour
    public boolean deplacement(Case source, Case destination, Echiquier e){
    	return new Tour(this.getCouleur(), "verif").deplacement(source, destination, e) || new Fou(this.getCouleur(), "verif").deplacement(source, destination, e);
	}

}//fin class Dame
