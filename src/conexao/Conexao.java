package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	public static Connection conn = null;
	
	public static Connection criarConexao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.1/teste_jdbc", "root", "");
			
			
		}catch(SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
		return conn;
	}

}
