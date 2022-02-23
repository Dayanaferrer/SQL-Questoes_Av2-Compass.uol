package avaliacao2.questao09;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	
	public static void menu() {
		System.out.println("\t===========TiTech SYSTEM==========");
		System.out.println("\t Digite a opçăo desejada");
		System.out.println("1. Inserir uma oferta");
		System.out.println("2. Atualizar uma oferta");
		System.out.println("3. Deletar uma oferta");
		System.out.println("4. Listar nomes existentes");
		System.out.println("5. Listar todos produtos");
		System.out.println("0. Sair");
		System.out.println("Opcao:");
	}

	static ArrayList<Produtos> products = new ArrayList<Produtos>();

	public static ProdutosDAO createProductDaoConn() {
		Connection connection = new ConnectionFactory().createConnection();
		ProdutosDAO produtosDAO = new ProdutosDAO(connection);
		return produtosDAO;
	}

	public static void inclui() throws SQLException {

		Scanner entrada = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.println("Digite o nome do Produto:");
		String nome = entrada.nextLine();

		System.out.println("Digite a descriçăo do produto:");
		String desc = entrada.nextLine();

		System.out.println("Digite a valor do produto:");
		String preco = entrada.nextLine();

		double valor = Double.valueOf(preco);
		Produtos produto = new Produtos(nome, desc, valor);

		createProductDaoConn().Salvar(produto);
		insert3products();

		List<Produtos> listaProd = createProductDaoConn().listar();

		listaProd.stream().forEach(lp -> System.out.println(lp));
	}

	public static void altera() throws SQLException {
		Scanner entradaalt = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		System.out.println("Digite o codigo do Produto a ser Alterado:");
		String strid = entradaalt.nextLine();

		System.out.println("Digite o nome do Produto:");
		String nome = entradaalt.nextLine();

		System.out.println("Digite a descriçăo do Produto:");
		String desc = entradaalt.nextLine();

		System.out.println("Digite a valor do Produto:");
		String custo = entradaalt.nextLine();

		double valor = Double.valueOf(custo);
		Integer id = Integer.valueOf(strid);
		Produtos produto = new Produtos(nome, desc, valor);

		if (createProductDaoConn().existId(id)) {
			createProductDaoConn().alterar(produto.getNome(), produto.getDescricao(), produto.getDesconto(), id);
		} else {
			createProductDaoConn().Salvar(produto);
			insert3products();
		}

		List<Produtos> listaProd = createProductDaoConn().listar();

		listaProd.stream().forEach(lp -> System.out.println(lp));
	}

	public static void excluir() throws SQLException {
		Scanner entradaexc = new Scanner(System.in);

		System.out.println("Digite o id do Produto:");
		int id = entradaexc.nextInt();

		if (createProductDaoConn().existId(id)) {
			createProductDaoConn().delete(id);
		} else {
			System.out.println("Produto de ID " + id + " Năo exite!");
		}
	}

	private static void listaAll() throws SQLException {

		List<Produtos> listaProd = createProductDaoConn().listar();

		listaProd.stream().forEach(lp -> System.out.println(lp));
	}

	public static void consulta() throws SQLException {
		Scanner entradacon = new Scanner(System.in);
		Locale.setDefault(Locale.ENGLISH);

		System.out.println("Digite o nome do Produto:");
		String nome = entradacon.nextLine();

		Produtos produto = new Produtos(nome);

		List<Produtos> listaProd = createProductDaoConn().listebusca(produto.getNome());

		listaProd.stream().forEach(lp -> System.out.println(lp));

	}

	public static void insert3products() {
		products.add(new Produtos("Itens de conectividade", "Modem 150 Mpbs", 80.60));
		products.add(new Produtos("Hardware", "HD SSD 150GB", 250.10));
		products.add(new Produtos("Notebook", "Notebook DEll i7", 840.70));
		products.add(new Produtos("HardWare", "Disco rídigo", 150.20));
		products.add(new Produtos("HardWare", "Coolers", 60.80));
		products.add(new Produtos("Periférico", "Mesa digitalizadora", 350.50));
		products.add(new Produtos("Hardware", "Placas-mãe", 450.50));
		products.add(new Produtos("HardWare", "Memória RAM", 260.60));
		products.add(new Produtos("Periférico", "Som e acessórios", 100.40));
		for (int i = 0; i < 3; i++) {
			Collections.shuffle(products);
			Produtos produto = new Produtos(products.get(i).getNome(), products.get(i).getDescricao(),
					products.get(i).getDesconto());
			createProductDaoConn().Salvar(produto);
		}
	}

	public static void main(String[] args) throws SQLException {

		int opcao;
		Scanner opcaoentrada = new Scanner(System.in);

		do {
			menu();
			opcao = opcaoentrada.nextInt();

			switch (opcao) {
			case 1:
				inclui();
				break;

			case 2:
				altera();
				break;

			case 3:
				excluir();
				break;

			case 4:
				consulta();
				break;

			case 5:
				listaAll();
				break;

			default:
				System.out.println("Opçăo inválida.");
			}
		} while (opcao != 0);
		opcaoentrada.close();
	}

}
