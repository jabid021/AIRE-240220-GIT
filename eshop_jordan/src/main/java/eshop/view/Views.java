package eshop.view;

public class Views {


	public class Common {}//Acces JSON le plus bas niveau, les attributs tels que les id, libelle auront cette projection


	public class Produit extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Compte
	public class ProduitWithVentes extends Produit{}
	
	public class Fournisseur extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Filiere
	public class FournisseurWithStock extends Fournisseur{} //Acces JSON spécifique pour les chargements toMany


	public class Client extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Matiere
	public class ClientWithAchats extends Client{}
	
	public class Achat extends Common {}//Acces JSON présent sur toutes les relations toOne dans la classe Module


}

