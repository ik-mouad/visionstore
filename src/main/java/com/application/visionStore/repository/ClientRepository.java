package com.application.visionStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.visionStore.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
