package ifpi.capar.escola.professor.controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
    
    public class Banco {
	
	private static final String DRIVER_BANCO = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1/escola-professor?serverTimezone=America/New_York";
	private final static String USUARIO = "root";
	private final static String SENHA = "";

	static Connection conexao;
	
	
	public static Connection getConexao() {
		try {
			
			Class.forName(DRIVER_BANCO);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			return conexao;
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do banco não encontrada.");
		}
		
		return null;
	}
	
	public static void fecharConexao() {
		try {
			
			conexao.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
    }

