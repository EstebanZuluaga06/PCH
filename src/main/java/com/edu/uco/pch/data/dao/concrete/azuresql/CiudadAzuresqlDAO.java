package com.edu.uco.pch.data.dao.concrete.azuresql;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.apache.logging.log4j.util.StringBuilders;

import com.edu.uco.pch.data.dao.concrete.SqlConnection;
import com.edu.uco.pch.data.dao.entity.List;
import com.edu.uco.pch.data.dao.entity.PaisDAO;
import com.edu.uco.pch.entity.CiudadEntity;
import com.edu.uco.pch.entity.PaisEntity;

public class CiudadAzuresqlDAO extends SqlConnection implements PaisDAO{

	@Override
	public List<CiudadEntity> consultar(PaisEntity data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public final void crear(final CiudadEntity data) {
		final StringBuilder setenciaSql = new StringBuilder();
		
		setenciaSql.append("INSERT INTO Ciudad ( id, nombre, departamento");
		setenciaSql.append("SELEC ?, ?, ?");
		
		setenciaSqlPreparada.setObject(1, data.getId());
		setenciaSqlPreparada.setString(2, data.getNombre());
		setenciaSqlPreparada.setObject(3, data.getDepartamento().getId());
		setenciaSqlPreparada.executeUpdate();
		

		try (final PreparedStatement SetenciaSqlPreparada = getConexion() )
		{
			
		}catch (Exception excepcion) {
			
		}
		
		
	}


}
