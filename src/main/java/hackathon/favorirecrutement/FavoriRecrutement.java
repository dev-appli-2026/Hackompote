package hackathon.favorirecrutement;

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
@EqualsAndHashCode( of = { "idFavori" } )
@Table("badge")
public class FavoriRecrutement {

    // -------
    // Champs
    // -------

    @Id
    private Long	idFavori;
    private String	noteInterne;

}
