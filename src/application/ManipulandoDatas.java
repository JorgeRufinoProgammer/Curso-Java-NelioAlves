package application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class ManipulandoDatas {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");				//formato que será mostrada a data
		
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));				

		
		System.out.println(sdf.format(d));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4); //adiciona 4 horas a data/hora
		d = cal.getTime();
		
		System.out.println(sdf.format(d)+ " -> 4 horas a mais");
		
		cal.add(Calendar.DAY_OF_YEAR, 2); //adiciona 2 dias a data/hora
		d = cal.getTime();
		
		System.out.println(sdf.format(d)+ " -> 2 dias a mais");
		
		cal.add(Calendar.MONTH, 7); //adiciona 7 meses a data/hora
		d = cal.getTime();
		
		System.out.println(sdf.format(d)+ " -> 7 meses a mais");
		
		int minutes = cal.get(Calendar.MINUTE);
		int month = cal.get(Calendar.MONTH);		//Janeiro no Java é o mês zero, por isso deve-se adicionar mais 1
		int month2 = 1 + cal.get(Calendar.MONTH);	//Adicionou mais 1 para pegar o mês certo
		System.out.println("Minutes:"+ minutes);
		System.out.println("Month:"+ month);
		System.out.println("Month:"+ month2);
	}

}
