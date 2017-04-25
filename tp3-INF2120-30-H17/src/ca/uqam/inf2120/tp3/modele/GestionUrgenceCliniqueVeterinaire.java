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
 * des patients de la clinique vétérinaire.
 * 
 * @author Ismael Doukoure 
 * Complèté par : VOTRE NOM VOTRE PRâ€¦NOM - VOTRE CODE PERMANENT
 * 
 * @version 5 avril 2017
 */
public class GestionUrgenceCliniqueVeterinaire {

	// La liste des patients
		private FileAttenteTda<Patient> listePatients;

	/**
	 * Constructeur sans argument qui crÃˆe une liste de patients vide.
	 */
	public GestionUrgenceCliniqueVeterinaire() {
		listePatients = new FileAttenteImpl<Patient>();
		Proprietaire proprioTest = new Proprietaire("Zekinan","Limonsso","","");
		Patient patientTest = new Patient("Milou","2 ans","Félin","Grippe",2,proprioTest);
		placerPatient(patientTest);
	}

	
	/**
	 * Place un patient dans la file des patients selon sa prioritÃˆ.
	 * 
	 * @param unPatient Le patient â€¡ ajouter
	 */
	public void placerPatient(Patient unPatient) {
		listePatients.placer(unPatient);
	}
	
	

	/**
	 * Trouve le patient selon son identifiant et modifie ce dernier selon les
	 * informations du patient passÃˆ en paramÃ‹tre.
	 * 
	 * @param unPatient Le patient â€¡ modifier
	 */
	public void modifierPatient(Patient unPatient) {
	
		Patient patient = rechercherParIndentifiant(unPatient.getIdentifiant());
		if (patient != null) {
			listePatients.enlever(patient);
			patient.setAge(unPatient.getAge());
			patient.modifierPriorite(unPatient.obtenirPriorite());
			patient.setRaisonUrgence(unPatient.getRaisonUrgence());
			listePatients.placer(patient);
		}

	}

	/**
	 * Recherche les patients selon leur prioritÃˆ. La recherche se fait selon
	 * les critères suivants en fonction des paramÃ‹tres "priorite" et
	 * "typeRecherche".
	 * 
	 * - Si le typeRecherche = 1, la mÃˆthode retourne tous les patients dont la
	 *   priorité est plus grande que la prioritÃˆ passÃˆe en paramÃ‹tre.
	 * 
	 * - Si le typeRecherche = 0, la mÃˆthode retourne tous les patients dont la
	 *   prioritÃˆ est Ãˆgale â€¡ la prioritÃˆ passÃˆe en paramÃ‹tre.
	 * 
	 * - Si le typeRecherche = -1, la mÃˆthode retourne tous les patients dont la
	 *    prioritÃˆ est plus petite que la prioritÃˆ passÃˆe en paramÃ‹tre.
	 * 
	 * La mÃˆthode retourne null si aucun patient ne rÃˆpond aux critÃ‹res.
	 * 
	 * @param priorite La PrioritÃˆ selon laquelle la recherche est faite.
	 * @param typeRecherche Le type de recherche dont les valeurs possibles: 1, 0, -1.
	 * @return Le tableau Liste (ArrayList) des patients qui rÃˆpondent au
	 *         critÃ‹re de recherche.
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
	 * Recherche le patient selon son identifiant. La mÃˆthode retourne le
	 * patient dont l'identifiant qui est Ãˆgal â€¡ l'identifiant passÃˆ en paramÃ‹tre.
	 * La méthode retourne null si aucun candidat trouvé avec cet identifiant.
	 * 
	 * @param identifiant L'identifiant du patient recherchÃˆ.
	 * @return Le patient dont l'identifiant est Ãˆgal â€¡ l'identifiant passÃˆ en
	 *         paramÃ‹tre.
	 */
	public Patient rechercherParIndentifiant(String identifiant) {
		
		boolean bTrouve = false;
		
		Iterator<Patient> itPatient = listePatients.iterateur();
		
		Patient patient = null;
		
		while (itPatient.hasNext() && !bTrouve) {
			
			patient = itPatient.next();
			
			if (patient.getIdentifiant() == identifiant) {
				
				bTrouve = true;
			}
		}
		return bTrouve?patient:null;
	}

	/**
	 * Recherche tous les patients. La mÃˆthode retourne tous les patients.
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
	 * EnlÃ‹ve le patient passÃˆ en paramÃ‹tre de la file des patients. Le
	 * patient enlevÃˆ doit avoir le mÃ�me identifiant et la mÃ�me prioritÃˆ que
	 * celui passÃˆ en paramÃ‹tre.
	 * 
	 * @param unPatient Le patient â€¡ enlever.
	 * @return Vrai si la suppression a ÃˆtÃˆ faite, sinon faux.
	 */
	public boolean enleverPatient(Patient patient) {
		
		return listePatients.enlever(patient);
	}
}
