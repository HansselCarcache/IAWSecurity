package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
					escala.setCalificacion(rs.getString("calificacion"));
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
		
	}
