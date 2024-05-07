package com.edu.uco.pch.crosscutting.exceptions.messagecatalog;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

public interface MessageCatalog {
	void inicializar(); 
	
	String obtenerMensaje();

}
