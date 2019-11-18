package system;

public class Anais extends Publicacao implements Comparable{
	private String titulo;
	private String ID;
	private String natureza;
	private String idioma;
	private String evento;
	
	public Anais(String ID, String natureza, String titulo, String pgFinal, String pgInicial, String evento, String cidade, String idioma) {
		this.ID = ID;
		this.natureza = natureza;
		this.titulo = titulo;
		this.numPaginas = calculaPaginas(pgInicial, pgFinal);
		this.evento = evento;
		this.cidade = cidade;
		this.idioma = idioma;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getID() {
		return ID;
	}

	public String getNatureza() {
		return natureza;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getEvento() {
		return evento;
	}

	@Override
	public int compareTo(Object b) {
		Anais a1 = (Anais) b;
		if(this.natureza.compareTo(a1.getNatureza()) != 0)
			return this.natureza.compareTo(a1.getNatureza());
		else if(this.titulo.compareTo(a1.getTitulo()) != 0)
			return this.titulo.compareTo(a1.getTitulo());
		else if(this.idioma.compareTo(a1.getIdioma()) != 0)
			return this.idioma.compareTo(a1.getIdioma());
		else if(this.evento.compareTo(a1.getEvento()) != 0)
			return this.evento.compareTo(a1.getEvento());
		else if(this.cidade.compareTo(a1.getCidade()) != 0)
			return this.cidade.compareTo(a1.getCidade());
		else
			return Integer.compare(this.numPaginas, a1.getPaginas());		
	}
	
	public void imprimeCSV() {
		if(this.numPaginas == 0)
			System.out.printf("%s;%s;%s;%s;%s;\n", this.natureza, this.titulo, this.idioma, this.evento, this.cidade);
		else
			System.out.printf("%s;%s;%s;%s;%s;%d\n", this.natureza, this.titulo, this.idioma, this.evento, this.cidade, this.numPaginas);
	}
	
}