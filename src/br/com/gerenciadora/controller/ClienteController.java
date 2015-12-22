package br.com.gerenciadora.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.gerenciadora.dao.ClienteDAO;
import br.com.gerenciadora.dao.VeiculoDAO;
import br.com.gerenciadora.modelo.Cliente;


@Controller
@Transactional
public class ClienteController {
	
	@Autowired
	ClienteDAO dao;
	@Autowired
	VeiculoDAO vdao;

	
	@RequestMapping("novoCliente")
	public String form() {
	return "cliente/adiciona";
	}
	
	@RequestMapping("adicionaCliente")
	public String adiciona(@Valid Cliente cliente, BindingResult result) {
		if(result.hasFieldErrors()) {
			return "cliente/adiciona";
		}
		dao.adiciona(cliente);
		return "redirect:listaClientes";
	}
	
	@RequestMapping("listaClientes")
	public String lista(Model model) {
		model.addAttribute("clientes",dao.lista());
		return "cliente/lista";
	}
	
	@RequestMapping("removeCliente")
	public String remove(int id) {
		dao.remove(id);
		return "cliente/lista";
	}
	
	@RequestMapping("mostraCliente")
	public String mostra(int id, Model model) {
		model.addAttribute("cliente", dao.buscaPorId(id));
		model.addAttribute("veiculos",vdao.veiculosCliente(id));
		return "cliente/mostra";
	}
	
	@RequestMapping("alteraCliente")
	public String altera(@Valid Cliente cliente, BindingResult result) {
		if(result.hasFieldErrors()) {
			return "cliente/mostra";
		}
		dao.altera(cliente);
		
		return "redirect:listaClientes";
	}
	
	
}
