package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hopital.context.Singleton;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Visite;


public class DAOVisite implements IDAO<Visite,Integer> {

	@Override
	public Visite findById(Integer id) {
		DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		DAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		
		Visite visite=null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getInt("salle"),rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		DAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		
		List<Visite> visites = new ArrayList();
		Visite visite=null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from visite ");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getInt("salle"),rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")));
				visites.add(visite);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visites;
	}

	@Override
	public void insert(Visite visite) {
		
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT into visite (id_patient,id_medecin,salle,prix,date_visite) VALUES (?,?,?,?,?) ",Statement.RETURN_GENERATED_KEYS);
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setInt(3, visite.getSalle());
			ps.setDouble(4, visite.getPrix());
			ps.setString(5, visite.getDateVisite().toString());
			ps.executeUpdate();

			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) 
			{
				visite.setId(rs.getInt(1));
			}
			
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Visite visite) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("update visite set id_patient=?,id_medecin=?,salle=?,prix=?,date_visite=? where numero=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setInt(3, visite.getSalle());
			ps.setDouble(4, visite.getPrix());
			ps.setString(5, visite.getDateVisite().toString());
			ps.setInt(6, visite.getId());
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
				PreparedStatement ps = conn.prepareStatement("DELETE from visite where numero=?");
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

	public List<Visite> findAllByPatient(Integer id) {
		DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		DAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		
		List<Visite> visites = new ArrayList();
		Visite visite=null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id_patient=? ");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getInt("salle"),rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")));
				visites.add(visite);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visites;
	}

}
