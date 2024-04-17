package eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.dao.IDAOPersonne;
import eshop.model.Client;
import eshop.model.Personne;

@Service
public class ClientService {

	@Autowired
	IDAOPersonne daoClient;
	
	public Client getById(Integer id) 
	{
		Optional<Personne> opt = daoClient.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Client) opt.get();
		}
	}

	public List<Client> getAll()
	{
		return daoClient.findAllClient();
	}
	
	public Client insert(Client client) 
	{
		
		return daoClient.save(client);
	}
	
	public Client update(Client client) 
	{
		if(client.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		
		return daoClient.save(client);
	}
	
	public void delete(Client client) 
	{
		daoClient.delete(client);
	}
	public void deleteById(Integer id) 
	{
		daoClient.deleteById(id);
	}
	
	
	public Client getByIdAvecAchats(Integer id) 
	{
		return daoClient.findByIdWithAchats(id);
	}
	
	

	 
	
}
