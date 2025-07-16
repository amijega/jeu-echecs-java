// === Classe DeplacementStatique ===
// Exception levée si la source et la destination sont identiques

public class DeplacementStatique extends Exception {

    //constructeur
    DeplacementStatique(){
        super();
    }

    //message d'erreur personnalisé
    public String toString(){
        return "Vous devez déplacer votre pièce";
    }

}//fin class DeplacementStatique
