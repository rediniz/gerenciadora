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

import br.com.caelum.tarefa.jdbc.ConnectionFactory;
import br.com.gerenciadora.modelo.Veiculo;

public class VeiculoDAO {
	Connection connection;
	EntityManagerFactory factory;
	EntityManager manager;

	public VeiculoDAO() {
		this.connection = new ConnectionFactory().getConnectionPostgreSQL();
		factory = Persistence.createEntityManagerFactory("veiculos");
		manager = factory.createEntityManager();

	}

	public void adiciona(Veiculo veiculo) {

		manager.getTransaction().begin();
		manager.persist(veiculo);

		manager.getTransaction().commit();
		manager.close();
	}

	public void remove(int id) {
		Veiculo v = manager.find(Veiculo.class, id);
		manager.getTransaction().begin();
		manager.remove(v);

		manager.getTransaction().commit();
		manager.close();

	}

	public void altera(Veiculo veiculo) {
		manager.getTransaction().begin();
		manager.merge(veiculo);

		manager.getTransaction().commit();
		manager.close();
	}

	public Veiculo buscaPorId(int id) {

		manager.getTransaction().begin();
		Veiculo veiculo = (Veiculo) manager.find(Veiculo.class, id);

		manager.getTransaction().commit();
		manager.close();

		return veiculo;

	}

	public List<Veiculo> veiculosCliente(int id) {

		try {
			List<Veiculo> veiculos = new ArrayList<Veiculo>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from veiculos where cliente_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("id"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setAno_fabricacao(rs.getInt("ano_fabricacao"));
				veiculo.setAno_modelo(rs.getInt("ano_modelo"));
				veiculo.setCliente_id(rs.getInt("cliente_id"));

				// adicionar objeto a lista
				veiculos.add(veiculo);
			}
			rs.close();
			stmt.close();
			return veiculos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean checaPlaca(String placa) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from veiculos where placa = ?");

			stmt.setString(1, placa);

			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
