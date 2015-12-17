package br.com.gerenciadora.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.gerenciadora.dao.ClienteDAO;
import br.com.gerenciadora.dao.VeiculoDAO;
import br.com.gerenciadora.modelo.Cliente;


@Controller
public class ClienteController {
	

	
	@RequestMapping("novoCliente")
	public String form() {
	return "cliente/adiciona";
	}
	
	@RequestMapping("adicionaCliente")
	public String adiciona(@Valid Cliente cliente, BindingResult result) {
		if(result.hasFieldErrors()) {
			return "cliente/adiciona";
		}
		ClienteDAO dao = new ClienteDAO();
		dao.adiciona(cliente);
		return "redirect:listaClientes";
	}
	
	@RequestMapping("listaClientes")
	public String lista(Model model) {
		ClienteDAO dao = new ClienteDAO();
		model.addAttribute("clientes",dao.lista());
		return "cliente/lista";
	}
	
	@RequestMapping("removeCliente")
	public String remove(int id) {
		ClienteDAO dao = new ClienteDAO();
		dao.remove(id);
		return "cliente/lista";
	}
	
	@RequestMapping("mostraCliente")
	public String mostra(int id, Model model) {
		ClienteDAO cdao = new ClienteDAO();
		model.addAttribute("cliente", cdao.buscaPorId(id));
		VeiculoDAO vdao = new VeiculoDAO();
		model.addAttribute("veiculos",vdao.veiculosCliente(id));
		return "cliente/mostra";
	}
	
	@RequestMapping("alteraCliente")
	public String altera(@Valid Cliente cliente, BindingResult result) {
		if(result.hasFieldErrors()) {
			return "cliente/mostra";
		}
		ClienteDAO dao = new ClienteDAO();
		dao.altera(cliente);
		
		return "redirect:listaClientes";
	}
	
	
}
