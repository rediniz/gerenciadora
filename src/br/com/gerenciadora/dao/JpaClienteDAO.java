package br.com.gerenciadora.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import br.com.gerenciadora.modelo.Cliente;

@Component
@Repository
public class JpaClienteDAO implements ClienteDAO{

	@PersistenceContext
	EntityManager manager;

	public void adiciona(Cliente cliente) {

		manager.persist(cliente);
	}

	public List<Cliente> lista() {

		return manager.createQuery("select c from Cliente c").getResultList();

	}

	public void remove(int id) {
		Cliente c = manager.find(Cliente.class, id);
		manager.remove(c);


	}

	public void altera(Cliente cliente) {		
		manager.merge(cliente);
	}

	public Cliente buscaPorId(int id) {

		return manager.find(Cliente.class, id);

	}
}
