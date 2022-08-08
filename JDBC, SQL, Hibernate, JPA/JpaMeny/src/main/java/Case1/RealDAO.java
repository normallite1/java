package Case1;

import java.sql.Connection;

public class RealDAO extends AbstractDAO {

    public RealDAO(Connection conn, String table) {
        super(conn, table);
    }
}
