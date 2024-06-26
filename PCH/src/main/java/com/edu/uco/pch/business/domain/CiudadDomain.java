package com.edu.uco.pch.business.domain;

import java.util.UUID;

import com.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import com.edu.uco.pch.crosscutting.helpers.TextHelper;
import com.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public final class CiudadDomain {
	private UUID id;
	private String nombre;
	private DepartamentoDomain departamento;

	private CiudadDomain(final UUID id, final String nombre, final DepartamentoDomain departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}

	public static final CiudadDomain build(final UUID id, final String nombre, final DepartamentoDomain departamento) {
		return new CiudadDomain(id, nombre, departamento);
	}

	public static final CiudadDomain build(final UUID id) {
		return new CiudadDomain(id, TextHelper.EMPTY, DepartamentoDomain.build());
	}

	public static final CiudadDomain build() {
		return new CiudadDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, DepartamentoDomain.build());
	}

	private final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	private final void setDepartamento(final DepartamentoDomain departamento) {
		this.departamento = ObjectHelper.getObjecHelper().getDefaultValue(departamento, DepartamentoDomain.build());
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final DepartamentoDomain getDepartamento() {
		return departamento;
	}

}