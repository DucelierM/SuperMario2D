package com.mathmaurer.affichage;

public class CompteARebours implements Runnable{

	// VARIABLES
	private final int PAUSE = 1000;	// 1000MilliSecondes = 1Seconde, il nous permet de faire le décompte en secondes.
	private int compteurTemps;
	private String str;
	public boolean tempsPause;
		
	// CONSTRUCTEUR
	public CompteARebours(){
		this.compteurTemps = 120; 
		this.str = "Temps restant : 120";		
		Thread compteARebours = new Thread(this);
		compteARebours.start();
	}
	
	// GETTERS	
	
	public int getCompteurTemps() {return compteurTemps;}
	
    public String getStr() {return str;}

	public boolean isTempsPause() {return tempsPause;}
    
    // SETTERS
    
	public void setStr(String str) {this.str = str;}

	public void setCompteurTemps(int compteurTemps) {this.compteurTemps = compteurTemps;}
	
	public void setTempsPause(boolean essai) {this.tempsPause = essai;}

	// METHODES	
	
	@Override
	public void run() {				
		while(true){	
			while(this.compteurTemps > 0 && tempsPause == false){
			    try{Thread.sleep(PAUSE);}
				catch (InterruptedException e){}
				this.compteurTemps--;
				this.str = "Temps restant : " + this.compteurTemps;
			}
		}		
	}	
}