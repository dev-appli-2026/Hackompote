package hackathon.utilisateur.repository;

import hackathon.utilisateur.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Utilisateur findByAdresseMail(String adresseMail);

    Utilisateur findByPseudo(String pseudo);

    boolean existsByAdresseMail(String adresseMail);

    boolean existsByPseudo(String pseudo);

}