package hackathon.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
public class SqlScriptRunner implements CommandLineRunner {

    private final DataSource dataSource;

    public SqlScriptRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> sqlFiles = List.of(
                "db/sql/script/supression-table.sql",
                "db/sql/script/init.sql",
                "db/sql/script/12_users.sql",
                "db/sql/script/10_events.sql",
                "db/sql/script/6_badge.sql",
                "db/sql/script/10_sujets.sql",
                "db/sql/script/8_equipes.sql",
                "db/sql/script/12_inscription-evenement.sql",
                "db/sql/script/16_composer-equipe.sql",
                "db/sql/script/6_sponsor.sql",
                "db/sql/script/10_obtenir-badge.sql",
                "db/sql/script/8_rdv-mentor.sql",
                "db/sql/script/12_journal-bord.sql",
                "db/sql/script/5_prix.sql",
                "db/sql/script/6_favori-recrutement.sql",
                "db/sql/script/12_score.sql"
        );

        for (String file : sqlFiles) {
            executeSqlFile(file);
        }

        System.out.println("Tous les scripts SQL ont été exécutés avec succès.");
    }

    private void executeSqlFile(String path) {
        Resource resource = new ClassPathResource(path);

        if (!resource.exists()) {
            throw new IllegalArgumentException("Fichier SQL introuvable : " + path);
        }

        System.out.println("Exécution de : " + path);

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(false, false, "UTF-8", resource);
        populator.execute(dataSource);
    }
}