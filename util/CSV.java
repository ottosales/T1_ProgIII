package util;

import java.util.TreeMap;
import java.io.*;
import java.util.Scanner;
import system.*;


public class CSV {
	
	public static void loadData(File f, TreeMap <String, PPG> mapPPG, TreeMap<String, IES> mapIES) throws IOException {	    

		// Cria um scanner para ler o arquivo linha por linha.
	    try (Scanner scanner = new Scanner(f)) {
	        // Despreza a primeira linha (titulo) e le as demais.
	        if (scanner.hasNextLine()) scanner.nextLine();
	        while (scanner.hasNextLine()) {
	            String linha = scanner.nextLine();
	            if ((linha != null) && (!linha.isEmpty())) {
	                // Separa os dados conditos na linha pelos ponto-e-virgula usados como separadores.
	                String[] dados = linha.split(";(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
	                // Remove espacos que estejam sobrando nas strings.
	                for (int i = 0; i < dados.length; i++)
	                    if (dados[i] != null) dados[i] = dados[i].trim();
	                
	                Publicacao proj = null;
	                
	                //Anal
	                if(dados[7].equals("8")) {
	                	proj = new Anais(dados[5], dados[8], dados[9], dados[13], dados[14], dados[15], dados[16], dados[18]);  
	                }
	                
	                //ArtJr
	                else if(dados[7].equals("9")) {
	                	proj = new ArtJr(dados[8], dados[12], dados[13], dados[9], dados[15], dados[10], dados[11]);
	                }
	                
	                //Outro
	                else if(dados[7].equals("10")) {
	                	proj = new Outro(dados[8], dados[12], dados[9], dados[10], dados[13]);
	                }
	                
	                //Traducao
	                else if(dados[7].equals("21")) {
	                	proj = new Traducao(dados[8], dados[10], dados[11], dados[13], dados[12], dados[14], dados[17]);
	                }
	                
	                //ArtPe
	                else if(dados[7].equals("25")) {
	                	proj = new ArtPe(dados[8], dados[14], dados[18], dados[9], dados[10], dados[11], 
	                			dados[21], dados[19], dados[12], dados[13]);
	                }
	                
	                //Livro
	                else if(dados[7].equals("26")) {
	                	proj = new Livro(dados[9], dados[15], dados[21], dados[10], dados[12], dados[11], dados[38]);
	                }
	                
	                //PartMu
	                else if(dados[7].equals("28")) {
	                	proj = new PartMu(dados[8], dados[10], dados[9], dados[11], dados[13]);
	                }
                
	                
	                
	                //os dois ja existem
	                if(mapPPG.containsKey(dados[0]) && mapIES.containsKey(dados[2] + " " + dados[3])) {
	                	mapPPG.get(dados[0]).inserePub(proj);
	                	if(!mapPPG.get(dados[0]).ExisteNaLista(dados[3]))
	                		mapPPG.get(dados[0]).registraIES(mapIES.get(dados[2] + " " + dados[3]));
	                	
	                	if(!mapIES.get(dados[2] + " " + dados[3]).ExisteNaLista(dados[1]))	
	                		mapIES.get(dados[2] + " " + dados[3]).registraPPG(mapPPG.get(dados[0]));
	                }
	                //o PPG ja existe mas a IES nao existe
	                else if(mapPPG.containsKey(dados[0]) && !mapIES.containsKey(dados[2] + " " + dados[3])) {
	                	IES tempIES = new IES(dados[3], dados[2]);
	                	mapIES.put(dados[2] + " " + dados[3], tempIES);
	                	mapPPG.get(dados[0]).inserePub(proj);
	                	if(!mapPPG.get(dados[0]).ExisteNaLista(dados[3]))
            				mapPPG.get(dados[0]).registraIES(mapIES.get(dados[2] + " " + dados[3]));
            	
            			if(!mapIES.get(dados[2] + " " + dados[3]).ExisteNaLista(dados[0]))	
            				mapIES.get(dados[2] + " " + dados[3]).registraPPG(mapPPG.get(dados[0]));
	                	
	                }
	                //o PPG nao existe mas a IES ja existe
	                else if(!mapPPG.containsKey(dados[0]) && mapIES.containsKey(dados[2] + " " + dados[3])) {
	                	PPG tempPPG = new PPG(dados[1], dados[0]);
	                	tempPPG.inserePub(proj);
	                	mapPPG.put(dados[0], tempPPG);
	                	if(!mapPPG.get(dados[0]).ExisteNaLista(dados[3]))
            				mapPPG.get(dados[0]).registraIES(mapIES.get(dados[2] + " " + dados[3]));
            	
            			if(!mapIES.get(dados[2] + " " + dados[3]).ExisteNaLista(dados[0]))	
            				mapIES.get(dados[2] + " " + dados[3]).registraPPG(mapPPG.get(dados[0]));
	                }
	                //os dois nao existem
	                else {
	                	PPG tempPPG = new PPG(dados[1], dados[0]);
	                	IES tempIES = new IES(dados[3], dados[2]);
	                	tempPPG.inserePub(proj);
	                	mapPPG.put(dados[0], tempPPG);
	                	mapIES.put(dados[2] + " " + dados[3], tempIES);
	                	if(!mapPPG.get(dados[0]).ExisteNaLista(dados[3]))
            				mapPPG.get(dados[0]).registraIES(mapIES.get(dados[2] + " " + dados[3]));
            	
            			if(!mapIES.get(dados[2] + " " + dados[3]).ExisteNaLista(dados[0]))	
            				mapIES.get(dados[2] + " " + dados[3]).registraPPG(mapPPG.get(dados[0]));
	                }
	            }
	        }
	    }	    	    
	}
}