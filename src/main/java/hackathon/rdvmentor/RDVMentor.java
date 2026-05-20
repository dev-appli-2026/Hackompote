package hackathon.rdvmentor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idRDV" } )
public class RDVMentor {

    // -------
    // Champs
    // -------

    @Id
    private Long	idRDV;
    private String	dateHeure; // A mettre en tant que date
    private String	statuRDV;

}
