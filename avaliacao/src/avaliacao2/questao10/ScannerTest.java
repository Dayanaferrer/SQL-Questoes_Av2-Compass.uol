package avaliacao2.questao10;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws SQLException {
		
		Scanner sn = new Scanner(System.in);
		
		Emoji humor = new Emoji();

		try (Connection connection = new ConnectorFactory().createConnector()){
			
		}
			
			System.out.println("Como está o humor do seu dia? ");
			System.out.println("===================================================");
			System.out.println("Responda com um dos seguintes emoticons :-) ou :-( ");
			
			String resposta = sn.nextLine();
			humor.selectEmoji(resposta);		
		

	}

}
