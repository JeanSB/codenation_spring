package br.com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/lista")
	public  List<Cliente> listaCliente() {
		return clienteService.listarClientes();
	}
	
	
	
	
}
