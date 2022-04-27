package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.poolConexion;

public class Ng_Facilitador {
	
	//Atributos
		poolConexion pc = poolConexion.getInstance();
		Connection c = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
	public boolean existeCedula(String cedula) {
		boolean existe = false;
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.facilitador where cedula=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setString(1, cedula);
			rs = ps.executeQuery();
			if(rs.next()) {
				existe = true;
			}
		}catch (Exception e){
			System.out.println("DATOS ERROR existeCedula(): "+ e.getMessage());
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
