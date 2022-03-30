package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Tbl_oferta;

public class Dt_oferta {

	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOferta = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsOferta(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.oferta;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOferta = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Tbl_oferta> listaOfActivos(){
		ArrayList<Tbl_oferta> listFac = new ArrayList<Tbl_oferta>();
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.oferta WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tbl_oferta of = new Tbl_oferta(); //instanciamos a rol
				of.setId_oferta(rs.getInt("id_oferta"));
				of.setNombre(rs.getString("nombre"));
				of.setDescripcion(rs.getString("descripcion"));
				of.setYear(rs.getString("periodo"));
				of.setFecha_inicial(rs.getDate("fecha_inicial"));
				of.setFecha_final(rs.getDate("fecha_final"));
				of.setEstado(rs.getInt("estado"));
				listFac.add(of);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Facultades: "+ e.getMessage());
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

	public Tbl_oferta getoferta(int id){
		Tbl_oferta of = new Tbl_oferta(); //instanciamos a rol
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT *  from gestion_docente.oferta where id_oferta = "+id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			
			of.setId_oferta(rs.getInt("id_oferta"));
			of.setNombre(rs.getString("nombre"));
			of.setDescripcion(rs.getString("descripcion"));
			of.setYear(rs.getString("year"));
			of.setFecha_inicial(rs.getDate("fecha_inicial"));
			of.setFecha_final(rs.getDate("fecha_final"));
			of.setEstado(rs.getInt("estado"));
			
			
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
		return of;
	}
	
	public int getid_oferta(){
		int x = 0;
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT id_oferta from gestion_docente.oferta where estado != 3 Order by id_oferta DESC Limit 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			x = rs.getInt("id_oferta");
			
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
		return x;
	}

	
	public boolean addOferta(Tbl_oferta fc){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsOferta(c);
			this.rsOferta.moveToInsertRow();
			rsOferta.updateString("nombre", fc.getNombre());
			rsOferta.updateInt("estado", 1);
			rsOferta.updateDate("fecha_inicial", fc.getFecha_inicial());
			rsOferta.updateDate("fecha_final", fc.getFecha_final());
			rsOferta.updateString("year", fc.getYear());
			rsOferta.updateString("descripcion", fc.getDescripcion());
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
