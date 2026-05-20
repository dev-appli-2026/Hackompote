package hackathon.sponsor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idSponsor" } )
public class Sponsor {

    // -------
    // Champs
    // -------

    @Id
    private Long	idSponsor;
    private String	nomEntreprise;
    private String	niveauPartenariat;

}
