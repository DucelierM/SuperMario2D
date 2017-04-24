package com.mathmaurer.jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mathmaurer.affichage.CompteARebours;
import com.mathmaurer.affichage.Score;
import com.mathmaurer.audio.Audio;
import com.mathmaurer.objets.Bloc;
import com.mathmaurer.objets.Cadeau;
import com.mathmaurer.objets.ChampignonTime;
import com.mathmaurer.objets.ChampignonUp;
import com.mathmaurer.objets.Fleur;
import com.mathmaurer.objets.Moon;
import com.mathmaurer.objets.Objet;
import com.mathmaurer.objets.Piece;
import com.mathmaurer.objets.TuyauRouge;
import com.mathmaurer.objets.TuyauVert;
import com.mathmaurer.personnages.Champ;
import com.mathmaurer.personnages.Mario;
import com.mathmaurer.personnages.Tortue;


@SuppressWarnings("serial")
public class Scene extends JPanel {
	//**** VARIABLES ****//
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	
	private int xFond1;
	private int xFond2;
	
	private int dx; // déplacement horizontal du fond d'écran.
	private int xPos; // position de mario relative au jeu
	private int ySol; // altitude courante (utile seulement pour mario)
	private int hautPlafond; // hauteur maximale courante (utile seulement pour mario)
	private boolean gagner;
	
	public TuyauRouge tuyauRouge1, tuyauRouge2,tuyauRouge3,tuyauRouge4,tuyauRouge5,tuyauRouge6,tuyauRouge7,tuyauRouge8;
	
	public TuyauVert tuyauVert1;
	
	public Bloc bloc1, bloc2, bloc3 , bloc4 , bloc5 , bloc6 , bloc7 , bloc8 , bloc9 , bloc10 , bloc11 , bloc12;
	
	public Cadeau cadeau1, cadeau2, cadeau3,cadeau4,cadeau5, cadeau6, cadeau7;

	public ChampignonUp champUp1,champUp2,champUp3,champUp4 ;
	public Fleur fleur1;
	public Moon moon1;
	public ChampignonTime champTime1;
	
	public Champ champ1, champ2, champ3, champ4, champ5, champ6, champ7, champ8;
	
	public Tortue tortue1, tortue2, tortue3, tortue4, tortue5, tortue6, tortue7, tortue8, tortue9;
	
	public Piece piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9, piece10, piece11, piece12
	, piece13, piece14, piece15, piece16, piece17, piece18, piece19, piece20;

	public Mario mario;
	
	private ArrayList<Objet> tabObjets; // tableau qui enregistre tous les objets du jeu
	
	private ArrayList<Cadeau> tabCadeau, tabItems;  // tabItems Permet de placer un item en fonction du tabCadeau
	
	private ArrayList<Champ> tabChamps; // tableau qui enregistre tous les champignons du jeu 
	private ArrayList<Tortue> tabTortues; // tableau qui enregistre toutes les tortues du jeu
	private ArrayList<Piece> tabPieces; // tableau qui enregistre toutes les pièces du jeu
	
	private Font police;
	private CompteARebours compteARebours;
	private Score score;
	
	//**** CONSTRUCTEUR	****//
	public Scene(){		
		super();
		this.dx = 0;
		this.xPos = -1; // Début de la maps, a partir de la tout va se dessiner 
		this.ySol = 293; // sol initial
		this.hautPlafond = 0; //plafond initial
		this.xFond1 = -50; // L'image de fond dépasse des 2 côtés de la fenêtre.
		this.xFond2 = 750;
		this.gagner = true;
		
		icoFond = new ImageIcon("images/fondEcran.png");
        imgFond1 = icoFond.getImage();
        imgFond2 = icoFond.getImage();
        icoChateau1 = new ImageIcon("images/chateau1.png");
        imgChateau1 = icoChateau1.getImage();
        icoDepart = new ImageIcon("images/depart.png");
        imgDepart = icoDepart.getImage();
        icoDrapeau = new ImageIcon("images/drapeau.png");
        imgDrapeau = icoDrapeau.getImage();
        icoChateauFin = new ImageIcon("images/chateauFin.png");
        imgChateauFin = icoChateauFin.getImage();
		
		tuyauRouge1 = new TuyauRouge(600, 230);
		tuyauRouge2 = new TuyauRouge(1000, 230);
		tuyauRouge3 = new TuyauRouge(1600, 230);
		
		tuyauVert1 = new TuyauVert(1900, 230);

		tuyauRouge5 = new TuyauRouge(2500, 230);
		tuyauRouge6 = new TuyauRouge(3000, 230);
		tuyauRouge7 = new TuyauRouge(3800, 230);
		tuyauRouge8 = new TuyauRouge(4500, 230);
		
		bloc1 = new Bloc(800, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2800, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3500, 160);
		bloc9 = new Bloc(3650, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
		cadeau1 = new Cadeau(400,180);
		cadeau2 = new Cadeau(1500,180);
		cadeau3 = new Cadeau(2130,180);
		cadeau4 = new Cadeau(2430,180);
		cadeau5 = new Cadeau(3430,180);
		cadeau6 = new Cadeau(4050,180);
		cadeau7 = new Cadeau(4700,180);
		
		
		//Initialisation des pouvoirs, Modification de leurs emplacements lors qu'il en as plusieurs
		champUp1 = new ChampignonUp(401,180);
		champUp1.setEmplacement(1);
		fleur1 = new Fleur(1501,180);
		champUp2 = new ChampignonUp(2130,180);
		champUp2.setEmplacement(3);
		moon1 = new Moon(2432,180);
		champUp3 = new ChampignonUp(3432,180);
		champUp3.setEmplacement(5);
		champUp4 = new ChampignonUp(4052,180);
		champUp4.setEmplacement(6);
		champTime1 = new ChampignonTime(4702,180);
		
		champ1 = new Champ(650, 263);
		champ2 = new Champ(1100, 263);
		champ3 = new Champ(2100, 263);
		champ4 = new Champ(2400, 263);
		champ5 = new Champ(3200, 263);
		champ6 = new Champ(3500, 263);
		champ7 = new Champ(3700, 263);
		champ8 = new Champ(4500, 263);
		
		tortue1 = new Tortue(950, 243);
		tortue2 = new Tortue(1500, 243);
		tortue3 = new Tortue(1800, 243);
		tortue4 = new Tortue(2400, 243);
		tortue5 = new Tortue(3100, 243);
		tortue6 = new Tortue(3600, 243);
		tortue7 = new Tortue(3900, 243);
		tortue8 = new Tortue(4200, 243);
		tortue9 = new Tortue(4400, 243);
		
		
		piece1 = new Piece(802, 145);
		piece2 = new Piece(1202, 140);
		piece3 = new Piece(1272, 95);
		piece4 = new Piece(1342, 40);
		piece5 = new Piece(1550, 145);
		piece6 = new Piece(2650, 145);
		piece7 = new Piece(3000, 135);
		piece8 = new Piece(3400, 125);
		piece9 = new Piece(4200, 145);
		piece10 = new Piece(4600, 40);
		piece11 = new Piece(1640,265); // 1640 / 130
		piece12 = new Piece(1670,265);
		piece13 = new Piece(1700,265);
		piece14 = new Piece(1730,265);
		piece15 = new Piece(1760,265);
		piece16 = new Piece(1790,265);
		piece17 = new Piece(1820,265);
		piece18 = new Piece(1850,265);
		piece19 = new Piece(1880,265);
		piece20 = new Piece(4390,265);

		
		mario = new Mario(300, 243); // X Horizontal // Y Vertical // Valeur de mario Grand
		
        tabObjets = new ArrayList<Objet>();	
		this.tabObjets.add(this.tuyauRouge1);
		this.tabObjets.add(this.tuyauRouge2);
		this.tabObjets.add(this.tuyauRouge3);
		this.tabObjets.add(this.tuyauVert1);
		this.tabObjets.add(this.tuyauRouge5);
		this.tabObjets.add(this.tuyauRouge6);
		this.tabObjets.add(this.tuyauRouge7);
		this.tabObjets.add(this.tuyauRouge8);
		
		this.tabObjets.add(this.bloc1);
		this.tabObjets.add(this.bloc2);
		this.tabObjets.add(this.bloc3);
		this.tabObjets.add(this.bloc4);
		this.tabObjets.add(this.bloc5);
		this.tabObjets.add(this.bloc6);
		this.tabObjets.add(this.bloc7);
		this.tabObjets.add(this.bloc8);
		this.tabObjets.add(this.bloc9);
		this.tabObjets.add(this.bloc10);
		this.tabObjets.add(this.bloc11);
		this.tabObjets.add(this.bloc12);
		
		tabCadeau = new ArrayList<Cadeau>();	
		
		this.tabCadeau.add(this.cadeau1);
		this.tabCadeau.add(this.cadeau2);
		this.tabCadeau.add(this.cadeau3);
		this.tabCadeau.add(this.cadeau4);
		this.tabCadeau.add(this.cadeau5);
		this.tabCadeau.add(this.cadeau6);
		this.tabCadeau.add(this.cadeau7);
		
		tabItems = new ArrayList<Cadeau>();
		
		this.tabItems.add(this.champUp1);
		this.tabItems.add(this.fleur1);
		this.tabItems.add(this.champUp2);
		this.tabItems.add(this.moon1);
		this.tabItems.add(this.champUp3);
		this.tabItems.add(this.champUp4);
		this.tabItems.add(this.champTime1);

		
		tabChamps = new ArrayList<Champ>();	
		this.tabChamps.add(this.champ1);
		this.tabChamps.add(this.champ2);
		this.tabChamps.add(this.champ3);
		this.tabChamps.add(this.champ4);
		this.tabChamps.add(this.champ5);
		this.tabChamps.add(this.champ6);
		this.tabChamps.add(this.champ7);
		this.tabChamps.add(this.champ8);
		
		tabTortues = new ArrayList<Tortue>();
		this.tabTortues.add(this.tortue1);
		this.tabTortues.add(this.tortue2);
		this.tabTortues.add(this.tortue3);
		this.tabTortues.add(this.tortue4);
		this.tabTortues.add(this.tortue5);
		this.tabTortues.add(this.tortue6);
		this.tabTortues.add(this.tortue7);
		this.tabTortues.add(this.tortue8);
		this.tabTortues.add(this.tortue9);
		
		tabPieces = new ArrayList<Piece>();			
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);
		this.tabPieces.add(this.piece9);
		this.tabPieces.add(this.piece10);
		this.tabPieces.add(this.piece11);
		this.tabPieces.add(this.piece12);
		this.tabPieces.add(this.piece13);
		this.tabPieces.add(this.piece14);
		this.tabPieces.add(this.piece15);
		this.tabPieces.add(this.piece16);
		this.tabPieces.add(this.piece17);
		this.tabPieces.add(this.piece18);
		this.tabPieces.add(this.piece19);
		this.tabPieces.add(this.piece20);


		this.setFocusable(true);  
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier()); // Ecouteur Clavier
		
		police = new Font("Arial", Font.PLAIN, 18);
		compteARebours = new CompteARebours();
		score = new Score();
		
		// chronoEcran nous permet de régler la vitesse du visuel
		Thread chronoEcran = new Thread(new Chrono()); // Ajout d'un chronomètre à PanJeu
		chronoEcran.start(); // Démarrage du chronomètre (appel de la méthode run() de la classe Chrono)
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}
	
	public int getxFond1() {return xFond1;}
	
	public int getxFond2() {return xFond2;}
		
	public int getHautPlafond() {return hautPlafond;}

	public int getySol() {return ySol;}


	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}	
	
	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hautPlafond) {this.hautPlafond = hautPlafond;}


	//**** METHODES ****//
	public void deplacementFond() { // Déplacement du fond lorsque mario se déplace
		if (this.xPos >= 0 && this.xPos <= 4430) {
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;			
		// Remise à zéro des abscisses pour rotation des images de fond
		if (this.xFond1 == -800) {this.xFond1 = 800;}
		else if (this.xFond2 == -800) {this.xFond2 = 800;}
		else if (this.xFond1 == 800) {this.xFond1 = -800;}
		else if (this.xFond2 == 800) {this.xFond2 = -800;}	
		}		
 		for(int i = 0; i < this.tabObjets.size(); i++){this.tabObjets.get(i).deplacement();}
 		for(int i = 0; i < this.tabChamps.size(); i++){this.tabChamps.get(i).deplacement();}
 		for(int i = 0; i < this.tabTortues.size(); i++){this.tabTortues.get(i).deplacement();}
 		for(int i = 0; i < this.tabPieces.size(); i++){this.tabPieces.get(i).deplacement();}
 		for(int i = 0; i < this.tabCadeau.size(); i++) {this.tabCadeau.get(i).deplacement();}
 		for(int i = 0; i < this.tabItems.size(); i++){this.tabItems.get(i).deplacement();}
	}
	
	private boolean partieGagnee(){		
		if(this.compteARebours.getCompteurTemps() > 0){
			if(this.mario.isVivant() == true){
				if(this.score.getNbrePieces() == 20){ 
					if(this.xPos > 4400){
						if(this.gagner == true){
							Audio.playSound("/audio/partieGagnee.wav");
							this.gagner = false;
						}
						return true;
					}else{return false;}
				}else{return false;}
			}else{return false;}				
		}else{return false;}
	}
	
	private boolean partiePerdue(){
		if(this.mario.isVivant() == false || this.compteARebours.getCompteurTemps() <= 0){
			
			return true;
			}
		else{return false;}
	}
		
	public boolean finDePartie(){
		if(this.partieGagnee() == true || this.partiePerdue() == true){ return true;}
		else{return false;}
	}
	
	
	public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		Graphics g2 = (Graphics2D) g; // Graphics2D donne un meilleur rendu graphique
 		
 
 		// Détections des contacts avec des objets
 		for(int i = 0; i < this.tabObjets.size(); i++){
 		    // mario
 		    if(this.mario.proche(this.tabObjets.get(i))){this.mario.contact(this.tabObjets.get(i));}
 		    // champignons
 		    for(int j = 0; j < this.tabChamps.size(); j++){
 			  if(this.tabChamps.get(j).proche(this.tabObjets.get(i))){this.tabChamps.get(j).contact(this.tabObjets.get(i));} 
 		    }
 		    // tortues
 		    for(int j = 0; j < this.tabTortues.size(); j++){
 			  if(this.tabTortues.get(j).proche(this.tabObjets.get(i))){this.tabTortues.get(j).contact(this.tabObjets.get(i));} 
 		    }
 		    
 		    // Items 
 		   for(int j = 0; j < this.tabItems.size(); j++){
 			   //Déplacement et contact de seulement les champignons
 			   if(this.tabItems.get(j).getImgObjet() == this.champUp1.getImgObjet()){
 				  if(this.tabItems.get(j).proche(this.tabObjets.get(i))){
 					 this.champUp1.contact(this.tabObjets.get(i));
 				  }
 			   }
 			  if(this.tabItems.get(j).getImgObjet() == this.champUp2.getImgObjet()){
				  if(this.tabItems.get(j).proche(this.tabObjets.get(i))){
					 this.champUp2.contact(this.tabObjets.get(i));
				  }
			   }
 			 if(this.tabItems.get(j).getImgObjet() == this.champUp3.getImgObjet()){
				  if(this.tabItems.get(j).proche(this.tabObjets.get(i))){
					 this.champUp3.contact(this.tabObjets.get(i));
				  }
			   }
 			if(this.tabItems.get(j).getImgObjet() == this.champUp4.getImgObjet()){
				  if(this.tabItems.get(j).proche(this.tabObjets.get(i))){
					 this.champUp4.contact(this.tabObjets.get(i));
				  }
			   }
 			if(this.tabItems.get(j).getImgObjet() == this.champTime1.getImgObjet()){
				  if(this.tabItems.get(j).proche(this.tabObjets.get(i))){
					 this.champTime1.contact(this.tabObjets.get(i));
				  }
			   }
 			
 		   }
 		    
 		}

 		
 	// Détections des contacts avec les cadeaux 
 	 		for(int lecadeau = 0; lecadeau < this.tabCadeau.size(); lecadeau++){
	 	 		    // mario
	 	 		    if(this.mario.procheCadeau(this.tabCadeau.get(lecadeau))){this.mario.contactCadeau(this.tabCadeau.get(lecadeau));}
	 	 		    if(this.mario.isSaut() == true && this.mario.contactCadeauDessous(this.tabCadeau.get(lecadeau)) && this.tabCadeau.get(lecadeau).isEtatCadeau()== true){
	 	 		    	this.mario.contactCadeau(this.tabCadeau.get(lecadeau));
	 	 		    		if(this.tabItems.get(lecadeau).isEtatCadeau() == true){
	 	 		    			Cadeau leObjet = this.tabItems.get(lecadeau);
		 	 		    		this.tabItems.get(lecadeau).apparitionCadeau(leObjet);	
		 	 		    		this.tabItems.get(lecadeau).setEtatCadeau(false);
		 	 		    		this.tabItems.get(lecadeau).isPouvoir();
		 	 		    		
	 	 		    		}
	 	 		    }
	 	 		    
	 	 		    // champignons
	 	 		    for(int j = 0; j < this.tabChamps.size(); j++){
	 	 			  if(this.tabChamps.get(j).procheCadeau(this.tabCadeau.get(lecadeau))){this.tabChamps.get(j).contact(this.tabCadeau.get(lecadeau));} 
	 	 		    }
	 	 		    // tortues
	 	 		    for(int j = 0; j < this.tabTortues.size(); j++){
	 	 			  if(this.tabTortues.get(j).procheCadeau(this.tabCadeau.get(lecadeau))){this.tabTortues.get(j).contact(this.tabCadeau.get(lecadeau));} 
	 	 		    }
 	 		}
 		 		
 	 	    // Détections des contacts des champignons avec les personnages (hors mario)
 	 		for(int i = 0; i < this.tabChamps.size(); i++){ 
 	 			// champignons
 	 			for(int j = 0; j < this.tabChamps.size(); j++){
 	 				if(j != i){ 					 				
 	 	 			  if(this.tabChamps.get(j).proche(this.tabChamps.get(i))){this.tabChamps.get(j).contact(this.tabChamps.get(i));}
 	 				}
 	 	 		}
 	 			// tortues
 	 			for(int j = 0; j < this.tabTortues.size(); j++){
 		 		    if(this.tabTortues.get(j).proche(this.tabChamps.get(i))){this.tabTortues.get(j).contact(this.tabChamps.get(i));}
 		 		}
 	 		}

 	 	    // Détections des contacts des tortues avec les personnages (hors mario)
 	 	 	for(int i = 0; i < this.tabTortues.size(); i++){  
 	 	 	    // champignons
 	 	 		for(int j = 0; j < this.tabChamps.size(); j++){
 	 	 	 	    if(this.tabChamps.get(j).proche(this.tabTortues.get(i))){this.tabChamps.get(j).contact(this.tabTortues.get(i));} 
 	 	 	 	}
 	 	 	    // tortues
 	 	 		for(int j = 1; j < this.tabTortues.size(); j++){
 	 				if(j != i){
 	 		 		    if(this.tabTortues.get(j).proche(this.tabTortues.get(i))){this.tabTortues.get(j).contact(this.tabTortues.get(i));} 
 	 				}
 	 			}
 	 	 	}   
 	 	
 	 	// Détection des contacts de mario avec des personnages
 	 	for(int i = 0; i < this.tabChamps.size(); i++){ 
 	 		// Si mario est en feu, il se levelDown
 	 			if(this.mario.proche(this.tabChamps.get(i)) && this.tabChamps.get(i).isVivant() == true){
 	 				this.mario.contact(this.tabChamps.get(i));
 	 	 			if(this.tabChamps.get(i).isVivant() == false){Audio.playSound("/audio/ecrasePersonnage.wav");}	
 	 			}

 	 	}
 	 	
 	 	// Mario Fantome : this.mario.setCompteurVie(1-this.mario.getCompteurVie()); 
 	 	
 	 	/**
 	 	 *  	 				
 	 	 * 
 	 	 */
 	 	
 	 	// J'ai enlever le fait qu'ils soient proches 
 	 	for(int i = 0; i < this.tabTortues.size(); i++){
 	 		if(this.mario.proche(this.tabTortues.get(i))&&this.tabTortues.get(i).isVivant() == true){
	 			this.mario.contact(this.tabTortues.get(i));
	 			if(this.tabTortues.get(i).isVivant() == false){Audio.playSound("/audio/ecrasePersonnage.wav");}	 
 	 		}
	 						 	 			 	 		

 	 	}
 	 	
    	// Détection des contacts de mario avec des pièces
 	 	for(int i = 0; i < this.tabPieces.size(); i++){
 	 		if(this.mario.proche(this.tabPieces.get(i))){
 	 			if(this.mario.contactPiece(this.tabPieces.get(i))){
 	 				Audio.playSound("/audio/piece.wav");
 	 				this.tabPieces.remove(i);
 	 				this.score.setNbrePieces(this.score.getNbrePieces() + 1);
 	 			}
 	 	    }
 	 	}
 	 	
 	 	
 		// Déplacement de tous les objets "fixes" du jeu et des personnages (hors mario)
 		this.deplacementFond();
 		
 	    // Image de fond
 		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
 		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
 		// Image du château du départ
 		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
 		// Image du panneau de départ
 		g2.drawImage(imgDepart, 220 - this.xPos, 234, null); 
 		// Image du drapeau d'arrivée
 		g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
 		// Image du château d'arrivée
	  	g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);
 		
 		// Images des objets
 		for(int i = 0; i < this.tabObjets.size(); i++){
 			g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
 		}
 		
 		
 		for(int i = 0; i < this.tabCadeau.size(); i++){
 			//System.out.println(this.tabCadeau.get(i).isEtatCadeau());
 			g2.drawImage(this.tabCadeau.get(i).getImgObjet(), this.tabCadeau.get(i).getX(), this.tabCadeau.get(i).getY(), null);
 			
 			if(this.tabItems.get(i).isEtatCadeau()==false){ // Si il ne contient plus d'objet, le cadeau devient vide
 				g2.drawImage(this.bloc1.getImgObjet(), this.tabCadeau.get(i).getX(), this.tabCadeau.get(i).getY(), null);
 			}
 		}
 		
 		
 		for(int i = 0; i < this.tabItems.size(); i++){
 			// Technique de debug pour afficher l'objet qui se trouve dans chaque Cadeau
 			//g2.drawImage(this.tabItems.get(i).getImgObjet(), this.tabItems.get(i).getX(), this.tabItems.get(i).getY(), null);
 			if(this.tabItems.get(i).isEtatCadeau()==false){ // Si il ne contient plus d'objet, le cadeau devient vide
 				g2.drawImage(this.tabItems.get(i).getImgObjet(), this.tabItems.get(i).getX(), this.tabItems.get(i).getY(), null);
 				
 				if(this.tabItems.get(i).getImgObjet() == this.champUp1.getImgObjet() && this.tabItems.get(i).getEmplacement() == 1){
 					this.champUp1.bouge();
 					this.champUp1.contact(this.tabCadeau.get(i));
 					if(this.tabItems.get(i).isEtatCadeau()==false){
 						if(this.champUp1.contactMario(this.mario)){
 							if(this.mario.getCompteurVie() == 3){
 								this.champUp1.setPouvoir(false);
 							}else{
 	 							this.champUp1.setPouvoir(true);
 	 							this.mario.setCompteurVie(2);
 	 							this.mario.setTransformation("mario");
 							}
 							Audio.playSound("/audio/mario-power.wav");
 							// Quand mario se fait toucher par un ennemies Audio.playSound("/audio/mario-retrecit.wav");
 							this.champUp1.setY(this.champUp1.getY()+200);
 							
 						}
 					}
 				}
 				
 				if(this.tabItems.get(i).getImgObjet() == this.fleur1.getImgObjet()){
 					if(this.tabItems.get(i).isEtatCadeau()==false){
 						if(this.fleur1.contactMario(this.mario)){
 							this.fleur1.setPouvoir(true);
 							this.mario.setTransformation("marioFeu");
 							//this.tabItems.remove(i);
 							this.mario.setCompteurVie(3);
 							this.fleur1.setY(this.fleur1.getY()+200);
 							Audio.playSound("/audio/mario-power.wav");
 						}
 					}
 				}
 				if(this.tabItems.get(i).getImgObjet() == this.champUp2.getImgObjet()&& this.tabItems.get(i).getEmplacement() == 3){
 					this.champUp2.bouge();
 					this.champUp2.contact(this.tabCadeau.get(i));
 					if(this.tabItems.get(i).isEtatCadeau()==false){
 						if(this.champUp2.contactMario(this.mario)){
 							if(this.mario.getCompteurVie() == 3){
 								this.champUp2.setPouvoir(false);
 							}else{
 	 							this.champUp2.setPouvoir(true);
 	 							this.mario.setCompteurVie(2);
 	 							this.mario.setTransformation("mario");
 							}
 							this.champUp2.setY(this.champUp2.getY()+200);
 							Audio.playSound("/audio/mario-power.wav");

 						}
 					}
 				}
 				if(this.tabItems.get(i).getImgObjet() == this.moon1.getImgObjet()){
 					if(this.tabItems.get(i).isEtatCadeau()==false){
 						if(this.moon1.contactMario(this.mario)){
 							this.moon1.setPouvoir(true);
 							//this.tabItems.remove(i);
 							this.moon1.setY(this.moon1.getY()+200);

 						}
 					}
 				}
 				if(this.tabItems.get(i).getImgObjet() == this.champUp3.getImgObjet()&& this.tabItems.get(i).getEmplacement() == 5){
 					this.champUp3.bouge();
 					this.champUp3.contact(this.tabCadeau.get(i));
 					if(this.tabItems.get(i).isEtatCadeau()==false){
 						if(this.champUp3.contactMario(this.mario)){
 							if(this.mario.getCompteurVie() == 3){
 								this.champUp3.setPouvoir(false);
 							}else{
 	 							this.champUp3.setPouvoir(true);
 	 							this.mario.setCompteurVie(2);
 	 							this.mario.setTransformation("mario");
 							}
 							//this.tabItems.remove(i);
 							
 							this.champUp3.setY(this.champUp3.getY()+200);
 							Audio.playSound("/audio/mario-power.wav");

 						}
 					}
 				}
 				if(this.tabItems.get(i).getImgObjet() == this.champUp4.getImgObjet()&& this.tabItems.get(i).getEmplacement() == 6){
 					this.champUp4.bouge();
 					this.champUp4.contact(this.tabCadeau.get(i));
 					if(this.tabItems.get(i).isEtatCadeau()==false){
 						if(this.champUp4.contactMario(this.mario)){
 							if(this.mario.getCompteurVie() == 3){
 								this.champUp4.setPouvoir(false);
 							}else{
 	 							this.champUp4.setPouvoir(true);
 	 							this.mario.setCompteurVie(2);
 	 							this.mario.setTransformation("mario");
 							}
 							this.champUp4.setY(this.champUp4.getY()+200);
 							Audio.playSound("/audio/mario-power.wav");
 						}
 					}
 				}
 				if(this.tabItems.get(i).getImgObjet() == this.champTime1.getImgObjet()){
 					this.champTime1.bouge();
 					this.champTime1.contact(this.tabCadeau.get(i));
 					if(this.tabItems.get(i).isEtatCadeau()==false){
 						if(this.champTime1.contactMario(this.mario)){
 							this.champTime1.setPouvoir(true);
 							//this.tabItems.remove(i);
 							this.champTime1.setY(this.champTime1.getY()+200);
 							this.compteARebours.setCompteurTemps(this.compteARebours.getCompteurTemps()+100);
 						}
 					}
 				}
 				
 				//this.tabItems.get(i).apparitionCadeau(this.tabItems.get(i));
 			}//else{
 				//g2.drawImage(this.tabItems.get(i).getImgObjet(), this.tabItems.get(i).getX(), this.tabItems.get(i).getY(), null);
 			//}
 			
 		}
 		// Images des champignons
 		for(int i = 0; i < this.tabChamps.size(); i++){
 			if(this.tabChamps.get(i).isVivant() == true){
 		        g2.drawImage(this.tabChamps.get(i).marche("champ", 45), this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY(), null);
 			}else{
 				g2.drawImage(this.tabChamps.get(i).meurt(), this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY() + 20, null); 				
 				if(this.tabChamps.get(i).getCompteur() > 100){this.tabChamps.remove(i);}				
 			}
 		}
 		
 	    // Images des tortues
 		for(int i = 0; i < this.tabTortues.size(); i++){
 			if(this.tabTortues.get(i).isVivant() == true && this.mario.procheTortue(this.tabTortues.get(i))){
 				this.tabTortues.get(i).setPAUSE(5);
 		        g2.drawImage(this.tabTortues.get(i).marche("tortueRouge", 45), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY(), null);
 			}else if(this.tabTortues.get(i).isVivant() == true){
 				this.tabTortues.get(i).setPAUSE(15);
 	 		    g2.drawImage(this.tabTortues.get(i).marche("tortue", 50), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY(), null);
 		        }
 			else{
 				g2.drawImage(this.tabTortues.get(i).meurt(), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY() + 30, null);
 				if(this.tabTortues.get(i).getCompteur() > 100000000){this.tabTortues.remove(i);}				
 	 			}
 		}  
 		
 		// Images des pièces
 		for(int i = 0; i < this.tabPieces.size(); i++){
 			g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
 		}
 		
 		if(Main.scene.mario.isVivant() == true){
 			
 			if(this.mario.getCompteurVie() == 3){
 				g2.drawImage(this.mario.marche("marioFeu", 25), this.mario.getX(), this.mario.getY(), null);
 				if(this.mario.isSaut()){
 					g2.drawImage(this.mario.saute("marioFeu"), this.mario.getX(), this.mario.getY(), null);
 				}
 				if(this.mario.isSaut()== false){
 					g2.drawImage(this.mario.retombeSaut("marioFeu"), this.mario.getX(), this.mario.getY(), null);
  	 		   }else{
  			      g2.drawImage(this.mario.marche("marioFeu", 25), this.mario.getX(), this.mario.getY(), null);
  			    }
 			}
 			else if(this.mario.getCompteurVie() == 2 || this.mario.getTransformation()=="mario"){
 				g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null); 
 				if(this.mario.isSaut()){
 					g2.drawImage(this.mario.saute("mario"), this.mario.getX(), this.mario.getY(), null);
 				}
 				if(this.mario.isSaut()== false){
 					g2.drawImage(this.mario.retombeSaut("mario"), this.mario.getX(), this.mario.getY(), null);
  	 		   }else{
  			      g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
  			    }
 			}
 			else if(this.mario.getCompteurVie() == 1){
 				if(this.mario.isSaut()){
 	 			   g2.drawImage(this.mario.saute("marioPetit"), this.mario.getX(), this.mario.getY(), null);
 	 			}
 	 		   else{
 	 				  g2.drawImage(this.mario.marche("marioPetit", 25), this.mario.getX(), this.mario.getY(), null); 
 	 		    	
 	 		    }
 	 		   if (this.mario.isSaut() == false ){ // retomber du saut 
 	 			  g2.drawImage(this.mario.retombeSaut("marioPetit"), this.mario.getX(), this.mario.getY(), null);
 	 		   }else{
 			      g2.drawImage(this.mario.marche("marioPetit", 25), this.mario.getX(), this.mario.getY(), null);
 			    }
 			}
 	 	 	 			
 		   
 		}else{
 				g2.drawImage(this.mario.meurt(), this.mario.getX(), this.mario.getY(), null);}
		
 	    // Mise à jour du temps de jeu restant
	    g2.setFont(police);
	    if(this.mario.isDead()){
	    	this.compteARebours.setTempsPause(true);
	    	g2.drawString(this.compteARebours.getStr(), 5, 25);
	    }else{
	    	if(this.compteARebours.getCompteurTemps() <=10){
	    		//Audio.playSound("/audio/");
	    	}
	    	g2.drawString(this.compteARebours.getStr(), 5, 25);
	    }
	    if(this.moon1.isPouvoir() == true){
	    	this.compteARebours.setTempsPause(true);
	    	g2.drawString(this.compteARebours.getStr(), 5, 25);
	    }
	    
	    
	    // Mise à jour du score
	    g2.drawString(this.score.getNbrePieces() + " pièce(s) trouvée(s) sur " + this.score.getNBRE_TOTAL_PIECES(), 460, 25);
	    
	    // Fin de partie
	    if(this.finDePartie() == true){
	    	Font policeFin = new Font("Arial", Font.BOLD, 50);
            g2.setFont(policeFin);
            
	        if(this.partieGagnee() == true){g2.drawString("Vous avez gagné !!", 120, 180);
	        }
	        else{g2.drawString("Vous avez perdu...", 120, 180);}
 	    }
 	}
}