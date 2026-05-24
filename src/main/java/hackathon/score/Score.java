package hackathon.score;

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
@EqualsAndHashCode( of = { "idScore" } )
@Table("badge")
public class Score {

    // -------
    // Champs
    // -------

    @Id
    private Long	idScore;
    private int	    valeurScore;
    private String	critereEvaluation;
    private String	commentaire;

}
