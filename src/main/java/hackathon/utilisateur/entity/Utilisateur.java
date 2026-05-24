package hackathon.utilisateur.entity;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idUtilisateur" } )
@Table("utilisateur")
public class Utilisateur {

    // -------
    // Champs
    // -------

    @Id
    private Long	idUtilisateur;
    private String	adresseMail;
    private String	nom;
    private String	prenom;
    private String	pseudo;
    private LocalDate dateNaissance;
    private String	motDePasse;
    private String	role;
    private String	lienCv;
    private String	competencesCles;
    private boolean	statutRecherche;

}

