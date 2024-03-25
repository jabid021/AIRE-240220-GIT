package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import quest.model.Adresse;
import quest.model.Filiere;
import quest.model.Stagiaire;

public class DAOStagiaire implements IDAO<Stagiaire, Integer>{
	
	@Override
	public Stagiaire findById(Integer id) {
		DAOFiliere daoFiliere = new DAOFiliere();
		Stagiaire stagiaire = null;
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

				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Adresse adresse= new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				stagiaire = new Stagiaire(rs.getInt("id"), rs.getString("email"),rs.getString("password"),rs.getString("prenom"),rs.getString("nom"), adresse,filiere );

			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return stagiaire;
	}

	@Override
	public List<Stagiaire> findAll() {
		DAOFiliere daoFiliere = new DAOFiliere();
		List<Stagiaire> stagiaires=new ArrayList();
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte where role='Stagiaire'");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Stagiaire stagiaire = new Stagiaire(rs.getInt("id"), rs.getString("email"),rs.getString("password"),rs.getString("prenom"),rs.getString("nom"), rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),filiere );
				stagiaires.add(stagiaire);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return stagiaires;
	}

	@Override

	public void insert(Stagiaire stagiaire) {


		try(
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (email,password,nom,prenom,numero,voie,ville,cp,filiere,role) VALUES (?,?,?,?,?,?,?,?,?,'Stagiaire')");
				)
		{
			Class.forName("com.mysql.jdbc.Driver");

			ps.setString(1, stagiaire.getEmail());
			ps.setString(2, stagiaire.getPassword());
			ps.setString(3, stagiaire.getNom());
			ps.setString(4, stagiaire.getPrenom());
			ps.setString(5, stagiaire.getAdresse().getNumero());
			ps.setString(6, stagiaire.getAdresse().getVoie());
			ps.setString(7, stagiaire.getAdresse().getVille());
			ps.setString(8, stagiaire.getAdresse().getCp());
			ps.setInt(9, stagiaire.getFiliere().getId());

			ps.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void update(Stagiaire stagiaire) {
		try(
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE compte set email=?,password=?,nom=?,prenom=?,numero=?,voie=?,ville=?,cp=?,filiere=? where id=?");
				)
		{
			Class.forName("com.mysql.jdbc.Driver");

			ps.setString(1, stagiaire.getEmail());
			ps.setString(2, stagiaire.getPassword());
			ps.setString(3, stagiaire.getNom());
			ps.setString(4, stagiaire.getPrenom());
			ps.setString(5, stagiaire.getAdresse().getNumero());
			ps.setString(6, stagiaire.getAdresse().getVoie());
			ps.setString(7, stagiaire.getAdresse().getVille());
			ps.setString(8, stagiaire.getAdresse().getCp());
			ps.setInt(9, stagiaire.getFiliere().getId());
			ps.setInt(10, stagiaire.getId());		
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

}
