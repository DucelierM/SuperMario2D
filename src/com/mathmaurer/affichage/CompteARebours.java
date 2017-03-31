package com.mathmaurer.affichage;

import com.mathmaurer.personnages.Mario;

public class CompteARebours implements Runnable{

	// VARIABLES
	private final int PAUSE = 1000;	// Est égale a une seconde 
	private final int STOP = 1000;
	private int compteurTemps;
	private String str;
	public Mario marioDead = new Mario(28, 30);
	
	
	// CONSTRUCTEUR
	public CompteARebours(){
		this.compteurTemps = 100; 
		this.str = "Temps restant : 100";		
		Thread compteARebours = new Thread(this);
		compteARebours.start();
	}

	
	// GETTERS	
	public int getCompteurTemps() {return compteurTemps;}
	
    public String getStr() {return str;}

	
    // SETTERS
    
    
	// METHODES	
	@Override
	public void run() {				
		while(true){	
			while(this.compteurTemps > 0){
			    try{Thread.sleep(PAUSE);}
				catch (InterruptedException e){}
				this.compteurTemps--;
				this.str = "Temps restant : " + this.compteurTemps;
			}
		}		
	}
	
	public void stopTime(){
		this.str = "Temps restant : " + this.compteurTemps;
	}
}