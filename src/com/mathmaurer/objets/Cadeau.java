package com.mathmaurer.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mathmaurer.jeu.Main;
import com.mathmaurer.personnages.Personnage;

public class Cadeau extends Objet {
	//**** VARIABLES ****//
	
// temps d'attente en ms entre 2 tours de boucle

	
	private boolean etatCadeau = true; // Il est remplie de base
	protected boolean itemVersDroite; // vrai quand le item est sorti du cadeau
	protected boolean pouvoir; //vrai quand l'objet permet de acquérir des pouvoirs
	private int emplacementItem;

	
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

    public boolean isItemVersDroite() {
		return itemVersDroite;
	}

	public void setItemVersDroite(boolean itemVersDroite) {
		this.itemVersDroite = itemVersDroite;
	}
	
	public int getEmplacementItem() {
		return emplacementItem;
	}

	public void setEmplacementItem(int emplacementItem) {
		this.emplacementItem = emplacementItem;
	}

	public boolean isPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(boolean pouvoir) {
		this.pouvoir = pouvoir;
	}

	public Image apparitionCadeau(Cadeau lecadeau){
    	String str = null;	
		ImageIcon ico;
		Image img;
		
		
		for(int compteur = 0 ; compteur <= 7; compteur++ ){ // Initialisation d'une boucle qui permet a l'item de sortir du tableau
	    		lecadeau.setY(lecadeau.getY()-compteur);
	    		
	    	}
		
		//this.setEtatCadeau(false); // Le cadeau devient vide
		str = "";
		ico = new ImageIcon(str);
        img = ico.getImage();
		return img;
		
    }
    
    public Image retombeSaut(String str){
		ImageIcon ico;
		Image img;
		
		if(this.getY() + this.getHauteur() < Main.scene.getySol()){
			this.setY(this.getY()+1);
			str = "";
		}	
		ico = new ImageIcon(str);
        img = ico.getImage();
		return img;
    }
    
    
    //**** METHODES ****//
    
    
    // Contact avec les objets // 
    
    protected boolean contactAvant(Objet objet){
		if(this.itemVersDroite== false){
			if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
			else{return true;}
		}else{return false;}
	}
    protected boolean contactArriere(Objet objet){	
    	//if(this.itemVersDroite == true){
    		if(this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
    		else{return true;}
    	//}else{return false;}
		
	}
    public boolean contactDessous(Objet objet){	
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5){return false;}
		else{return true;}		
	}
    public boolean contactDessus(Objet objet){
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5){return false;}
		else{return true;}
	}
    
    public boolean proche(Objet objet){   	
    	if((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10) 
    	|| (this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur() + 10)){return true;}
    	else{return false;}
    }
    
    
    
    
    // Contact avec les cadeaux// 
    
    public boolean contactDessous(Cadeau cadeau){	
		if(this.x + this.largeur < cadeau.getX() + 5 || this.x > cadeau.getX() + cadeau.getLargeur() - 5 || this.y + this.hauteur < cadeau.getY() || this.y + this.hauteur > cadeau.getY() + 5){return false;}
		else{return true;}		
	}
    
    public boolean contactDessus(Cadeau cadeau){
		if(this.x + this.largeur < cadeau.getX() + 5 || this.x > cadeau.getX() + cadeau.getLargeur() - 5 || this.y < cadeau.getY() + cadeau.getHauteur() || this.y > cadeau.getY() + cadeau.getHauteur() + 5){return false;}
		else{return true;}
	}
    
    public boolean proche(Cadeau cadeau){   	
    	if((this.x > cadeau.getX() - 10 && this.x < cadeau.getX() + cadeau.getLargeur() + 10) 
    	|| (this.x + this.largeur > cadeau.getX() - 10 && this.x + this.largeur < cadeau.getX() + cadeau.getLargeur() + 10)){return true;}
    	else{return false;}
    }
    
    // Contact avec les personnages //
    
    protected boolean contactAvant(Personnage personnage){
		if(this.itemVersDroite == true){
			if(this.x + this.largeur < personnage.getX() || this.x + this.largeur > personnage.getX() + 5 || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()){return false;}
			else{return true;}
		}else{return false;}
	} 
    
    protected boolean contactArriere(Personnage personnage){		
		if(this.x > personnage.getX() + personnage.getLargeur() || this.x + this.largeur < personnage.getX() + personnage.getLargeur() - 5 || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()){return false;}
		else{return true;}
	}

    protected boolean contactDessous(Personnage personnage){
    	if(this.x + this.largeur < personnage.getX() || this.x > personnage.getX() + personnage.getLargeur() || this.y + this.hauteur < personnage.getY() || this.y + this.hauteur > personnage.getY()){return false;}
		else{return true;}
	}
    
    public boolean proche(Personnage personnage){  	
    	if((this.x > personnage.getX() - 10 && this.x < personnage.getX() + personnage.getLargeur() + 10) 
    	|| (this.x + this.largeur > personnage.getX() - 10 && this.x + this.largeur < personnage.getX() + personnage.getLargeur() + 10)){return true;}
    	else{return false;}
    }
    
   
    
}