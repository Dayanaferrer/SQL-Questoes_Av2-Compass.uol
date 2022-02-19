package avaliacao2.questao10;
import java.util.Scanner;

public class ClasseScanner {

	public static void main(String[] args) throws Exception{
		
		Scanner sn = new Scanner(System.in);
						
		char[] divertido  = new char[] {58, 45, 41,}; 	//ASCII :-)
		char[] chateado  = new char[] {58, 45, 40,};	//ASCII :-(
		
	    System.out.println("====================================");
		System.out.printf("Como está o humor do seu dia: ");
		
		String humor =sn.nextLine();
		
		//char [] h = divertido;
		//char [] humorChateado = chateado;
		
		
		System.out.println("Seu humor está " + humor);
		
		sn.close();

	}

}
