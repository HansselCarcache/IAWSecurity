package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_Carreras;
import entidades.Tbl_departamento;
import entidades.Vw_carrera_departamento;
import entidades.Vw_facultad_departamento;

public class Dt_carreras {
	
	
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsCarreras = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsCarreras(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM gestion_docente.carrera;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCarreras = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CARRERAS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//Metodo para visualizar usuarios registrados y activos
		public ArrayList<Vw_carrera_departamento> listCarrera(){
			ArrayList<Vw_carrera_departamento> listCarrera = new ArrayList<Vw_carrera_departamento>();
			try{
				c = poolConexion.getConnection(); //obtenemos una conexion del pool
				ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_carrera_departamento WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()){
					Vw_carrera_departamento tc = new Vw_carrera_departamento(); //instanciamos a rol
					tc.setId_carrera(rs.getInt("id_carrera"));
					tc.setNombre_carrera(rs.getString("nombre_carrera"));
					tc.setId_departamento(rs.getInt("id_departamento"));
					tc.setNombre_departamento(rs.getString("nombre_departamento"));
					tc.setEstado(rs.getInt("estado"));
					listCarrera.add(tc);
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR DEPARTAMENTOS "+ e.getMessage());
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
			return listCarrera;
		}
	
	
	
	//Metodo para almacenar carrera 
	public boolean guardarCarrera(Tbl_Carreras tc) {
		boolean guardado = false;
		try {
			c = poolConexion.getConnection();
			this.llenaRsCarreras(c);
			rsCarreras.moveToInsertRow();
			//rsCarrerasdepa.updateInt("id_carrera", tc.getId_carrera());
			rsCarreras.updateString("nombre_carrera", tc.getNombre_carrera());
			rsCarreras.updateInt("id_departamento", tc.getId_departamento());
			rsCarreras.updateInt("estado", 1);
			rsCarreras.insertRow();
			rsCarreras.moveToCurrentRow();
			guardado = true;
		}catch (Exception e) {
			System.err.println("ERROR AL GUARDAR CARRERAS"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(rsCarreras != null){
					rsCarreras.close();
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
	
	//Metodo para visualizar
	public Vw_carrera_departamento getCarreraDFbyID(int idcarrera) {
		Vw_carrera_departamento tc = new Vw_carrera_departamento();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_carrera_departamento where id_carrera=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idcarrera);
			rs = ps.executeQuery();
			if(rs.next()) {
				tc.setId_carrera(rs.getInt("id_carrera"));
				tc.setNombre_carrera(rs.getString("nombre_carrera"));
				tc.setId_departamento(rs.getInt("id_departamento"));
				tc.setNombre_departamento(rs.getString("nombre_departamento"));
				tc.setEstado(rs.getInt("estado"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS ERROR getUserbyID(): "+ e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(rsCarreras != null){
					rsCarreras.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tc;
	}
	
	
	// Metodo para modificar carrera
			public boolean modificarCarrera(Tbl_Carreras tc)
			{
				boolean modificado=false;	
				try
				{
					c = poolConexion.getConnection();
					this.llenaRsCarreras(c);
					rsCarreras.beforeFirst();
					while (rsCarreras.next())
					{
						if(rsCarreras.getInt(1)==tc.getId_carrera())
						{
							rsCarreras.updateString("nombre_carrera", tc.getNombre_carrera());
							rsCarreras.updateInt("id_departamento", tc.getId_departamento());
							rsCarreras.updateInt("estado", 2);
							rsCarreras.updateRow();
							modificado=true;
							break;
						}
					}
				}
				catch (Exception e)
				{
					System.err.println("ERROR al modificar Carrera"+e.getMessage());
					e.printStackTrace();
				}
				finally
				{
					try {
						if(rsCarreras != null){
							rsCarreras.close();
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
			
	
			// Metodo para eliminar carrera
			public boolean eliminarCarrera(Tbl_Carreras tc)
			{
				boolean eliminado=false;	
				try
				{
					c = poolConexion.getConnection();
					this.llenaRsCarreras(c);
					rsCarreras.beforeFirst();
					while (rsCarreras.next()){
						if(rsCarreras.getInt(1)==tc.getId_carrera())
						{
							rsCarreras.updateInt("estado", 3);
							rsCarreras.updateRow();
							eliminado=true;
							break;
						}
					}
				}
				catch (Exception e){
					System.err.println("ERROR al eliminar carrera) "+e.getMessage());
					e.printStackTrace();
				}
				finally{
					try {
						if(rsCarreras != null){
							rsCarreras.close();
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