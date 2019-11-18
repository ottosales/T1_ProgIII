package system;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Set;
import java.util.Collections;
import java.util.TreeSet;


public class PPG implements Comparable{
	private String titulo;
	private String ID;
	private ArrayList<IES> iess;
	private ArrayList<Publicacao> pubs;
	
	public PPG(String titulo, String cod) {
		this.titulo = titulo;
		this.ID = cod;
		this.pubs = new ArrayList<Publicacao>();
		this.iess = new ArrayList<IES>();
	}
	
	public void inserePub(Publicacao p) {
		pubs.add(p);
	}
	
	public void registraIES(IES ies) {
		this.iess.add(ies);
	}
	
	public int getIesNum() {
		return this.iess.size();
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public ArrayList<IES> getIES(){
		return this.iess;
	}
	
	public int getNumPublicacoes() {
		return this.pubs.size();
	}
	
	public Boolean ExisteNaLista(String ies) {
		for(IES iter : this.iess) {
			if(iter.getNome().equals(ies))
				return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Object b) {
		PPG ppg = (PPG) b;
		return this.titulo.compareTo(ppg.getTitulo());
	}

	
	public static void rede(TreeMap mapPPG) {
		System.out.println("Programas em rede:");
		Set<Entry<String, PPG>> entrySet = mapPPG.entrySet();
		
		
		for(Entry<String, PPG> iter : entrySet) {
			if(iter.getValue().getIesNum() > 1) {
				System.out.println(iter.getValue().getID() + ": " + iter.getValue().getTitulo());
				ArrayList<IES> ies = iter.getValue().getIES();
				Collections.sort(ies);
				for(IES i : ies) {
					System.out.println("\t- " + i.getSigla() + " (" + i.getNome() + ")");
				}
			}
		}
	}
	
	public void comandoPPG() {
		System.out.println("Programa: " + this.titulo);
		System.out.println("Instituicoes:");
		Collections.sort(this.iess);
		for(IES iter : this.iess) {
			System.out.println("\t- " + iter.getSigla() + " (" + iter.getNome() + ")");
		}
		System.out.println("\nQuantidade de producoes por tipo:");
		int contaAnais = 0;
		int contaArtJr = 0;
		int contaArtPe = 0;
		int contaLivros = 0;
		int contaPartMu = 0;
		int contaTraducoes = 0;
		int contaOutros = 0;
		int somaPaginas = 0;
		
		for(Publicacao iter : this.pubs) {
			if(iter.getClass().equals(Anais.class))
				contaAnais++;
			else if(iter.getClass().equals(ArtJr.class))
				contaArtJr++;
			else if(iter.getClass().equals(ArtPe.class))
				contaArtPe++;
			else if(iter.getClass().equals(Livro.class))
				contaLivros++;
			else if(iter.getClass().equals(PartMu.class))
				contaPartMu++;
			else if(iter.getClass().equals(Traducao.class))
				contaTraducoes++;
			else
				contaOutros++;
			
			somaPaginas += iter.getPaginas();
		}
		
		
		System.out.printf("\t- Artigos em anais de eventos: %d\n" + 
				"\t- Artigos em jornais e revistas: %d\n" + 
				"\t- Artigos em periodicos cientificos: %d\n" + 
				"\t- Livros: %d\n" + 
				"\t- Partituras musicais: %d\n" + 
				"\t- Traducoes: %d\n" + 
				"\t- Outros: %d\n\n", contaAnais, contaArtJr, contaArtPe, contaLivros, contaPartMu, contaTraducoes, contaOutros);
	
		System.out.print("Total de paginas produzidas pelo PPG: " + somaPaginas);
	}
	
	public void criaCSV(String tipoPub) {
		if(tipoPub.equals("anais")) {
			System.out.println("Natureza;Titulo;Idioma;Evento;Cidade;Paginas");
			TreeSet<Anais> anaisSet = new TreeSet<Anais>();
			for(Publicacao iter : this.pubs) {
				if(iter.getClass().equals(Anais.class))
					anaisSet.add((Anais)iter);
			}
			for(Anais iter : anaisSet) {
				iter.imprimeCSV();
			}
			
		}
		else if(tipoPub.equals("artjr")) {
			System.out.println("Titulo;Idioma;Cidade;Data;ISSN;Paginas");
			TreeSet<ArtJr> artjrSet = new TreeSet<ArtJr>();
			for(Publicacao iter : this.pubs) {
				if(iter.getClass().equals(ArtJr.class))
					artjrSet.add((ArtJr)iter);
			}
			for(ArtJr iter : artjrSet) {
				iter.imprimeCSV();
			}
		}
		else if(tipoPub.equals("artpe")) {
			System.out.println("Natureza;Idioma;Editora;Cidade;Volume;Fasciculo;Serie;ISSN;Paginas");
			TreeSet<ArtPe> artpeSet = new TreeSet<ArtPe>();
			for(Publicacao iter : this.pubs) {
				if(iter.getClass().equals(ArtPe.class))
					artpeSet.add((ArtPe)iter);
			}
			for(ArtPe iter : artpeSet) {
				iter.imprimeCSV();
			}
			
		}
		else if(tipoPub.equals("livro")) {
			System.out.println("Natureza;Titulo;Idioma;Editora;Cidade;ISBN;Paginas");
			TreeSet<Livro> livroSet = new TreeSet<Livro>();
			for(Publicacao iter : this.pubs) {
				if(iter.getClass().equals(Livro.class))
					livroSet.add((Livro)iter);
			}
			for(Livro iter : livroSet) {
				iter.imprimeCSV();
			}
		}
		else if(tipoPub.equals("partmu")) {
			System.out.println("Natureza;Editora;Cidade;Formacao;Paginas");
			TreeSet<PartMu> partmuSet = new TreeSet<PartMu>();
			for(Publicacao iter : this.pubs) {
				if(iter.getClass().equals(PartMu.class))
					partmuSet.add((PartMu)iter);
			}
			for(PartMu iter : partmuSet) {
				iter.imprimeCSV();
			}
		}
		
		else if(tipoPub.equals("tradu")){
			System.out.println("Natureza;Titulo;Idioma;Editora;Cidade;Traducao;Paginas");
			TreeSet<Traducao> tradSet = new TreeSet<Traducao>();
			for(Publicacao iter : this.pubs) {
				if(iter.getClass().equals(Traducao.class))
					tradSet.add((Traducao)iter);
			}
			for(Traducao iter : tradSet) {
				iter.imprimeCSV();
			}
		}
		else if(tipoPub.equals("outro")) {
			System.out.println("Natureza;Idioma;Editora;Cidade;Paginas");
			TreeSet<Outro> outroSet = new TreeSet<Outro>();
			for(Publicacao iter : this.pubs) {
				if(iter.getClass().equals(Outro.class))
					outroSet.add((Outro)iter);
			}
			for(Outro iter : outroSet) {
				iter.imprimeCSV();
			}
		}
		else {
			System.out.println("Tipo invalido.");
		}
	}
	
}