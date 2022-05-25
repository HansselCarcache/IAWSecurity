package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_inscripcion;
import entidades.Tbl_user;
import entidades.Vw_inscripcion_docente;
import entidades.Vw_perfilDocente;
import entidades.Vw_userrol;

public class Dt_inscripcionDocente {

	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsInscripcion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsInscripcion(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM gestion_docente.inscripcion", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsInscripcion = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCION "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Esto era del proyecto viejo y quien sabe si se vuelva a ocupar
	public ArrayList<Vw_inscripcion_docente> listainscripcion(){
		ArrayList<Vw_inscripcion_docente> listInsc = new ArrayList<Vw_inscripcion_docente>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_inscripcion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_inscripcion_docente insc = new Vw_inscripcion_docente();
				insc.setId_inscripcion(rs.getInt("id_inscripcion"));
				insc.setNombre_completo(rs.getString("nombre_completo"));
				insc.setTelefono(rs.getString("telefono"));
				insc.setCorreo(rs.getString("correo"));
				insc.setId_usuario(rs.getInt("id_usuario"));
				insc.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				insc.setValor(rs.getString("valor"));
				insc.setDesc_valor(rs.getString("desc_valor"));
				insc.setEstado(rs.getInt("estado"));
				insc.setOtras_dependencias(rs.getString("otras_dependencias"));
				
				listInsc.add(insc);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCION"+ e.getMessage());
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
		return listInsc;
	}
	
	public ArrayList<Vw_inscripcion_docente> listainscripcionPersonal(int idUser) {
		ArrayList<Vw_inscripcion_docente> listInsc = new ArrayList<Vw_inscripcion_docente>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_inscripcion_docente where id_usuario=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1,  idUser);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_inscripcion_docente insc = new Vw_inscripcion_docente();
				insc.setId_inscripcion(rs.getInt("id_inscripcion"));
				insc.setNombre_completo(rs.getString("nombre_completo"));
				insc.setTelefono(rs.getString("telefono"));
				insc.setCorreo(rs.getString("correo"));
				insc.setId_usuario(rs.getInt("id_usuario"));
				insc.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				insc.setCapacitacion(rs.getString("capacitacion"));
				insc.setFecha_final(rs.getDate("fecha_final"));
				insc.setFecha_inicial(rs.getDate("fecha_inicial"));
				insc.setDescripcion_horaria(rs.getString("descripcion_horaria"));
				insc.setDias(rs.getString("dias"));
				insc.setValor(rs.getString("valor"));
				insc.setDesc_valor(rs.getString("desc_valor"));
				insc.setEstado(rs.getInt("estado"));
				insc.setOtras_dependencias(rs.getString("otras_dependencias"));
				
				listInsc.add(insc);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCION"+ e.getMessage());
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
		return listInsc;
	}
	
	public ArrayList<Vw_perfilDocente> listaPerfil(int idUser) {
		ArrayList<Vw_perfilDocente> listInsc = new ArrayList<Vw_perfilDocente>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_perfil where id_usuario=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1,  idUser);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_perfilDocente insc = new Vw_perfilDocente();
				insc.setId_inscripcion(rs.getInt("id_inscripcion"));
				insc.setNombre_completo(rs.getString("nombre_completo"));
				insc.setTelefono(rs.getString("telefono"));
				insc.setCorreo(rs.getString("correo"));
				insc.setId_usuario(rs.getInt("id_usuario"));
				insc.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				insc.setValor(rs.getString("valor"));
				insc.setDesc_valor(rs.getString("desc_valor"));
				insc.setEstado(rs.getInt("estado"));
				insc.setOtras_dependencias(rs.getString("otras_dependencias"));
				insc.setId_capacitacion(rs.getInt("id_capacitacion"));
				insc.setNombre_capacitacion(rs.getString("nombre_capacitacion"));
				insc.setFecha_inicial(rs.getDate("fecha_inicial"));
				insc.setFecha_final(rs.getDate("fecha_final"));
				
				listInsc.add(insc);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCION"+ e.getMessage());
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
		return listInsc;
	}
	
	
	public Vw_inscripcion_docente getInscripcionbyID(int id_inscripcion) {
		Vw_inscripcion_docente insc = new Vw_inscripcion_docente();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_inscripcion_docente where id_inscripcion=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1,  id_inscripcion);
			rs = ps.executeQuery();
			if(rs.next()) {
				insc.setId_inscripcion(rs.getInt("id_inscripcion"));
				insc.setNombre_completo(rs.getString("nombre_completo"));
				insc.setTelefono(rs.getString("telefono"));
				insc.setCorreo(rs.getString("correo"));
				insc.setId_usuario(rs.getInt("id_usuario"));
				insc.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				insc.setCapacitacion(rs.getString("capacitacion"));
				insc.setFecha_final(rs.getDate("fecha_final"));
				insc.setFecha_inicial(rs.getDate("fecha_inicial"));
				insc.setDescripcion_horaria(rs.getString("descripcion_horaria"));
				insc.setDias(rs.getString("dias"));
				insc.setValor(rs.getString("valor"));
				insc.setDesc_valor(rs.getString("desc_valor"));
				insc.setEstado(rs.getInt("estado"));
				insc.setOtras_dependencias(rs.getString("otras_dependencias"));
				
			}
		}catch (Exception e)
		{
			System.out.println("DATOS ERROR getUserbyID(): "+ e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return insc;
	}
	
	
	
	//Metodo para almacenar nueva inscripcion
	public int guardarInscripcion(Tbl_inscripcion tins) {
		int guardado = 0;
		try {
			c = poolConexion.getConnection();
			this.llenaRsInscripcion(c);
			rsInscripcion.moveToInsertRow();
			rsInscripcion.updateString("nombre_completo", tins.getNombre_completo());
			rsInscripcion.updateString("telefono", tins.getTelefono());
			rsInscripcion.updateString("correo", tins.getCorreo());
			rsInscripcion.updateInt("estado", 1);
			rsInscripcion.updateString("otras_dependencias", tins.getOtras_dependencias());
			rsInscripcion.updateInt("id_usuario", tins.getId_usuario());
			rsInscripcion.updateInt("id_oferta_detalle", tins.getId_oferta_detalle());
			rsInscripcion.insertRow();
			rsInscripcion.moveToCurrentRow();
			this.llenaRsInscripcion(c);
			rsInscripcion.last();
			guardado = rsInscripcion.getInt("id_inscripcion");
			
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Tbl_inscripcion "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsInscripcion != null){
					rsInscripcion.close();
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
	
	public boolean eliminarInsc(int id_inscripcion)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llenaRsInscripcion(c);
			rsInscripcion.beforeFirst();
			while (rsInscripcion.next()){
				if(rsInscripcion.getInt(1)==id_inscripcion){
					
					rsInscripcion.deleteRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e){
			System.err.println("ERROR AL eliminarInsc() "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsInscripcion != null){
					rsInscripcion.close();
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
