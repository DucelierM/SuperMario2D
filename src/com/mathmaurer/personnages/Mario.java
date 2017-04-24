package com.mathmaurer.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mathmaurer.audio.Audio;
import com.mathmaurer.jeu.Main;
import com.mathmaurer.objets.Cadeau;
import com.mathmaurer.objets.Objet;
import com.mathmaurer.objets.Piece;


public class Mario extends Personnage {
	//**** VARIABLES ****//
	private Image imgMario;
	private ImageIcon icoMario;	
	private boolean saut; // vrai quand mario saute
	private int compteurSaut; // gère la durée et la hauteur du saut de mario quand il saute	
	private int compteurMort;
	private int compteurVie;
	
	//private boolean chute; // vrai quand mario quitte un objet
		
	public String transformation = null;
	
	
	//**** CONSTRUCTEUR	****//	
	public Mario(int x, int y) {
		super(x, y, 26, 29); // 28 , 50 
		super.setVersDroite(true);
		super.setMarche(false);
		this.icoMario = new ImageIcon("");
        this.imgMario = icoMario.getImage();		
		this.saut = false;
		this.compteurSaut = 0;
		this.compteurMort = 0;
		this.transformation = "marioPetit";
		this.compteurVie=1;
	}

	
	//**** GETTERS ****//		
	public Image getImgMario() {return imgMario;}
	
	public boolean isSaut() {return saut;}
	



	//**** SETTERS ****//
	public void setSaut(boolean saut) {this.saut = saut;}
	
	public int getCompterMort(){
		return this.compteurMort;
	}
	
	
	

	public String getTransformation() {
		return transformation;
	}


	public void setTransformation(String transformation) {
		this.transformation = transformation;
	}
	
	


	public int getCompteurVie() {
		return compteurVie;
	}


	public void setCompteurVie(int compteurVie) {
		this.compteurVie = compteurVie;
	}
	
	//**** METHODES ****//
    public Image saute(String nom){		
    	String str;	
		ImageIcon ico;
		Image img;
	
		// Changer le str et le nom en variable de la classe pour qu'elle soit accesible sur toutes les méthodes et pouvoir effectuer des opération directement a ce moment la
		
		this.compteurSaut++;
		// Montée du saut		
		if(this.compteurSaut <= 40){
			// permer a mario de sauté
			if(this.getY() > Main.scene.getHautPlafond()){this.setY(this.getY() - 5);}
			else{this.compteurSaut = 41;}
			
			if(this.isVersDroite() == true){str = "images/"+nom+"SautDroite.png";}
			else{str = "images/"+nom+"SautGauche.png";}			
		// Retombée du saut
		}else if(this.getY() + this.getHauteur() < Main.scene.getySol()){
			this.setY(this.getY() + 1);
			if(this.isVersDroite() == true){str = "images/"+nom+"SautDroite.png";}
			else{str = "images/"+nom+"SautGauche.png";}		
		// Saut terminé
			
		}else{				
			if(this.isVersDroite() == true){str = "images/"+nom+"ArretDroite.png";}
			else{str = "images/"+nom+"ArretGauche.png";}	
			this.saut = false;
			this.compteurSaut = 0;
		}
		// Affichage de l'image de mario
        ico = new ImageIcon(str);
        img = ico.getImage();
		return img;
	}
    
    public Image retombeSaut(String nom){
    	String str = null;	
		ImageIcon ico;
		Image img;
		
		if(this.getY() + this.getHauteur() < Main.scene.getySol()){
			this.setY(this.getY()+1);
			if(this.isVersDroite() == true){str = "images/"+nom+"SautDroite.png";}
			else{str = "images/"+nom+"SautGauche.png";}	
		}
		ico = new ImageIcon(str);
        img = ico.getImage();
		return img;
    }
    
    public Image apparitionCadeau(Cadeau lecadeau){
    	String str = null;	
		ImageIcon ico;
		Image img;
		for(int compteur = 0 ; compteur <= 3; compteur++ ){ // Initialisation d'une boucle qui permet a l'item de sortir du tableau
	    		lecadeau.setY(lecadeau.getY()-compteur);}
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		str = "";
		ico = new ImageIcon(str);
        img = ico.getImage();
		return img;
    }
    
	public void contact(Objet objet) {		
		if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
			Main.scene.setDx(0);
		    this.setMarche(false);
		}
        if(super.contactDessous(objet) == true && this.saut == true){
			Main.scene.setySol(objet.getY());			
		}else if(super.contactDessous(objet) == false){
			Main.scene.setySol(293); // altitude du sol initial
			// Il n'est plus sur l'objet et qu'il ne saute pas
			//if(this.saut == false ){
				//this.setY(243);
				retombeSaut("mario");
			//}
		}
        if(super.contactDessus(objet) == true){
			Main.scene.setHautPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
			//System.out.println("Sa passe dans l'objet");
		}else if(super.contactDessus(objet) == false && this.saut == false){
			Main.scene.setHautPlafond(0);
		}
	}
	
	// Test des contact avec les Cadeau
	
	public void contactCadeau(Cadeau cadeau){	
		if((super.contactAvant(cadeau) == true && this.isVersDroite() == true) || (super.contactArriere(cadeau) == true && this.isVersDroite() == false)){
			Main.scene.setDx(0);
		    this.setMarche(false);
		}
        if(super.contactDessous(cadeau) == true && this.saut == true){
			Main.scene.setySol(cadeau.getY());	
		}else if(super.contactDessous(cadeau) == false){
			Main.scene.setySol(293); // altitude du sol initial
			// Il n'est plus sur l'objet et qu'il ne saute pas
				retombeSaut("mario");
		}
        if(super.contactDessus(cadeau) == true){
			Main.scene.setHautPlafond(cadeau.getY() + cadeau.getHauteur()); // le plafond devient le dessous de l'objet

        }else if(super.contactDessus(cadeau) == false && this.saut == false){
			Main.scene.setHautPlafond(0);
		}
	}
	
	// Pas utiliser : 
	/**
	 * 	public boolean contactItem(Cadeau leitem){		
		if(this.contactArriere(leitem) == true || this.contactAvant(leitem) == true || this.contactDessous(leitem) == true || this.contactDessus(leitem) == true){
			return true;			
		}else{return false;}
	}
	 * 
	 * @param leitem
	 * @return
	 */

	
	public boolean contactPiece(Piece piece){		
		if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || this.contactDessus(piece) == true){
			return true;			
		}else{return false;}
	}
	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "images/boom.png";
        if(this.compteurMort == 0){Audio.playSound("/audio/boum.wav");}
        if(this.compteurMort == 100){Audio.playSound("/audio/partiePerdue.wav");}
        this.compteurMort++; 
        if(isDead()){
        	str = "images/marioMeurt.png";
        	this.setY(this.getY() - 1);
        }
		ico = new ImageIcon(str);
		img = ico.getImage();
		return img; 
	} 
	
	public boolean isDead(){
		if(this.compteurMort > 100){
			return true;
        }else{
        	return false;
        }
	}

    public void contact(Personnage personnage) {		
		
			int vie = this.getCompteurVie();
			
			switch(vie){
			
				case 3 : 
					if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true)){
						setTransformation("mario");
						toucheLevelDown(personnage);
						setCompteurVie(2);
						Audio.playSound("/audio/mario-retrecit.wav");
					}
					break;
				
				case 2 : 
					if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true)){
						setTransformation("marioPetit");
						this.setHauteur(26);
						this.setLargeur(29);
						toucheLevelDown(personnage);
						setCompteurVie(1);
						Audio.playSound("/audio/mario-retrecit.wav");

					}
					
					
					break;
				case 1 : 
					if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true)){
						if(getCompteurVie() == 1 && getTransformation() == "marioPetit"){
							this.setMarche(false);
				    		this.setVivant(false);
						}
					}
					

			
		}
		if(super.contactDessous(personnage) == true && this.getTransformation() == "marioPetit" || super.contactDessous(personnage) == true && this.getTransformation() == "mario" || super.contactDessous(personnage) == true && this.getTransformation() == "marioFeu"){
			personnage.setMarche(false);
			personnage.setVivant(false);
		}	
    }
    
    public void toucheLevelDown(Personnage personnage){
    	if(personnage.isVersDroite() == false && isVersDroite() == true ){
			personnage.setX(getX()-30);

		}
		if(personnage.isVersDroite() == false && isVersDroite() == false){
			personnage.setX(getX()-50);
		}
		if(personnage.isVersDroite() == true && isVersDroite() == false){
			personnage.setX(getX()+30);
		}
		if(personnage.isVersDroite() == true && isVersDroite() == true){
			personnage.setX(getX()+50);
		}
    }
 }