package com.mathmaurer.objets;

import javax.swing.ImageIcon;

import com.mathmaurer.affichage.CompteARebours;
import com.mathmaurer.personnages.Mario;
import com.mathmaurer.personnages.Personnage;

public class ChampignonTime extends Cadeau {

	private int dxChampignonTime;
	CompteARebours time;
	
	public ChampignonTime(int x, int y) {
		super(x, y);
		super.icoObjet = new ImageIcon("images/champignonUp.png");
        super.imgObjet = super.icoObjet.getImage();
		// TODO Auto-generated constructor stub
	}
	
	public void bouge(){
		if(this.pouvoir == false){
			if(super.isEtatCadeau() == false){
				if(this.itemVersDroite == true){
					this.dxChampignonTime = 1;
				}else{
					this.dxChampignonTime = -1;
					}{
				super.setX(super.getX() + this.dxChampignonTime);
				}
			    //super.retombeSaut("images/champignon.png");
			}	
		}
	}
	public void contact(Objet objet){
		if(super.contactAvant(objet) == true && this.isItemVersDroite() == true){					
	        super.setItemVersDroite(false);
		    this.dxChampignonTime = -1; 
		}else if(super.contactArriere(objet) == true && this.isItemVersDroite() == false){
		    super.setItemVersDroite(true);
		    this.dxChampignonTime = 1;     
		}
	}
	
	public void contact(Personnage personnage) {			
		if(super.contactAvant(personnage) == true && this.itemVersDroite == true){					
	        super.setItemVersDroite(false);
	    	this.dxChampignonTime = -1; 
	    }else if(super.contactArriere(personnage) == true && this.itemVersDroite == false){
	    	super.setItemVersDroite(true);
	    	this.dxChampignonTime = 1;     
	    }
	}
	
	public boolean contactMario(Mario mario){
		if(super.contactArriere(mario) == true || super.contactAvant(mario) == true || super.contactDessous(mario) == true || super.contactDessus(mario) ){
			this.setPouvoir(true);
			mario.transformation = "Grand";
			return true;
		}else {
			return false;
		}
	}
	
	public void contact(Cadeau lecadeau){
		if(super.contactDessous(lecadeau)== false){
			super.retombeSaut("");
		}else{
			//Main.scene.setySol(lecadeau.getY());
		}
	}

}
