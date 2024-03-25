package quest.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import quest.model.Matiere;

public class DAOMatiere implements IDAO<Matiere, Integer>{

	@Override
	public Matiere findById(Integer id) {
		Matiere matiere = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from matiere where id=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				
				matiere = new Matiere(rs.getInt("id"),rs.getString("libelle"));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		
		List<Matiere> matieres = new ArrayList();
		Matiere matiere = null;
		
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from matiere");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				
				matiere = new Matiere(rs.getInt("id"),rs.getString("libelle"));
				matieres.add(matiere);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return matieres;
	}

	@Override
	public void insert(Matiere matiere) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO matiere (libelle) VALUES (?)");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setString(1,matiere.getLibelle());
			
			
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}			
	}

	@Override
	public void update(Matiere matiere) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE matiere set libelle=? where id=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setString(1,matiere.getLibelle());
			ps.setInt(2,matiere.getId());
			
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
				PreparedStatement ps = conn.prepareStatement("DELETE from matiere where id=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			ps.setInt(1,id);
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
		
	}
	
}
