package filmes;

import java.util.Scanner;

public class ListaFilme {
	static Scanner scan = new Scanner(System.in);
	
	//  ATRIBUTOS
	private Filme[] listaFilmes;
	private int qtdFilmes;
	
	//  CONSTRUTORES
	public ListaFilme(int newQtdFilmes) {
		this.listaFilmes = new Filme[newQtdFilmes];
		this.qtdFilmes = 0;
	}
	
	//  SETTERS
	public void setQtdFilmes(int newQtdFilmes) {
		this.qtdFilmes = newQtdFilmes;
	}
	public void indexListaFilmes(int newIndexFilmes, Filme newFilme) {
		this.listaFilmes[newIndexFilmes] = newFilme;
	}
	
	//  GETTERS
	public Filme getFilme(int indexListaFilmes) {
		return this.listaFilmes[indexListaFilmes];
	}
	public int getQtdFilmes() {
		return qtdFilmes;
	}
	
	// TO STRING
	public String toString() {
		String escreveLista = "";
		
		for (int i = 0; i < this.qtdFilmes; i++) {
			escreveLista += (i + 1) + ". " + this.listaFilmes[i] + "\n";
		}
		
		return escreveLista;
	}
	
	//  ADICIONAR FILME
	public boolean adicionarFilme(Filme newFilme) {
		if (this.qtdFilmes == this.listaFilmes.length) {
			return false;
		}
		else {
			this.listaFilmes[this.qtdFilmes] = newFilme;
			this.qtdFilmes++;
			return true;
		}
	}
	
	//  PESQUISAR FILMES POR: 1. CÓDIGO; 2. TÍTULO; 3. GÊNERO (A-AÇÃO, T-TERROR, D-DRAMA)
	//  PESQUISA POR CÓDIGO
	public String pesqCod(int cod) {
		String resultado = "";
		
		for (int i = 0; i < this.qtdFilmes; i++) {
			if (listaFilmes[i].getCodigo() == cod) {
				resultado = listaFilmes[i].getTitulo();
			}
			else {
				resultado = "Não existe filme com este código.";
			}
		}
		
		return resultado;
	}
	
	//  PESQUISA POR TÍTULO
	public String pesqTitle(String title) {
		String resultado = "";
		
		for (int i = 0; i < this.qtdFilmes; i++) {
			if (listaFilmes[i].getTitulo() == title) {
				resultado = listaFilmes[i].getTitulo();
			}
			else {
				resultado = "Não existe filme com este título.";
			}
		}
		
		return resultado;
	}
	
	//  PESQUISA POR GÊNERO
	public String pesqGen(String gen) {
		String resultado = "";
		int count = 0;
		
		//  CHECAR SE EXISTEM FILMES DO GÊNERO NA LISTA
		for (int i = 0; i < this.qtdFilmes; i++) {
			if (listaFilmes[i].getGenero() == gen) {
				count++;
			}		
		}
		
		//  ESCREVER FILMES DO GÊNERO
		if (count == 0) {
			resultado = "Não existe filme com este código.";
		}
		else {
			for (int i = 0; i < this.qtdFilmes; i++) {
				if (listaFilmes[i].getGenero() == gen) {
					resultado += (i + 1) + ". " + listaFilmes[i].getTitulo() + "\n";
				}
			}
		}

		return resultado;
	}
	
	//  EXCLUIR FILME
	public boolean removerFilme(int cod) {
		if (this.qtdFilmes == 0) {
			return false;
		}
		else {
			int i = 0;
			while (i < this.qtdFilmes && (this.listaFilmes[i].getCodigo() != cod)) {
				i++;
			}
			if (i == this.qtdFilmes) {
				return false;
			}
			else {
				this.listaFilmes[i] = this.listaFilmes[this.qtdFilmes - 1];
				this.qtdFilmes--;
				return true;
			}
		}
	}
}
