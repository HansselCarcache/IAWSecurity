package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_departamento;
import entidades.Vw_facultad_departamento;

public class Dt_departamento {

	//Atributos
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsDepartamento = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llenaRsDepartamento(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.departamento;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsDepartamento = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR DEPARTAMENTOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Vw_facultad_departamento> listaDepartamentosActivos(){
		ArrayList<Vw_facultad_departamento> listDepa = new ArrayList<Vw_facultad_departamento>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_facultad_departamento WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_facultad_departamento tdepa = new Vw_facultad_departamento(); //instanciamos a rol
				tdepa.setId_departamento(rs.getInt("id_departamento"));
				tdepa.setNombre_departamento(rs.getString("nombre_departamento"));
				tdepa.setNombre_facultad(rs.getString("nombre_facultad"));
				tdepa.setEstado(rs.getInt("estado"));
				tdepa.setId_facultad(rs.getInt("id_facultad"));
				listDepa.add(tdepa);
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
		return listDepa;
	}
	
	//Metodo para almacenar nuevo departamento
		public boolean addDepartamento(Tbl_departamento tdepa){
			boolean guardado = false;
//			int guardado = 0;
			try{
				c = poolConexion.getConnection();
				this.llenaRsDepartamento(c);
				rsDepartamento.moveToInsertRow();
				rsDepartamento.updateString("nombre_departamento", tdepa.getNombre_departamento());
				rsDepartamento.updateInt("id_facultad", tdepa.getId_facultad());
				rsDepartamento.updateInt("estado", 1);
				rsDepartamento.insertRow();
				rsDepartamento.moveToCurrentRow();
				this.llenaRsDepartamento(c);
				rsDepartamento.last();
			//	guardado = rsDepartamento.getInt("id_departamento");
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR DEPARTAMENTO "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsDepartamento != null){
						rsDepartamento.close();
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
		

		//Metodo para visualizar departamento
		
		public Vw_facultad_departamento getDepartamentobyID(int idDepartamento) {
			Vw_facultad_departamento td = new Vw_facultad_departamento();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_facultad_departamento where estado <> 3 and id_departamento=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, idDepartamento);
				rs = ps.executeQuery();
				if(rs.next()) {
					td.setId_departamento(rs.getInt("id_departamento"));
					td.setNombre_departamento(rs.getString("nombre_departamento"));
					td.setId_facultad(rs.getInt("id_facultad"));
					td.setNombre_facultad(rs.getString("nombre_facultad"));
					td.setEstado(rs.getInt("estado"));
			
				}
			}catch (Exception e)
			{
				System.out.println("DATOS ERROR get Departamento by ID(): "+ e.getMessage());
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
			
			return td;
		}
		
		
		// Metodo para modificar departamento
		public boolean modificarDepartamento(Tbl_departamento tdepa)
		{
			boolean modificado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsDepartamento(c);
				rsDepartamento.beforeFirst();
				while (rsDepartamento.next())
				{
					if(rsDepartamento.getInt(1)==tdepa.getId_departamento())
					{
						rsDepartamento.updateString("nombre_departamento", tdepa.getNombre_departamento());
				//		rsDepartamento.updateString("nombre_facultad", tdepa.getNombre_facultad());
						rsDepartamento.updateInt("id_facultad", tdepa.getId_facultad());
						rsDepartamento.updateInt("estado", 2);
						rsDepartamento.updateRow();
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR al modificar Departamento"+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsDepartamento != null){
						rsDepartamento.close();
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
		
	
		// Metodo para eliminar departamento
		public boolean eliminarDepartamento(Tbl_departamento tdepa)
		{
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsDepartamento(c);
				rsDepartamento.beforeFirst();
				while (rsDepartamento.next()){
					if(rsDepartamento.getInt(1)==tdepa.getId_departamento())
					{
						rsDepartamento.updateInt("estado", 3);
						rsDepartamento.updateRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e){
				System.err.println("ERROR al eliminar departamento) "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsDepartamento != null){
						rsDepartamento.close();
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