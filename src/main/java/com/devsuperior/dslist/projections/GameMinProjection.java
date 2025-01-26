package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	// Metodos de get para cada retorno da consulta
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
