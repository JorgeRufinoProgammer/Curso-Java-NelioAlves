package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Datas {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");				//formato que será mostrada a data
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	//formato que será mostrada a data
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date y1 = sdf1.parse("25/06/2022");				
		Date y2 = sdf2.parse("25/06/2022 07:30:25");	
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));				

		Date x1 = new Date();							//pega a data e o horario no momento da exato
		Date x2 = new Date(System.currentTimeMillis()); //pega a data e o horario no momento da exato passando os milissegundos de 1970 até hoje
		Date x3 = new Date(0L);							//passou 0 milisegundos, logo é a data usada como referencia (01/01/1970)
		Date x4 = new Date(1000L*60L*60L*5L); // Mil milisegundos que é igual a 1 segundo, * 60 (1min), * 60 (1 hora), * 5 (5 horas de 01/01/1970)		
		
		//Mostra as datas no formato padrão do Java
		System.out.println(y1);	
		System.out.println(y2);
		System.out.println(x1);
		
		//Mostra as datas de acordo com o formato definido nos Objetos do tipo Date
		System.out.println("Y1: "+sdf1.format(y1));			//usou o formato do obj "sdf1"
		System.out.println("Y2: "+sdf2.format(y2));			//usou o formato do obj "sdf2"
		System.out.println("Y3: "+sdf2.format(y3));			//No hora
		System.out.println("X1: "+sdf2.format(x1));			
		System.out.println("X2: "+sdf2.format(x2));
		System.out.println("X3: "+sdf2.format(x3));			//Como estamos no Brasil, tem uma diferença de 3horas, por isso gerou esta data
		System.out.println("X4: "+sdf2.format(x4));		
		System.out.println("----------------------");
		System.out.println("Y1: "+sdf3.format(y1));			
		System.out.println("Y2: "+sdf3.format(y2));			
		System.out.println("Y3: "+sdf3.format(y3));			
		System.out.println("X1: "+sdf3.format(x1));			
		System.out.println("X2: "+sdf3.format(x2));
		System.out.println("X3: "+sdf3.format(x3));
		System.out.println("X4: "+sdf3.format(x4));	
	}

}
