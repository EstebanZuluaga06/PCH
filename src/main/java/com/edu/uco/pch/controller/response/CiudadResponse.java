package com.edu.uco.pch.controller.response;

import java.util.ArrayList;

import com.edu.uco.pch.dto.CiudadDTO;

public class CiudadResponse extends Response<CiudadDTO>{
	
	public CiudadResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
		
	}

}
