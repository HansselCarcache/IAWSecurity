package negocio;

import java.sql.Date;

public class Ng_Oferta_Det {
	
	public int verifyDates(Date sqlinicio, Date sqlfin, Date sqlfinicioe, Date sqlfine) {
		int x = 0;
		if( sqlfinicioe.getTime() <= sqlinicio.getTime() && sqlfine.getTime() >= sqlinicio.getTime()) {
			//Fecha inicio esta en rango
			
			if(sqlfinicioe.getTime() <= sqlfin.getTime() && sqlfine.getTime() >= sqlfin.getTime()) {
				//Fecha final esta en rango
				if(sqlinicio.getTime() <= sqlfin.getTime()) {
					//Fecha de inicio es menor o igual que fecha final
					x=1;	
				}
				else 
				{
					//Fecha inicio es mayor que la final
					x=2;
				}
			}
			else 
			{
				//Fecha final fuera de rango
				x=3;
			}
		}
		else
		{
			//Fecha inicio fuera de rango
			x=4;
		}
		return x;
	}
}
