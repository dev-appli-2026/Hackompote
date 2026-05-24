package hackathon.equipe;

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
@EqualsAndHashCode( of = { "idEquipe" } )
@Table("badge")
public class Equipe {

    // -------
    // Champs
    // -------

    @Id
    private Long	idEquipe;
    private String	nomEquipe;
    private String	lienLivrable;

}
