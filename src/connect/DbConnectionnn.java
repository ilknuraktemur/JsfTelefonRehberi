package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionnn implements IDbConnectionnn {

	public Connection connectDatabase() {
		Connection dbConnection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			 dbConnection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=TelefonRehberi;integratedSecurity=true;",
					"DESKTOP-5JV4MDV\\q", "");

		} catch (Exception e) {
			System.out.println("Baþarýsýz");
		}
		
		return dbConnection;
	}

	public void closeDatabase(Connection dbConnection) {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
