package hackathon.evenement.entity;

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
@EqualsAndHashCode( of = { "idEvenement" } )
@Table("evenement")
public class Evenement {

    @Id
    private Long	    idEvenement;
    private String	    nom;
    private LocalDate   dateDebut;
    private LocalDate	dateFin;
    private int         dureeHeures;
    private int         nbMaxParEquipe;
    private String	    statutEvent;
    private String	    localisationGeo;
    private String      lienBilletterie;

}
