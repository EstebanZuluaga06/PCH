package com.edu.uco.pch.business.usecase.impl.ciudad;

import com.edu.uco.pch.business.domain.CiudadDomain;
import com.edu.uco.pch.business.usecase.UseCaseWithRurn;
import com.edu.uco.pch.business.usecase.UseCaseWithouReturn;

public class ConsultarCiudadades implements UseCaseWithRurn<CiudadDomain, List<Ciudad>>{
	private DAOFactory factory;
	public RegistrarCiudad (final DAOFactory factory) {
		if(ObjetHelper.getObjetcHelper().isNull(factory)) {
		var mensajeUsuario="dads";
		var mensajeTecnico="dads";
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuario);
		}
		this.factory = factory;
	}
	
	private final void validadCiudadMismoNombreDeparamento(final String nombreCiudad, final UUID idDepartamento) {
		var ciudadEntity = CiudadEntity.build().setNombre(nombreCiudad).setDepartamento(DepartamentoEntity.build().setId(idDepartamento));
		var resultados = factory.getCiudadDao().consultar(ciudadEntity);
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "Consultar Ciudad";
		throw 
		}
	}


}
