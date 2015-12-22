package br.com.gerenciadora.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import br.com.gerenciadora.modelo.Veiculo;
@Component
@Repository
public class JpaVeiculoDAO implements VeiculoDAO{

	@PersistenceContext
	EntityManager manager;

	public void adiciona(Veiculo veiculo) {
		manager.persist(veiculo);
	}

	public void remove(int id) {
		Veiculo v = manager.find(Veiculo.class, id);
		manager.remove(v);
	}

	public void altera(Veiculo veiculo) {
		manager.merge(veiculo);
	}

	public Veiculo buscaPorId(int id) {

		return manager.find(Veiculo.class, id);
	}

	public List<Veiculo> veiculosCliente(int id) {
		
		Query q = manager.createQuery("select v from Veiculo v where cliente_id = :id");
		q.setParameter("id", id);
		return q.getResultList();
		
	}

	public boolean checaPlaca(String placa) {
		Query q = manager.createQuery("select v from Veiculo v where placa = :placa");
		q.setParameter("placa", placa);
		return !q.getResultList().isEmpty();
	}

}
