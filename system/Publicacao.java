package system;

public class Publicacao {

	protected String cidade;
	protected int numPaginas;
	
	
	protected int calculaPaginas(String pgInicial, String pgFinal) {
		int pgs = 0;
		try {
			int inteiro_pgInicial = Integer.parseInt(pgInicial);
			int inteiro_pgFinal = Integer.parseInt(pgFinal);
			
			if(inteiro_pgInicial <= inteiro_pgFinal)
				if(inteiro_pgFinal >= 0 && inteiro_pgInicial >= 0)
					if(inteiro_pgFinal - inteiro_pgInicial < 2000)
						pgs = inteiro_pgFinal - inteiro_pgInicial + 1;
		}	
			
		catch(NumberFormatException e) {	
		}
		return pgs;
	}
	
	protected int validaPaginas(String numPaginas) {
		int pgs = 0;
		try {
			pgs = Integer.parseInt(numPaginas);
			if(pgs < 0 || pgs > 2000)
				pgs = 0;
		}
		catch(NumberFormatException e) {
			pgs = 0;
		}
		
		return pgs;
	}
	
	public int getPaginas() {
		return numPaginas;
	}

	public String getCidade() {
		return cidade;
	}
	
	
}