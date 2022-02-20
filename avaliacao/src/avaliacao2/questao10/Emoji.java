package avaliacao2.questao10;

public class Emoji {
	
	private Integer idTbl; 
	private String sentimento;
	private String dia;
	
	private Integer emojiChateado;
	private Integer emojiDivertido;
	private String chateado = " :-( ";
	private String divertido = " :-) ";
	
	public Emoji(String emj) {
		this.sentimento=emj;
	}

	public Emoji() {
		
	}

	public void selectEmoji (String selectEmj) {
		this.emojiChateado = selectEmj.split(this.chateado, -1).length -1;
		this.emojiDivertido = selectEmj.split(this.divertido, -1).length -1;
		resultEmoji();		
	}
	public void resultEmoji () {
		if(getEmojiDivertido() > getEmojiChateado()) {
			String sentimentoFuncionario = "Divertido :-) ";
			System.out.println(sentimentoFuncionario);
			setSentimento(sentimentoFuncionario);
			
		}else if (getEmojiDivertido() < getEmojiChateado()) {
			String sentimentoFuncionario = "Chateado :-( ";
			System.out.println(sentimentoFuncionario);
			setSentimento(sentimentoFuncionario);
			
		}else { 
			String sentimentoFuncionario = "Neutro!";
			System.out.println(sentimentoFuncionario);
			setSentimento(sentimentoFuncionario);
						
		}
	}
	
	
	public Integer getIdTbl() {
		return idTbl;
	}
	public void setIdTbl(Integer idTbl) {
		this.idTbl = idTbl;
	}
	public String getSentimento() {
		return sentimento;
	}
	public void setSentimento(String sentimento) {
		this.sentimento = sentimento;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Integer getEmojiChateado() {
		return emojiChateado;
	}
	public void setEmojiChateado(Integer emojiChateado) {
		this.emojiChateado = emojiChateado;
	}
	public Integer getEmojiDivertido() {
		return emojiDivertido;
	}
	public void setEmojiDivertido(Integer emojiDivertido) {
		this.emojiDivertido = emojiDivertido;
	}
	public String getChateado() {
		return chateado;
	}
	public void setChateado(String chateado) {
		this.chateado = chateado;
	}
	public String getDivertido() {
		return divertido;
	}
	public void setDivertido(String divertido) {
		this.divertido = divertido;
	}		

}
