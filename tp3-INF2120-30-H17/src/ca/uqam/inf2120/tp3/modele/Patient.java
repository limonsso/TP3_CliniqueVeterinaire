package ca.uqam.inf2120.tp3.modele;

import java.util.GregorianCalendar;

import ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3 
 * 
 * Classe Patient (FÈlin, Canin, ou autre): contient les informations 
 * d'un patient de la Clinique vÈtÈrinaire.
 *    
 * @author Ismael Doukoure
 * ComplÈtÈ par : Doumo Doumo  Serges=Michel - DOUS20078401
 * 
 * @version 5 avril 2017
 */

public class Patient implements OrdonnableParPrioriteEtDateHeure {

	// D�claration des attributs
	private String identifiant;
	private String espece;
	private String nom;
	private String age;
	private GregorianCalendar dateHeureArrivee;
	private String raisonUrgence;
	private int priorite;
	private Proprietaire proprietaire;
	private static int nbSequentiel = 0;
	
	
	
	
	/**
	 * 
	 * @param nom
	 * @param age
	 * @param espece
	 * @param raisonUrgence
	 * @param priorite
	 * @param proprietaire
	 */
	public Patient(String nom, String age, String espece, String raisonUrgence,
			       int priorite, Proprietaire proprietaire) {
		
		this.nom = nom;
		this.age = age;
		this.espece = espece;
		this.raisonUrgence = raisonUrgence;
		this.priorite = priorite;
		this.proprietaire = proprietaire;
		identifiant = construireIdentifiant();
		dateHeureArrivee = new GregorianCalendar();
		nbSequentiel++;
	
	}
	
	
	
	/**
	 * Construit l'identifiant en concatenant les trois (3) premiers caractËres 
	 * du nom du patient et un numÈro sÈquentiel . le numÈro sÈquentiel doit Ítre 
	 * un attribut statique de type int qui s'incrÈmente chaque fois qu'on construit
	 * un identifiant. Cet attribut doit Ítre dÈclarÈ dans la classe Patient.
	 * 
	 * Si le nombre de caractËres composant le nom du patient est moins que trois (3)
	 * caractËres, le caractËre 'X' est utilisÈ pour les caractËres manquants.
	 * 
	 * Exemple : 
	 *   - nom du 1er patient  = Isidor,   l'identifiant = "ISI1
	 *   - nom du 2e patient  =  Betty,    l'identifiant = "BET2
	 *   - nom du 3e patient  =  Ya,       l'identifiant = "YAX3
	 * 
	 */
	public String construireIdentifiant() {
		String identifiant = null;
		
		while(nom.length() > 0){
			
			if (nom.length() == 1) {
				
				identifiant = nom.trim().toUpperCase() + "XX" + nbSequentiel + " ";
				
			} else if (nom.length() ==2) {
				
				identifiant = nom.trim().toUpperCase() + "X" + nbSequentiel + " ";
				
			} 
			
				identifiant = nom.trim().toUpperCase() + nbSequentiel + " ";
			
		}
		
		
		return identifiant;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure#modifierPriorite
	 * (int)
	 */
	@Override
	public void modifierPriorite(int priorite) {
		this.priorite = priorite;

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure#obtenirPriorite(
	 * )
	 */
	@Override
	public int obtenirPriorite() {
		return priorite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure#
	 * obtenirDateHeureCreation()
	 */
	@Override
	public GregorianCalendar obtenirDateHeureCreation() {
		return dateHeureArrivee;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object unAutreObjet) {

		boolean estEgal = false;

		// Si les 2 objets sont identiques, on doit retourner
		// vrai comme r�sultat.
		if (this == unAutreObjet) {
			estEgal = true;

		} else if (unAutreObjet != null && this.getClass() == unAutreObjet.getClass()) {

			// Sachant que unAutreObjet n'est pas null et que unAutreObjet
			// et l'objet courant sont de m�me type, on peut se permettre
			// la conversion de UnAutreObjet en Membre
			Patient mbre = (Patient) unAutreObjet;

			// Tester si les deux (2) objets ont le m�me identifiant.
			estEgal = (identifiant.equals(mbre.identifiant));
		}

		return estEgal;
	}
	
	

	/**
	 * 
	 * @return identifiant
	 */
	public String getIdentifiant() {
		
		return identifiant;
	}

	/**
	 * 
	 * @return espece
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @return age
	 */
	public String getAge() {
		return age;
	}

	

	/**
	 * 
	 * @return raisonUrgence
	 */
	public String getRaisonUrgence() {
		return raisonUrgence;
		
	}


	/**
	 * 
	 * @return nbSequentiel
	 */
	public static int getNbSequentiel() {
		return nbSequentiel;
	}

	/**
	 * 
	 * @return proprietaire
	 */
	public Proprietaire getProprietaire() {
		
		return proprietaire;
	}

	
	/**
	 * 
	 * @param espece
	 */
	public void setEspece(String espece) {
		this.espece = espece;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 
	 * @param raisonUrgence
	 */
	public void setRaisonUrgence(String raisonUrgence) {
		this.raisonUrgence = raisonUrgence;
	}

	

	
	



}
