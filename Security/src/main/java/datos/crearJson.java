package datos;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entidades.Tbl_rol;

public class crearJson {
	
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	
	
	public ArrayList<Tbl_rol> listaRolActivos(){
		ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM seguridad.tbl_rol WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tbl_rol trol = new Tbl_rol(); //instanciamos a rol
				trol.setId_rol(rs.getInt("id_rol"));
				trol.setRol(rs.getString("rol"));
				trol.setEstado(rs.getInt("estado"));
				listRol.add(trol);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
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
		
		//PARA GUARDAR
		try (FileWriter writer = new FileWriter("Security:\\\\\\\\src\\\\\\\\main\\\\\\\\datos_rol.json")) {
            gson.toJson(listRol, writer);
            
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		//PARA LEER
		String fileName = "C:\\\\\\\\payara5\\\\\\\\glassfish\\\\\\\\domains\\\\\\\\domain1\\\\\\\\config\\\\\\\\datos_rol.json";
		Path path = new File(fileName).toPath();
		
		try (Reader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            
            Tbl_rol[] lista2 = gson.fromJson(br, Tbl_rol[].class);
            Arrays.stream(lista2).forEach(e -> {
            	System.out.println("{"+"\n"+"id_rol: "+e.getId_rol()+",\n"+"rol: "+ e.getRol()+",\n"+"estado: "+ e.getEstado()+"\n}\n");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
		return listRol;
	}
	
	
	public static void writeJsonSimpleDemo(String filename) throws Exception {
	    JSONObject sampleObject = new JSONObject();
	    sampleObject.put("name", "Pharos.shr");
	    sampleObject.put("age", 35);

	    JSONArray messages = new JSONArray();
	    messages.add("Hey!");
	    messages.add("What's up?!");

	    sampleObject.put("messages", messages);
	    Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
	}
	
	public static Object readJsonSimpleDemo(String filename) throws Exception {
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}
	
	public File eliminarFichero(File fichero) {
		 if (!fichero.exists()) {
		        System.out.println("El archivo data no existe.");
		    } else {
		        fichero.delete();
		        System.out.println("El archivo data fue eliminado.");
		    }
		 return fichero;
	}
	public Path fichero() {
		//PARA GUARDAR
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				try (FileWriter writer = new FileWriter("../datos_persona3.json")) {
		            gson.toJson(listaRolActivos(), writer);
		            
		           
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				//PARA LEER
				String fileName = "../datos_persona3.json";
				Path path = new File(fileName).toPath();
				
				try (Reader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

		            
		            Tbl_rol[] lista2 = gson.fromJson(br, Tbl_rol[].class);
		            Arrays.stream(lista2).forEach(e -> {
		            	System.out.println("{"+"\n"+"id_rol: "+e.getId_rol()+",\n"+"rol: "+ e.getRol()+",\n"+"estado: "+ e.getEstado()+"\n}\n");
		            });

		        }  catch (IOException e) {
		            e.printStackTrace();
		        }
				return path;
						
	}
	
	
	
	
	public static void main(String[] args) {
		/*Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Tbl_rol tu = new Tbl_rol(1,"prueba",1);
		Tbl_rol tu2 = new Tbl_rol(1,"prueba2",1);
		ArrayList<Tbl_rol> lista = new ArrayList<Tbl_rol>();
		lista.add(tu);
		lista.add(tu2);
		
		try (FileWriter writer = new FileWriter("src/main/webapp/production/datos_persona.json")) {
            gson.toJson(lista, writer);
            
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		String fileName = "src/main/webapp/production/datos_persona.json";
		Path path = new File(fileName).toPath();
		
		try (Reader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            
            Tbl_rol[] lista2 = gson.fromJson(br, Tbl_rol[].class);
            Arrays.stream(lista2).forEach(e -> {
            	System.out.println("{"+"\n"+"id_rol: "+e.getId_rol()+",\n"+"rol: "+ e.getRol()+",\n"+"estado: "+ e.getEstado()+"\n}\n");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
		*/
		
		
		
		
		
		

	}
}
