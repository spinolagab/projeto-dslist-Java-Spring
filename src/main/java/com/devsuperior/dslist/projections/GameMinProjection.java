package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	// Metodos de get para cada retorno da consulta
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
