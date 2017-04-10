package ca.uqam.inf2120.tp3.modele;

public class Proprietaire {
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private Patient patient;

	/**
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * 
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 
	 * @return patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
