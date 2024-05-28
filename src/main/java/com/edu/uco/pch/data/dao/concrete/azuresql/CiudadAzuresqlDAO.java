package com.edu.uco.pch.data.dao.concrete.azuresql;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

import com.edu.uco.pch.data.dao.concrete.SqlConnection;
import com.edu.uco.pch.data.dao.entity.List;
import com.edu.uco.pch.data.dao.entity.PaisDAO;
import com.edu.uco.pch.entity.CiudadEntity;
import com.edu.uco.pch.entity.PaisEntity;

public class CiudadAzuresqlDAO extends SqlConnection implements PaisDAO{

	protected CiudadAzuresqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}
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
	@Override
	public List<PaisEntity> consultar(final PaisEntity data) {
	    final StringBuilder sentenciaSql = new StringBuilder();
	    sentenciaSql.append("SELECT id, nombre FROM Pais WHERE 1=1");

	    if (data != null) {
	        if (data.getId() != null) {
	            sentenciaSql.append(" AND id = ?");
	        }
	        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
	            sentenciaSql.append(" AND nombre = ?");
	        }
	    }

	    final List<PaisEntity> paises = new ArrayList<>();

	    try (final PreparedStatement sentenciaSqlPreparada = getConnection()
	            .prepareStatement(sentenciaSql.toString())) {

	        int index = 1;

	        if (data != null) {
	            if (data.getId() != null) {
	                sentenciaSqlPreparada.setObject(index++, data.getId());
	            }
	            if (!TextHelper.isNullOrEmpty(data.getNombre())) {
	                sentenciaSqlPreparada.setString(index++, data.getNombre());
	            }
	        }

	        try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
	            while (resultado.next()) {
	                PaisEntity pais = new PaisEntity();
	                pais.setId((UUID) resultado.getObject("id"));
	                pais.setNombre(resultado.getString("nombre"));
	                paises.add(pais);
	            }
	        }

	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar los países. Por favor, contacte al administrador del sistema.";
	        var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de los países en la tabla \"Pais\" de la base de datos Azure SQL.";

	        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar los países. Por favor, contacte al administrador del sistema.";
	        var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los países en la tabla \"Pais\" de la base de datos Azure SQL.";

	        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
	    }

	    return paises;
	}
	@Override
	public List<DepartamentoEntity> consultar(final DepartamentoEntity data) {
	    final StringBuilder sentenciaSql = new StringBuilder();
	    sentenciaSql.append("SELECT id, nombre, pais FROM Departamento WHERE 1=1");

	    if (!ObjectHelper.getObjecHelper().isNull(data.getId())) {
	        sentenciaSql.append(" AND id = ?");
	    }
	    if (!TextHelper.isNullOrEmpty(data.getNombre())) {
	        sentenciaSql.append(" AND nombre = ?");
	    }
	    if (data.getPais() != null && !ObjectHelper.getObjecHelper().isNull(data.getPais().getId())) {
	        sentenciaSql.append(" AND pais = ?");
	    }

	    final List<DepartamentoEntity> departamentos = new ArrayList<>();

	    try (final PreparedStatement sentenciaSqlPreparada = getConnection()
	            .prepareStatement(sentenciaSql.toString())) {

	        int index = 1;

	        if (!ObjectHelper.getObjecHelper().isNull(data.getId())) {
	            sentenciaSqlPreparada.setObject(index++, data.getId());
	        }
	        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
	            sentenciaSqlPreparada.setString(index++, data.getNombre());
	        }
	        if (data.getPais() != null && !ObjectHelper.getObjecHelper().isNull(data.getPais().getId())) {
	            sentenciaSqlPreparada.setObject(index++, data.getPais().getId());
	        }

	        try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
	            while (resultado.next()) {
	                DepartamentoEntity departamento = new DepartamentoEntity();
	                departamento.setId((UUID) resultado.getObject("id"));
	                departamento.setNombre(resultado.getString("nombre"));
	                // Asignar el país si se está seleccionando en la consulta
	                PaisEntity pais = new PaisEntity();
	                pais.setId((UUID) resultado.getObject("pais"));
	                departamento.setPais(pais);
	                departamentos.add(departamento);
	            }
	        }

	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar los departamentos. Por favor, contacte al administrador del sistema.";
	        var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de los departamentos en la tabla \"Departamento\" de la base de datos Azure SQL.";

	        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar los departamentos. Por favor, contacte al administrador del sistema.";
	        var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los departamentos en la tabla \"Departamento\" de la base de datos Azure SQL.";

	        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
	    }

	    return departamentos;
	}
	public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

		public CiudadAzureSqlDAO(final Connection conexion) {
			super(conexion);
		}

		@Override
		public final void crear(final CiudadEntity data) {
			final StringBuilder sentenciaSql = new StringBuilder();

			sentenciaSql.append("INSERT INTO Ciudad (id, nombre, departamento) ");
			sentenciaSql.append("SELECT ?, ?, ?");

			try (final PreparedStatement sentenciaSqlPreparada = getConnection()
					.prepareStatement(sentenciaSql.toString())) {

				sentenciaSqlPreparada.setObject(1, data.getId());
				sentenciaSqlPreparada.setString(2, data.getNombre());
				sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());

				sentenciaSqlPreparada.executeUpdate();

			} catch (final SQLException excepcion) {
				var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
				var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la base de datos Azure SQL";

				throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

			} catch (final Exception excepcion) {

				var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
				var mensajeTecnico = "Se ha presentado un problema INESPERADO con una exception de tipo exeption tratando de realizar el insert de la ciudad \"${1}\" en la tabla \\\"Pais\\\" de la base de datos Azure SQL";

				throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
			}
		}

		@Override
		public List<CiudadEntity> consultar(final CiudadEntity data) {
		    final StringBuilder sentenciaSql = new StringBuilder();
		    sentenciaSql.append("SELECT id, nombre, departamento FROM Ciudad WHERE 1=1");

		    final List<Object> parametros = new ArrayList<>();

		    if (!ObjectHelper.getObjecHelper().isNull(data.getId())) {
		        sentenciaSql.append(" AND id = ?");
		        parametros.add(data.getId());
		    }
		    if (!TextHelper.isNullOrEmpty(data.getNombre())) {
		        sentenciaSql.append(" AND nombre = ?");
		        parametros.add(data.getNombre());
		    }
		    if (!ObjectHelper.getObjecHelper().isNull(data.getDepartamento()) && !ObjectHelper.getObjecHelper().isNull(data.getDepartamento().getId())) {
		        sentenciaSql.append(" AND departamento = ?");
		        parametros.add(data.getDepartamento().getId());
		    }

		    final List<CiudadEntity> ciudades = new ArrayList<>();

		    try (final PreparedStatement sentenciaSqlPreparada = getConnection()
		            .prepareStatement(sentenciaSql.toString())) {

		        for (int i = 0; i < parametros.size(); i++) {
		            sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
		        }

		        try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
		            while (resultado.next()) {
		                CiudadEntity ciudad = new CiudadEntity();
		                ciudad.setId((UUID) resultado.getObject("id"));
		                ciudad.setNombre(resultado.getString("nombre"));
		                DepartamentoEntity departamento = new DepartamentoEntity();
		                departamento.setId((UUID) resultado.getObject("departamento"));
		                ciudad.setDepartamento(departamento);
		                ciudades.add(ciudad);
		            }
		        }

		    } catch (final SQLException excepcion) {
		        var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades. Por favor, contacte al administrador del sistema.";
		        var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de las ciudades en la tabla \"Ciudad\" de la base de datos Azure SQL.";

		        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

		    } catch (final Exception excepcion) {
		        var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades. Por favor, contacte al administrador del sistema.";
		        var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las ciudades en la tabla \"Ciudad\" de la base de datos Azure SQL.";

		        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
		    }

		    return ciudades;
		}


		@Override
		public void modificar(final CiudadEntity data) {
			final StringBuilder sentenciaSql = new StringBuilder();

			sentenciaSql.append("UPDATE Ciudad SET nombre = ?, departamento = ? WHERE id = ?");

			try (final PreparedStatement sentenciaSqlPreparada = getConnection()
					.prepareStatement(sentenciaSql.toString())) {

				sentenciaSqlPreparada.setObject(1, data.getId());
				sentenciaSqlPreparada.setString(2, data.getNombre());
				sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());

				sentenciaSqlPreparada.executeUpdate();

			} catch (final SQLException excepcion) {
				var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
				var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la base de datos Azure SQL";

				throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

			} catch (final Exception excepcion) {

				var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
				var mensajeTecnico = "Se ha presentado un problema INESPERADO con una exception de tipo exeption tratando de realizar el insert de la ciudad \"${1}\" en la tabla \\\"Pais\\\" de la base de datos Azure SQL";

				throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
			}

		}

		@Override
		public void eliminar(final UUID id) {
			final StringBuilder sentenciaSql = new StringBuilder();

			sentenciaSql.append("DELETE FROM Ciudad WHERE id = ?");

			try (final PreparedStatement sentenciaSqlPreparada = getConnection()
					.prepareStatement(sentenciaSql.toString())) {

				sentenciaSqlPreparada.setObject(1, id);

				sentenciaSqlPreparada.executeUpdate();

			} catch (final SQLException excepcion) {
				var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
				var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la base de datos Azure SQL";

				throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

			} catch (final Exception excepcion) {

				var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
				var mensajeTecnico = "Se ha presentado un problema INESPERADO con una exception de tipo exeption tratando de realizar el insert de la ciudad \"${1}\" en la tabla \\\"Pais\\\" de la base de datos Azure SQL";

				throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
			}

		}

	}


}



