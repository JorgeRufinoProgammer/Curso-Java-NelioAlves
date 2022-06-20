package Aulas_com_String;

public class Aula_59 {

	public static void main(String[] args) {
		String original = "abcde FGHIJ ABC abc DEFG     "; 
		//A primeira posição de uma String começa com 0
		
		String s01 = original.toLowerCase();
		String s02 = original.toUpperCase();
		String s03 = original.trim();
		String s04 = original.substring(2);//pega os caracteres da String a partir da posição 2, que no caso é o C pois começo com 0
		String s05 = original.substring(2, 9);//pega os caracteres de posição 2 até uma posição antes da 9 (pos. 9 é o I)
		String s06 = original.replace('a','x');//troca o 'a' minusculo por 'x' minusculo
		String s07 = original.replace("abc","xy");
		int i = original.indexOf("bc");//posicao da primeira ocorrencia do 'bc'		
		int j = original.lastIndexOf("bc");//posicao da ultima ocorrencia do 'bc'		
		String s55 = original.substring(2).trim();
				
		System.out.println("Original: -" + original + "-");	//repare os espaçoes em branco no final
		System.out.println("Lower Case: -" + s01 + "-");
		System.out.println("Upper Case: -" + s02 + "-");
		System.out.println("Trim: -" + s03 + "-");			//repare que agora os espaços no final(ou começo) da string sumiram
		System.out.println("Substring(2): -" + s04 + "-");
		System.out.println("Substring(2,9): -" + s05 + "-");
		System.out.println("replace('a','x'): -" + s06 + "-");
		System.out.println("replace('abc','xy'): -" + s07 + "-");
		System.out.println("IndexOf('bc'): -" + i + "-");
		System.out.println("LastIndexOf('bc'): -" + j + "-");		
		System.out.println("Substring(2) com trim: -" + s55 + "-");
		System.out.println();
		
		String s = "potato apple lemon";
		String[] vect = s.split(" ");//split separa em um Vector com base em um Separador que no exemplo é o "espaço"
		System.out.println(vect[0]);
		System.out.println(vect[1]);
		System.out.println(vect[2]);
		
		String teste ="";
		for (i = 0;i < 3; i++) {
			teste = teste + vect[i] + " "; 
		}
		
		System.out.println(teste);
	}

}
