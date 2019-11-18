package system;

import java.util.ArrayList;
import java.util.Collections;

public class IES implements Comparable{
	private String nome;
	private String sigla;
	private String siglaNomeConcat;
	private ArrayList<PPG> PPGs;
	
	public IES(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		this.siglaNomeConcat = this.sigla + " " + this.nome;
		this.PPGs = new ArrayList<PPG>();
	}
	
	public void registraPPG(PPG ppg) {
		this.PPGs.add(ppg);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSigla() {
		return this.sigla;
	}
	
	public Boolean ExisteNaLista(String ppg) {
		for(PPG iter : this.PPGs) {
			if(iter.getTitulo().equals(ppg))
				return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Object b) {
		IES ies = (IES) b;
		return this.siglaNomeConcat.compareTo(ies.siglaNomeConcat);
	}
	
	public void comandoIES() {
		System.out.println(this.nome + " (" + this.sigla + "):");
		Collections.sort(this.PPGs);
		for(PPG iter : this.PPGs) {
			System.out.println("\t- " + iter.getTitulo() + ": " + iter.getNumPublicacoes() + " producoes");
		}
	}
}