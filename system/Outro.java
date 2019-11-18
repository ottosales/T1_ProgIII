package system;

public class Outro extends Publicacao implements Comparable{
	private String natureza;
	private String idioma;
	private String editora;

	public Outro(String natureza, String idioma, String editora, String cidade, String numPaginas) {
		this.natureza = natureza;
		this.idioma = idioma;
		this.editora = editora;
		this.cidade = cidade;
		this.numPaginas = validaPaginas(numPaginas);
	}

	public String getNatureza() {
		return natureza;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getEditora() {
		return editora;
	}
	
	@Override
	public int compareTo(Object b) {
		Outro o = (Outro) b;
		if(this.natureza.compareTo(o.getNatureza()) != 0)
			return this.natureza.compareTo(o.getNatureza());
		else if(this.idioma.compareTo(o.getIdioma()) != 0)
			return this.idioma.compareTo(o.getIdioma());
		else if(this.editora.compareTo(o.getEditora()) != 0)
			return this.editora.compareTo(o.getEditora());
		else if(this.cidade.compareTo(o.getCidade()) != 0)
			return this.cidade.compareTo(o.getCidade());
		else 
			return Integer.compare(this.numPaginas, o.getPaginas());
	}
	
	public void imprimeCSV() {
		if(this.numPaginas == 0)
			System.out.printf("%s;%s;%s;%s;\n", this.natureza, this.idioma, this.editora, this.cidade);
		else
			System.out.printf("%s;%s;%s;%s;%d\n", this.natureza, this.idioma, this.editora, this.cidade, this.numPaginas);
	}
	
	
	
}