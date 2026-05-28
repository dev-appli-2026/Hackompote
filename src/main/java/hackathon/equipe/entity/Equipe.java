package hackathon.equipe.entity;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "idEquipe" } )
@Table("equipe")
public class Equipe {
    
    @Id
    private Long	idEquipe;
    private String	nomEquipe;
    private String	lienLivrable;

}
