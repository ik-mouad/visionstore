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

import com.application.visionStore.model.Achat;
import com.application.visionStore.repository.AchatRepository;


@RestController
@RequestMapping
public class AchatController {

	@Autowired
	AchatRepository achatRepository;

	// Get All Achat
	@GetMapping("/achats")
	public List<Achat> getAllAchats() {
		return achatRepository.findAll();
	}

	// Create a new Achat
	@PostMapping("/achats")
	public Achat createAchat(@Valid @RequestBody Achat achat) {
		return achatRepository.save(achat);
	}

	// Update a Achat
	@PutMapping("/achats/{id}")
	public Achat updateAchat(@PathVariable(value = "id") Long achatId,
			@Valid @RequestBody Achat achatDetails) {

		Achat updatedAchat = achatRepository.save(achatDetails);
		return updatedAchat;
	}

	// Delete a Achat
	@DeleteMapping("/achats/{id}")
	public void deleteAchat(@PathVariable long id) {
		achatRepository.deleteById(id);
	}

}
