package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Matiere;
import quest.model.Module;

public class DAOModule implements IDAO<Module,Integer>{

	@Override
	public Module findById(Integer id) {
		DAOFiliere daoFiliere = new DAOFiliere();
		DAOMatiere daoMatiere = new DAOMatiere();
		DAOFormateur daoFormateur = new DAOFormateur();
		Module module = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from module where id=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Matiere matiere = daoMatiere.findById(rs.getInt("matiere"));
				Formateur formateur = daoFormateur.findById(rs.getInt("formateur"));

				module = new Module(id,LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),rs.getInt("quest"),filiere,matiere,formateur);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return module;

	}

	@Override
	public List<Module> findAll() {
		DAOFiliere daoFiliere = new DAOFiliere();
		DAOMatiere daoMatiere = new DAOMatiere();
		DAOFormateur daoFormateur = new DAOFormateur();
		Module module = null;
		List<Module> modules= new ArrayList();
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from module");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");


			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Matiere matiere = daoMatiere.findById(rs.getInt("matiere"));
				Formateur formateur = daoFormateur.findById(rs.getInt("formateur"));

				module = new Module(rs.getInt("id"),LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),rs.getInt("quest"),filiere,matiere,formateur);
				modules.add(module);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return modules;
	}

	@Override
	public void insert(Module module) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO module (debut,fin,quest,filiere,matiere,formateur) VALUES (?,?,?,?,?,?)");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setString(1, module.getDebut().toString());
			ps.setString(2, module.getFin().toString());
			ps.setInt(3, module.getQuest());
			ps.setInt(4, module.getFiliere().getId());
			ps.setInt(5, module.getMatiere().getId());
			
			if(module.getFormateur()==null) 
			{
				ps.setObject(6, null);
			}
			else 
			{
				ps.setInt(6, module.getFormateur().getId());
			}
			
			ps.executeUpdate();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Module module) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE module set debut=?,fin=?,quest=?,filiere=?,matiere=?,formateur=? where id=?");
			) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setString(1, module.getDebut().toString());
			ps.setString(2, module.getFin().toString());
			ps.setInt(3, module.getQuest());
			ps.setInt(4, module.getFiliere().getId());
			ps.setInt(5, module.getMatiere().getId());
			
			if(module.getFormateur()==null) 
			{
				ps.setObject(6, null);
			}
			else 
			{
				ps.setInt(6, module.getFormateur().getId());
			}
			
			ps.setInt(7, module.getId());
			
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
				PreparedStatement ps = conn.prepareStatement("DELETE from module where id=?");
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

	
	
	
	
	public List<Module> findAllByFiliere(Integer idFiliere) {
		DAOFiliere daoFiliere = new DAOFiliere();
		DAOMatiere daoMatiere = new DAOMatiere();
		DAOFormateur daoFormateur = new DAOFormateur();
		Module module = null;
		List<Module> modules= new ArrayList();
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from module where filiere=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, idFiliere);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Matiere matiere = daoMatiere.findById(rs.getInt("matiere"));
				Formateur formateur = daoFormateur.findById(rs.getInt("formateur"));

				module = new Module(rs.getInt("id"),LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),rs.getInt("quest"),filiere,matiere,formateur);
				modules.add(module);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return modules;
	}
}
