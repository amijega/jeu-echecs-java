// === Classe Joueur ===
public class Joueur {
    //variables, couleurs des pièces à jouer et nom du joueur
    String nom;
    String couleur;

    //constructeur
    public Joueur(String nom, String couleur){
        this.nom = nom;
        this.couleur = couleur;
    }

    //getters, renvoie le nom du joueur
    public String getNom(){
        return this.nom;
    }

    //renvoie la couleur des pièces jouées par le joueur
    public String getCouleur(){
        return this.couleur;
    }

}//fin class Joueur
	
