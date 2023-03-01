package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static Connection con;

	public static Connection getConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=QLBH;Username=sa;Password =dangnam;encrypt=true;trustServerCertificate=true;");

			//"jdbc:sqlserver://192.168.1.50;databaseName=qltuyensinh10;Username=sa;Password =dangnam;encrypt=true;trustServerCertificate=true;"
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
