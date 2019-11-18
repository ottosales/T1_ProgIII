package system;

public class PartMu extends Publicacao implements Comparable{
	private String natureza;
	private String editora;
	private String formInstrumental;
	
	public PartMu(String natureza, String editora, String formInstrumental, String cidade, String numPaginas) {
		this.natureza = natureza;
		this.editora = editora;
		this.formInstrumental = formInstrumental;
		this.cidade = cidade;
		this.numPaginas = validaPaginas(numPaginas);
	}

	public String getNatureza() {
		return natureza;
	}

	public String getEditora() {
		return editora;
	}

	public String getFormInstrumental() {
		return formInstrumental;
	}
		
	
	@Override
	public int compareTo(Object b) {
		PartMu mu = (PartMu) b;
		if(this.natureza.compareTo(mu.getNatureza()) != 0)
			return this.natureza.compareTo(mu.getNatureza());
		else if(this.editora.compareTo(mu.getEditora()) != 0)
			return this.editora.compareTo(mu.getEditora());
		else if(this.cidade.compareTo(mu.getCidade()) != 0)
			return this.cidade.compareTo(mu.getCidade());
		else if(this.formInstrumental.compareTo(mu.getFormInstrumental()) != 0)
			return this.formInstrumental.compareTo(mu.getFormInstrumental());
		else
			return Integer.compare(this.numPaginas, mu.getPaginas());
	}
	
	public void imprimeCSV() {
		if(this.numPaginas == 0) 
			System.out.printf("%s;%s;%s;%s;\n", this.natureza, this.editora, this.cidade, this.formInstrumental);
		else
			System.out.printf("%s;%s;%s;%s;%d\n", this.natureza, this.editora, this.cidade, this.formInstrumental, this.numPaginas);
	}
	
}
