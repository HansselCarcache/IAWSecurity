package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_facultad;


public class Dt_facultad {

	//Atributos
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsFacultad = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llenaRsFacultad(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.facultad;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsFacultad = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR FACULTADES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Tbl_facultad> listaFacultadActivos(){
		ArrayList<Tbl_facultad> listFacu = new ArrayList<Tbl_facultad>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.facultad WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tbl_facultad tfacu = new Tbl_facultad(); //instanciamos a rol
				tfacu.setId_facultad(rs.getInt("id_facultad"));
				tfacu.setNombre_facultad(rs.getString("nombre_facultad"));
				tfacu.setEstado(rs.getInt("estado"));
				listFacu.add(tfacu);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR FACULTADES "+ e.getMessage());
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
		return listFacu;
	}
	
	//Metodo para almacenar nueva facultad
		public boolean addFacultad (Tbl_facultad tfacu){
			boolean guardado = false;
//			int guardado = 0;
			try{
				c = poolConexion.getConnection();
				this.llenaRsFacultad(c);
				rsFacultad.moveToInsertRow();
				rsFacultad.updateString("nombre_facultad", tfacu.getNombre_facultad());
				rsFacultad.updateInt("estado", 1);
				rsFacultad.insertRow();
				rsFacultad.moveToCurrentRow();
				this.llenaRsFacultad(c);
				rsFacultad.last();
			//	guardado = rsFacultad.getInt("id_facultad");
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR FACULTAD "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsFacultad != null){
						rsFacultad.close();
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
		

		//Metodo para visualizar facultad
		
		public Tbl_facultad getFacultadbyID(int id_facultad) {
			Tbl_facultad tf = new Tbl_facultad();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.facultad where estado <> 3 and id_facultad=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, id_facultad);
				rs = ps.executeQuery();
				if(rs.next()) {
					tf.setId_facultad(rs.getInt("id_facultad"));
					tf.setNombre_facultad(rs.getString("nombre_facultad"));
					tf.setEstado(rs.getInt("estado"));
			
				}
			}catch (Exception e)
			{
				System.out.println("DATOS ERROR get FACULTAD by ID(): "+ e.getMessage());
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
			
			return tf;
		}
		
		
		// Metodo para modificar facultad
		public boolean modificarFacultad(Tbl_facultad tfacu)
		{
			boolean modificado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsFacultad(c);
				rsFacultad.beforeFirst();
				while (rsFacultad.next())
				{
					if(rsFacultad.getInt(1)==tfacu.getId_facultad())
					{
						rsFacultad.updateString("nombre_facultad", tfacu.getNombre_facultad());
						rsFacultad.updateInt("estado", 2);
						rsFacultad.updateRow();
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR al modificar facultad"+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsFacultad != null){
						rsFacultad.close();
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
		
	
		// Metodo para eliminar facultad
		public boolean eliminarFacultad (Tbl_facultad tfacu)
		{
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsFacultad(c);
				rsFacultad.beforeFirst();
				while (rsFacultad.next()){
					if(rsFacultad.getInt(1)==tfacu.getId_facultad())
					{
						rsFacultad.updateInt("estado", 3);
						rsFacultad.updateRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e){
				System.err.println("ERROR al eliminar facultad) "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsFacultad != null){
						rsFacultad.close();
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