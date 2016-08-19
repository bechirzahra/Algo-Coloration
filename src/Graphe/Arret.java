/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphe;

/**
 *
 * @author bechir
 */
public class Arret {
    private Sommet _1;
    private Sommet _2;
    
    public Arret(Sommet _1,Sommet _2){
        this._1=_1;
        this._2=_2;
    }
    public Sommet get_1(){
        return _1;
    }
    public Sommet get_2(){
        return _2;
    }
    @Override
    public int hashCode(){
        return _1.getNumero()*7+_2.getNumero()*5;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arret arret = (Arret) obj;
        if(
                (this._1.equals(arret._1) && this._2.equals(arret._2)) ||
                (this._1.equals(arret._2) && this._1.equals(arret._2))
                
                ) return true;

        
        return false;
    }
}
