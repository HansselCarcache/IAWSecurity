package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_escalaCalificacion;
import entidades.Tbl_user;

public class Dt_escalacalificacion {
	
	//Atributos
		poolConexion pc = poolConexion.getInstance();
		Connection c = null;
		private ResultSet rsEscala = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		//Metodo para llenar el ResultSet para insert, update y delete
		public void llenaRsEscala(Connection c) {
			try {
				ps = c.prepareStatement("SELECT * FROM dbfdocente.escalacalificacion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsEscala = ps.executeQuery();
				
			}
			catch(Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ESCALA DE CALIFICACION "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		public ArrayList<Tbl_escalaCalificacion> listaEscalaActivo(){
			ArrayList<Tbl_escalaCalificacion> listEscala = new ArrayList<Tbl_escalaCalificacion>();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM dbfdocente.escalacalificacion WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()) {
					Tbl_escalaCalificacion escala = new Tbl_escalaCalificacion();
					escala.setId_escala(rs.getInt("id_escala"));
					escala.setTipo_calificacion(rs.getString("tipo_calificacion"));
					escala.setDescripcion(rs.getString("descripcion"));
					escala.setEstado(rs.getInt("estado"));
					listEscala.add(escala);
					
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ESCALA DE CALIFICACION"+ e.getMessage());
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
			return listEscala;
		}
		
		public boolean addEscalaCalificacion(Tbl_escalaCalificacion ec){
			boolean guardado = false;
			
			try{
				c = poolConexion.getConnection();
				this.llenaRsEscala(c);
				this.rsEscala.moveToInsertRow();
				rsEscala.updateString("tipo_calificacion", ec.getTipo_calificacion());
				rsEscala.updateString("descripcion", ec.getDescripcion());
				rsEscala.updateInt("estado", 1);
			
				rsEscala.insertRow();
				rsEscala.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR ESCALDA CALIFICACIONES: "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsEscala != null){
						rsEscala.close();
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

}
		
	
