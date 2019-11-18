package system;

public class Traducao extends Publicacao implements Comparable{
	private String natureza;
	private String titulo;
	private String idioma;
	private String editora;
	private String idiomaTraducao;
	
	public Traducao(String natureza, String titulo, String idioma, String editora, String idiomaTraducao, String cidade, String numPaginas) {
		this.natureza = natureza;
		this.titulo = titulo;
		this.idioma = idioma;
		this.editora = editora;
		this.idiomaTraducao = idiomaTraducao;
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

	public String getIdiomaTraducao() {
		return idiomaTraducao;
	}
	
	@Override
	public int compareTo(Object b) {
		Traducao trad = (Traducao) b;
		if(this.natureza.compareTo(trad.getNatureza()) != 0)
			return this.natureza.compareTo(trad.getNatureza());
		else if(this.titulo.compareTo(trad.getTitulo()) != 0)
			return this.titulo.compareTo(trad.getTitulo());
		else if(this.idioma.compareTo(trad.getIdioma()) != 0)
			return this.idioma.compareTo(trad.getIdioma());
		else if(this.editora.compareTo(trad.getEditora()) != 0)
			return this.editora.compareTo(trad.getEditora());
		else if(this.cidade.compareTo(trad.getCidade()) != 0)
			return this.cidade.compareTo(trad.getCidade());
		else if(this.idiomaTraducao.compareTo(trad.getIdiomaTraducao()) != 0)
			return this.idiomaTraducao.compareTo(trad.getIdiomaTraducao());
		else
			return Integer.compare(this.numPaginas, trad.getPaginas());
	}
	
	public void imprimeCSV() {
		if(this.numPaginas == 0)
			System.out.printf("%s;%s;%s;%s;%s;%s;\n", this.natureza, this.titulo, this.idioma, this.editora, this.cidade, this.idiomaTraducao);
		else
			System.out.printf("%s;%s;%s;%s;%s;%s;%d\n", this.natureza, this.titulo, this.idioma, this.editora, this.cidade, this.idiomaTraducao, this.numPaginas);
	}
	
}