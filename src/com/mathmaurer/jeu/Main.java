package com.mathmaurer.jeu;

import javax.swing.JFrame;


public class Main {
	
	//**** VARIABLES ****//
	public static Scene scene; // Toutes les classes ont acc�s � l'objet scene (static)

	public static void main(String[] args) {
		
		JFrame fenetre = new JFrame("Super Mario 2D");
		// Cr�ation de la fenetre de l'application
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		// Instanciation de l'objet scene
		scene = new Scene();
		fenetre.setContentPane(scene); // On associe la scene � la fen�tre de l'application
		fenetre.setVisible(true);
		
	}
}