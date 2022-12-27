package com.rcg.Date;

import java.util.Calendar;
import java.util.Date;
 
public class Formato{
    private static final int  DIA = 0,MES = 1, ANIO = 2;
	public static void main(String[] args){
		System.out.println(configurarFecha("02/03/2020","dd/mm/yyyy"));
		/*System.out.println(configurarFecha("2020/03/02","yyyy/mm/dd"));
		System.out.println(configurarFecha("03/02/2020","mm/dd/yyyy"));*/
	}
	
	public static Date configurarFecha(String fecha, String formato){
		int[] datos = new int[3];
		int indice = 0;
		String[] separadoFecha = fecha.split("/");
		String[] separadoFormato = formato.split("/");
		Calendar respuesta;
		for(int i = 0 ; i < separadoFormato.length ; i++){
			indice = indices(separadoFormato[i].charAt(0));
			datos[indice] = Integer.parseInt(separadoFecha[i]);
            System.out.print("Datos indice: " );
            System.out.println(datos[indice] = Integer.parseInt(separadoFecha[i]));
		}
		if(datos[DIA] > 0 && datos[DIA] <= 31 && datos[MES] > 0 && datos[MES] <=12){
			respuesta  = Calendar.getInstance();
			respuesta.set(datos[ANIO],datos[MES]-1,datos[DIA],0,0,0);
		}else{
			return null;
		}
		return respuesta.getTime();
	}
	
	public static int indices(char caracter){
		if(caracter == 'd'){
            System.out.println("DIA: "+DIA);
			return DIA;
		}else if(caracter == 'm'){
            System.out.println("MES: "+MES);
			return MES;
		}else if(caracter == 'y'){
            System.out.println("ANIO: "+ANIO);
			return ANIO;
		}
		return -1;
	}
}
