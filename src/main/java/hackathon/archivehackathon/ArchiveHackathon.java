package hackathon.archivehackathon;

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
@EqualsAndHashCode( of = { "idArchiveHackathon" } )
@Table("archive_hackathon")
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
