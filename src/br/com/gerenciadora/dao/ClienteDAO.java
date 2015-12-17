package br.com.gerenciadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefa.jdbc.ConnectionFactory;
import br.com.gerenciadora.modelo.Cliente;
import br.com.gerenciadora.modelo.Veiculo;

public class ClienteDAO {
	Connection connection;
	EntityManagerFactory factory;
	EntityManager manager;

	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnectionPostgreSQL();
		factory = Persistence.createEntityManagerFactory("clientes");
		manager = factory.createEntityManager();

	}

	public void adiciona(Cliente cliente) {

		manager.getTransaction().begin();
		manager.persist(cliente);

		manager.getTransaction().commit();
		manager.close();
	}

	public List<Cliente> lista() {

		try{
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from clientes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto cliente
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				
				//adicionar objeto a lista
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		Cliente c = manager.find(Cliente.class, id);
		manager.getTransaction().begin();
		manager.remove(c);

		manager.getTransaction().commit();
		manager.close();

	}

	public void altera(Cliente cliente) {
		
		manager.getTransaction().begin();
		manager.merge(cliente);

		manager.getTransaction().commit();
		manager.close();
	}

	public Cliente buscaPorId(int id) {

		manager.getTransaction().begin();
		Cliente cliente = (Cliente) manager.find(Cliente.class, id);

		manager.getTransaction().commit();
		manager.close();

		return cliente;

	}
}
