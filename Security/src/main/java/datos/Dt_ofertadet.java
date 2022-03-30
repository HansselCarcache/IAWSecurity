package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Vw_ofertadet;

public class Dt_ofertadet {
	
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOferta = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsOFerta_Det(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.oferta_detalle;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOferta = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Oferta_Detalle (llenar) "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Vw_ofertadet> listaOfertasdet(){
		ArrayList<Vw_ofertadet> listofc = new ArrayList<Vw_ofertadet>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_ofertadet;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_ofertadet topc = new Vw_ofertadet(); //instanciamos a rol
				topc.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				topc.setId_oferta(rs.getInt("id_oferta"));
				topc.setPeriodo(rs.getString("periodo"));
				topc.setDias(rs.getString("dias"));
				topc.setPublico(rs.getInt("publico"));
				topc.setId_capacitacion(rs.getInt("id_capacitacion"));
				topc.setCapacitacion(rs.getString("capacitacion"));
				topc.setModalidad(rs.getString("modalidad"));
				topc.setId_facilitador(rs.getInt("id_facilitador"));
				listofc.add(topc);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Oferta_Detalle "+ e.getMessage());
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
	
	@SuppressWarnings("deprecation")
	public ArrayList<Vw_ofertadet> listaOD_id(int id){
		ArrayList<Vw_ofertadet> listFac = new ArrayList<Vw_ofertadet>();
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_ofertadet WHERE id_oferta = "+ id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_ofertadet ofd = new Vw_ofertadet(); //instanciamos a rol
				ofd.setId_oferta(rs.getInt("id_oferta"));
				
				Date inicial= rs.getDate("fecha_inicial");
				inicial.setDate((rs.getDate("fecha_inicial").getDate()+1));
				
				Date fin= rs.getDate("fecha_final");
				fin.setDate((rs.getDate("fecha_final").getDate()+1));
				
				ofd.setFecha_inicio(inicial);
				ofd.setFecha_final(fin);
				System.out.print("Final " + fin);
				ofd.setDias(rs.getString("dias"));
				ofd.setPublico(rs.getInt("publico"));
				ofd.setId_oferta(rs.getInt("id_oferta"));
				ofd.setId_capacitacion(rs.getInt("id_capacitacion"));
				ofd.setId_facilitador(rs.getInt("id_facilitador"));
				ofd.setCapacitacion(rs.getString("capacitacion"));
				ofd.setFacilitador(rs.getString("facilitador"));
				ofd.setDescripcion_horaria(rs.getString("descripcion_horaria"));
				ofd.setTipo_capacitacion(rs.getString("tipo_capacitacion"));
				ofd.setModalidad(rs.getString("modalidad"));
				listFac.add(ofd);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Oferta_Detalle: "+ e.getMessage());
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
		return listFac;
	}

	public boolean addOferta(Vw_ofertadet ofd){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsOFerta_Det(c);
			this.rsOferta.moveToInsertRow();
			
			rsOferta.updateDate("fecha_inicial", ofd.getFecha_inicio());
			rsOferta.updateDate("fecha_final", ofd.getFecha_final());
			rsOferta.updateString("dias", ofd.getDias());
			rsOferta.updateString("descripcion_horaria", ofd.getDescripcion_horaria());
			rsOferta.updateInt("publico", ofd.getPublico());
			rsOferta.updateInt("id_oferta", ofd.getId_oferta());
			rsOferta.updateInt("id_capacitacion", ofd.getId_capacitacion());
			rsOferta.updateInt("id_facilitador", ofd.getId_facilitador());
			rsOferta.updateInt("id_modalidad", ofd.getId_modalidad());
			
			rsOferta.insertRow();
			rsOferta.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR OFERTA: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsOferta != null){
					rsOferta.close();
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
