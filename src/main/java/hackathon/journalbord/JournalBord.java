package hackathon.journalbord;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idJournal" } )
public class JournalBord {

    // -------
    // Champs
    // -------

    @Id
    private Long	idJournal;
    private String	description;
    private String	dateEntree;  // A mettre en tant que date


}
