package hackathon.db;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import hackathon.StartWebServer;

@SpringBootTest( classes = { StartWebServer.class } )
@TestMethodOrder( MethodOrderer.MethodName.class )
public class Init_DB {

	@Test
	@Sql( "/db/sql/1-tables.sql" )
	void db_1_Tables() {
	}

	@Test
	@Sql( value = "/db/sql/2-procedures.sql", config = @SqlConfig( separator = "\n\n" ) )
	void db_2_Procedures() {
	}

	@Test
	@Sql( "/db/sql/3-data.sql" )
	void db_3_Data() {
	}

}
