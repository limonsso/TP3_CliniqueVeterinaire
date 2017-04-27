package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ca.uqam.inf2120.tp3.modele.Patient;


/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP3
 * 
 * Classe ControleurRecherchePatient : controle la recherche d'un patient
 * (nom, age,etc...)
 * 
 * 
 * @author Doumo Doumo Serges=Michel - DOUS20078401 et Ezeckiel Gnepa
 *         -GNEP09110902
 * @version 5 avril 2017
 */
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
				"Priorité", "Date / Heure d'arrivée","Nom et prénom du propriétaire"  };
		
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//vide la liste de resultat
		
		
		// Obtenir la source de l'�v�nement.
        Object source = event.getSource();
        
        //event radio bouton Tous
        if(source == this.uneVue.getRdbtnTous()){
        	if (Resultat!= null && !Resultat.isEmpty()) {
    			Resultat.removeAll(Resultat);
    		}
        	Resultat = this.Model.rechercheTousLesPatients();
        	if(!FillData())
        	{
        		JOptionPane.showMessageDialog(this.uneVue,
    					"Aucun patient n'existe dans le système",
    					"SPT- Information",
    					JOptionPane.INFORMATION_MESSAGE);
        	}
        }
        //Bouton Rechercher
        if(source == this.uneVue.getBtnRechercher()){
        	if (Resultat!= null && !Resultat.isEmpty()) {
    			Resultat.removeAll(Resultat);
    		}
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
		        					"Aucun patient n'a une priorité inférieure à " + priorite + " dans le système ",
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
	        	//radio bouton priorit� superieur a
	        	if(this.uneVue.getRdbtnSuppiorite().isSelected()){
	        		
	        		int priorite;
	        		
	        		try{
	        			priorite = Integer.parseInt(valeurRecherche);
		        		
		        		Resultat = this.Model.rechercheParPriorite(priorite, 1);
		        		
		        		if(!FillData())
		            	{
		            		JOptionPane.showMessageDialog(this.uneVue,
		        					"Aucun patient n'a une priorité supérieure à " + priorite + " dans le système ",
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
        	int index = uneVue.getTablePatients().getSelectedRow();
        	String Id = this.uneVue.getTablePatients().getValueAt(uneVue.getTablePatients().getSelectedRow(), 0).toString();
        	Patient unPatient = this.Model.rechercherParIndentifiant(Id); 
        	switch(unPatient.getEspece()){
        	case "Félin":
        		EditerPatient.getRdbtnFelin().setSelected(true);
        		break;
        	case "Canin":
        		EditerPatient.getRdbtnCanin().setSelected(true);
        		break;	
        		
        	case "Autre":
        		EditerPatient.getRdbtnAutre().setSelected(true);
        		break;	
        	}
        	EditerPatient.gettFId().setText(Id);
        	EditerPatient.gettFNom().setText(unPatient.getNom());
        	EditerPatient.gettFAge().setText(unPatient.getAge());
        	EditerPatient.gettFRaison().setText(unPatient.getRaisonUrgence());
        	for (int i = 0; i < EditerPatient.getCboPriorite().getItemCount(); i++)
            {
                if (EditerPatient.getCboPriorite().getItemAt(i)==unPatient.obtenirPriorite())
                {
                	EditerPatient.getCboPriorite().setSelectedIndex(i);
                    break;
                }
            }
        	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        	EditerPatient.gettFDate().setText(formatDate.format(unPatient.obtenirDateHeureCreation().getTime()));
        	EditerPatient.gettFNomP().setText(unPatient.getProprietaire().getNom());
        	EditerPatient.gettFPrenomP().setText(unPatient.getProprietaire().getPrenom());
        	EditerPatient.gettFAdresse().setText(unPatient.getProprietaire().getAdresse());
        	EditerPatient.gettFTel().setText(unPatient.getProprietaire().getTelephone());
        	ControleurDialogP = new ControleurDialogPatient(EditerPatient,this.Model);
        	EditerPatient.setControleurDialogPatient(ControleurDialogP);
        	EditerPatient.setModal(true);
        	EditerPatient.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        	EditerPatient.setVisible(true);
        	
        	Resultat.set(index, unPatient);
        	FillData();
        }
      //Bouton "Afficher"
        if(source == this.uneVue.getBtnAfficher())
        {
        	DialogPatientAffiche AfficherPatient = new DialogPatientAffiche(this.uneVue);
        	ControleurDialogP = new ControleurDialogPatient(AfficherPatient,this.Model);
        	AfficherPatient.Value = new Object[5];
        	String Id = this.uneVue.getTablePatients().getValueAt(uneVue.getTablePatients().getSelectedRow(), 0).toString();
        	Patient unPatient = this.Model.rechercherParIndentifiant(Id);       			
        	AfficherPatient.gettFId().setText(Id);
        	AfficherPatient.gettFNom().setText(unPatient.getNom());
        	AfficherPatient.gettFAge().setText(unPatient.getAge());
        	AfficherPatient.gettFRaison().setText(unPatient.getRaisonUrgence());
        	AfficherPatient.gettFPriorite().setText(unPatient.obtenirPriorite()+"");
        	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    		AfficherPatient.gettFDate().setText(formatDate.format(unPatient.obtenirDateHeureCreation().getTime()));
    		AfficherPatient.gettFNomP().setText(unPatient.getProprietaire().getNom());
    		AfficherPatient.gettFPrenomP().setText(unPatient.getProprietaire().getPrenom());
    		AfficherPatient.gettFAdresse().setText(unPatient.getProprietaire().getAdresse());
    		AfficherPatient.gettFTel().setText(unPatient.getProprietaire().getTelephone());
        	AfficherPatient.setControleurDialogPatient(ControleurDialogP);
        	AfficherPatient.setModal(true);
        	AfficherPatient.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        	AfficherPatient.setVisible(true);
        }
        //Bouton "Suppimer"
        if(source == this.uneVue.getBtnSupprimer())
        {
        	int index = uneVue.getTablePatients().getSelectedRow();
        	// Question avec les boutons de r�ponse Oui et Non
        	int reponse = JOptionPane.showConfirmDialog(null,
    				        "Voulez-vous supprimer le patient "+this.uneVue.getTablePatients()
    				        .getValueAt(index, 0).toString(),
    				        "SPT- Avertissement",
    				        JOptionPane.YES_NO_OPTION);
        	
        	if(reponse ==JOptionPane.YES_OPTION)
        	{
        		String Id = this.uneVue.getTablePatients().getValueAt(uneVue.getTablePatients()
        				.getSelectedRow(), 0).toString();
        		this.Model.enleverPatient(this.Model.rechercherParIndentifiant(Id));
        		Resultat.remove(index);
            	FillData();
        	}
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
        		this.uneVue.Value = creerModele();
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
	private DefaultTableModel creerModele() {

		return new DefaultTableModel(data, entete) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	}
}
