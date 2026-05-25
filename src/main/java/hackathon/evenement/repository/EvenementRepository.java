package hackathon.evenement.repository;

import hackathon.evenement.entity.Evenement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface EvenementRepository extends CrudRepository<Evenement, Long> {

    Evenement findByIdEvenement(Long idEvenement);

    Evenement findByNom(String nom);

    Iterable<Evenement> findAll();

    // Requete pour avoir les n evenment les plus proches
    List<Evenement> findAllByStatutEventOrderByDateDebutAsc(String statut, Pageable pageable);

}