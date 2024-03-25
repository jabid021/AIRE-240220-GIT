package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Secretaire;

public class DAOCompte implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
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
				if(rs.getString("type_compte").equals("Medecin"))
				{
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
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
		List<Compte> comptes = new ArrayList();
		Compte compte = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");


			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin"))
				{
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
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
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,type_compte)");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");

			ps.setString(1, compte.getLogin());
			ps.setString(2, compte.getPassword());
			ps.setString(3, compte.getClass().getSimpleName());

			ps.executeUpdate();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public Compte update(Compte compte) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE compte set login=?,password=?,type_compte=? where id=?)");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");

			if(compte instanceof Medecin) 
			{
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, "Medecin");
				ps.setInt(4,compte.getId());
			}
			else 
			{
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, "Secretaire");
				ps.setInt(4,compte.getId());
			}


			ps.executeUpdate();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id=?)");
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

	public Compte findByLoginAndPassword(String login, String password) {
		Compte compte = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin"))
				{
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
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
