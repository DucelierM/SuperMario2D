package com.mathmaurer.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mathmaurer.jeu.Main;
import com.mathmaurer.personnages.Personnage;


public class Objet {
	//**** VARIABLES ****//
	protected int largeur; //dimensions de l'objet
	protected int hauteur;
	protected int x; //position de l'objet	
	protected int y;
	protected Image imgObjet;
	protected ImageIcon icoObjet;
	private int emplacement = 0;

	
	
	//**** CONSTRUCTEUR ****//	
	public Objet(int x, int y, int largeur, int hauteur){		
	    this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	
    //**** GETTERS ****//	
    public int getX() {return x;}

	public int getY() {return y;}

	public int getLargeur() {return largeur;}

	public int getHauteur() {return hauteur;}
	
	public Image getImgObjet() {return imgObjet;}
	
	


	public int getEmplacement() {
		return emplacement;
	}


	public void setEmplacement(int emplacement) {
		this.emplacement = emplacement;
	}


	//**** SETTERS ****//	
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setLarg(int largeur) {this.largeur = largeur;}

	public void setHaut(int hauteur) {this.hauteur = hauteur;}
	
	
	//**** METHODES ****//
	public void deplacement() {		
		if(Main.scene.getxPos() >= 0 && Main.scene.getxPos() <= 4430){
		  this.setX(this.getX() - Main.scene.getDx());		
	    }
	}
	
	protected boolean contactDessus(Personnage personnage){
		if(this.x + this.largeur < personnage.getX() + 5 || this.x > personnage.getX() + personnage.getLargeur() - 5 || this.y < personnage.getY() + personnage.getHauteur() || this.y > personnage.getY() + personnage.getHauteur() + 5){return false;}
		else{return true;}
	}
	
	// si l'objet est en contact avec un autre objet, il font une mutation qui leurs permet de devenir un et unique objet, l
	// Une méthode mutation permettra de crée un environnement qui ferra muttez les objets en bloc plus long
	// X Horizontal // Y Vertical 
	
	
}