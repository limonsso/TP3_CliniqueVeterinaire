package ca.uqam.inf2120.tp3.modele;


import java.util.List;

import ca.uqam.inf2120.tp1.adt.FileAttenteTda;
import ca.uqam.inf2120.tp3.adt.impl.FileAttenteImpl;

public class GestionUrgenceCliniqueVeterinaire {
	
	//Declaration d'attributs
	private FileAttenteTda listePatients;
	
	
	public GestionUrgenceCliniqueVeterinaire() {
		listePatients = new FileAttenteImpl();
	}
	public void placerPatient(Patient unPatient){
		
	}
	
	public void modifierPatient(Patient unPatient){
		
	}
	public List<Patient> rechercheParPriorite(int Priorite,int typeRecherche){
		
		return null;
	}
	public Patient rechercherParIndetiant(String identifiant){
		return null;
	}
	public List<Patient> rechercheTousLesPatients(){
		
		return null;
	}
	public boolean enleverPatient(Patient patient){
		return false;
	}
}
