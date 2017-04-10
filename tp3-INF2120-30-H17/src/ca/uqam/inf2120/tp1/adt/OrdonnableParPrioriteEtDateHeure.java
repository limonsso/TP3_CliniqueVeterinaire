package ca.uqam.inf2120.tp1.adt;

import java.util.GregorianCalendar;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP1
 * 
 * OrdonnableParPrioriteEtDateHeure : Interface d�finissant les services 
 * de gestion de la priorit� et de la date / heure de cr�ation d'un �l�ment 
 * ordonnable selon la priorit� et la date / heure de cr�ation. 
 *    
 * @author Ismael Doukoure
 * @version  8 f�vrier 2017
 */
 public interface OrdonnableParPrioriteEtDateHeure {
	
	/**
	 * Modifie la priorit� .
	 * 
	 * @param priorite La nouvelle priorit�.
	 */
	 public void modifierPriorite (int priorite);
	
	/**
	 * Retourne la prioriti�
	 * 
	 * @return La priorit� 
	 */
	public int obtenirPriorite();
	
	/**
	 * Retourne la date et heure de cr�ation
	 * 
	 * @return La date de cr�ation et heure de cr�ation 
	 */
	public GregorianCalendar obtenirDateHeureCreation();
	
}
