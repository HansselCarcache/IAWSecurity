package negocio;

import java.sql.Date;

public class Ng_Oferta {
	
	@SuppressWarnings("deprecation")
	public int verifyDates(Date sqlinicio, Date sqlfin) {
		int x = 0;
		if(sqlinicio.getYear()==sqlfin.getYear()) {
			if(sqlinicio.getTime()<=sqlfin.getTime()) {
				
				x=1;
			}else {
				//Inicio es mayor que final so bai
				x=3;
			}
		}else {
			//Fechas en distintos años so no
			x=2;
		}
		return x;
	}
}
