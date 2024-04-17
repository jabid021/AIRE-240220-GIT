package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOCompte;
import quest.model.Compte;
import quest.model.Stagiaire;

@Service
public class StagiaireService {
	@Autowired
	IDAOCompte daoCompte;
	
	public Stagiaire getById(Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Stagiaire) opt.get();
		}
	}

	public List<Stagiaire> getAll()
	{
		return daoCompte.findAllStagaire();
	}
	
	
	
	
	public Stagiaire insert(Stagiaire stagiaire) 
	{
		return daoCompte.save(stagiaire);
	}
	
	public Stagiaire update(Stagiaire stagiaire) 
	{
		if(stagiaire.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		
		
		return daoCompte.save(stagiaire);
	}
	
	
	public Stagiaire updatePartiel(Stagiaire stagiaireJSON) 
	{
		if(stagiaireJSON.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		Optional<Compte> opt = daoCompte.findById(stagiaireJSON.getId());
		if(opt.isPresent()) {
			Stagiaire stagiaireBdd = (Stagiaire) opt.get();
			if(stagiaireJSON.getAdresse()!=null) 
			{
				if(stagiaireJSON.getAdresse().getNumero()!=null) 
				{
					stagiaireBdd.getAdresse().setNumero(stagiaireJSON.getAdresse().getNumero());
				}
				if(stagiaireJSON.getAdresse().getVoie()!=null) 
				{
					stagiaireBdd.getAdresse().setVoie(stagiaireJSON.getAdresse().getVoie());
				}
				if(stagiaireJSON.getAdresse().getVille()!=null) 
				{
					stagiaireBdd.getAdresse().setVille(stagiaireJSON.getAdresse().getVille());
				}
				if(stagiaireJSON.getAdresse().getCp()!=null) 
				{
					stagiaireBdd.getAdresse().setCp(stagiaireJSON.getAdresse().getCp());
				}
			}
			if(stagiaireJSON.getEmail()!=null) 
			{
				stagiaireBdd.setEmail(stagiaireJSON.getEmail());
			}
			if(stagiaireJSON.getNom()!=null) 
			{
				stagiaireBdd.setNom(stagiaireJSON.getNom());
			}
			if(stagiaireJSON.getPrenom()!=null) 
			{
				stagiaireBdd.setPrenom(stagiaireJSON.getPrenom());
			}
			if(stagiaireJSON.getPassword()!=null) 
			{
				stagiaireBdd.setPassword(stagiaireJSON.getPassword());
			}
			if(stagiaireJSON.getFiliere()!=null) 
			{
				stagiaireBdd.setFiliere(stagiaireJSON.getFiliere());
			}
			return daoCompte.save(stagiaireBdd);
		}
		else 
		{
			return null;
		}
		
		
	}
	
	public void delete(Stagiaire stagiaire) 
	{
		daoCompte.delete(stagiaire);
	}
	public void deleteById(Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
	
	
}


