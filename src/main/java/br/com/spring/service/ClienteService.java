package br.com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.model.Cliente;
import br.com.spring.repository.ClienteRepository;

@Service
public class ClienteService {

	
	private final ClienteRepository clienteRepository;
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public void cadastrar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	
	
}
