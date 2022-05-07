package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Vw_carreraInscripcion;
import entidades.Vw_carrera_departamento;
import entidades.Vw_inscripcionAdmin;

public class Dt_inscripcionAdmin {
	
	
	//Atributos
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsInscripcionAdmin = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private ResultSet rsInscripcion_carrera = null;
	
	public void llenar_rsInscripcionAdmin(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.inscripcion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsInscripcionAdmin = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCIONES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void llenar_rsInscripcion_carrera(Connection c2) {
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.carrera_inscripcion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsInscripcion_carrera = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCIONES CARRERA "+ e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	   //Metodo para visualizar inscripcion registrados y activos
	   public ArrayList<Vw_inscripcionAdmin> listaInsAdmActivos(){
		ArrayList<Vw_inscripcionAdmin> listInsAdm = new ArrayList<Vw_inscripcionAdmin>();
		try {
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_inscripcion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_inscripcionAdmin InsAdm = new Vw_inscripcionAdmin(); //instanciamos a Inscripcion
				InsAdm.setId_inscripcion(rs.getInt("id_inscripcion"));
				InsAdm.setNombre_completo(rs.getString("nombre_completo"));
				InsAdm.setTelefono(rs.getString("telefono"));
				InsAdm.setCorreo(rs.getString("correo"));
				InsAdm.setEstado(rs.getInt("estado"));
				InsAdm.setOtras_dependencias(rs.getString("otras_dependencias"));
				InsAdm.setId_usuario(rs.getInt("id_usuario"));
				InsAdm.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				listInsAdm.add(InsAdm);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCION: "+ e.getMessage());
			e.printStackTrace();
			
		}
		finally {
			try {
				if(rs!= null) {
					rs.close();
				}
				if(ps!= null) {
					ps.close();
				}
				if(c != null) {
					poolConexion.closeConnection(c);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listInsAdm;
	}
			
	   //Metodo para agregar InscripcionAdmin
	
	   public int addInscripcionAdmin(Vw_inscripcionAdmin InsAdm){
		int guardado = 0;
		
		try{
			c = poolConexion.getConnection();
			this.llenar_rsInscripcionAdmin(c);
			this.rsInscripcionAdmin.moveToInsertRow();
			rsInscripcionAdmin.updateString("nombre_completo", InsAdm.getNombre_completo());
			rsInscripcionAdmin.updateString("telefono", InsAdm.getTelefono());
			rsInscripcionAdmin.updateString("correo", InsAdm.getCorreo());
			rsInscripcionAdmin.updateInt("estado", 1);
			rsInscripcionAdmin.updateString("otras_dependencias", InsAdm.getOtras_dependencias());
			rsInscripcionAdmin.updateInt("id_usuario", InsAdm.getId_usuario());
			rsInscripcionAdmin.updateInt("id_oferta_detalle", InsAdm.getId_oferta_detalle());
			
			
			
			rsInscripcionAdmin.insertRow();
			
			rsInscripcionAdmin.moveToCurrentRow();
			this.llenar_rsInscripcionAdmin(c);
			rsInscripcionAdmin.last();
			guardado = rsInscripcionAdmin.getInt("id_inscripcion");
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR INSCRIPCION: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsInscripcionAdmin != null){
					rsInscripcionAdmin.close();
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
	
	    //Visualizar InscripcionAdmin
	
	    public Vw_inscripcionAdmin getInscripcionAdmin(int id) {
		Vw_inscripcionAdmin InsAdm = new Vw_inscripcionAdmin();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_inscripcion where id_inscripcion = " +id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//ps.setInt(1, idTC);
			rs = ps.executeQuery();
			if(rs.next()) {
				InsAdm.setId_inscripcion(rs.getInt("id_inscripcion"));
				InsAdm.setNombre_completo(rs.getString("nombre_completo"));
				InsAdm.setTelefono(rs.getString("telefono"));
				InsAdm.setCorreo(rs.getString("correo"));
				InsAdm.setEstado(rs.getInt("estado"));
				InsAdm.setOtras_dependencias(rs.getString("otras_dependencias"));
				InsAdm.setId_usuario(rs.getInt("id_usuario"));
				InsAdm.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				
				
			}
		}catch (Exception e)
		{
			System.out.println("DATOS ERROR getInscripcionAdmin(): "+ e.getMessage());
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
		
		return InsAdm;
	}
	
	
	    // Metodo para Eliminar inscripcion 
		public boolean deleteInscripcion(Vw_inscripcionAdmin InsAdm)
		{
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenar_rsInscripcionAdmin(c);
				rsInscripcionAdmin.beforeFirst();
				while (rsInscripcionAdmin.next())
				{
					if(rsInscripcionAdmin.getInt(1)==InsAdm.getId_inscripcion())
					{
						rsInscripcionAdmin.updateInt("estado", 3);
						
						rsInscripcionAdmin.updateRow();
						eliminado=true;
						break;
					}
					
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR AL deleteInscripcion() "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsInscripcionAdmin != null){
						rsInscripcionAdmin.close();
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
		
		
		

		//Metodo para modificar la inscripcion
		public boolean updateInscripcionAdmin(Vw_inscripcionAdmin ia)
		{
			boolean modificado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenar_rsInscripcionAdmin(c);
				rsInscripcionAdmin.beforeFirst();
				while (rsInscripcionAdmin.next())
				{
					if(rsInscripcionAdmin.getInt(1)==ia.getId_inscripcion())
					{
						rsInscripcionAdmin.updateString("nombre_completo", ia.getNombre_completo());
						rsInscripcionAdmin.updateString("telefono", ia.getTelefono());
						rsInscripcionAdmin.updateString("correo", ia.getCorreo());
						rsInscripcionAdmin.updateInt("estado", ia.getEstado());
						rsInscripcionAdmin.updateInt("id_usuario", ia.getId_usuario());
						rsInscripcionAdmin.updateString("otras_dependencias", ia.getOtras_dependencias());
						rsInscripcionAdmin.updateInt("id_oferta_detalle", ia.getId_oferta_detalle());
						
						
						
						
						rsInscripcionAdmin.updateRow();
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR AL updateInscripcionAdmin() "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsInscripcionAdmin != null){
						rsInscripcionAdmin.close();
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
	
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//"Detalle"
		
		//Metodo para obtener carreaInscripcion por ID
		public ArrayList<Vw_carreraInscripcion> listaCaInscripcion(int id_inscripcion){
			ArrayList<Vw_carreraInscripcion> listaCaInscripcion = new ArrayList<Vw_carreraInscripcion>();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_carrera_inscripcion where id_inscripcion = " +id_inscripcion, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				//ps.setInt(1, idTC);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					Vw_carreraInscripcion CaIns = new Vw_carreraInscripcion();
					
					CaIns.setId_carrera(rs.getInt("id_carrera"));
					CaIns.setNombre_carrera(rs.getString("nombre_carrera"));
					CaIns.setId_departamento(rs.getInt("id_departamento"));
					CaIns.setIdcarrera_inscripcion(rs.getInt("idcarrera_inscripcion"));
					CaIns.setId_facultad(rs.getInt("id_facultad"));
					CaIns.setEstado(rs.getInt("estado"));
					CaIns.setId_inscripcion(rs.getInt("id_inscripcion"));
					
					listaCaInscripcion.add(CaIns);
				}
			}catch (Exception e)
			{
				System.out.println("DATOS ERROR listaCaInscripcion(): "+ e.getMessage());
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
			
			return listaCaInscripcion;
		}

		//Agregar CarreraInscripcion
		public boolean addInscripcionCarrera(Vw_carrera_departamento CaIns, int id_inscripcion){
			boolean guardado = false;
			
			try{
				c = poolConexion.getConnection();
				this.llenar_rsInscripcion_carrera(c);
				this.rsInscripcion_carrera.moveToInsertRow();
				rsInscripcion_carrera.updateInt("id_carrera", CaIns.getId_carrera());
				rsInscripcion_carrera.updateInt("id_departamento", CaIns.getId_departamento());
				rsInscripcion_carrera.updateInt("id_facultad", CaIns.getId_facultad());
				rsInscripcion_carrera.updateInt("id_inscripcion", id_inscripcion);
				rsInscripcion_carrera.updateInt("estado", 1);				
				rsInscripcion_carrera.insertRow();
				rsInscripcion_carrera.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR INSCRIPCION CARRERA: "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsInscripcionAdmin != null){
						rsInscripcionAdmin.close();
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

		//Eliminar CarreraInscripcionById
		public boolean deleteCarreraInscripcionById(int id)
		{
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenar_rsInscripcion_carrera(c);
				rsInscripcion_carrera.beforeFirst();
				while (rsInscripcion_carrera.next()){
					if(rsInscripcion_carrera.getInt("id_inscripcion") == id){
						rsInscripcion_carrera.updateInt("estado", 3);
						rsInscripcion_carrera.deleteRow();
						eliminado=true;
						
					}
				}
			}
			catch (Exception e){
				System.err.println("ERROR AL deleteCarreraInscripcionById() "+e.getMessage());
				e.printStackTrace();
			}
			finally{
			try {
				if(rsInscripcion_carrera != null){
					rsInscripcion_carrera.close();
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

        //Eliminar CarreraInscripcion
		public boolean deleteCarreraInscripcion(Vw_carreraInscripcion ci)
		{
			Dt_inscripcionAdmin dtIA= new Dt_inscripcionAdmin();
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenar_rsInscripcion_carrera(c);
				rsInscripcionAdmin.beforeFirst();
				while (rsInscripcionAdmin.next()){
					if(rsInscripcionAdmin.getInt(1)==ci.getIdcarrera_inscripcion()){
						rsInscripcionAdmin.updateInt("estado", 3);
						rsInscripcionAdmin.deleteRow();
						eliminado=true;
						break;
					}
				}
				
				dtIA.deleteCarreraInscripcionById(ci.getIdcarrera_inscripcion());
			}
			catch (Exception e){
				System.err.println("ERROR AL deleteOferta() "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsInscripcionAdmin != null){
						rsInscripcionAdmin.close();
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

	

