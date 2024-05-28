package com.edu.uco.pch.crosscutting.exceptions;

import com.edu.uco.pch.crosscutting.exceptions.enums.Lugar;
import com.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import com.edu.uco.pch.crosscutting.helpers.TextHelper;

public class PCHException extends RuntimeException {

	private static final long serialVersionUID = -5855680087714145843L;
	protected String mensajeUsuario;
	protected Lugar lugar;

	public PCHException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar,
			final Throwable exeptionRaiz) {
		super(mensajeTecnico, exeptionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	public PCHException(final String mensajeUsuario, final Lugar lugar) {
		super(mensajeUsuario);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	public PCHException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar) {
		super(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario); 
		setLugar(lugar);
	}

	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}

	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjecHelper().getDefaultValue(lugar, Lugar.DEFAULT);
	}

	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public final Lugar getLugar() {
		return lugar;
	}

}
