package hackathon.badge;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idBadge" } )
public class Badge {

    // -------
    // Champs
    // -------

    @Id
    private Long	idBadge;
    private String	nomBadge;
    private String	iconeUrl;

}
