package com.mathmaurer.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mathmaurer.jeu.Main;
import com.mathmaurer.personnages.Mario;
import com.mathmaurer.personnages.Personnage;

public class ChampignonUp extends Cadeau implements Runnable{
	
	private int dxChampignonUp;
	private final int PAUSE = 50;

	public ChampignonUp(int x, int y) {
		super(x, y);
		super.icoObjet = new ImageIcon("images/champignon.png");
        super.imgObjet = super.icoObjet.getImage();
        Thread chronoChampUp = new Thread(this);
        chronoChampUp.start();
        
	}
	

	public void bouge(){
		if(this.pouvoir == false){
			if(super.isEtatCadeau() == false){
				if(this.itemVersDroite == false){
					this.dxChampignonUp = 1;
				}else{
					this.dxChampignonUp = -1;
					}{
				super.setX(super.getX() + this.dxChampignonUp);
				}
			    //super.retombeSaut("images/champignon.png");
			}	
		}
		
	}
	
	public void contact(Objet objet){
		if(super.contactAvant(objet) == true && this.isItemVersDroite() == false){					
	        super.setItemVersDroite(true);
		    this.dxChampignonUp = -1; 
		}else if(super.contactArriere(objet) == true && this.isItemVersDroite() == true){
		    super.setItemVersDroite(false);
		    this.dxChampignonUp = 1;     
		}
	}
	
	public void contact(Personnage personnage) {			
		if(super.contactAvant(personnage) == true && this.itemVersDroite == true){					
	        super.setItemVersDroite(false);
	    	this.dxChampignonUp = -1; 
	    }else if(super.contactArriere(personnage) == true && this.itemVersDroite == false){
	    	super.setItemVersDroite(true);
	    	this.dxChampignonUp = 1;     
	    }	
	}
	
	public boolean contactMario(Mario mario){
		if(super.contactArriere(mario) == true || super.contactAvant(mario) == true || super.contactDessous(mario) == true || super.contactDessus(mario) ){
			mario.setHauteur(50);
			mario.setLargeur(28);
			mario.setY(243);
			this.setPouvoir(true);
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
	

	// Méthodes 
	
	@Override
	public void run() {							
		while(true){ // boucle infinie											
			try{
				Thread.sleep(PAUSE);
			}
			catch (InterruptedException e){}
		}		
	}
	    
}
