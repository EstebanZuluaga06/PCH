package com.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import com.edu.uco.pch.crosscutting.exceptions.custom.CroscuttingPCHException;
import com.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessegeCatalog;
import com.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import com.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import com.edu.uco.pch.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessegeCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
 
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
				"Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
				"Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentado realizar el cierre de una conexión SQL que ya estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00010.getIdentificador(), new Mensaje(CodigoMensaje.M00010,
				"Se ha presentado un problema tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00011.getIdentificador(), new Mensaje(CodigoMensaje.M00011,
				"Se ha presentado un problema INESPERADO tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00012.getIdentificador(), new Mensaje(CodigoMensaje.M00012,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00013.getIdentificador(), new Mensaje(CodigoMensaje.M00013,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00014.getIdentificador(), new Mensaje(CodigoMensaje.M00014,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00015.getIdentificador(), new Mensaje(CodigoMensaje.M00015,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00016.getIdentificador(), new Mensaje(CodigoMensaje.M00016,
				"Se ha intentado cancelar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00017.getIdentificador(), new Mensaje(CodigoMensaje.M00017,
				"Se ha intentado cancelar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00018.getIdentificador(), new Mensaje(CodigoMensaje.M00018,
				"Se ha presentado un problema tratando de cancelar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00019.getIdentificador(), new Mensaje(CodigoMensaje.M00019,
				"Se ha presentado un problema INESPERADO tratando de cancelar una transacción SQL con la fuente de información deseada..."));
 
		mensajes.put(CodigoMensaje.M00020.getIdentificador(), new Mensaje(CodigoMensaje.M00020,
				"Se ha intentado iniciar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00021.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00022.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema INESPERADO tratando de iniciar una transacción SQL con la fuente de información deseada..."));
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {

		if (ObjectHelper.getObjecHelper().isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CroscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}

		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
			throw new CroscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}

		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
			throw new CroscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}

		return mensajes.get(codigo.getIdentificador());
	}

}
