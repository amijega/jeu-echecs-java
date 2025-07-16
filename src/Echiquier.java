// === Classe Echiquier ===
class Echiquier implements DonneesDamier{ 

    //variable, matrice représentant l’échiquier : chaque case contient une pièce ou est vide
    Case[][] damier = new Case[8][8];

    //constructeur
    public Echiquier(){
        for (int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                this.damier[i][j] = new Case(getLibelle(j),i+1);
            }
        }
    }

    //méthodes, renvoie le caractère correspondant à l’indice ( 0 -> ‘a’,1 -> ‘b’, etc.)
    public char getLibelle(int val){
        return DonneesDamier.Libelles[val];
    }
   
    //renvoie l’indice d'une lettre (0-7)
    public int getValeur(char libel){
        int i = 0 ;
        while (DonneesDamier.Valeurs[i] != (int)libel){
                i++;
            }
        return i;
    }
    
    //renvoie la case à partir de sa colonne (lettre) et ligne (chiffre)
    public Case getCase(char colonne, int ligne){
        return this.damier[ligne-1][getValeur(colonne)];
    }

    //Affiche l'état de l'échiquier dans la console
    public void afficher(){
        System.out.println("\n");
        System.out.println("  ╭―――――――――――――――――╮");

        for (int i = 7; i>=0; i--){
            System.out.print(i+1+" |");

            for (int j = 0; j<8; j++){
                System.out.print(" "+this.damier[i][j].afficher());
            }
            System.out.println(" |");
        }
        System.out.println("  ╰―――――――――――――――――╯");
        System.out.println("    "+"a b c d e f g h");
        System.out.println("\n");
    }

    //Place une pièce sur la case de coordonnées (colonnes, ligne)
    public void placerPiece(Piece piece, int colonne, int ligne){
        this.damier[ligne][colonne].setPiece(piece);
    }


    /**
     *Gère le déplacement d’une pièce d’une pièce d’une case source à une case destination,
     *en validant toutes les règles du jeu 
    */
    public void deplacerPiece(Case source, Case destination, Joueur courant) throws CaseVide, DeplacementPieceAdverse, DeplacementInterdit, DeplacementStatique, CaseOccupee, Obstacle {
        Piece piece = source.getPiece();
        Piece pieceDestination = destination.getPiece();

        int sx = getValeur(source.getColonne());
        int sy = source.getLigne();
        int dx = getValeur(destination.getColonne());
        int dy = destination.getLigne();

        //Vérifie que la case de départ n’est pas vide
        if (piece == null) {
            throw new CaseVide(source);
        }
        //Vérifie que la pièce appartient au joueur courant
        if (!piece.getCouleur().equals(courant.getCouleur())) {
            throw new DeplacementPieceAdverse(piece.getCouleur(), courant.getCouleur());
        }
        //Vérifie que le déplacement de la pièce est légal selon la pièce
        if (!piece.deplacement(source, destination, this)) {
            throw new DeplacementInterdit(source, destination, piece);
        }
        //Vérifie que le source et la destination sont différentes
        if (source.equals(destination)) {
            throw new DeplacementStatique();
        }
        //Vérifie qu’on ne capture pas une pièce de la même couleur
        if (pieceDestination != null && piece.getCouleur().equals(pieceDestination.getCouleur())) {
            throw new CaseOccupee(piece.getCouleur());
        }
        //Vérifie qu’aucune pièce ne bloque le déplacement (sauf pour les Cavaliers)
        if (!(piece instanceof Cavalier)) {
            int dirX = Integer.signum(dx - sx);   //détermine le signe du déplacement horizontal/vertical
            int dirY = Integer.signum(dy - sy);

            int x = sx + dirX;
            int y = sy + dirY;

            while (x != dx || y != dy) {
                Case caseIntermediaire = getCase(getLibelle(x), y);
                if (caseIntermediaire.getPiece() != null) {
                    throw new Obstacle(caseIntermediaire, caseIntermediaire.getPiece());
                }
                x += dirX;
                y += dirY;
            }
        }
        
        //La pièce est placée dans la case destination et est retirée de la case source
        getCase(getLibelle(dx), dy).setPiece(piece);
        getCase(getLibelle(sx), sy).setPiece(null);
    }


}//fin class Echiquier
	
