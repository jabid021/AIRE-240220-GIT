package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Marque;
import quest.model.Ordinateur;
import quest.model.Stagiaire;

public class DAOOrdinateur implements IDAO<Ordinateur,Integer>{

	@Override
	public Ordinateur findById(Integer id) {
		DAOStagiaire daoStagiaire = new DAOStagiaire();
		Ordinateur ordinateur = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from ordinateur where id=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				Stagiaire stagiaire = daoStagiaire.findById(rs.getInt("stagiaire"));
				ordinateur = new Ordinateur(rs.getInt("id"),rs.getInt("ram"),Marque.valueOf(rs.getString("marque")),stagiaire);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ordinateur;
	
		
	}

	@Override
	public List<Ordinateur> findAll() {
		DAOStagiaire daoStagiaire = new DAOStagiaire();
		List<Ordinateur> Ordinateurs = new ArrayList();
		Ordinateur Ordinateur = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from ordinateur");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				Stagiaire stagiaire = daoStagiaire.findById(rs.getInt("stagiaire"));
				Ordinateur = new Ordinateur(rs.getInt("id"),rs.getInt("ram"), Marque.valueOf(rs.getString("marque")), stagiaire);
			
				Ordinateurs.add(Ordinateur);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return Ordinateurs;
	}

		
	

	@Override
	public void insert(Ordinateur ordinateur) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO ordinateur (ram,marque,stagiaire) VALUES (?,?,?)");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setInt(1,ordinateur.getRam());
			ps.setString(2,ordinateur.getMarque().toString());
			if(ordinateur.getStagiaire()==null) 
			{
				ps.setObject(3, null);
			}
			else 
			{
				ps.setInt(3,ordinateur.getStagiaire().getId());
			}
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
		
	}

	@Override
	public void update(Ordinateur ordinateur) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("update  ordinateur set ram=?, marque=?,stagiaire=? where id=?");)
				
			{Class.forName("com.mysql.jdbc.Driver");
			
			
			ps.setInt(1,ordinateur.getRam());
			ps.setString(2,ordinateur.getMarque().toString());
			if(ordinateur.getStagiaire()==null) 
			{
				ps.setObject(3, null);
			}
			else 
			{
				ps.setInt(3,ordinateur.getStagiaire().getId());
			}
			ps.setInt(4,ordinateur.getId());
			
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
				PreparedStatement ps = conn.prepareStatement("DELETE from ordinateur where id=?");
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

	public Ordinateur findByStagiaire(Integer idStagiaire) {
		DAOStagiaire daoStagiaire = new DAOStagiaire();
		Ordinateur ordinateur = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from ordinateur where stagiaire=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, idStagiaire);
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				Stagiaire stagiaire = daoStagiaire.findById(rs.getInt("stagiaire"));
				ordinateur = new Ordinateur(rs.getInt("id"),rs.getInt("ram"),Marque.valueOf(rs.getString("marque")),stagiaire);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ordinateur;
	
		
	}
		
	}
	


