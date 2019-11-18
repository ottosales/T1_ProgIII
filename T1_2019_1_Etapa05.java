import util.CSV;
import java.io.IOException;
import java.io.File;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

import system.*;

public class T1_2019_1_Etapa05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		TreeMap<String, IES> mapIES = new TreeMap<String, IES>();
		TreeMap<String, PPG> mapPPG = new TreeMap<String, PPG>();
		
		String diretorio = scan.nextLine();
		try{
			for(int i = 0; i < 7; i++) {
				String nome = scan.nextLine();
				String arquivo = diretorio + nome;
				
				File f = new File(arquivo);
	
				
				CSV.loadData(f, mapPPG, mapIES);
			}
			String[] comando = scan.nextLine().split(" ");
			
			if(comando[0].equals("rede")) {
				PPG.rede(mapPPG);
			}
			else if(comando[0].equals("ppg")) {
				try{
					mapPPG.get(comando[1]).comandoPPG();
				}
				catch(Exception e) {
					System.out.println("PPG nao encontrado.");
				}
			}
			else if(comando[0].equals("ies")) {
				Set<Entry<String, IES>> entrySet = mapIES.entrySet();
				Boolean encontrou = false;
				
				for(Entry<String, IES> iter : entrySet) {
					if(iter.getValue().getSigla().equals(comando[1])) {
						iter.getValue().comandoIES();
						encontrou = true;
					}
				}
				if(!encontrou)
					System.out.println("IES nao encontrada.");
			}
			else if(comando[0].equals("csv")) {
				try{
					mapPPG.get(comando[1]).criaCSV(comando[2]);
				}
				catch(NullPointerException e) {
					System.out.println("PPG nao encontrado.");
				}
			}
			else
				System.out.println("Comando desconhecido.");
		}
		catch(IOException e) {
			System.out.println("Erro de I/O");
		}
		
		scan.close();
		
		
	}

}