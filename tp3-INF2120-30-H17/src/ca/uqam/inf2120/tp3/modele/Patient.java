package ca.uqam.inf2120.tp3.modele;

import java.util.GregorianCalendar;

import ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure;

/**
 * 
 * @author serges- Michel Doumo
 *
 */

public class Patient implements OrdonnableParPrioriteEtDateHeure {

	// D�claration des attributs
	private String identifiant;
	private String espece;
	private String nom;
	private String age;
	private GregorianCalendar dateHeureCreation;
	private String raisonUrgence;
	private int priorite;
	private static int nbSequentiel = 0;
	private Proprietaire proprietaire;

	public Patient() {
		dateHeureCreation = new GregorianCalendar();
		nbSequentiel++;
	}

	/**
	 * @param identifiant
	 * @param espece
	 * @param nom
	 * @param age
	 * @param dateHeureCreation
	 * @param raisonUrgence
	 * @param priorite
	 */
	public Patient(String identifiant, String espece, String nom, String age, GregorianCalendar dateHeureCreation,
			String raisonUrgence, int priorite) {

		this.identifiant = identifiant;
		this.espece = espece;
		this.nom = nom;
		this.age = age;
		this.dateHeureCreation = dateHeureCreation;
		this.raisonUrgence = raisonUrgence;
		this.priorite = priorite;
		dateHeureCreation = new GregorianCalendar();
		nbSequentiel++;
	}

	/***************** GETTERS ************************/
	/**
	 * 
	 * @return identifiant
	 */
	public String getIdentifiant() {

		identifiant = ((nom.length() <= 3) ? nom : nom.substring(0, 4)).toUpperCase() + nbSequentiel + "";

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
	 * @return dateHeureCreation
	 */
	public GregorianCalendar getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * 
	 * @return dateHeureCreation
	 */
	public String getRaisonUrgence() {
		return raisonUrgence;
		
	}

	/**
	 * 
	 * @return priorite
	 */
	public int getPriorite() {
		return priorite;
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

	/************************* SETTERS ********************/
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
		return dateHeureCreation;
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

}
