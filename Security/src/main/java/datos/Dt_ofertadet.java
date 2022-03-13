package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Vw_ofertadet;

public class Dt_ofertadet {
	
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsRol(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_ofertadet;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsRol = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Vw_ofertadet> listaOfertasdet(){
		ArrayList<Vw_ofertadet> listofc = new ArrayList<Vw_ofertadet>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_ofertadet;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_ofertadet topc = new Vw_ofertadet(); //instanciamos a rol
				topc.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				topc.setId_oferta(rs.getInt("id_oferta"));
				topc.setPeriodo(rs.getString("periodo"));
				topc.setFecha_inicio(rs.getString("fecha_inicio"));
				topc.setFecha_final(rs.getString("fecha_final"));
				topc.setHora_inicio(rs.getString("hora_inicio"));
				topc.setHora_final(rs.getString("hora_final"));
				topc.setDias(rs.getString("dias"));
				topc.setPublico(rs.getInt("publico"));
				topc.setId_capacitacion(rs.getInt("id_capacitacion"));
				topc.setCapacitacion(rs.getString("capacitacion"));
				topc.setModalidad(rs.getString("modalidad"));
				topc.setId_facilitador(rs.getInt("id_facilitador"));
				topc.setNombres(rs.getString("nombres"));
				topc.setApellidos(rs.getString("apellidos"));
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
