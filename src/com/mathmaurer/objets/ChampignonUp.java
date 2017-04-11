package com.mathmaurer.objets;

import javax.swing.ImageIcon;

public class ChampignonUp extends Cadeau {

	public ChampignonUp(int x, int y) {
		super(x, y);
		super.icoObjet = new ImageIcon("images/champignon.png");
        super.imgObjet = super.icoObjet.getImage(); 
	}

}
