package com.edu.uco.pch.dto;

import java.util.UUID;

import com.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import com.edu.uco.pch.crosscutting.helpers.TextHelper;
import com.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public final class CiudadDTO {
	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;

	public CiudadDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setDepartamento(DepartamentoDTO.build());
	}

	public CiudadDTO(final UUID id, final String nombre, final DepartamentoDTO departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}

	public static final CiudadDTO build() {
		return new CiudadDTO();
	}

	public final UUID getId() {
		return id;
	}

	public final CiudadDTO setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final CiudadDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public final DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public final CiudadDTO setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = ObjectHelper.getObjecHelper().getDefaultValue(departamento, new DepartamentoDTO());
		return this;
	}

}