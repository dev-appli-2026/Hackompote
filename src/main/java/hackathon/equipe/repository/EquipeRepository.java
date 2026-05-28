package hackathon.equipe.repository;

import hackathon.equipe.entity.Equipe;
import hackathon.evenement.entity.Evenement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipeRepository extends CrudRepository<Equipe, Long> {


}