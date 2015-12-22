package br.com.gerenciadora.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.gerenciadora.modelo.Cliente;

public interface ClienteDAO {

	public void adiciona(Cliente cliente);

	public List<Cliente> lista();

	public void remove(int id);

	public void altera(Cliente cliente);

	public Cliente buscaPorId(int id);

}
