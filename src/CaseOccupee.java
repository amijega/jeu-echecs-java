//=== Classe CaseOccupee ===
// Exception levée si la destination est occupée par une pièce de même couleur

public class CaseOccupee extends Exception {
    //variable
    private String couleur;

    //constructeur
    CaseOccupee(String c){
        super();
        this.couleur = c;
    }

    //message d'erreur personnalisé
    public String toString(){
        return "Vous ne pouver pas déplacer votre pièce "+couleur+" sur une autre pièce "+couleur;
    }

}//fin class CaseOccupee
