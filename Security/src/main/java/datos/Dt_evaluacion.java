package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_escalaCalificacion;
import entidades.Tbl_escalaCalificacionDet;
import entidades.Tbl_inscripcion;
import entidades.Vw_evaluacion;
import entidades.Vw_inscripcion;

public class Dt_evaluacion {

	//Atributos
		poolConexion pc = poolConexion.getInstance();
		Connection c = null;
		private ResultSet rsIncripcion = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		//Metodo para llenar el ResultSet para insert, update y delete
		public void llenaRsInscripcion(Connection c) {
			try {
				ps = c.prepareStatement("SELECT * FROM gestion_docente.inscripcion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsIncripcion = ps.executeQuery();
				
			}
			catch(Exception e){
				System.out.println("DATOS: ERROR EN LISTAR INSCRIPCIONES "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		public ArrayList<Vw_evaluacion> listaInscripActivo(String cedula){
			ArrayList<Vw_evaluacion> listEv = new ArrayList<Vw_evaluacion>();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_evaluacion WHERE estado <> 3 AND cedula = '"+cedula+"'", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()) {
					Vw_evaluacion ev = new Vw_evaluacion();
					//DATOS DE DOCENTE
					ev.setId_inscripcion(rs.getInt("id_inscripcion"));
					ev.setEstudiante(rs.getString("estudiante"));
					ev.setTelefono(rs.getString("telefono"));
					ev.setCorreo(rs.getString("correo"));
					ev.setEstado(rs.getInt("estado"));
					//DATOS DE EVALUACION
					ev.setId_escala(rs.getInt("id_escala"));
					ev.setTipo_calificacion(rs.getString("tipo_calificacion"));
					ev.setDescripcion(rs.getString("descripcion"));
					ev.setDescr_det(rs.getString("descr_det"));
					ev.setValor1(rs.getString("valor1"));
					ev.setValor2(rs.getString("valor2"));
					//DATOS DE OFERTA
					ev.setCapacitacion(rs.getString("capacitacion"));
					ev.setConvocatoria(rs.getString("convocatoria"));
					
					
					listEv.add(ev);
					
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR EVALUACION"+ e.getMessage());
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
			return listEv;
		}
		
		public String getCedula(int id) {
			String cedula= "";
			
			try{
				c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
				ps = c.prepareStatement("SELECT cedula  from gestion_docente.usuario where id_usuario = "+id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				rs.next();
				
				cedula = rs.getString("cedula");	
				
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN getCedula(): "+ e.getMessage());
				e.printStackTrace();
			}
			finally{
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
			
			return cedula;
		}
		
		public ArrayList<Tbl_escalaCalificacionDet> listAllEscDet(){
			ArrayList<Tbl_escalaCalificacionDet> lted = new ArrayList<Tbl_escalaCalificacionDet>();
			try{
				c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
				ps = c.prepareStatement("SELECT *  from gestion_docente.det_escalacalificacion where estado<>3 order by id_escala;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				
				while(rs.next()){
					Tbl_escalaCalificacionDet ted = new Tbl_escalaCalificacionDet(); //instanciamos a rol
					ted.setId_det_escalaCalificacion(rs.getInt("id_det_escalaCalificacion"));
					ted.setValor1(rs.getString("valor1"));
					ted.setValor2(rs.getString("valor2"));
					ted.setDescripcion(rs.getString("descripcion"));
					ted.setId_escala(rs.getInt("id_escala"));
					
					lted.add(ted);
				}
				
				
				
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN listAllEscDet(): "+ e.getMessage());
				e.printStackTrace();
			}
			finally{
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
			
			
			return lted;
		}
	
}
