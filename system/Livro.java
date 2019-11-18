package system;

public class Livro extends Publicacao implements Comparable{
	private String natureza;
	private String titulo;
	private String idioma;
	private String editora;
	private String ISBN;
	
	
	public Livro(String natureza, String titulo, String idioma, String editora, String ISBN, String cidade, String numPaginas) {
		this.natureza = natureza;
		this.titulo = titulo;
		this.idioma = idioma;
		this.editora = editora;
		this.ISBN = ISBN;
		this.cidade = cidade;
		this.numPaginas = validaPaginas(numPaginas);
	}


	public String getNatureza() {
		return natureza;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getIdioma() {
		return idioma;
	}


	public String getEditora() {
		return editora;
	}


	public String getISBN() {
		return ISBN;
	}
	
	@Override
	public int compareTo(Object b) {
		Livro li = (Livro) b;
		if(this.natureza.compareTo(li.getNatureza()) != 0)
			return this.natureza.compareTo(li.getNatureza());
		else if(this.titulo.compareTo(li.getTitulo()) != 0)
			return this.titulo.compareTo(li.getTitulo());
		else if(this.idioma.compareTo(li.getIdioma()) != 0)
			return this.idioma.compareTo(li.getIdioma());
		else if(this.editora.compareTo(li.getEditora()) != 0)
			return this.editora.compareTo(li.getEditora());
		else if(this.cidade.compareTo(li.getCidade()) != 0)
			return this.cidade.compareTo(li.getCidade());
		else if(this.ISBN.compareTo(li.getISBN()) != 0)
			return this.ISBN.compareTo(li.getISBN());
		else
			return Integer.compare(this.numPaginas, li.getPaginas());
	}
	
	public void imprimeCSV() {
		if(this.numPaginas == 0)
			System.out.printf("%s;%s;%s;%s;%s;%s;\n", this.natureza, this.titulo, this.idioma, this.editora, this.cidade, this.ISBN);
		else
			System.out.printf("%s;%s;%s;%s;%s;%s;%d\n", this.natureza, this.titulo, this.idioma, this.editora, this.cidade, this.ISBN, this.numPaginas);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}