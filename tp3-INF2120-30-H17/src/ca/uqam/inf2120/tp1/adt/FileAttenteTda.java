package ca.uqam.inf2120.tp1.adt;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * UQAM - Hiver 2017 - INF2120 - Groupe 30 - TP1
 * 
 * FileAttenteTda : Cette interface définit les services d'une file d'attente basée dans laquelle 
 * les éléments sont organisés en ordre décroissant selon leur priorité et leur date / heure de création. 
 * Les priorités commencent à 1  jusqu'à n, d'où 1 est la plus grande priorité, tandis que n est la
 * plus petite. Les éléments de la plus grande priorité sont ajoutés au début de la liste. Les éléments
 * de la même priorité sont ordonnés selon la date et l'heure de création 
 * 
 * @author Ismael Doukoure
 * @version 8 février 2017
 */
public interface FileAttenteTda<T extends OrdonnableParPrioriteEtDateHeure> {

	/**
	 * Place l'élément "elt" dans la file selon sa priorité. Les éléments de la
	 * plus grande priorité sont placés au début de la file. Si "elt" a la même
	 * priorité qu'un autre élément qui existe déjà dans la file, il doit être 
	 * placé avant cet élément si sa date / heure de création est plus ancienne 
	 * que ce dernier, sinon il est placé après. L'élément ne doit pas être placé
	 * dans la file  si une des conditions suivantes est vraie :
	 *   - L'élément est null.
	 *   - L'élément existe déjà dans la file (éléments identiques sans tenir compte 
	 *     de leur priorité et leur date / heure de création).
	 *   - La priorité de l'élément est inférieure à 1.
	 *
	 * @param elt L'élément à ajouter
	 * @return true si "elt" est ajouté, sinon false
	 */
	public boolean placer(T elt);

	/**
	 * Place tous les éléments de la liste passée en paramètre dans la file.
	 * Tous les éléments sont placer dans la file selon leur priorité. Les éléments de
	 * la plus grande priorité sont placés au début de la file. Si un élément de la liste
	 * a la même priorité qu'un autre élément qui existe déjà dans la file, il doit être 
	 * placé avant cet élément si sa date / heure de création est plus ancienne que ce 
	 * dernier, sinon il est placé après. L'élément de la liste passée en paramètre 
	 * ne doit pas être placé dans la file si une des conditions suivantes est vraie :
	 *   - L'élément à placer est null.
	 *   - L'élément existe déjà dans la file (éléments identiques sans tenir compte
	 *     de leur priorité et leur date / heure de création).
	 *   - La priorité de l'élément est inférieure à 1.
	 * 
	 * La liste passée en paramètre peut être nulle ou vide.
	 * 
	 * @param liste Le tableau liste (ArrayList) dont les éléments doivent être placés dans la file
	 */
	public void placer(List<T> liste);

	/**
	 * Enlève l'élément "elt" dans la file. Aucune action à faire si "elt" est nul ou s'il 
	 * n'existe pas dans la file. L'élément à enlever doit être égal à celui passé en paramètre ("elt") 
	 * sans tenir compte de leur priorité et leur date / heure de création.
	 * 
	 * @param elt L'élément à enlever
	 * @return Vrai si l'élément est enlevé
	 */
	public boolean enlever(T elt);

	/**
	 * Enlève tous les éléments de la liste passée en paramètre dans la file.
	 * Tous les éléments non enlevés de la liste passée en paramètre sont retournés dans
	 * un tableau liste (ArrayList). La comparaison entre les éléments de la liste passée
	 * en paramètre et  de la file doit se faire sans tenir compte de leur priorité et leur 
	 * date / heure de création. La liste passée en paramètre peut être nulle ou vide.
	 * 
	 * @param liste Le tableau liste (ArrayList) dont les éléments doivent être enlevés
	 * @return Le tableau liste (ArrayList) des éléments non enlevés, nul si tous les éléments
	 *         sont enlevés.
	 */
	public List<T> enlever(List<T> liste);
	
	
	/**
	 * Enlève tous les éléments dont la priorité est égale à celle passée en
	 * paramètre. Les éléments enlevés sont retournés dans un tableau liste.
	 * Une valeur nulle est retournée si aucun élément n'est enlevé.
	 * 
	 * @param priorite La priorité des éléments à enlever
	 * @return Le tableau liste des éléments enlevés, null si aucun élément n'a été enlevé
	 */
	public List<T> enlever(int priorite);

	
	/**
	 * Enlève les éléments de la file selon les conditions suivantes :
	 *   - Si le paramètre "plusPetit" est vrai, les éléments à enlever doivent
	 *     avoir la priorité plus petite que celle passée en paramètre.
	 *   - Si le paramètre "plusPetit" est faux, les éléments à enlever doivent
	 *     avoir la priorité plus grande que celle passée en paramètre.
	 *     
	 * Les éléments enlevés sont retournés dans une matrice dynamique de type HashMap<K,T>.
	 * La clé (K) de chaque emplacement dans la matrice est la priorité de type Integer, tandis
	 * que la valeur (T) est un tableau liste (ArrayList) de tous les éléments enlevés qui ont
	 * cette priorité. Une valeur nulle est retournée si aucun élément n'est enlevé.
	 * 
	 * @param priorite La priorité
	 * @return la matrice dynamique de type HashMap<K,T> de tous les éléments enlevés.
	 */
	public Map<Integer, List<T>> enlever(int priorite, boolean plusPetit);
	
     
	/**
     * Remplace la priorité de tous les éléments de la file dont la priorité est égale à 
     * "anciennePriorite" par "nouvellePriorite". La priorité "nouvellePriorite"
     * ne doit pas être inférieure à 1. Assurez-vous que la file est ordonnée après le 
     * remplacement.
     * 
	 * @param anciennePriorite L'ancienne priorité 
	 * @param nouvellePriorite La nouvelle priorité
	 * 
	 * @return Vrai si au moins un changement de priorité a été effectué
	 */
     public boolean remplacer(int anciennePriorite, int nouvellePriorite);


   /**
    * Retourne le nombre d'éléments dont la priorité est égale à celle passée en paramètre.
    * 
    * @param priorite La priorité 
    * @return Le nombre d'éléments dont la priorité = "priorite" 
    */
     public int ObtenirNbElments(int priorite);
      
	/**
	 * Vérifie si la file existante est vide.
	 * 
	 * @return Vrai si la file est vide, sinon faux
	 */
	 public boolean estVide();

	/**
	 * Retourne un itérateur qui permet de parcourir la file.
	 * 
	 * @return Itérateur sur la file.
	 */
	 public Iterator<T> iterateur();

}
