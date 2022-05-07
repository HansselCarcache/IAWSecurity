package datos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entidades.Tbl_user;
import entidades.Vw_userrol;

public class Dt_usuario {
	
	//Atributos
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsUsuario(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM gestion_docente.usuario;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Tbl_user> listaUserActivos(){
		ArrayList<Tbl_user> listUser = new ArrayList<Tbl_user>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.usuario WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tbl_user user = new Tbl_user();
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setId_uca(rs.getString("id_uca"));
				user.setNombre_real(rs.getString("nombre_real"));
				user.setNombre_usuario(rs.getString("nombre_usuario"));
				user.setPwd(rs.getString("pwd"));
				user.setCorreo_institucional(rs.getString("correo_institucional"));
				user.setCorreo_personal(rs.getString("correo_personal"));
				user.setSexo(rs.getInt("sexo"));
				user.setCargo(rs.getString("cargo"));
				user.setTelefono_contacto(rs.getString("telefono_contacto"));
				user.setEstado(rs.getInt("estado"));
				user.setCedula(rs.getString("cedula"));
				
				
				
				/*user.setFecha_registro(rs.getString("fecha_registro"));
				user.setUrlFoto(rs.getString("urlFoto"));
				user.setCodVerificacion(rs.getString("codVerificacion"));
				
				user.setUsuario_creacion(rs.getInt("usuario_creacion"));
				user.setFecha_creacion(rs.getString("fecha_creacion"));
				user.setUsuario_edicion(rs.getInt("usuario_edicion"));
				user.setFecha_edicion(rs.getString("fecha_edicion"));
				user.setUsuario_eliminacion(rs.getInt("usuario_eliminacion"));
				user.setFecha_eliminacion(rs.getString("fecha_eliminacion"));*/
				listUser.add(user);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS"+ e.getMessage());
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
		return listUser;
	}
	
	//CREACION DE JSON DE IDUCA Y CORREO INSTITUCIONAL
	public ArrayList<Tbl_user> crearJSON(){
		ArrayList<Tbl_user> listUser = new ArrayList<Tbl_user>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT nombre_usuario, id_uca, correo_institucional, cedula FROM gestion_docente.usuario;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tbl_user user = new Tbl_user();
				user.setNombre_usuario(rs.getString("nombre_usuario"));
				user.setId_uca(rs.getString("id_uca"));
				user.setCorreo_institucional(rs.getString("correo_institucional"));
				user.setCedula(rs.getString("cedula"));
				listUser.add(user);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS"+ e.getMessage());
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
		//PARA GUARDAR
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			try (FileWriter writer = new FileWriter("../eclipseApps/Security/production/datos_usuario.json")) {
	            gson.toJson(listUser, writer);
	            
	            
	           
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			//PARA LEER
			String fileName = "../eclipseApps/Security/production/datos_usuario.json";
			Path path = new File(fileName).toPath();
			
			try (Reader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

	            
				Tbl_user[] lista2 = gson.fromJson(br, Tbl_user[].class);
	            Arrays.stream(lista2).forEach(e -> {
	            	//System.out.println("{"+"\n"+"id_uca: "+e.getId_uca()+",\n"+"correo institucional: "+ e.getCorreo_institucional()+"\n}\n");
	            });

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			//PARA ELIMINAR EL ARCHIVO PEGARLO EN EL SERVLET
			/*File archivoJSON = new File("../eclipseApps/Security/production/datos_rol.json");
			eliminarFichero(archivoJSON);*/
			//PARA ELIMINAR EL ARCHIVO PEGARLO EN EL SERVLET
		
		return listUser;
	}
	
	public ArrayList<Tbl_user> listaUserInactivos(){
		ArrayList<Tbl_user> listUser = new ArrayList<Tbl_user>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.usuario WHERE estado = 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tbl_user user = new Tbl_user();
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setId_uca(rs.getString("id_uca"));
				user.setNombre_real(rs.getString("nombre_real"));
				user.setNombre_usuario(rs.getString("nombre_usuario"));
				user.setPwd(rs.getString("pwd"));
				user.setCorreo_institucional(rs.getString("correo_institucional"));
				user.setCorreo_personal(rs.getString("correo_personal"));
				user.setSexo(rs.getInt("sexo"));
				user.setCargo(rs.getString("cargo"));
				user.setTelefono_contacto(rs.getString("telefono_contacto"));
				user.setEstado(rs.getInt("estado"));
				user.setCedula(rs.getString("cedula"));
				
				
				
				/*user.setFecha_registro(rs.getString("fecha_registro"));
				user.setUrlFoto(rs.getString("urlFoto"));
				user.setCodVerificacion(rs.getString("codVerificacion"));
				
				user.setUsuario_creacion(rs.getInt("usuario_creacion"));
				user.setFecha_creacion(rs.getString("fecha_creacion"));
				user.setUsuario_edicion(rs.getInt("usuario_edicion"));
				user.setFecha_edicion(rs.getString("fecha_edicion"));
				user.setUsuario_eliminacion(rs.getInt("usuario_eliminacion"));
				user.setFecha_eliminacion(rs.getString("fecha_eliminacion"));*/
				listUser.add(user);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS"+ e.getMessage());
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
		return listUser;
	}
	
	//Metodo para almacenar nuevo usuario
	public int guardarUser(Tbl_user tus) {
		int guardado = 0;
		try {
			c = poolConexion.getConnection();
			this.llenaRsUsuario(c);
			rsUsuario.moveToInsertRow();
			rsUsuario.updateString("id_uca", tus.getId_uca());
			rsUsuario.updateString("nombre_real", tus.getNombre_real());
			rsUsuario.updateString("nombre_usuario", tus.getNombre_usuario());
			rsUsuario.updateString("pwd", tus.getPwd());
			rsUsuario.updateString("correo_institucional", tus.getCorreo_institucional());
			rsUsuario.updateString("correo_personal", tus.getCorreo_personal());
			rsUsuario.updateInt("sexo", tus.getSexo());
			rsUsuario.updateString("cargo", tus.getCargo());
			rsUsuario.updateString("telefono_contacto", tus.getTelefono_contacto());
			rsUsuario.updateInt("estado", 0);
			rsUsuario.updateString("cedula", tus.getCedula());
			//rsUsuario.updateString("urlFoto", tus.getUrlFoto());
			rsUsuario.updateString("codVerificacion", tus.getCodVerificacion());
			rsUsuario.updateInt("usuario_creacion", tus.getUsuario_creacion());
			rsUsuario.updateTimestamp("fecha_creacion", tus.getFecha_creacion());
			rsUsuario.insertRow();
			rsUsuario.moveToCurrentRow();
			this.llenaRsUsuario(c);
			rsUsuario.last();
			guardado = rsUsuario.getInt("id_usuario");
			
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Tbl_User "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsUsuario != null){
					rsUsuario.close();
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
	
	public Tbl_user getUserbyID(int idUser) {
		Tbl_user tu = new Tbl_user();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.usuario where id_usuario=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1,  idUser);
			rs = ps.executeQuery();
			if(rs.next()) {
				tu.setId_usuario(rs.getInt("id_usuario"));
				tu.setId_uca(rs.getString("id_uca"));
				tu.setNombre_real(rs.getString("nombre_real"));
				tu.setNombre_usuario(rs.getString("nombre_usuario"));
				tu.setCorreo_institucional(rs.getString("correo_institucional"));
				tu.setCorreo_personal(rs.getString("correo_personal"));
				tu.setSexo(rs.getInt("sexo"));
				tu.setCargo(rs.getString("cargo"));
				tu.setTelefono_contacto(rs.getString("telefono_contacto"));
				tu.setCedula(rs.getString("cedula"));
				tu.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
				tu.setEstado(rs.getInt("estado"));
				
			}
		}catch (Exception e)
		{
			System.out.println("DATOS ERROR getUserbyID(): "+ e.getMessage());
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
		return tu;
	}
	
	//metodo para modificar usuario
	public boolean modificarUser(Tbl_user tus) {
		boolean modificado = false;
		try {
			c = poolConexion.getConnection();
			this.llenaRsUsuario(c);
			rsUsuario.beforeFirst();
			while(rsUsuario.next())
			{
				if(rsUsuario.getInt(1)==tus.getId_usuario())
				{
					rsUsuario.updateString("id_uca", tus.getId_uca());
					rsUsuario.updateString("correo_institucional", tus.getCorreo_institucional());
					rsUsuario.updateString("nombre_real", tus.getNombre_real());
					rsUsuario.updateInt("sexo", tus.getSexo());
					rsUsuario.updateString("telefono_contacto", tus.getTelefono_contacto());
					rsUsuario.updateString("cargo", tus.getCargo());
					rsUsuario.updateInt("usuario_edicion", tus.getUsuario_edicion());
					rsUsuario.updateTimestamp("fecha_edicion", tus.getFecha_edicion());
					rsUsuario.updateInt("estado", 2);
					rsUsuario.updateRow();
					modificado = true;
					break;
				}
			}
		}catch (Exception e)
		{
			System.err.println("ERROR AL modificarUser() "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsUsuario != null){
					rsUsuario.close();
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
	
	//metodo para modificar usuario sin IDUCA
		public boolean modificarUserNoID(Tbl_user tus) {
			boolean modificado = false;
			try {
				c = poolConexion.getConnection();
				this.llenaRsUsuario(c);
				rsUsuario.beforeFirst();
				while(rsUsuario.next())
				{
					if(rsUsuario.getInt(1)==tus.getId_usuario())
					{
						
						rsUsuario.updateString("correo_institucional", tus.getCorreo_institucional());
						rsUsuario.updateString("nombre_real", tus.getNombre_real());
						rsUsuario.updateInt("sexo", tus.getSexo());
						rsUsuario.updateString("telefono_contacto", tus.getTelefono_contacto());
						rsUsuario.updateString("cargo", tus.getCargo());
						rsUsuario.updateInt("usuario_edicion", tus.getUsuario_edicion());
						rsUsuario.updateTimestamp("fecha_edicion", tus.getFecha_edicion());
						rsUsuario.updateInt("estado", 2);
						rsUsuario.updateRow();
						modificado = true;
						break;
					}
				}
			}catch (Exception e)
			{
				System.err.println("ERROR AL modificarUser() "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsUsuario != null){
						rsUsuario.close();
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
		
		//metodo para restaurar usuario
				public boolean restaurarUsuario(Tbl_user tus) {
					boolean modificado = false;
					try {
						c = poolConexion.getConnection();
						this.llenaRsUsuario(c);
						rsUsuario.beforeFirst();
						while(rsUsuario.next())
						{
							if(rsUsuario.getInt(1)==tus.getId_usuario())
							{
								
								
								rsUsuario.updateInt("usuario_edicion", tus.getUsuario_edicion());
								rsUsuario.updateTimestamp("fecha_edicion", tus.getFecha_edicion());
								rsUsuario.updateInt("estado", 4);
								rsUsuario.updateRow();
								modificado = true;
								break;
							}
						}
					}catch (Exception e)
					{
						System.err.println("ERROR AL modificarUser() "+e.getMessage());
						e.printStackTrace();
					}
					finally
					{
						try {
							if(rsUsuario != null){
								rsUsuario.close();
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
	

	// Metodo para eliminar usuario
	public boolean eliminarUser(Tbl_user tus)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llenaRsUsuario(c);
			rsUsuario.beforeFirst();
			while (rsUsuario.next()){
				if(rsUsuario.getInt(1)==tus.getId_usuario()){
					rsUsuario.updateTimestamp("fecha_eliminacion", tus.getFecha_eliminacion());
					rsUsuario.updateInt("usuario_eliminacion", tus.getUsuario_eliminacion());
					rsUsuario.updateInt("estado", 3);
					rsUsuario.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e){
			System.err.println("ERROR AL eliminarUser() "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsUsuario != null){
					rsUsuario.close();
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
	
	
	//METODO PARA GENERAR UN CODIGO DE VERIFICACION //
		public static String randomAlphaNumeric(int count) 
		{
			StringBuilder builder = new StringBuilder();
			while (count-- != 0) 
			{
				int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			return builder.toString();
		}
		
		// Metodo para actualizar el estado del Usuario //Cuando es verificado
		public boolean updEstado(String login)
		{
			boolean actualizado = false;
			try{
				c = poolConexion.getConnection();
				this.llenaRsUsuario(c);	
				rsUsuario.beforeFirst();
				while(rsUsuario.next()){
					if(rsUsuario.getString("nombre_usuario").equals(login)){
						rsUsuario.updateInt("estado", 1);
						rsUsuario.updateRow();
						actualizado = true;
						break;
					}
				}
			}
			catch (Exception e) {
				System.err.println("ERROR updEstado() "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsUsuario != null){
						rsUsuario.close();
					}
					if(c != null){
						poolConexion.closeConnection(c);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return actualizado;
		}
		
		// METODO PARA OBTENER UN OBJETO DE TIPO Vw_userrol //
				public Vw_userrol dtGetVwUR(String login){
					Vw_userrol vwur = new Vw_userrol();
					String SQL = ("SELECT * FROM gestion_docente.vw_rol_usuarios WHERE nombre_usuario=? and estado<>3");
					try{
						c = poolConexion.getConnection();
						ps = c.prepareStatement(SQL);
						ps.setString(1, login);
						rs = ps.executeQuery();
						if(rs.next()){
							vwur.setId_usuario(rs.getInt("id_usuario"));
							vwur.setNombre_usuario(rs.getString("nombre_usuario"));
							vwur.setUsuario(rs.getString("nombre_real"));
							vwur.setPwd(rs.getString("pwd"));
							vwur.setKey(rs.getString("token"));
							vwur.setCodVerificacion(rs.getString("codVerificacion"));
							vwur.setId_rol(rs.getInt("id_rol"));
							vwur.setRol(rs.getString("rol_descripcion"));
							vwur.setEstado(rs.getInt("estado"));
						}
					}
					catch (Exception e){
						System.out.println("DATOS: ERROR EN dtGetVwUR "+ e.getMessage());
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
				
					return vwur;
				}
		
				// METODO PARA VERIFICAR USUARIO, PWD, ROL Y CODIGO DE VERIFICACION // POR PRIMERA VEZ
				public boolean dtverificarLogin2(String login, String clave, int rol, String codigo)
				{
					boolean existe=false;
					String SQL = ("SELECT * FROM gestion_docente.vw_rol_usuarios WHERE nombre_usuario=? AND pwd=? AND id_rol=? AND codVerificacion=? AND estado=0");
					try{
						/////// DESENCRIPTACION DE LA PWD //////////
						Vw_userrol vwur = new Vw_userrol();
						Encrypt enc = new Encrypt();
						vwur = this.dtGetVwUR(login);
						String pwdDecrypt = "";
						String pwdEncrypt = "";
						
						pwdEncrypt = vwur.getPwd();
						pwdDecrypt = enc.getAESDecrypt(pwdEncrypt,vwur.getKey());
						/////////////////////////////////////////
						c = poolConexion.getConnection();
						ps = c.prepareStatement(SQL);
						ps.setString(1, login);
						if(clave.equals(pwdDecrypt)){
							ps.setString(2, pwdEncrypt);
						}
						else {
							ps.setString(2, clave);
						}
						
						ps.setInt(3, rol);
						ps.setString(4, codigo);
						rs = ps.executeQuery();
						if(rs.next()){
							existe=true;
							this.updEstado(login);
						}
					}
					catch (Exception e){
						System.out.println("DATOS: ERROR dtverificarLogin2() "+ e.getMessage());
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
				
					return existe;
				}
		
				// METODO PARA VERIFICAR USUARIO, PWD Y ROL //
				public boolean dtverificarLogin(String login, String clave, int rol)
				{
					boolean existe=false;
					String SQL = ("SELECT * FROM gestion_docente.vw_rol_usuarios WHERE nombre_usuario=? AND pwd=? AND id_rol=? AND estado>0 AND estado<3");
					try{
						/////// DESENCRIPTACION DE LA PWD //////////
						Vw_userrol vwur = new Vw_userrol();
						Encrypt enc = new Encrypt();
						vwur = this.dtGetVwUR(login);
						String pwdDecrypt = "";
						String pwdEncrypt = "";
						
						pwdEncrypt = vwur.getPwd();
						pwdDecrypt = enc.getAESDecrypt(pwdEncrypt,vwur.getKey());
						/////////////////////////////////////////
						c = poolConexion.getConnection();
						ps = c.prepareStatement(SQL);
						ps.setString(1, login);
						
						if(clave.equals(pwdDecrypt)){
							ps.setString(2, pwdEncrypt);
						}
						else {
							ps.setString(2, clave);
						}
						ps.setInt(3, rol);
						rs = ps.executeQuery();
						if(rs.next()){
							existe=true;
						}
					}
					catch (Exception e){
						System.out.println("DATOS: ERROR dtverificarLogin() "+ e.getMessage());
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
				
					return existe;
				}
	
}
