package com.mathmaurer.objets;

import javax.swing.ImageIcon;

import com.mathmaurer.personnages.Mario;

public class Cadeau extends Objet{
	//**** VARIABLES ****//
	
	private boolean etatCadeau = true; // Il est remplie de base
	
	//**** CONSTRUCTEUR	****//
    public Cadeau(int x, int y){
	    super(x, y, 30, 30);		
	    super.icoObjet = new ImageIcon("images/cadeau.png");
        super.imgObjet = super.icoObjet.getImage();
    }

	

    //**** GETTERS ****//		

    

 

    public boolean isEtatCadeau() {
		return etatCadeau;
	}

    //**** SETTERS ****//
    
	public void setEtatCadeau(boolean etatCadeau) {
		this.etatCadeau = etatCadeau;
	}

    //**** METHODES ****//
    
    // J'ai choisi de crée mes méthodes boolean ainsi pour qu'il n'ont qu'une entrée et qu'une sortie
    
    
    
}