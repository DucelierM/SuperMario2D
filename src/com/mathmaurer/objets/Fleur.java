package com.mathmaurer.objets;

import javax.swing.ImageIcon;

import com.mathmaurer.personnages.Mario;

public class Fleur extends Cadeau {
	

	public Fleur(int x, int y) {
		super(x, y);
		super.icoObjet = new ImageIcon("images/fleur.png");
        super.imgObjet = super.icoObjet.getImage();
		// TODO Auto-generated constructor stub
	}
	
	public boolean contactMario(Mario mario){
		if(super.contactArriere(mario) == true || super.contactAvant(mario) == true || super.contactDessous(mario) == true || super.contactDessus(mario) ){
				mario.setHauteur(50);
				mario.setLargeur(28);
				mario.transformation = "Feu";
				this.setPouvoir(true);
				return true;
		}else {
			return false;
		}
	}

}
