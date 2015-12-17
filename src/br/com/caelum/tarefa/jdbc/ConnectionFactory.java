package br.com.caelum.tarefa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnectionPostgreSQL() {
		try {
			Class.forName("org.postgresql.Driver");
			DriverManager.registerDriver(new org.postgresql.Driver());
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost/gerenciadora", "postgres", "admin"); // Editar com nome do banco/usuário/senha corretos
		} catch (SQLException exc) {
			throw new RuntimeException(exc);

		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new RuntimeException(exc);
		}
	}
}
