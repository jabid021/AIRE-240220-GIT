package fr.formation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, String> {
    public List<Commentaire> findAllByProduitId(String produitId);

    @Query("select c from Commentaire c where c.produitId = ?1")
    public List<Commentaire> findAllByProduitIdQuery(String produitId);

    @Query("select c from Commentaire c where c.produitId = :produitId")
    public List<Commentaire> findAllByProduitIdQueryParams(@Param("produitId") String produitId);

    @Query("select AVG((c.noteQuality + c.notePrice + c.noteEase) / 3) from Commentaire c where c.produitId = ?1")
    public Optional<Integer> getNoteMoyenneByProduitId(String produitId);
}