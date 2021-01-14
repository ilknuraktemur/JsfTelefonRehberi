package connect;
import java.sql.Connection;

public interface IDbConnectionnn {
public Connection connectDatabase();
public void closeDatabase(Connection dbConnection);
}

