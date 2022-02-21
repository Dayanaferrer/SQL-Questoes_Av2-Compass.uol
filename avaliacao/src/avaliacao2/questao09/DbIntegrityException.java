package avaliacao2.questao09;

// Exceção personalizada de integridade referencial

public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbIntegrityException (String msg) {
		super(msg);
	}

}
