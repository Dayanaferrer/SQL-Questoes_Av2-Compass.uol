package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import avaliacao2.questao10.ConnectorFactory;
import avaliacao2.questao10.Emoji;


public class EmocoesFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelId, labelEmoji, labelDia;
	private JTextField textoId, textoEmoji, textoDia;
	private JComboBox<Emoji> comboEmoticons;		
	private JButton botaoSalvar, botaoEditar, botaoLimpar, botarApagar;
	private JTable funcionario;
	private DefaultTableModel modelo;
	private ConnectorFactory emojiController;
	

	public EmocoesFrame() {
		super("Sentimentos");
		Container container = getContentPane();
		setLayout(null);

		this.emojiController = new ConnectorFactory();

		labelId = new JLabel("Id do Funcionário");
		labelEmoji = new JLabel("Emocão");
		labelDia = new JLabel("Data");

		labelId.setBounds(10, 10, 240, 15);
		labelEmoji.setBounds(10, 50, 240, 15);
		labelDia.setBounds(10, 90, 240, 15);

		labelId.setForeground(Color.BLACK);
		labelEmoji.setForeground(Color.BLACK);
		labelDia.setForeground(Color.BLACK);

		container.add(labelId);
		container.add(labelEmoji);
		container.add(labelDia);
		
		textoId = new JTextField();
		textoEmoji = new JTextField();
		textoDia = new  JTextField();		

		textoId.setBounds(10, 25, 265, 20);
		textoEmoji.setBounds(10, 65, 265, 20);
		textoDia.setBounds(10, 105, 265, 20);

		container.add(textoDia);
		container.add(textoEmoji);
		container.add(textoId);

		botaoSalvar = new JButton("Salvar");
		botaoLimpar = new JButton("Limpar");

		botaoSalvar.setBounds(10, 145, 80, 20);
		botaoLimpar.setBounds(100, 145, 80, 20);

		container.add(botaoSalvar);
		container.add(botaoLimpar);

		funcionario = new JTable();
		modelo = (DefaultTableModel) funcionario.getModel();

		modelo.addColumn("Identificador do Produto");
		modelo.addColumn("Nome do Produto");
		modelo.addColumn("Descricao do Produto");


		funcionario.setBounds(10, 185, 760, 300);
		container.add(funcionario);

		botarApagar = new JButton("Excluir");
		botaoEditar = new JButton("Alterar");

		botarApagar.setBounds(10, 500, 80, 20);
		botaoEditar.setBounds(100, 500, 80, 20);

		container.add(botarApagar);
		container.add(botaoEditar);

		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);

	
	}

	
	}
