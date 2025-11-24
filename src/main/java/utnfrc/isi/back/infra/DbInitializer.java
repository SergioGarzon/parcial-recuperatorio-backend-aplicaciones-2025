package utnfrc.isi.back.infra;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import org.h2.tools.RunScript;

public class DbInitializer {
    
    private static final String URL  = "jdbc:h2:mem:backdb;DB_CLOSE_DELAY=-1;MODE=LEGACY";
    private static final String USER = "sa";
    private static final String PASS = "";

    private static final String DDL_CLASSPATH = "/sql/database-ddl.sql";

    private DbInitializer() {        
    }
    
    public static void recreateSchemaFromDdl() {
       
        try (Connection cn = DriverManager.getConnection(URL, USER, PASS)) {
            var in = DbInitializer.class.getResourceAsStream(DDL_CLASSPATH);
            if (in == null) {
                throw new IllegalStateException("No se encontró el recurso " + DDL_CLASSPATH +
                        " en el classpath (¿está en src/main/resources/sql/database-ddl.sql?).");
            }
            try (var reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
                // Ejecuta TODO el script (soporta ;, CRLF, comentarios, etc.)
                RunScript.execute(cn, reader);
            }
            // Validación rápida: asegurar que la secuencia existe
            try (var ps = cn.prepareStatement(
                    "SELECT COUNT(*) FROM INFORMATION_SCHEMA.SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_ARTIST_ID'")) {
                try (var rs = ps.executeQuery()) {
                    rs.next();
                    if (rs.getInt(1) == 0) {
                        throw new IllegalStateException("La secuencia SEQ_ARTIST_ID no existe tras correr el DDL. " +
                                "Revisá el contenido del ddl.sql.");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error ejecutando DDL con RunScript", e);
        }
        
    }

    

    

}
