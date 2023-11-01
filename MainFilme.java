package filmes;

import java.util.Scanner;

public class MainFilme {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String opcao;
		int qtdFilmes = 1000;
		ListaFilme lista1 = new ListaFilme(qtdFilmes);
		
		//  INICIO
		do {
			System.out.println("Selecione uma opção:");
			System.out.println("A para adicionar filme");
			System.out.println("L para listar filmes");
			System.out.println("PC para pesquisar filme por código");
			System.out.println("PT para pesquisar filme por título");
			System.out.println("PG para listar os filmes de um gênero");
			System.out.println("E para excluir um filme");
			System.out.println("EXIT para encerrar o programa");
			opcao = scan.next();
			
			//  OPERAÇÃO
			switch (opcao) {
			case "C":
				adicionarFilme(lista1);
				break;
			case "L":
				System.out.println(lista1.toString());
				break;
			case "PC":
				pesqCodigo(lista1);
				break;
			case "PT":
				pesqTitulo(lista1);
				break;
			case "PG":
				System.out.println("Digite: A para ação; D para drama; T para Terror");
				String genFilme = scan.next();
				
				switch (genFilme) {
				case "A":
					pesqAcao(lista1);
					break;
				case "D":
					pesqDrama(lista1);
					break;
				case "T":
					pesqTerror(lista1);
					break;
					default:
						System.out.println("Opção inválida, o programa encerrará");
						opcao = "EXIT";
				}
				break;
			case "E":
				excluirFilme(lista1);
				break;
			case "EXIT":
				System.out.println("Opção inválida, o programa encerrará");
				opcao = "EXIT";
				break;
			default:
					System.out.println("Opção inválida, o programa encerrará");
					opcao = "EXIT";
			}
		} while (opcao != "EXIT");
	}
	
	static void adicionarFilme(ListaFilme lista1) {
		Filme filme = new Filme();
		int cod;
		String title, gen;
		
		System.out.println("Digite o código do filme");
		cod = scan.nextInt();
		System.out.println("Digite o título do filme");
		title = scan.next();
		System.out.println("Digite o gênero (Ação/Drama/Terror) do filme");
		gen = scan.next();
		
		if (lista1.adicionarFilme(filme)) {
			System.out.println("Filme adicionado");
		}
		else {
			System.out.println("Filme não adicionado: lista cheia");
		}
	}
	
	static void pesqCodigo(ListaFilme lista1) {
		int codAlvo;
		System.out.println("Digite o código do filme:");
		codAlvo = scan.nextInt();
		
		lista1.pesqCod(codAlvo);
	}
	
	static void pesqTitulo(ListaFilme lista1) {
		String titleAlvo;
		System.out.println("Digite o título do filme:");
		titleAlvo = scan.next();
		
		lista1.pesqTitle(titleAlvo);
	}
	
	static void pesqAcao(ListaFilme lista1) {
		String genAlvo = "Ação";
		lista1.pesqGen(genAlvo);
	}
	
	static void pesqDrama(ListaFilme lista1) {
		String genAlvo = "Drama";
		lista1.pesqGen(genAlvo);
	}
	
	static void pesqTerror(ListaFilme lista1) {
		String genAlvo = "Terror";
		lista1.pesqGen(genAlvo);
	}
	
	static void excluirFilme(ListaFilme lista1) {
		int filmeAlvo;
		System.out.println("Digite o código do filme:");
		filmeAlvo = scan.nextInt();
		
		if (lista1.removerFilme(filmeAlvo)) {
			System.out.println("Filme excluído com sucesso.");
		}
		else {
			System.out.println("Filme não encontrado, lista inalterada.");
		}
	}
	
}

