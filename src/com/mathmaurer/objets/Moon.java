package com.mathmaurer.objets;

import javax.swing.ImageIcon;

import com.mathmaurer.personnages.Mario;

public class Moon extends Cadeau{

	public Moon(int x, int y) {
		super(x, y);
		super.icoObjet = new ImageIcon("images/moon.png");
        super.imgObjet = super.icoObjet.getImage();
		// TODO Auto-generated constructor stub
	}
	
	public boolean contactMario(Mario mario){
		if(super.contactArriere(mario) == true || super.contactAvant(mario) == true || super.contactDessous(mario) == true || super.contactDessus(mario) ){
				this.setPouvoir(true);
				return true;
		}else {
			return false;
		}
	}

}
