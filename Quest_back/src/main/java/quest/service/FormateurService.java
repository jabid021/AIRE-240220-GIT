package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOCompte;
import quest.model.Compte;
import quest.model.Formateur;

@Service
public class FormateurService {

	@Autowired
	IDAOCompte daoCompte;
	
	public Formateur getById(Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Formateur) opt.get();
		}
	}

	public List<Formateur> getAll()
	{
		return daoCompte.findAllFormateur();
	}
	
	public Formateur insert(Formateur formateur) 
	{
		return daoCompte.save(formateur);
	}
	
	public Formateur update(Formateur formateur) 
	{
		if(formateur.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		return daoCompte.save(formateur);
	}
	
	
	public Formateur updateJumeau(Integer id) 
	{
		Formateur formateur = getById(id);
		formateur.setPrenom(inverserVoyelles(formateur.getPrenom()));
		formateur.setNom(inverserVoyelles(formateur.getNom()));
		return daoCompte.save(formateur);
	}
	
	public void delete(Formateur formateur) 
	{
		daoCompte.delete(formateur);
	}
	public void deleteById(Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
	
	protected static String inverserVoyelles(String mot) {
        char[] voyelles = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};
        StringBuilder resultat = new StringBuilder(mot);
        int debut = 0;
        int fin = mot.length() - 1;

        while (debut < fin) {
            while (debut < fin && !estVoyelle(mot.charAt(debut), voyelles)) {
                debut++;
            }
            while (debut < fin && !estVoyelle(mot.charAt(fin), voyelles)) {
                fin--;
            }

            if (debut < fin) {
                char temp = resultat.charAt(debut);
                resultat.setCharAt(debut, resultat.charAt(fin));
                resultat.setCharAt(fin, temp);
                debut++;
                fin--;
            }
        }
        return resultat.toString();
    }

    protected static boolean estVoyelle(char c, char[] voyelles) {
        for (char voyelle : voyelles) {
            if (c == voyelle) {
                return true;
            }
        }
        return false;
    }
}
