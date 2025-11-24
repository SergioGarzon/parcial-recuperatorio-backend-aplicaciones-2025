package utnfrc.isi.back.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public final class LocalEntityManagerProvider {
    
    
    private static final String PU = "pu-backend";
    private static final EntityManagerFactory EMF;

    static {
        // Configurar el EntityManagerFactory para usar el DataSource
        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.datasource", DataSourceProvider.getDataSource());

        // Recrear el esquema desde el DDL
        DbInitializer.recreateSchemaFromDdl();

        // Crear el EntityManagerFactory con las propiedades personalizadas
        EMF = Persistence.createEntityManagerFactory(PU, properties);
    }

    private LocalEntityManagerProvider() {}

    public static EntityManager em() {
        return EMF.createEntityManager();
    }

    public static void close() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }

}
