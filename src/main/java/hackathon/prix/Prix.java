package hackathon.prix;

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
@EqualsAndHashCode( of = { "idPrix" } )
@Table("badge")
public class Prix {

    // -------
    // Champs
    // -------

    @Id
    private Long	idPrix;
    private String	nomPrix;
    private String	recompense;

}
