package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Vw_facultad_departamento;

public class Dt_departamento {

	//Atributos
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsDepartamento = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsDepartamento(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_facultad_departamento;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
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
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_facultad_departamento WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

}