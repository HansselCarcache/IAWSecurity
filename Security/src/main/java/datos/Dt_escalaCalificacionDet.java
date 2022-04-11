package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import entidades.Tbl_escalaCalificacion;
import entidades.Tbl_escalaCalificacionDet;



public class Dt_escalaCalificacionDet {
	
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsEscala = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsEscalaCalificacionDet(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM  gestion_docente.det_escalacalificacion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsEscala = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Oferta_Detalle (llenar) "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Tbl_escalaCalificacionDet> listaEscaladet(){
		ArrayList<Tbl_escalaCalificacionDet> listescDet = new ArrayList<Tbl_escalaCalificacionDet>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM  gestion_docente.det_escalacalificacion where estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tbl_escalaCalificacionDet escdet = new Tbl_escalaCalificacionDet(); //instanciamos a rol
				escdet.setId_det_escalaCalificacion(rs.getInt("id_det_escalaCalificacion"));
				escdet.setValor1(rs.getString("valor1"));
				escdet.setValor2(rs.getString("valor2"));
				escdet.setDescripcion(rs.getString("descripcion"));
				escdet.setId_escala(rs.getInt("id_escala"));
				
				listescDet.add(escdet);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR escalaCalificacion_Detalle "+ e.getMessage());
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
		return listescDet;
	}
	
	public Tbl_escalaCalificacionDet getDetalleId(int id) {
		Tbl_escalaCalificacionDet od = new Tbl_escalaCalificacionDet();
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.det_escalacalificacion where estado<>3 and id_det_escalaCalificacion = "+id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			od.setId_det_escalaCalificacion(rs.getInt("id_det_escalaCalificacion"));
			od.setValor1(rs.getString("valor1"));
			od.setValor2(rs.getString("valor2"));
			od.setDescripcion(rs.getString("descripcion"));
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
	
	public ArrayList<Tbl_escalaCalificacionDet> listaESCD_id(int id){
		ArrayList<Tbl_escalaCalificacionDet> listEscd = new ArrayList<Tbl_escalaCalificacionDet>();
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM  gestion_docente.det_escalacalificacion WHERE estado<>3 and id_escala = "+ id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tbl_escalaCalificacionDet escD = new Tbl_escalaCalificacionDet(); //instanciamos a rol
				escD.setId_escala(rs.getInt("id_escala"));
				
				escD.setId_det_escalaCalificacion(rs.getInt("id_det_escalaCalificacion"));
				escD.setValor1(rs.getString("valor1"));
				escD.setValor2(rs.getString("valor2"));
				escD.setDescripcion(rs.getString("descripcion"));
				
				listEscd.add(escD);
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
		return listEscd;
	}

	public boolean addEscalaDet(Tbl_escalaCalificacionDet escDet){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsEscalaCalificacionDet(c);
			this.rsEscala.moveToInsertRow();
			
			rsEscala.updateString("valor1", escDet.getValor1());
			rsEscala.updateString("valor2", escDet.getValor2());
			rsEscala.updateString("descripcion", escDet.getDescripcion());
			rsEscala.updateInt("estado", 1);
			rsEscala.updateInt("id_escala",escDet.getId_escala());
			rsEscala.insertRow();
	
			rsEscala.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR OFERTA: "+e.getMessage());
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

	public boolean editEscalaDet(Tbl_escalaCalificacionDet escD) {
		boolean modificado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsEscalaCalificacionDet(c);
			rsEscala.beforeFirst();
			
			while (rsEscala.next())
			{
				if(rsEscala.getInt(1)==escD.getId_det_escalaCalificacion())
				{
					rsEscala.updateString("valor1", escD.getValor1());
					rsEscala.updateString("valor2", escD.getValor2());
					rsEscala.updateString("descripcion", escD.getDescripcion());
					rsEscala.updateInt("id_escala", escD.getId_escala());
					
					rsEscala.updateInt("estado", 2);
					rsEscala.updateRow();
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
		
		return modificado;
	}

	public boolean deleteEscalaDetByID(int id)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsEscalaCalificacionDet(c);
			rsEscala.beforeFirst();
			while (rsEscala.next()){
				if(rsEscala.getInt("id_escala") == id){
					rsEscala.updateInt("estado", 3);
					rsEscala.updateRow();
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
		return eliminado;
	}
	
	public boolean deleteEscalaDet(Tbl_escalaCalificacionDet tesc)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsEscalaCalificacionDet(c);
			rsEscala.beforeFirst();
			while (rsEscala.next()){
				if(rsEscala.getInt("id_det_escalaCalificacion") == tesc.getId_det_escalaCalificacion()){
					rsEscala.updateInt("estado", 3);
					rsEscala.updateRow();
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
		return eliminado;
	}
	
	

}



