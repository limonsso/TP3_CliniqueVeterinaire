package ca.uqam.inf2120.tp3.controleurs;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ca.uqam.inf2120.tp3.interfacegraphiques.DialogPatientAffiche;
import ca.uqam.inf2120.tp3.interfacegraphiques.DialogPatientAjout;
import ca.uqam.inf2120.tp3.interfacegraphiques.DialogPatientEditer;
import ca.uqam.inf2120.tp3.interfacegraphiques.FenetreRecherchePatients;
import ca.uqam.inf2120.tp3.modele.Patient;
import ca.uqam.inf2120.tp3.modele.Proprietaire;

public class ControleurRecherchePatient extends ControleurPatient {
	
	private FenetreRecherchePatients uneVue;
	private List<Patient> Resultat;
	private String[] entete ;
	private Object[][] data;
	private ControleurDialogPatient ControleurDialogP;
	
	public ControleurRecherchePatient(FenetreRecherchePatients _fenetreRecherche) {
		super();
		this.uneVue =_fenetreRecherche;
		Resultat = new ArrayList<Patient>();
		entete = new String[] { "Identifiant", "Nom",
				"Priorité", "Date / Heure d'arrivée","Nom et prénom du propriotaire"  };
		
		Proprietaire proprioTest = new Proprietaire("Zekinan","Limonsso","","");
		Patient patientTest = new Patient("Milou","2 ans","Félin","Grippe",2,proprioTest);
		
		Proprietaire proprioTest2 = new Proprietaire("Serge","Limonsso","","");
		Patient patientTest2 = new Patient("Bobi","4 ans","Canin","Grippe",4,proprioTest2);
		
		Proprietaire proprioTest3 = new Proprietaire("aminata","jeanne","","");
		Patient patientTest3 = new Patient("michel","3 ans","chevre","fievre",2,proprioTest3);
		
		Proprietaire proprioTest4 = new Proprietaire("Serge","Limonsso","","");
		Patient patientTest4 = new Patient("jacques","5 ans","Canin","mal dentaire",4,proprioTest4);
		
		this.Model.placerPatient(patientTest);
		this.Model.placerPatient(patientTest2);
		this.Model.placerPatient(patientTest3);
		this.Model.placerPatient(patientTest4);



		
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//vide la liste de resultat
		
		if (Resultat!= null && !Resultat.isEmpty()) {
			Resultat.removeAll(Resultat);
		}
		// Obtenir la source de l'ï¿½vï¿½nement.
        Object source = event.getSource();
        
        //event radio bouton Tous
        if(source == this.uneVue.getRdbtnTous()){
        	Resultat = this.Model.rechercheTousLesPatients();
        	if(!FillData())
        	{
        		JOptionPane.showMessageDialog(this.uneVue,
    					"Aucun patient n'existe dans le systï¿½me",
    					"SPT- Information",
    					JOptionPane.INFORMATION_MESSAGE);
        	}
        }
        if(source == this.uneVue.getBtnRechercher()){
        	String valeurRecherche = uneVue.getTfRecherche().getText().trim().toUpperCase();
        	
        	if(!uneVue.getTfRecherche().getText().isEmpty())
        	{
	        	if(this.uneVue.getRdbtnIdentifiant().isSelected()){
	        		Patient PatientRecherche = this.Model.rechercherParIndentifiant(valeurRecherche);
	        		
	        		if(PatientRecherche!=null)
	        		{
	        			Resultat.add(PatientRecherche);
	        			FillData();
	        		}else{
	        			JOptionPane.showMessageDialog(this.uneVue,
	        					"Aucun patient avec l'identifiant "+valeurRecherche+" !",
	        					"SPT- Information",
	        					JOptionPane.INFORMATION_MESSAGE);
	        			uneVue.Value=null;
	        			uneVue.refresh();
	        		}
	        	}
	        	if(this.uneVue.getRdbtnEgalepiorite().isSelected()){
	        		int priorite;
	        		
	        		try{
	        			priorite = Integer.parseInt(valeurRecherche);
		        		
		        		Resultat = this.Model.rechercheParPriorite(priorite, 0);
		        		
		        		if(!FillData())
		            	{
		            		JOptionPane.showMessageDialog(this.uneVue,
		        					"Aucun patient n'a la priorité " + priorite + " dans le système ",
		        					"SPT- Information",
		        					JOptionPane.INFORMATION_MESSAGE);
		            	}
	        		} catch (NumberFormatException ex ) { 
	        			
	        			JOptionPane.showMessageDialog(this.uneVue,
	        					"Rentrez une valeur numérique s'il vous plait ",
	        					"SPT- Information",
	        					JOptionPane.ERROR_MESSAGE);
	        		}
	        		 
	        		
	        		
	        	}
	        	if(this.uneVue.getRdbtnInfpiorite().isSelected()){
	        		
	        		int priorite;
	        		
	        		try{
	        			priorite = Integer.parseInt(valeurRecherche);
		        		
		        		Resultat = this.Model.rechercheParPriorite(priorite, -1);
		        		
		        		if(!FillData())
		            	{
		            		JOptionPane.showMessageDialog(this.uneVue,
		        					"Aucun patient n'a une priorité inférieure a  " + priorite + " dans le système ",
		        					"SPT- Information",
		        					JOptionPane.INFORMATION_MESSAGE);
		            	}
	        		} catch (NumberFormatException ex ) { 
	        			
	        			JOptionPane.showMessageDialog(this.uneVue,
	        					"Rentrez une valeur numérique s'il vous plait ",
	        					"SPT- Information",
	        					JOptionPane.ERROR_MESSAGE);
	        		}
	        	}
	        	if(this.uneVue.getRdbtnSuppiorite().isSelected()){
	        		
	        		int priorite;
	        		
	        		try{
	        			priorite = Integer.parseInt(valeurRecherche);
		        		
		        		Resultat = this.Model.rechercheParPriorite(priorite, 1);
		        		
		        		if(!FillData())
		            	{
		            		JOptionPane.showMessageDialog(this.uneVue,
		        					"Aucun patient n'a une priorité supérieure a  " + priorite + " dans le système ",
		        					"SPT- Information",
		        					JOptionPane.INFORMATION_MESSAGE);
		            	}
	        		} catch (NumberFormatException ex ) { 
	        			
	        			JOptionPane.showMessageDialog(this.uneVue,
	        					"Rentrez une valeur numérique s'il vous plait ",
	        					"SPT- Information",
	        					JOptionPane.ERROR_MESSAGE);
	        		}
	        	}
        	}
        	else
        	JOptionPane.showMessageDialog(this.uneVue,
					"Ajoutez une valeur de recherche SVP !!!",
					"SPT- Erreur",
					JOptionPane.ERROR_MESSAGE);
        }
        
        //Bouton "Ajouter"
        if(source == this.uneVue.getBtnAjouter())
        {
        	
        	DialogPatientAjout AjoutPatient = new DialogPatientAjout(this.uneVue);
        	ControleurDialogP = new ControleurDialogPatient(AjoutPatient,this.Model);
        	AjoutPatient.setControleurDialogPatient(ControleurDialogP);
        	AjoutPatient.setModal(true);
        	AjoutPatient.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        	AjoutPatient.setVisible(true);
        }
      //Bouton "Modifier"
        if(source == this.uneVue.getBtnModifier())
        {
        	DialogPatientEditer EditerPatient = new DialogPatientEditer(this.uneVue);
        	ControleurDialogP = new ControleurDialogPatient(EditerPatient,this.Model);
        	EditerPatient.setControleurDialogPatient(ControleurDialogP);
        	EditerPatient.setModal(true);
        	EditerPatient.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        	EditerPatient.setVisible(true);
        }
      //Bouton "Modifier"
        if(source == this.uneVue.getBtnAfficher())
        {
        	DialogPatientAffiche AfficherPatient = new DialogPatientAffiche(this.uneVue);
        	ControleurDialogP = new ControleurDialogPatient(AfficherPatient,this.Model);
        	AfficherPatient.setControleurDialogPatient(ControleurDialogP);
        	AfficherPatient.setModal(true);
        	AfficherPatient.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        	AfficherPatient.setVisible(true);
        }
      //Bouton "Fermer"
        if(source == this.uneVue.getBtnFermer())
        {
        	this.uneVue.dispose();
        }
	}
	/**
	 * Permet de remplire l'objet data du JTable de FenetreRecherchePatients
	 * avec le resultat obtenu du model
	 * @return vrai si on a des resultats
	 */
	public boolean FillData(){
		boolean bReturn= false;
		if(Resultat!=null && !Resultat.isEmpty())
    	{
        	data = new Object[Resultat.size()][5];
        	int i = 0;
        	for(Patient patient : Resultat){
        		if(patient !=null)
	        	{
        			data[i][0] = patient.getIdentifiant();
	        		data[i][1] = patient.getNom();
	        		data[i][2] = patient.obtenirPriorite();
	        		//Formater la date 
	        		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        		data[i][3] = formatDate.format(patient.obtenirDateHeureCreation().getTime());
	        		data[i][4] = patient.getProprietaire().getNom() +" "+patient.getProprietaire().getPrenom();
	        		i++;
        		}
        	}
        	if(data.length>0){
        		this.uneVue.Value = new DefaultTableModel(data,entete);
        		this.uneVue.refresh();
        		bReturn=true;
        	}
        	
    	}
		if (bReturn == false) {
    		this.uneVue.Value = null;
    		this.uneVue.refresh();
    	}
		return bReturn;
	}
	
}
