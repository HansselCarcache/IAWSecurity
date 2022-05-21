package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import datos.Dt_usuario;

/**
 * Servlet implementation class Sl_guardarFoto
 */
@WebServlet("/Sl_guardarFoto")
public class Sl_guardarFoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_guardarFoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			Dt_usuario dtu = new Dt_usuario();
			
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String path = getServletContext().getRealPath("/");
			List<FileItem> items = upload.parseRequest(request);
			File fichero = null;
			String idusuario = null;
			String rutaFichero = null;
			String usuario = null;
			int rolID = 0;
			
			for(FileItem item: items) {
				FileItem uploaded = item;
				if(uploaded.isFormField()) {
					String key = uploaded.getFieldName();
					String valor = uploaded.getString();
					String valor2 = uploaded.getString();
					String valor3 = uploaded.getString();
					if(key.equals("id_usuario")) {
						idusuario = valor;
					}
					
				}
			}
			
			for(FileItem item: items) {
				FileItem uploaded = item;
				if(!uploaded.isFormField()) {
					////////TAMAÑO DEL ARCHIVO////////
					long size = uploaded.getSize();
					System.out.println("size: "+size);
					
					/////GUARDAMOS EN UN ARREGLO LOS FORMATOS QUE SE DESEAN PERMITIR
					List<String> formatos = Arrays.asList("image/jpeg");
					
					/////COMPROBAR SI EL TAMAÑO Y FORMATO SON PERMITIDOS////////
					//if(formatos.contains(uploaded.getContentType()) && size <= 102400)
					if(formatos.contains(uploaded.getContentType())) {
						System.out.println("Filetype: "+uploaded.getContentType());
						
						rutaFichero = "fotoUsuario_"+idusuario+".jpg";
						path = "C:\\payara5\\glassfish\\fotos_usuariosGD\\";
						System.out.println(path+rutaFichero);
						
						fichero = new File(path+rutaFichero);
						System.out.println(path+rutaFichero);
						
						//////// GUARDAR EN EL SERVIDOR ///////////////
						uploaded.write(fichero);
						
						System.out.println("SERVIDOR: FOTO GUARDADA CON EXITO!!!");
						///////ACTUALIZAMOS EL CAMPO URLFOTO EN LA BASE DE DATOS
						String url = "fotos_usuariosGD/"+rutaFichero;
						
						if(dtu.guardarFotoUser(Integer.parseInt(idusuario), url)) {
							response.sendRedirect("production/tbl_Usuario.jsp?msj=10");
						}
						else {
							response.sendRedirect("production/tbl_Usuario.jsp?msj=11");
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("SERVLET: ERROR AL SUBIR LA FOTO: " + e.getMessage());
			System.out.println("SERVLET: ERROR AL SUBIR LA FOTO: " + e.getStackTrace());
		}
	}

}
