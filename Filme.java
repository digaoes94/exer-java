package filmes;

import java.util.Scanner;

public class Filme {
	static Scanner scan = new Scanner(System.in);
	
	//  ATRIBUTOS
	private int codigo;
	private String titulo;
	private String genero;
	
	//  CONSTRUTORES
	public Filme(int cod, String title, String gen) {
		this.codigo = cod;
		this.titulo = title;
		this.genero = gen;
	}	
	public Filme() {
		this.codigo = 0;
		this.titulo = "";
		this.genero = "";
	}
	
	//  SETTERS
	public void setCodigo(int newCod) {
		this.codigo = newCod;
	}
	public void setTitulo(String newTitle) {
		this.titulo = newTitle;
	}
	public void setCodigo(String newGenero) {
		this.genero = newGenero;
	}
	
	//  GETTERS
	public int getCodigo() {
		return this.codigo;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public String getGenero() {
		return this.genero;
	}
	
	//  TO STRING
	public String toString() {
		return "O filme " + this.titulo + " é do gênero " + this.genero + ", e seu código é " + this.codigo + ".";
	}
}
