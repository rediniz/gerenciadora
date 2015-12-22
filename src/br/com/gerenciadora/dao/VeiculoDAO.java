package br.com.gerenciadora.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gerenciadora.modelo.Veiculo;
@Service
public interface VeiculoDAO {
	
	public void adiciona(Veiculo veiculo);
	
	public void remove(int id);

	public void altera(Veiculo veiculo);

	public Veiculo buscaPorId(int id);

	public List<Veiculo> veiculosCliente(int id);

	public boolean checaPlaca(String placa);


}
