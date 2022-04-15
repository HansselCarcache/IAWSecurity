package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Tbl_user;

public class Dt_usuario {
	
	//Atributos
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
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
				user.setSexo(rs.getString("sexo"));
				user.setCargo(rs.getString("cargo"));
				user.setTelefono_contacto(rs.getString("telefono_contacto"));
				user.setEstado(rs.getInt("estado"));
				user.setCedula(rs.getString("cedula"));
				
				
				
				/*setFecha_registro(rs.getString("fecha_registro"));
				user.setUrlFoto(rs.getString("urlFoto"));
				user.setCodVerificacion(rs.getString("codVerificacion"));
				user.setKey_encriptacion(rs.getString("key_encriptacion"));
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
	
}
