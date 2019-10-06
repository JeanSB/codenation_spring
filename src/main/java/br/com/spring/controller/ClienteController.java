package br.com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.spring.model.Cliente;
import br.com.spring.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/formulario")
	public  String formulario() {
		return "cliente/formulario";
	}
	
	@PostMapping("/formulario")
	public String cadastrar(Cliente cliente) {
		clienteService.cadastrar(cliente);
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView listaCliente() {
		ModelAndView mv = new ModelAndView("cliente/listar");
		List<Cliente> clientes = clienteService.listarClientes();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	
	
	
}
