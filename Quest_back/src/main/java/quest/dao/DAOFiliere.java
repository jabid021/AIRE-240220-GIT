package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import quest.model.Filiere;

public class DAOFiliere implements IDAO<Filiere,Integer>{

	@Override
	public Filiere findById(Integer id) {
		
		
		
		Filiere filiere = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from filiere where id=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				

				LocalDate debut = (rs.getString("debut")==null) ? null : LocalDate.parse(rs.getString("debut"));
				LocalDate fin = (rs.getString("fin")==null) ? null : LocalDate.parse(rs.getString("fin"));

				filiere = new Filiere(rs.getInt("id"), rs.getString("libelle"),debut,fin );

			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return filiere;

	}

	@Override
	public List<Filiere> findAll() {

		Filiere filiere = null;
		List<Filiere> filieres = new ArrayList();
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from filiere ");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
		

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				

				
				LocalDate debut = (rs.getString("debut")==null) ? null : LocalDate.parse(rs.getString("debut"));
				LocalDate fin = (rs.getString("fin")==null) ? null : LocalDate.parse(rs.getString("fin"));

				filiere = new Filiere(rs.getInt("id"), rs.getString("libelle"),debut,fin );

                filieres.add(filiere);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return filieres;
		
	}

	@Override
	public void insert(Filiere filiere) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO filiere (libelle,debut,fin) VALUES (?,?,?)");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setString(1,filiere.getLibelle());
			ps.setString(2,filiere.getDebut().toString());
			ps.setString(3,filiere.getFin().toString());
			
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
		
	}

	@Override
	public void update(Filiere filiere) {
		// TODO Auto-generated method stub
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE filiere  set libelle=?, debut=?, fin=? where id=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setString(1, filiere.getLibelle());
			ps.setString(2, filiere.getDebut().toString());
			ps.setString(3, filiere.getFin().toString());	

			ps.setInt(4, filiere.getId());

			ps.executeUpdate();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("delete from filiere where id=?");
				
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
