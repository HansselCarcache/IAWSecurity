package datos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.*;
import java.sql.SQLException;

import com.google.gson.Gson;

import entidades.Tbl_rol;

public class crearJson {
	
	public void crear(){
	Gson gson = new Gson();
	Tbl_rol tu = new Tbl_rol(1,"prueba",1);
	String json = gson.toJson(tu);
	try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos_persona.json"))) {
	    bw.write(json);
	    System.out.println("Fichero creado");
	} catch (IOException ex) {
	   
	}
	}
	
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		Tbl_rol tu = new Tbl_rol(1,"prueba",1);
		String json = gson.toJson(tu);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos_persona.json"))) {
		    bw.write(json);
		    System.out.println("Fichero creado");
		} catch (IOException ex) {
		   
		}
	}
}
