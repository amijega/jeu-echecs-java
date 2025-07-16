//=== Classe CaseVide ===
//Exception levée si la case source est vide (aucune pièce à déplacer)

public class CaseVide extends Exception{
    //variable
    private Case caseVide;
    
    //constructeur
    public CaseVide(Case source){
        super();
        this.caseVide = source;
    }

    //message d'erreur personnalisé
    public String toString(){
        return "Il n'y a pas de pièce sur la case "+caseVide;
    }

}//fin class CaseVide
