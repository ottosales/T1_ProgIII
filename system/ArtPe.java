package system;


public class ArtPe extends Publicacao implements Comparable{
	private String natureza;
	private String idioma;
	private String editora;
	private String volume;
	private String fasciculo;
	private String serie;
	private String ISSN;

	
	public ArtPe(String natureza, String idioma, String editora, String volume, String fasciculo, String serie,
			String ISSN, String cidade, String pgFinal, String pgInicial) {
		this.natureza = natureza;
		this.idioma = idioma;
		this.editora = editora;
		this.volume = volume;
		this.fasciculo = fasciculo;
		this.serie = serie;
		this.ISSN = ISSN;
		this.cidade = cidade;
		this.numPaginas = calculaPaginas(pgInicial, pgFinal);
		this.corrigeDadosCSV();
		
	}

	private void corrigeDadosCSV() {
		
		int inteiro_serie = -1;
		int inteiro_volume = -1;
		int inteiro_fasciculo = -1;
		try {
			inteiro_serie = Integer.parseInt(this.serie);
		}
		catch(NumberFormatException e){
			inteiro_serie = -1;
		}
		
		try {
			inteiro_volume = Integer.parseInt(this.volume);
		}
		catch(NumberFormatException e){
			inteiro_volume = -1;
		}
		
		try {
			inteiro_fasciculo = Integer.parseInt(this.fasciculo);
		}
		catch(NumberFormatException e){
			inteiro_fasciculo = -1;
		}
		
		if(inteiro_serie == -1)
			this.serie = "-1";
		else
			this.serie = Integer.toString(inteiro_serie);
		if(inteiro_volume == -1)
			this.volume = "-1";
		else
			this.volume = Integer.toString(inteiro_volume);
		if(inteiro_fasciculo == -1)
			this.fasciculo = "-1";
		else
			this.fasciculo = Integer.toString(inteiro_fasciculo);
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


	public String getVolume() {
		return volume;
	}


	public String getFasciculo() {
		return fasciculo;
	}


	public String getSerie() {
		return serie;
	}


	public String getISSN() {
		return ISSN;
	}
	
	@Override
	public int compareTo(Object b) {
		ArtPe artpe = (ArtPe) b;
		if(this.natureza.compareTo(artpe.getNatureza()) != 0)
			return this.natureza.compareTo(artpe.getNatureza());
		else if(this.idioma.compareTo(artpe.getIdioma()) != 0)
			return this.idioma.compareTo(artpe.getIdioma());
		else if(this.editora.compareTo(artpe.getEditora()) != 0)
			return this.editora.compareTo(artpe.getEditora());
		else if(this.cidade.compareTo(artpe.getCidade()) != 0)
			return this.cidade.compareTo(artpe.getCidade());
		else if(Integer.compare(Integer.parseInt(this.volume),Integer.parseInt(artpe.getVolume())) != 0)
			return Integer.compare(Integer.parseInt(this.volume),Integer.parseInt(artpe.getVolume()));
		else if(Integer.compare(Integer.parseInt(this.fasciculo),Integer.parseInt(artpe.getFasciculo())) != 0)
			return Integer.compare(Integer.parseInt(this.fasciculo),Integer.parseInt(artpe.getFasciculo()));
		else if(Integer.compare(Integer.parseInt(this.serie),Integer.parseInt(artpe.getSerie())) != 0)
			return Integer.compare(Integer.parseInt(this.serie),Integer.parseInt(artpe.getSerie()));
		else if(this.ISSN.compareTo(artpe.getISSN()) != 0)
			return this.ISSN.compareTo(artpe.getISSN());
		else
			return Integer.compare(this.numPaginas, artpe.getPaginas());
	}

	public void imprimeCSV() {
		
		if(Integer.parseInt(this.fasciculo) == -1)
			this.fasciculo = "";
		if(Integer.parseInt(this.serie) == -1)
			this.serie = "";
		if(Integer.parseInt(this.volume) == -1)
			this.volume = "";
		
		
		
		if(this.numPaginas == 0)
			System.out.printf("%s;%s;%s;%s;%s;%s;%s;%s;\n", this.natureza, this.idioma, this.editora, this.cidade, 
					this.volume, this.fasciculo, this.serie, this.ISSN);
		else
			System.out.printf("%s;%s;%s;%s;%s;%s;%s;%s;%d\n", this.natureza, this.idioma, this.editora, this.cidade, 
					this.volume, this.fasciculo, this.serie, this.ISSN, this.numPaginas);
	}
	
}