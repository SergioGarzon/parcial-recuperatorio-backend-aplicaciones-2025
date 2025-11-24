package utnfrc.isi.back.infra;

import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;

public final class DataSourceProvider {

    private static final String URL = "jdbc:h2:mem:backdb;DB_CLOSE_DELAY=-1;MODE=LEGACY";
    private static final String USER = "sa";
    private static final String PASS = "";

    private DataSourceProvider() {
    }

    public static DataSource getDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASS);
        return dataSource;
    }
}
