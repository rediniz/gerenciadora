package br.com.gerenciadora.controller;

import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.gerenciadora.dao.VeiculoDAO;
import br.com.gerenciadora.modelo.Veiculo;


@Controller
@Transactional
public class VeiculoController {
	
	@Autowired
	VeiculoDAO dao;
	

	@RequestMapping("novoVeiculo")
	public String form(int id, Model model) {
		model.addAttribute("cliente_id", id);
	return "veiculo/adiciona";
	}

	@RequestMapping("adicionaVeiculo")
	public String adiciona(@Valid Veiculo veiculo, BindingResult result) {
		if(result.hasFieldErrors()) {
			return "veiculo/adiciona";
		}
		dao.adiciona(veiculo);
		return "redirect:mostraCliente?id="+veiculo.getCliente_id();
	}
	
	
	@RequestMapping("removeVeiculo")
	public String remove(int id) {
		dao.remove(id);
		return "cliente/mostra";
	}
	
	@RequestMapping("mostraVeiculo")
	public String mostra(int id, Model model) {
		model.addAttribute("veiculo", dao.buscaPorId(id));
		return "veiculo/mostra";
	}
	
	@RequestMapping("alteraVeiculo")
	public String altera(@Valid Veiculo veiculo, Model model, BindingResult result) {
		
		if(result.hasFieldErrors()) {
			return "veiculo/mostra";
		}
		dao.altera(veiculo);
		model.addAttribute(veiculo.getCliente_id());
		return "redirect:mostraCliente?id="+veiculo.getCliente_id();
	}
	
	@RequestMapping("veiculosCliente")
	public String veiculosCliente(int id, Model model) {
		model.addAttribute("veiculos",dao.veiculosCliente(id));
		return "cliente/lista";
	}
	
	@RequestMapping("checaPlaca")
	@ResponseBody
	public String checaPlaca(String placa, Model model) {
		if(dao.checaPlaca(placa)){
			return "true";
		}else{
			return "false";
		}		
	}	
}
