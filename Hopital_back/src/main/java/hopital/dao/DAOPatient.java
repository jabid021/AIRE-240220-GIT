package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hopital.model.Patient;

public class DAOPatient implements IDAO<Patient,Integer> {

	@Override
	public Patient findById(Integer id) {
		Patient patient = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from patient where id=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				patient = new Patient(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> patients= new ArrayList();
		Patient patient = null;
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("SELECT * from patient");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				patient = new Patient(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
				patients.add(patient);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public void insert(Patient patient) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO patient VALUES (?,?,?)");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			ps.setInt(1, patient.getId());
			ps.setString(2, patient.getNom());
			ps.setString(3, patient.getPrenom());

			ps.executeUpdate();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Patient patient) {
		try(
				Connection conn  = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
				PreparedStatement ps = conn.prepareStatement("UPDATE patient set nom=?,prenom=? where id=?");
				) 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			ps.setString(1, patient.getNom());
			ps.setString(2, patient.getPrenom());
			ps.setInt(3, patient.getId());

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
				PreparedStatement ps = conn.prepareStatement("DELETE from patient where id=?");
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
