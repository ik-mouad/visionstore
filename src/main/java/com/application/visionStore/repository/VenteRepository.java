package com.application.visionStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.visionStore.model.Vente;

public interface VenteRepository extends JpaRepository<Vente, Long> {

}
