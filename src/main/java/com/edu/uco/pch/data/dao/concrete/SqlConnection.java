package com.edu.uco.pch.data.dao.concrete;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

import com.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import com.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;

	public class SqlConnection {
	
	protected SqlConnection(final Connection conexion) {
		setConexion(conexion);
	}
	private Connection conexion;
	protected final Connection getConexion){
		return conexion;
	}
	protected final void setConexion (final Connection conexion) {
		if (!isOpen(conexion)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear el DAO deseado con una conexion cerrada";
	}
	

}
