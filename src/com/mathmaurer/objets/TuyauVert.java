package com.mathmaurer.objets;

import javax.swing.ImageIcon;

public class TuyauVert extends Objet{
	//**** VARIABLES ****//
	
	
	//**** CONSTRUCTEUR	****//	
	public TuyauVert(int x, int y) {
		super(x, y, 43, 65);		
		super.icoObjet = new ImageIcon("images/tuyauVert.png");
        super.imgObjet = super.icoObjet.getImage();
	}

	
	//**** GETTERS ****//		
	
	
	//**** SETTERS ****//
	

	//**** METHODES ****//
}
