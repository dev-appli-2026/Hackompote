package hackathon.equipe;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idEquipe" } )
public class Equipe {

    // -------
    // Champs
    // -------

    @Id
    private Long	idEquipe;
    private String	nomEquipe;
    private String	lienLivrable;

}
