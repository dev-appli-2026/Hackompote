package hackathon.utilisateur;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idUtilisateur" } )
@Table(name = "utilisateur", schema = "hackompote")
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
    private String	dateNaissance; // A mettre en tant que date
    @Transient
    private String	motDePasse;
    private String	empreinteMdp;
    private String	role;
    private String	lienCv;
    private String	competencesCles;
    private boolean	statutRecherche;

}
