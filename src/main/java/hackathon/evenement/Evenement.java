package hackathon.evenement;

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
@EqualsAndHashCode( of = { "idEvenement" } )
@Table("badge")
public class Evenement {

    // -------
    // Champs
    // -------

    @Id
    private Long	idEvenement;
    private String	nom;
    private String	dateDebut;  // A mettre en tant que date
    private String	dateFin;    // A mettre en tant que date
    private int     dureeHeures;
    private int     nbMaxParEquipe;
    private String	statuEvent;
    private String	localisationGeo;
    private String  lienBilletterie;

}
