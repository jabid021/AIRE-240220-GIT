package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service
public class MatiereService {

	@Autowired
	IDAOMatiere daoMatiere;
	
	public Matiere getById(Integer id) 
	{
		Optional<Matiere> opt = daoMatiere.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	public List<Matiere> getAll()
	{
		return daoMatiere.findAll();
	}
	
	public Matiere insert(Matiere matiere) 
	{
		return daoMatiere.save(matiere);
	}
	
	public Matiere update(Matiere matiere) 
	{
		if(matiere.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		return daoMatiere.save(matiere);
	}
	
	public void delete(Matiere matiere) 
	{
		daoMatiere.delete(matiere);
	}
	public void deleteById(Integer id) 
	{
		daoMatiere.deleteById(id);
	}
	
	
	
}
