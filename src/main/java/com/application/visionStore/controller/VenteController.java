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

import com.application.visionStore.model.Vente;
import com.application.visionStore.repository.VenteRepository;

@RestController
@RequestMapping
public class VenteController {

	@Autowired
	VenteRepository venteRepository;

	// Get All Vente
	@GetMapping("/ventes")
	public List<Vente> getAllVentes() {
		return venteRepository.findAll();
	}

	// Create a new Vente
	@PostMapping("/ventes")
	public Vente createVente(@Valid @RequestBody Vente vente) {
		return venteRepository.save(vente);
	}

	// Update a Vente
	@PutMapping("/ventes/{id}")
	public Vente updateVente(@PathVariable(value = "id") Long venteId,
			@Valid @RequestBody Vente venteDetails) {

		Vente updatedVente = venteRepository.save(venteDetails);
		return updatedVente;
	}

	// Delete a Vente
	@DeleteMapping("/ventes/{id}")
	public void deleteVente(@PathVariable long id) {
		venteRepository.deleteById(id);
	}	
}
