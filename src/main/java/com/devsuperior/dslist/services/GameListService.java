package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		// retorno tambem pode ser feito usando result.stream().map(x -> new GameListDTO(x)).toList()
		// retorna uma lista de GameListDTO
		return result.stream().map(GameListDTO::new).toList();
	}
	
	
	// Atualizar posicoes da lista
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		// lista com os elementos
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		// remove o objeto da posicao anterior e insere ele na posicao nova fazendo as alteracoes necessarias
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		// atualiza o ID apenas das posicoes dentro do intervalo
		int min = sourceIndex < destinationIndex ?sourceIndex : destinationIndex;
		int max = sourceIndex > destinationIndex ?sourceIndex : destinationIndex;
		
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
		
	}
}
