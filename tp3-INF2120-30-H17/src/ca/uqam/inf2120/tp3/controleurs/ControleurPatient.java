package ca.uqam.inf2120.tp3.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import ca.uqam.inf2120.tp3.modele.GestionUrgenceCliniqueVeterinaire;

public class ControleurPatient implements ActionListener {


	protected GestionUrgenceCliniqueVeterinaire Model;
	public ControleurPatient() {
		Model = new GestionUrgenceCliniqueVeterinaire();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
