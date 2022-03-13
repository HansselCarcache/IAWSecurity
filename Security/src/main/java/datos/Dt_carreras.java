package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Vw_carreras;


public class Dt_carreras {
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsCarreras = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsCarreras(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_carreras;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCarreras = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CARRERAS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vw_carreras> listaCarreras(){
		ArrayList<Vw_carreras> listCarreras = new ArrayList<Vw_carreras>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM dbfdocente.Vw_carreras;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_carreras carreras = new Vw_carreras();
				carreras.setId_carrera(rs.getInt("id_carrera"));
				carreras.setNombre_carrera(rs.getString("nombre_carrera"));
				carreras.setId_departamento(rs.getInt("id_departamento"));
				carreras.setNombre_departamento(rs.getString("nombre_departamento"));
				carreras.setEstado(rs.getInt("estado"));
				
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
}