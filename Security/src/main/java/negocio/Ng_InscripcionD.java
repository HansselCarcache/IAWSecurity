package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.poolConexion;

public class Ng_InscripcionD {
	
	//Atributos
		poolConexion pc = poolConexion.getInstance();
		Connection c = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;

		public boolean existeInscripcion(int id_oferta_detalle, int id_usuario) {
			boolean existe = false;
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.inscripcion WHERE id_oferta_detalle=? AND id_usuario=?;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, id_oferta_detalle);
				ps.setInt(2, id_usuario);
				rs = ps.executeQuery();
				if(rs.next()) {
					existe = true;
				}
			}catch (Exception e){
				System.out.println("DATOS ERROR existeInscripcion(): "+ e.getMessage());
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
			
			return existe;
		}
}
