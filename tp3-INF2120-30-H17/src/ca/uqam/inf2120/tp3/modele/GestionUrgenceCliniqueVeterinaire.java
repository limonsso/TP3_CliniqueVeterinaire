package ca.uqam.inf2120.tp3.modele;


import java.util.ArrayList;
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
	/**
	 * Modifie le patient passé en paramètre
	 * @param unPatient
	 */
	public void modifierPatient(Patient unPatient){
		Patient patient = rechercherParIndetiant(unPatient.getIdentifiant());
		if(patient != null){
			listePatients.enlever(patient);
			patient.setAge(unPatient.getAge());
			patient.modifierPriorite(unPatient.getPriorite());
			patient.setRaisonUrgence(unPatient.getRaisonUrgence());
			listePatients.placer(patient);
		}
		
	}
	/**
	 * Recherche les patients en fonction du type de recherche.
	 * @param Priorite
	 * @param typeRecherche 
	 * @return 	- Si typeRecherche = 1 retourne la list des patient dont la priorité est superieur a celle passé en paramètre
	 * 			- Si typeRecherche = 0 retourne la list des patient dont la priorité est égale a celle passé en paramètre
	 * 			- Si typeRecherche = -1 retourne la list des patient dont la priorité est inferieur a celle passé en paramètre
	 * 			- null si aucun patient n'a été trouvé
	 */
	public List<Patient> rechercheParPriorite(int Priorite,int typeRecherche){
		List<Patient> lPatients= new ArrayList<Patient>();
		Iterator<Patient> itPatient =  listePatients.iterateur();				
		Patient patient = null;
		switch(typeRecherche)
		{
			case 1:
				while(itPatient.hasNext()){
					patient = itPatient.next();
					if(patient.getPriorite() > Priorite){
						lPatients.add(patient);
					}
				}
				break;
			case -1:
				while(itPatient.hasNext()){
					patient = itPatient.next();
					if(patient.getPriorite() < Priorite){
						lPatients.add(patient);
					}
				}
				break;
			case 0:
				while(itPatient.hasNext()){
					patient = itPatient.next();
					if(patient.getPriorite() == Priorite){
						lPatients.add(patient);
					}
				}
				break;
		}
		
		return lPatients.size()==0 ? null : lPatients;
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
	/**
	 * Recherche Tous les patients enregistrés
	 * @return retourne tous les patients ou null si aucun patient n'existe
	 */
	public List<Patient> rechercheTousLesPatients(){
		List<Patient> lPatients= new ArrayList<Patient>();
		Iterator<Patient> itPatient =  listePatients.iterateur();				
		Patient patient = null;
		while(itPatient.hasNext()){
			patient = itPatient.next();
			lPatients.add(patient);
		}
		return lPatients.size()==0 ? null : lPatients;
	}
	/**
	 * Enlève
	 * @param patient
	 * @return
	 */
	public boolean enleverPatient(Patient patient){
		return listePatients.enlever(patient);
	}
}
