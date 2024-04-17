package eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.dao.IDAOAchat;
import eshop.model.Achat;

@Service
public class AchatService {

	@Autowired
	IDAOAchat daoAchat;
	
	public Achat getById(Integer id) 
	{
		Optional<Achat> opt = daoAchat.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	public List<Achat> getAll()
	{
		return daoAchat.findAll();
	}
	
	public Achat insert(Achat achat) 
	{
		return daoAchat.save(achat);
	}
	
	public Achat update(Achat achat) 
	{
		if(achat.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		
		return daoAchat.save(achat);
	}
	
	public void delete(Achat achat) 
	{
		daoAchat.delete(achat);
	}
	public void deleteById(Integer id) 
	{
		daoAchat.deleteById(id);
	}
	
	
}
