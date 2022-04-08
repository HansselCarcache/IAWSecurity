package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import entidades.Tbl_ofertadet;
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
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_ofertadet where estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
	
	public Vw_ofertadet getDetalleId(int id) {
		Vw_ofertadet od = new Vw_ofertadet();
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT *  from gestion_docente.vw_ofertadet where estado<>3 and id_oferta_detalle = "+id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			od.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
			od.setId_oferta(rs.getInt("id_oferta"));
			od.setFecha_inicio(rs.getDate("fecha_inicial"));
			od.setFecha_final(rs.getDate("fecha_final"));
			od.setDias(rs.getString("dias"));
			
			String temp =rs.getString("descripcion_horaria");
			
			od.setDescripcion_horaria(temp.replace("</br>", "\n"));
			
			od.setPublico(rs.getInt("publico"));
			od.setId_facilitador(rs.getInt("id_facilitador"));
			od.setFacilitador(rs.getString("facilitador"));
			od.setId_capacitacion(rs.getInt("id_capacitacion"));
			od.setCapacitacion(rs.getString("capacitacion"));
			od.setId_modalidad(rs.getInt("id_modalidad"));
			od.setModalidad(rs.getString("modalidad"));
			
			
			
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR OFERTA: "+ e.getMessage());
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
		return od;
	}
	
	public ArrayList<Vw_ofertadet> listaOD_id(int id){
		ArrayList<Vw_ofertadet> listFac = new ArrayList<Vw_ofertadet>();
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_ofertadet WHERE estado<>3 and id_oferta = "+ id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_ofertadet ofd = new Vw_ofertadet(); //instanciamos a rol
				ofd.setId_oferta(rs.getInt("id_oferta"));
				
				ofd.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				ofd.setFecha_inicio(rs.getDate("fecha_inicial"));
				ofd.setFecha_final(rs.getDate("fecha_final"));
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
			rsOferta.updateInt("estado", 1);
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

	public boolean editOfertaDet(Vw_ofertadet tod) {
		boolean modificado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsOFerta_Det(c);
			rsOferta.beforeFirst();
			
			while (rsOferta.next())
			{
				if(rsOferta.getInt(1)==tod.getId_oferta_detalle())
				{
					rsOferta.updateDate("fecha_inicial", tod.getFecha_inicio());
					rsOferta.updateDate("fecha_final", tod.getFecha_final());
					rsOferta.updateString("dias", tod.getDias());
					rsOferta.updateString("descripcion_horaria", tod.getDescripcion_horaria());
					rsOferta.updateInt("publico", tod.getPublico());
					rsOferta.updateInt("id_oferta", tod.getId_oferta());
					rsOferta.updateInt("id_capacitacion", tod.getId_capacitacion());
					rsOferta.updateInt("id_facilitador", tod.getId_facilitador());
					rsOferta.updateInt("id_modalidad", tod.getId_modalidad());
					rsOferta.updateInt("estado", 2);
					rsOferta.updateRow();
					modificado=true;
					break;
				}
			}
			
		}
		catch (Exception e) {
			System.err.println("ERROR AL Modificar OFERTA det: "+e.getMessage());
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
		
		return modificado;
	}

	public boolean deleteOfertaDetByID(int id)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsOFerta_Det(c);
			rsOferta.beforeFirst();
			while (rsOferta.next()){
				if(rsOferta.getInt("id_oferta") == id){
					rsOferta.updateInt("estado", 3);
					rsOferta.updateRow();
					eliminado=true;
					
				}
			}
		}
		catch (Exception e){
			System.err.println("ERROR AL deleteOferta() "+e.getMessage());
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
		return eliminado;
	}
	
	public boolean deleteOfertaDet(Vw_ofertadet to)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsOFerta_Det(c);
			rsOferta.beforeFirst();
			while (rsOferta.next()){
				if(rsOferta.getInt("id_oferta_detalle") == to.getId_oferta_detalle()){
					rsOferta.updateInt("estado", 3);
					rsOferta.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e){
			System.err.println("ERROR AL deleteOfertaDet() "+e.getMessage());
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
		return eliminado;
	}


}
