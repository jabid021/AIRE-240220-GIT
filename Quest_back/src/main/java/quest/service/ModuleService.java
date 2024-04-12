package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOModule;
import quest.model.Matiere;
import quest.model.Module;

@Service
public class ModuleService {

	@Autowired
	IDAOModule daoModule;
	
	public Module getById(Integer id) 
	{
		Optional<Module> opt = daoModule.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	public List<Module> getAll()
	{
		return daoModule.findAll();
	}
	
	
	public List<Module> getAllByFiliere(Integer idFiliere)
	{
		return daoModule.findAllByFiliere(idFiliere);
	}
	
	public Module insert(Module module) 
	{
		return daoModule.save(module);
	}
	
	public Module update(Module module) 
	{
		if(module.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		return daoModule.save(module);
	}
	
	public void delete(Module module) 
	{
		daoModule.delete(module);
	}
	public void deleteById(Integer id) 
	{
		daoModule.deleteById(id);
	}
	
	
	
}
