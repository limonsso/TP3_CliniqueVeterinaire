package ca.uqam.inf2120.tp3.modele;


import java.util.Iterator;
import java.util.List;

import ca.uqam.inf2120.tp1.adt.FileAttenteTda;
import ca.uqam.inf2120.tp3.adt.impl.FileAttenteImpl;

/**
 * 
 * @author Ezechiel Gneap
 *
 */
public class GestionUrgenceCliniqueVeterinaire {
	
	//Declaration d'attributs
	private FileAttenteTda<Patient> listePatients = null;
	
	/*********get*******/
	public GestionUrgenceCliniqueVeterinaire() {
		listePatients = new FileAttenteImpl<Patient>();
	}
	/**
	 * 
	 * @param unPatient le patient a ajouté
	 */
	public void placerPatient(Patient unPatient){
		listePatients.placer(unPatient);
	}
	
	public void modifierPatient(Patient unPatient){
		
	}
	public List<Patient> rechercheParPriorite(int Priorite,int typeRecherche){
		
		return null;
	}
	/**
	 * 
	 * @param identifiant
	 * @return patient : le patient ayant l'indentifiant recherché ou null si aucun patient trouvé
	 */
	public Patient rechercherParIndetiant(String identifiant){
		boolean bTrouve = false;
		Iterator<Patient> itPatient =  listePatients.iterateur();
		Patient patient = null;
		while(itPatient.hasNext() && !bTrouve){
			patient = itPatient.next();
			if(patient.getIdentifiant()==identifiant){
				bTrouve = true;
			}
		}
		return patient;
	}
	public List<Patient> rechercheTousLesPatients(){
		
		return null;
	}
	public boolean enleverPatient(Patient patient){
		return listePatients.enlever(patient);
	}
}
