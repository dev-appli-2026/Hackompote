package hackathon.utilisateur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface UtilisateurRepository extends ListCrudRepository<Utilisateur, Long>, ListPagingAndSortingRepository<Utilisateur, Long> {

    Utilisateur findByPseudo( String pseudo );

    Utilisateur findByAdresseMail( String adresseMail );

    Page<Utilisateur> findByPseudoContainingIgnoreCaseOrAdresseMailContainingIgnoreCase( String search,
                                                                              String search2, Pageable pageable );

    @Query( "SELECT COUNT(*)=0 FROM utilisateur WHERE pseudo = :pseudo AND id_utilisateur <> COALESCE(:id, 0)" )
    boolean verifierUnicitePseudo( String pseudo, Long id );

    @Query( "SELECT COUNT(*)=0 FROM utilisateur WHERE adresseMail = :adresseMail AND id_utilisateur <> COALESCE(:id, 0)" )
    boolean verifierUniciteEmail( String adresseMail, Long id );

}
