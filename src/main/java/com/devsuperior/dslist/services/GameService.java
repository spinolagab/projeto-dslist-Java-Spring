package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

// Registra o GameService como se fosse um componente do sistema
@Service
public class GameService {
	
	// O proprio spring resolve a dependencia
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		// Transforma a lista de games em uma lista de GameMinDTO
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}











