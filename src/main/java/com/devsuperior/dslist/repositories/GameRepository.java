package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

// Usar as operacoes prontas do JpaRepository
public interface GameRepository extends JpaRepository<Game, Long> {
	
}
