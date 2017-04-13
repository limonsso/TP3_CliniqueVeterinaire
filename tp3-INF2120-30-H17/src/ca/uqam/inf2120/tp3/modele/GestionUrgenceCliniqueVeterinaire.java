package ca.uqam.inf2120.tp3.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.uqam.inf2120.tp1.adt.FileAttenteTda;
import ca.uqam.inf2120.tp3.adt.impl.FileAttenteImpl;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3
 * 
 * Classe GestionUrgenceCliniqueVeterinaire : contient les services de gestion
 * des patients de la clinique vÈtÈrinaire.
 * 
 * @author Ismael Doukoure 
 * ComplÈtÈ par : VOTRE NOM VOTRE PR…NOM - VOTRE CODE PERMANENT
 * 
 * @version 5 avril 2017
 */
public class GestionUrgenceCliniqueVeterinaire {

	// La liste des patients
		private FileAttenteTda<Patient> listePatients;

	/**
	 * Constructeur sans argument qui crÈe une liste de patients vide.
	 */
	public GestionUrgenceCliniqueVeterinaire() {
		listePatients = new FileAttenteImpl<Patient>();
	}

	
	/**
	 * Place un patient dans la file des patients selon sa prioritÈ.
	 * 
	 * @param unPatient Le patient ‡ ajouter
	 */
	public void placerPatient(Patient unPatient) {
		listePatients.placer(unPatient);
	}
	
	

	/**
	 * Trouve le patient selon son identifiant et modifie ce dernier selon les
	 * informations du patient passÈ en paramËtre.
	 * 
	 * @param unPatient Le patient ‡ modifier
	 */
	public void modifierPatient(Patient unPatient) {
	
		Patient patient = rechercherParIndetiant(unPatient.getIdentifiant());
		if (patient != null) {
			listePatients.enlever(patient);
			patient.setAge(unPatient.getAge());
			patient.modifierPriorite(unPatient.obtenirPriorite());
			patient.setRaisonUrgence(unPatient.getRaisonUrgence());
			listePatients.placer(patient);
		}

	}

	/**
	 * Recherche les patients selon leur prioritÈ. La recherche se fait selon
	 * les critËres suivants en fonction des paramËtres "priorite" et
	 * "typeRecherche".
	 * 
	 * - Si le typeRecherche = 1, la mÈthode retourne tous les patients dont la
	 *   prioritÈ est plus grande que la prioritÈ passÈe en paramËtre.
	 * 
	 * - Si le typeRecherche = 0, la mÈthode retourne tous les patients dont la
	 *   prioritÈ est Ègale ‡ la prioritÈ passÈe en paramËtre.
	 * 
	 * - Si le typeRecherche = -1, la mÈthode retourne tous les patients dont la
	 *    prioritÈ est plus petite que la prioritÈ passÈe en paramËtre.
	 * 
	 * La mÈthode retourne null si aucun patient ne rÈpond aux critËres.
	 * 
	 * @param priorite La PrioritÈ selon laquelle la recherche est faite.
	 * @param typeRecherche Le type de recherche dont les valeurs possibles: 1, 0, -1.
	 * @return Le tableau Liste (ArrayList) des patients qui rÈpondent au
	 *         critËre de recherche.
	 */
	public List<Patient> rechercheParPriorite(int Priorite, int typeRecherche) {
		
		List<Patient> lPatients = new ArrayList<Patient>();
		Iterator<Patient> itPatient = listePatients.iterateur();
		Patient patient = null;
		
		switch (typeRecherche) {
		
		case 1:
			
			while (itPatient.hasNext()) {
				
				patient = itPatient.next();
				
				if (patient.obtenirPriorite() > Priorite) {
					
					lPatients.add(patient);
				}
			}
			break;
			
		case -1:
			
			while (itPatient.hasNext()) {
				
				patient = itPatient.next();
				
				if (patient.obtenirPriorite() < Priorite) {
					
					lPatients.add(patient);
				}
			}
			break;
			
		case 0:
			
			while (itPatient.hasNext()) {
				
				patient = itPatient.next();
				
				if (patient.obtenirPriorite() == Priorite) {
					
					lPatients.add(patient);
				}
			}
			break;
		}

		return lPatients.size() == 0 ? null : lPatients;
	}

	/**
	 * Recherche le patient selon son identifiant. La mÈthode retourne le
	 * patient dont l'identifiant qui est Ègal ‡ l'identifiant passÈ en paramËtre.
	 * La mÈthode retourne null si aucun candidat trouvÈ avec cet identifiant.
	 * 
	 * @param identifiant L'identifiant du patient recherchÈ.
	 * @return Le patient dont l'identifiant est Ègal ‡ l'identifiant passÈ en
	 *         paramËtre.
	 */
	public Patient rechercherParIndetiant(String identifiant) {
		
		boolean bTrouve = false;
		
		Iterator<Patient> itPatient = listePatients.iterateur();
		
		Patient patient = null;
		
		while (itPatient.hasNext() && !bTrouve) {
			
			patient = itPatient.next();
			
			if (patient.getIdentifiant() == identifiant) {
				
				bTrouve = true;
			}
		}
		return patient;
	}

	/**
	 * Recherche tous les patients. La mÈthode retourne tous les patients.
	 * 
	 * @return Le tableau Liste (ArrayList) des patients.
	 */
	public List<Patient> rechercheTousLesPatients() {
		
		List<Patient> lPatients = new ArrayList<Patient>();
		
		Iterator<Patient> itPatient = listePatients.iterateur();
		
		Patient patient = null;
		
		while (itPatient.hasNext()) {
			
			patient = itPatient.next();
			
			lPatients.add(patient);
			
		}
		
		return lPatients.size() == 0 ? null : lPatients;
	}

	/**
	 * EnlËve le patient passÈ en paramËtre de la file des patients. Le
	 * patient enlevÈ doit avoir le mÍme identifiant et la mÍme prioritÈ que
	 * celui passÈ en paramËtre.
	 * 
	 * @param unPatient Le patient ‡ enlever.
	 * @return Vrai si la suppression a ÈtÈ faite, sinon faux.
	 */
	public boolean enleverPatient(Patient patient) {
		
		return listePatients.enlever(patient);
	}
}
