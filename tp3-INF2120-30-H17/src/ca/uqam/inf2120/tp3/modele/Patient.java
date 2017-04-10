package ca.uqam.inf2120.tp3.modele;

import java.util.GregorianCalendar;

import ca.uqam.inf2120.tp1.adt.OrdonnableParPrioriteEtDateHeure;


public class Patient implements OrdonnableParPrioriteEtDateHeure {
	
	private String identifiant;
	private String espece;
	private String nom;
	private String age;
	private GregorianCalendar dateHeureCreation;
	private String raisonUrgence;
	private int priorite;
	private static int nbSequentiel = 0;
	
	
	
	@Override
	public void modifierPriorite(int priorite) {
		this.priorite = priorite;

	}

	@Override
	public int obtenirPriorite() {
		return priorite;
	}

	@Override
	public GregorianCalendar obtenirDateHeureCreation() {
		return dateHeureCreation;
	}
	
	@Override
	public boolean equals(Object unAutreObjet) {

		boolean estEgal = false;

		// Si les 2 objets sont identiques, on doit retourner
		// vrai comme r�sultat.
		if (this == unAutreObjet) {
			estEgal = true;

		} else if (unAutreObjet != null && 
				this.getClass() == unAutreObjet.getClass()) {

			// Sachant que unAutreObjet n'est pas null et que unAutreObjet
			// et l'objet courant sont de m�me type, on peut se permettre
			// la conversion de UnAutreObjet en Membre
			Patient mbre = (Patient) unAutreObjet;

			// Tester si les deux (2) objets ont le m�me identifiant.
			estEgal = (identifiant.equals(mbre.identifiant));
		}

		return estEgal;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getEspece() {
		return espece;
	}

	public String getNom() {
		return nom;
	}

	public String getAge() {
		return age;
	}

	public GregorianCalendar getDateHeureCreation() {
		return dateHeureCreation;
	}

	public String getRaisonUrgence() {
		return raisonUrgence;
	}

	public int getPriorite() {
		return priorite;
	}

	public static int getNbSequentiel() {
		return nbSequentiel;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setDateHeureCreation(GregorianCalendar dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public void setRaisonUrgence(String raisonUrgence) {
		this.raisonUrgence = raisonUrgence;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public static void setNbSequentiel(int nbSequentiel) {
		Patient.nbSequentiel = nbSequentiel;
	}
}

