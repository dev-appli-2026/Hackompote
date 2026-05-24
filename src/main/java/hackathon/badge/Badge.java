package hackathon.badge;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idBadge")
@Table("badge")
public class Badge {

    @Id
    @Column("id_badge")
    private Long idBadge;

    @Column("nom_badge")
    private String nomBadge;

    @Column("icone_url")
    private String iconeUrl;
}