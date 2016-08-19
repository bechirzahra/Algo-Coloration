import java.awt.Color;
import java.util.*;
public class Sommet extends LinkedList<Sommet> implements Comparable<Sommet>{
    private double degre=0;
    private int numero;
    private float x;
    private float y;
    private Color couleur=Color.gray;

    public boolean equals(Object o){
	if(o==null) return false;	
	if(! (o instanceof Sommet)) return false;
	Sommet oo=(Sommet) o;
	return oo.numero==numero;
    }
    public boolean add(Sommet s){
	if(super.add(s)){
	    degre++;
	    s.degre++;
	    return true;
	}
	return false;
    }

    public boolean estFils(Sommet s){
	return contains(s);
    }

    public Sommet(int num,float x,float y){
	super();
	this.numero=num;
	this.x=x;
	this.y=y;
    }
    public int compareTo(Sommet s){
	if(degre<s.degre) return -1;
	else if(degre>s.degre) return 1;
	return 0;
    }
    public Sommet(int num,float x,float y,Color c){
	this(num,x,y);
	couleur=c;
    }
    public int getNumero(){
	return numero;
    }
    public float getX(){
	return x;
    }
    public float getY(){
	return y;
    }
    public Color getCouleur(){
	return couleur;
    }
    public void setCouleur(Color c){
	couleur=c;
    }
}
