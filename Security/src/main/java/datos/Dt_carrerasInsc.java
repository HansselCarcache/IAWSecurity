package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_carrera_inscripcion;
import entidades.Tbl_user;
import entidades.Vw_carrera_departamento;

public class Dt_carrerasInsc {
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsCarreras = null;
	private ResultSet rsCarrerasins = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private PreparedStatement ps2 = null;
	//CAMBIAR CAMBIAR CAMBIAR CAMBIAR 
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsCarreras(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_carrera_departamento;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCarreras = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CARRERAS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	//NO TOCAR NO TOCAR NO TOCAR NO TOCAR
	//Metodo para llenar el ResultSet para insert, update y delete
		public void llenaRsCarrerasInsc(Connection c) {
			try {
				ps2 = c.prepareStatement("SELECT * FROM gestion_docente.carrera_inscripcion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsCarrerasins = ps2.executeQuery();
				
			}
			catch(Exception e){
				System.out.println("DATOS: ERROR EN LISTAR CARRERAS "+ e.getMessage());
				e.printStackTrace();
			}
		}
	
	public ArrayList<Vw_carrera_departamento> listaCarreras(){
		ArrayList<Vw_carrera_departamento> listCarreras = new ArrayList<Vw_carrera_departamento>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_carrera_dep_fac WHERE estado_carrera <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_carrera_departamento carreras = new Vw_carrera_departamento();
				carreras.setId_carrera(rs.getInt("id_carrera"));
				carreras.setNombre_carrera(rs.getString("nombre_carrera"));
				carreras.setId_departamento(rs.getInt("id_departamento"));
				carreras.setNombre_departamento(rs.getString("nombre_departamento"));
				carreras.setEstado(rs.getInt("estado_carrera"));
				
				listCarreras.add(carreras);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CARRERAS"+ e.getMessage());
			e.printStackTrace();
			
		}
		finally {
			try {
				if(rs!= null) {
					rs.close();
				}
				if(ps!= null) {
					ps.close();
				}
				if(c != null) {
					poolConexion.closeConnection(c);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCarreras;
	}
	
	//Metodo para almacenar la carrera de una inscripcion
	public boolean guardarCarrerainsc(Tbl_carrera_inscripcion tci) {
		boolean guardado = false;
		try {
			c = poolConexion.getConnection();
			this.llenaRsCarrerasInsc(c);
			rsCarrerasins.moveToInsertRow();
			rsCarrerasins.updateInt("id_departamento", tci.getId_departamento());
			rsCarrerasins.updateInt("id_facultad", tci.getId_facultad());
			rsCarrerasins.updateInt("estado", tci.getEstado());
			rsCarrerasins.updateInt("id_carrera", tci.getId_carrera());
			rsCarrerasins.updateInt("id_inscripcion", tci.getId_inscripcion());
			rsCarrerasins.insertRow();
			rsCarrerasins.moveToCurrentRow();
			guardado = true;
		}catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Tbl_carrera_inscripcion"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(rsCarrerasins != null){
					rsCarrerasins.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	//Agregar CarreraInscripcion
			public boolean addInscripcionCarrera(Vw_carrera_departamento CaIns, int id_inscripcion){
				boolean guardado = false;
				
				try{
					c = poolConexion.getConnection();
					this.llenaRsCarrerasInsc(c);
					this.rsCarrerasins.moveToInsertRow();
					rsCarrerasins.updateInt("id_carrera", CaIns.getId_carrera());
					rsCarrerasins.updateInt("id_departamento", CaIns.getId_departamento());
					rsCarrerasins.updateInt("id_facultad", CaIns.getId_facultad());
					rsCarrerasins.updateInt("id_inscripcion", id_inscripcion);
					rsCarrerasins.updateInt("estado", 1);				
					rsCarrerasins.insertRow();
					rsCarrerasins.moveToCurrentRow();
					guardado = true;
				}
				catch (Exception e) {
					System.err.println("ERROR AL GUARDAR INSCRIPCION CARRERA: "+e.getMessage());
					e.printStackTrace();
				}
				finally{
					try {
						if(rsCarrerasins != null){
							rsCarrerasins.close();
						}
						if(c != null){
							poolConexion.closeConnection(c);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				return guardado;
			}
	
	//Metodo para recuperar departamentos y facultad de una carrera
	public Vw_carrera_departamento getCarreraDFbyID(int idcarrera) {
		Vw_carrera_departamento cardf = new Vw_carrera_departamento();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_carrera_dep_fac where id_carrera=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idcarrera);
			rs = ps.executeQuery();
			if(rs.next()) {
				cardf.setId_carrera(rs.getInt("id_carrera"));
				cardf.setNombre_carrera(rs.getString("nombre_carrera"));
				cardf.setId_departamento(rs.getInt("id_departamento"));
				cardf.setNombre_departamento(rs.getString("nombre_departamento"));
				cardf.setId_facultad(rs.getInt("id_facultad"));
				cardf.setNombre_facultad(rs.getString("nombre_facultad"));
				cardf.setEstado(rs.getInt("estado_carrera"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS ERROR getUserbyID(): "+ e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(rsCarrerasins != null){
					rsCarrerasins.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cardf;
	}
	
	// Metodo para eliminar usuario
		public boolean eliminarCarreraInsc(int id_inscripcion)
		{
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsCarrerasInsc(c);
				rsCarrerasins.beforeFirst();
				while (rsCarrerasins.next()){
					if(rsCarrerasins.getInt(6)==id_inscripcion){
						
						rsCarrerasins.deleteRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e){
				System.err.println("ERROR AL eliminarCarreraInsc() "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsCarrerasins != null){
						rsCarrerasins.close();
					}
					if(c != null){
						poolConexion.closeConnection(c);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return eliminado;
		}
	
	
}
