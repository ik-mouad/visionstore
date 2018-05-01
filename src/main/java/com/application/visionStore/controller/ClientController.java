package com.application.visionStore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.visionStore.model.Client;
import com.application.visionStore.repository.ClientRepository;
import com.application.visionStore.service.ClientService;

@RestController
@RequestMapping
public class ClientController {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientService clientService;

	// Get All Client
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	// Create a new Client
	@PostMapping("/clients")
	public Client createClient(@Valid @RequestBody Client client) {
		return clientRepository.save(client);
	}

	// Update a Client
	@PutMapping("/clients/{id}")
	public Client updateClient(@PathVariable(value = "id") Long clientId,
			@Valid @RequestBody Client clientDetails) {

		Client updatedClient = clientRepository.save(clientDetails);
		return updatedClient;
	}

	// Delete a Client
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable long id) {
		clientRepository.deleteById(id);
	}

	@GetMapping("/clients/{keyword}")
	public List<Client> search(@PathVariable String keyword) {
		
		return clientService.searchByAll(keyword);
	}	
}
