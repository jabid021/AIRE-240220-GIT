package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Formateur;

public class DAOFormateur implements IDAO<Formateur,Integer> {

	@Override
	public Formateur findById(Integer id) {
		Formateur formateur = null;
		try(	Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte WHERE id=?");)
		{
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				formateur = new Formateur(rs.getInt("id"), rs.getString("email"),
						rs.getString("password"), rs.getString("prenom"),
						rs.getString("nom"), rs.getDouble("tarif"));
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return formateur;
	}

	@Override
	public List<Formateur> findAll() {
		List<Formateur> formateurs = new ArrayList<Formateur>();
		Formateur formateur = null;
		
		try(	Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte WHERE role='Formateur' ");)
		{
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				
				formateur = new Formateur(rs.getInt("id"), rs.getString("email"),
						rs.getString("password"), rs.getString("prenom"),
						rs.getString("nom"), rs.getDouble("tarif"));
				formateurs.add(formateur);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return formateurs;
	}

	@Override
	public void insert(Formateur formateur) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (email,password,nom,prenom,tarif,role) VALUES (?,?,?,?,?,'Formateur')");
			) 
		{
			ps.setString(1,formateur.getEmail());
			ps.setString(2,formateur.getPassword());
			ps.setString(3,formateur.getNom());
			ps.setString(4,formateur.getPrenom());
			ps.setDouble(5,formateur.getTarif());
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Formateur formateur) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE compte SET email=?,password=?,nom=?,prenom=?,tarif=? WHERE id=?");
			) 
		{
			ps.setString(1,formateur.getEmail());
			ps.setString(2,formateur.getPassword());
			ps.setString(3,formateur.getNom());
			ps.setString(4,formateur.getPrenom());
			ps.setDouble(5,formateur.getTarif());
			ps.setInt(6,formateur.getId());

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
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("DELETE FROM compte WHERE id=?");
			) 
		{
			ps.setInt(1,id);

			ps.executeUpdate();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

	
}
