<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<%
	Dt_escalaCalificacionDet ded = new Dt_escalaCalificacionDet();
	ArrayList<Tbl_escalaCalificacionDet> ted = new ArrayList<Tbl_escalaCalificacionDet>();
	String id = request.getParameter("idTipo");

	ted = ded.listaESCD_id(Integer.parseInt(id));
	String cadena="";
	
	if(ted.isEmpty()==false){
		cadena="<option value='0'>Seleccione...</option>";
		
		for(Tbl_escalaCalificacionDet tb:ted){
			cadena +="<option value='"+tb.getId_det_escalaCalificacion()+"'>"+tb.getValor1()+" - "+tb.getValor2()+"</option>";
		}
		
		cadena+="*************";
		
		for(Tbl_escalaCalificacionDet tb:ted){
			cadena +="<option value='"+tb.getId_det_escalaCalificacion()+"'>"+tb.getDescripcion()+"</option>";
		}
	}
	
	
	out.print(cadena);
%>