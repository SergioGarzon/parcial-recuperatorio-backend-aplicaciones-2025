package utnfrc.isi.back.infra;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import org.h2.tools.RunScript;

public class DbInitializer {
    
    private static final String DDL_CLASSPATH = "/sql/database-ddl.sql";

    private DbInitializer() {}

    public static void recreateSchemaFromDdl() {
        try (Connection cn = DataSourceProvider.getDataSource().getConnection()) {
            var in = DbInitializer.class.getResourceAsStream(DDL_CLASSPATH);
            if (in == null) {
                throw new IllegalStateException("No se encontró el recurso " + DDL_CLASSPATH);
            }
            try (var reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
                RunScript.execute(cn, reader);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error ejecutando DDL con RunScript", e);
        }
    }    

}
