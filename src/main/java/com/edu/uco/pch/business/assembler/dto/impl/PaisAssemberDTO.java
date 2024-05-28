package com.edu.uco.pch.business.assembler.dto.impl;

import com.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import com.edu.uco.pch.business.domain.PaisDomain;
import com.edu.uco.pch.dto.PaisDTO;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO>{

	private final static AssemblerDTO<PaisDomain, PaisDTO> instance = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance(){
		return instance;
	}
	
	@Override
	public final  PaisDomain toDomain(PaisDTO data) {
		var paisDTOTmp = getObjectHelper().getDefaultValue(data, PaisDTO.build());
		return PaisDomain.build(data.getId(),paisDTOTmp.getNombre());
		// TODO Auto-generated method stub
	}

	@Override
	public PaisDTO toDTO(PaisDomain domain) {
		var paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		// TODO Auto-generated method stub
		return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

}