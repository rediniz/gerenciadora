package br.com.gerenciadora.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_seq_gen")
	@SequenceGenerator(name = "clientes_seq_gen", sequenceName = "clientes_id_seq", allocationSize = 1 )
	@Column(name = "id")
	private int id;	
	@NotNull (message = "Nome não pode ser nulo")
	@Size(min=1,max=80, message="Nome não pode ser nulo e deve ter no máximo 80 caracteres")
	@Column(name="nome", nullable = false) 
	private String nome;
	@NotNull
	@Size(min=1,max=80, message="Endereço não pode ser nulo e deve ter no máximo 80 caracteres")
	private String endereco;
	@NotNull
	@Size(min=1,max=80, message="Bairro não pode ser nulo e deve ter no máximo 45 caracteres")
	private String bairro;
	@NotNull
	@Size(min=1, max=8, message="CEP não pode ser nulo e deve ter no máximo 8 caracteres")
	private String cep;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
