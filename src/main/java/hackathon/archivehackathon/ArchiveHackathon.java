package hackathon.archivehackathon;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idArchiveHackathon" } )
public class ArchiveHackathon {

    // -------
    // Champs
    // -------

    @Id
    private Long	idArchiveHackathon;
    private String	nomEvenement;
    private String	dateHackathon; // A mettre en tant que date
    private String	sujetTraite;
    private String	nomEquipeGagnante;
    private String	dateArchivage; // A mettre en tant que date

}
