package datos;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entidades.Vw_oferta;

public class Dt_oferta {

	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsRol(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_oferta;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsRol = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Vw_oferta> listaOfertasCActivos(){
		ArrayList<Vw_oferta> listofc = new ArrayList<Vw_oferta>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_oferta;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_oferta topc = new Vw_oferta(); //instanciamos a rol
				topc.setId_oferta(rs.getInt("id_oferta"));
				topc.setNombre(rs.getString("nombre"));
				topc.setDescripcion(rs.getString("descripcion"));
				topc.setPeriodo(rs.getString("periodo"));
				topc.setFecha_inicio(rs.getString("fecha_inicio"));
				topc.setFecha_final(rs.getString("fecha_final"));
				topc.setEstado(rs.getInt("estado"));
				topc.setCantidad(rs.getInt("cantidad"));
				listofc.add(topc);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
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
		return listofc;
	}

	
}
