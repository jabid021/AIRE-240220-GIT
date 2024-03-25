package hopital.dao;

import java.util.List;

public interface IDAO<T,K> {

	

	public String loginBdd= "root";
	public String passwordBdd = "";
	public String urlBdd = "jdbc:mysql://localhost:3306/hopital";
	
	
	public T findById(K id);
	public List<T> findAll();
	public void insert(T obj);
	public T update(T obj);
	public void delete(K id);

}
