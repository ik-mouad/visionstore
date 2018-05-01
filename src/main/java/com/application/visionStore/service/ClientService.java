package com.application.visionStore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.visionStore.model.Client;
import com.application.visionStore.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> searchByAll(String keyword) {

		List<Client> clients = clientRepository.findAll();
		
		return clients.stream()
				.filter(client ->  client.getNom().toLowerCase().contains(keyword.toLowerCase()) 
						|| client.getPrenom().toLowerCase().contains(keyword.toLowerCase())
						|| client.getTel().toLowerCase().contains(keyword.toLowerCase())
						|| client.getNumFiche().toLowerCase().contains(keyword.toLowerCase()))
					.collect(Collectors.toList());
	}
}
