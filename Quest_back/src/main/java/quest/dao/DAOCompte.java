package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Adresse;
import quest.model.Compte;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Stagiaire;

public class DAOCompte implements IDAO<Compte,Integer>{

	@Override
	public Compte findById(Integer id) {
		DAOFiliere daoFiliere = new DAOFiliere();
		Compte compte = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("role").equals("Stagiaire")) 
				{
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					Adresse adresse= new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					compte = new Stagiaire(rs.getInt("id"), rs.getString("email"),rs.getString("password"),rs.getString("prenom"),rs.getString("nom"), adresse,filiere );

				}
				else 
				{
					compte = new Formateur(rs.getInt("id"), rs.getString("email"),
							rs.getString("password"), rs.getString("prenom"),
							rs.getString("nom"), rs.getDouble("tarif"));
				}

			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		DAOFiliere daoFiliere = new DAOFiliere();
		Compte compte = null;
		List<Compte> comptes = new ArrayList();
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");


			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("role").equals("Stagiaire")) 
				{
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					Adresse adresse= new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					compte = new Stagiaire(rs.getInt("id"), rs.getString("email"),rs.getString("password"),rs.getString("prenom"),rs.getString("nom"), adresse,filiere );

				}
				else 
				{
					compte = new Formateur(rs.getInt("id"), rs.getString("email"),
							rs.getString("password"), rs.getString("prenom"),
							rs.getString("nom"), rs.getDouble("tarif"));
				}
				comptes.add(compte);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public void insert(Compte compte) {

		try(
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (email,password,nom,prenom,numero,voie,ville,cp,filiere,tarif,role) VALUES (?,?,?,?,?,?,?,?,?,?)");
				)
		{
			Class.forName("com.mysql.jdbc.Driver");

			if(compte instanceof Stagiaire) {
				Stagiaire stagiaire = (Stagiaire) compte;

				ps.setString(1, stagiaire.getEmail());
				ps.setString(2, stagiaire.getPassword());
				ps.setString(3, stagiaire.getNom());
				ps.setString(4, stagiaire.getPrenom());
				ps.setString(5, stagiaire.getAdresse().getNumero());
				ps.setString(6, stagiaire.getAdresse().getVoie());
				ps.setString(7, stagiaire.getAdresse().getVille());
				ps.setString(8, stagiaire.getAdresse().getCp());
				ps.setInt(9, stagiaire.getFiliere().getId());
				ps.setObject(10,null);
				ps.setString(11, "Stagiaire");
			}
			else 
			{
				Formateur formateur = (Formateur) compte;
				ps.setString(1,formateur.getEmail());
				ps.setString(2,formateur.getPassword());
				ps.setString(3,formateur.getNom());
				ps.setString(4,formateur.getPrenom());
				ps.setObject(5,null);
				ps.setObject(6,null);
				ps.setObject(7,null);
				ps.setObject(8,null);
				ps.setObject(9,null);
				ps.setDouble(10,formateur.getTarif());
				ps.setString(11, "Formateur");
			}
			ps.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Compte compte) {
		try(
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE compte set email=?,password=?,nom=?,prenom=?,numero=?,voie=?,ville=?,cp=?,filiere=?,tarif=?,role=? where id=?");
				)
		{
			Class.forName("com.mysql.jdbc.Driver");

			if(compte instanceof Stagiaire) {
				Stagiaire stagiaire = (Stagiaire) compte;

				ps.setString(1, stagiaire.getEmail());
				ps.setString(2, stagiaire.getPassword());
				ps.setString(3, stagiaire.getNom());
				ps.setString(4, stagiaire.getPrenom());
				ps.setString(5, stagiaire.getAdresse().getNumero());
				ps.setString(6, stagiaire.getAdresse().getVoie());
				ps.setString(7, stagiaire.getAdresse().getVille());
				ps.setString(8, stagiaire.getAdresse().getCp());
				ps.setInt(9, stagiaire.getFiliere().getId());
				ps.setObject(10,null);
				ps.setString(11, "Stagiaire");
				ps.setInt(12, stagiaire.getId());
			}
			else 
			{
				Formateur formateur = (Formateur) compte;
				ps.setString(1,formateur.getEmail());
				ps.setString(2,formateur.getPassword());
				ps.setString(3,formateur.getNom());
				ps.setString(4,formateur.getPrenom());
				ps.setObject(5,null);
				ps.setObject(6,null);
				ps.setObject(7,null);
				ps.setObject(8,null);
				ps.setObject(9,null);
				ps.setDouble(10,formateur.getTarif());
				ps.setString(11, "Formateur");
				ps.setInt(12, formateur.getId());
			}
			ps.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try(
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("DELETE from compte where id=?");
				)
		{
			Class.forName("com.mysql.jdbc.Driver");

			
			ps.setInt(1, id);
			
			ps.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public Compte findByEmailAndPassword(String email,String password) 
	{
		DAOFiliere daoFiliere = new DAOFiliere();
		Compte compte = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte where email=? and password=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("role").equals("Stagiaire")) 
				{
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					Adresse adresse= new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					compte = new Stagiaire(rs.getInt("id"), rs.getString("email"),rs.getString("password"),rs.getString("prenom"),rs.getString("nom"), adresse,filiere );

				}
				else 
				{
					compte = new Formateur(rs.getInt("id"), rs.getString("email"),
							rs.getString("password"), rs.getString("prenom"),
							rs.getString("nom"), rs.getDouble("tarif"));
				}

			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return compte;
	}

}
