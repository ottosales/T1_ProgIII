package system;

public class ArtJr extends Publicacao implements Comparable{
	private String titulo;
	private String idioma;	
	private String data;
	private String ISSN;
	
	public ArtJr(String titulo, String idioma, String cidade, String data, String ISSN, String pgFinal, String pgInicial) {
		this.titulo = titulo;
		this.idioma = idioma;
		this.cidade = cidade;
		this.data = data;
		this.ISSN = ISSN;
		this.numPaginas = calculaPaginas(pgInicial, pgFinal);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getData() {
		return data;
	}

	public String getISSN() {
		return ISSN;
	}
	
	@Override
	public int compareTo(Object b) {
		ArtJr artjr = (ArtJr) b;
		if(this.titulo.compareTo(artjr.getTitulo()) != 0) 
			return this.titulo.compareTo(artjr.getTitulo());
		else if(this.idioma.compareTo(artjr.getIdioma()) != 0)
			return this.idioma.compareTo(artjr.getIdioma());
		else if(this.cidade.compareTo(artjr.getCidade()) != 0)
			return this.cidade.compareTo(artjr.getCidade());
		else {
			String[] data1 = this.data.split("/");
			String[] data2 = artjr.getData().split("/");
			//comparar ano, mes e dia! ([2], [1], [0])
			
			if(data1[2].compareTo(data2[2]) != 0)
				return data1[2].compareTo(data2[2]);
			else if(data1[1].compareTo(data2[1]) != 0)
				return data1[1].compareTo(data2[1]);
			else if(data1[0].compareTo(data2[0]) != 0)
				return data1[0].compareTo(data2[0]);
			else if(this.ISSN.compareTo(artjr.getISSN()) != 0)
				return this.ISSN.compareTo(artjr.getISSN());
			else
				return Integer.compare(this.numPaginas, artjr.getPaginas());
			
		}
	}

	public void imprimeCSV() {
		if(this.numPaginas == 0)
			System.out.printf("%s;%s;%s;%s;%s;\n", this.titulo, this.idioma, this.cidade, this.data, this.ISSN);
		else
			System.out.printf("%s;%s;%s;%s;%s;%d\n", this.titulo, this.idioma, this.cidade, this.data, this.ISSN, this.numPaginas);
	}
}