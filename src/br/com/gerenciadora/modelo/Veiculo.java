package br.com.gerenciadora.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_seq_gen")
	@SequenceGenerator(name = "clientes_seq_gen", sequenceName = "clientes_id_seq")
	private int id;
	@NotNull (message="Placa não pode ser nula")
	@Size(max=7, message="Placa deve ter no máximo 7 caracteres")
	private String placa;
	@NotNull (message="Ano de fabricação não pode ser nulo")
	private Integer ano_fabricacao;
	@NotNull (message="Ano do modelo não pode ser nulo")
	private Integer ano_modelo;
	@NotNull
	private Integer cliente_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(Integer ano_fabricao) {
		this.ano_fabricacao = ano_fabricao;
	}
	public Integer getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(Integer ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

}
