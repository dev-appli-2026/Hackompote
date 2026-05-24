package hackathon.sujet;

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
@EqualsAndHashCode( of = { "idSujet" } )
@Table("badge")
public class Sujet {

    // -------
    // Champs
    // -------

    @Id
    private Long	idSujet;
    private String	titre;
    private String	descriptionDetaillee;
    private String	technologiesRequises;

}
