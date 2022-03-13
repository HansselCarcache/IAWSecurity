package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Tbl_inscripcion;

public class Dt_inscripcion {

	//Atributos
		poolConexion pc = poolConexion.getInstance();
		Connection c = null;
		private ResultSet rsIncripcion = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		//Metodo para llenar el ResultSet para insert, update y delete
		public void llenaRsInscripcion(Connection c) {
			try {
				ps = c.prepareStatement("SELECT * FROM dbfdocente.inscripcion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsIncripcion = ps.executeQuery();
				
			}
			catch(Exception e){
				System.out.println("DATOS: ERROR EN LISTAR INSCRIPCIONES "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		public ArrayList<Tbl_inscripcion> listaInscripActivo(){
			ArrayList<Tbl_inscripcion> listIncrip = new ArrayList<Tbl_inscripcion>();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM dbfdocente.inscripcion WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()) {
					Tbl_inscripcion inscr = new Tbl_inscripcion();
					inscr.setId_inscripcion(rs.getInt("id_inscripcion"));
					inscr.setId_usuario(rs.getInt("id_usuario"));
					inscr.setId_facultad(rs.getInt("id_facultad"));
					inscr.setId_departamento(rs.getInt("id_departamento"));
					inscr.setId_carrera(rs.getInt("id_carrera"));
					inscr.setFecha_inscripcion(rs.getString("fecha_inscripcion"));
					inscr.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
					inscr.setId_escala(rs.getInt("id_escala"));
					listIncrip.add(inscr);
					
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR INSCRIPCIONES"+ e.getMessage());
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
			return listIncrip;
		}
	
}
