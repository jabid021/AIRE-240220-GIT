package quest.view;

public class Views {
	
	public class Common {}//Acces JSON le plus bas niveau, les attributs tels que les id, libelle auront cette projection

	public class Compte extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Compte
	public class Filiere extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Filiere
		public class FiliereWithStagiaire extends Filiere{} //Acces JSON spécifique pour les chargements toMany
	
	public class Matiere extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Matiere
	public class Module extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Module
	public class Ordinateur extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Ordinateur
	
}
