package hackathon.utilisateur.repository;

import hackathon.utilisateur.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Utilisateur findByAdresseMail(String adresseMail);

    Utilisateur findByPseudo(String pseudo);

    boolean existsByAdresseMail(String adresseMail);

    boolean existsByPseudo(String pseudo);

    // Requete pour avoir les
    List<Utilisateur> findAllByIdEquipe(int idEquipe);

    Utilisateur findAllByIdEquipeAndRole(int idEquipe, String role);


}