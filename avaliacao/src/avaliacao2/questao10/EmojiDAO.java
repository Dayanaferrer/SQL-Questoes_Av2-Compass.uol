package avaliacao2.questao10;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmojiDAO {

	private Connection connection;

	public EmojiDAO(Connection connection) {
		this.connection = connection;
	}
	public void Save(Emoji emoji) throws SQLException {
		String sql = "INSERT INTO tblemoji (emoji,dia) VALUES (?,?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, emoji.getSentimento());
			pstm.setDate(2, Date.valueOf(java.time.LocalDate.now()), null);
			

			pstm.execute();

			try (ResultSet resultado = pstm.getGeneratedKeys()) {
				while (resultado.next()) {
				emoji.setIdTbl(resultado.getInt(4));
				}
			}
		}
	}

	
}




/*
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import javax.swing.JOptionPane;
 * 
 * import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare; import
 * com.mysql.cj.xdevapi.Statement;
 * 
 * public class EmojiDAO {
 * 
 * public static void create (Emoji emj ) { //Método para salvar C (CRUD)
 * 
 * Connection con = ConnectorFactory.getConnection(); //Abrir conexão
 * PreparedStatement stmt = null;
 * 
 * try { stmt =
 * con.prepareStatement("INSERT INTO tblemoji (emoji, dia) VALUES (? , ?) ");
 * stmt.setString(1,emj.getSentimento()); stmt.setString(2,emj.getDia());
 * 
 * stmt.executeUpdate(); //Prepara o sql e executa
 * 
 * JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
 * 
 * } catch (SQLException ex) { JOptionPane.showMessageDialog(null,
 * "Erro ao salvar! " + ex); }try {
 * 
 * } finally { ConnectorFactory.closeConnection(con, stmt); } }
 * 
 * public List<Emoji> listar(){ //Read R (CRUD)
 * 
 * Connection con = ConnectorFactory.getConnection(); PreparedStatement stmt =
 * null; ResultSet rs = null;
 * 
 * List<Emoji> emoticons = new ArrayList<>();
 * 
 * try { stmt = con.prepareStatement("SELECT * FROM tblEmoji"); rs =
 * stmt.executeQuery(); //Consultas ao banco
 * 
 * while(rs.next()) {
 * 
 * 
 * Emoji emj = new Emoji();
 * 
 * emj.setIdTbl(rs.getInt("id")); emj.setSentimento(rs.getString("emoji"));
 * emj.setDia(rs.getString("dia")); emoticons.add(emj);
 * 
 * 
 * }
 * 
 * } catch (SQLException ex) {
 * 
 * System.out.println("Mensagem do erro : " + ex); }finally {
 * ConnectorFactory.closeConnection(con, stmt, rs); }
 * 
 * return emoticons;
 * 
 * } public void update (Emoji emj ) { //Update U (CRUD)
 * 
 * Connection con = ConnectorFactory.getConnection(); PreparedStatement stmt =
 * null;
 * 
 * try { stmt =
 * con.prepareStatement("UPDATE tblemoji SET emoji = ?, dia = ?  WHERE id = ?");
 * stmt.setString(1,emj.getSentimento()); stmt.setString(2,emj.getDia());
 * stmt.setInt(3, emj.getIdTbl());
 * 
 * stmt.executeUpdate();
 * 
 * JOptionPane.showMessageDialog(null, "Atualizado com sucesso! ");
 * 
 * } catch (SQLException ex) { JOptionPane.showMessageDialog(null,
 * "Erro ao atualizar! " + ex); }try {
 * 
 * } finally { ConnectorFactory.closeConnection(con, stmt); } } public void
 * delete (Emoji emj ) { //Delete D (CRUD)
 * 
 * Connection con = ConnectorFactory.getConnection(); PreparedStatement stmt =
 * null;
 * 
 * try { stmt = con.prepareStatement("DELETE FROM tblemoji WHERE id = ?");
 * stmt.setInt(1, emj.getIdTbl());
 * 
 * stmt.executeUpdate();
 * 
 * JOptionPane.showMessageDialog(null, "Excluido com sucesso! ");
 * 
 * } catch (SQLException ex) { JOptionPane.showMessageDialog(null,
 * "Erro ao Excluir: " + ex); }try {
 * 
 * } finally { ConnectorFactory.closeConnection(con, stmt); } }
 * 
 * 
 * }
 */