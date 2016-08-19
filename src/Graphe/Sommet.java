package Graphe;

/**
 *
 * @author bechir
 */
public class Sommet {
    private int numero;
    private int couleur;
    public void setNumero(int numero){
        this.numero=numero;
    }
    public void setCouleur(int couleur){
        this.couleur=couleur;
    }
    public int getNumero(){
        return this.numero;
    }
    public int getCouleur(){
        return this.couleur;
    }
    public Sommet(int numero,int couleur){
        this.setNumero(numero);
        this.setCouleur(couleur);
    }
    @Override
    public int hashCode(){
        return 41+7*this.numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sommet other = (Sommet) obj;
        return this.numero == other.numero;
    }
    @Override
    public String toString(){
        String tmp="------------\n";
        tmp+="Numéro: "+this.numero+"\n";
        tmp+="Coleure: " +this.couleur+"\n";
        return tmp;
    }

}
