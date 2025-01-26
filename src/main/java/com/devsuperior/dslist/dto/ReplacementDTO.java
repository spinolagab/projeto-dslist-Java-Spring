package com.devsuperior.dslist.dto;

public class ReplacementDTO {
	
	
	// A operacao de troca eh um post que possui um body em json
	// entao precisa de um DTO para receber as informacoes
	
	private Integer sourceIndex;
	private Integer destinationIndex;
	
	// Getters e Setters
	
	public Integer getSourceIndex() {
		return sourceIndex;
	}
	
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	
	public Integer getDestinationIndex() {
		return destinationIndex;
	}
	
	public void setDestinationIndex(Integer destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
	
	
	
}
