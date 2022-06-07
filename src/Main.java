import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ArvoreBinariaBusca abb = new ArvoreBinariaBusca();
		ArquivoTexto txt = new ArquivoTexto("lista.txt");
		MeuMenu menu = new MeuMenu();
		Scanner sc = new Scanner(System.in);
		
		criarArvoreUsandoArquivo(abb, txt);
			    
		boolean sair = true;
		while(sair) {
			
			menu.mostrarMenu();
			
			int chave = sc.nextInt();
			menu.apagarConsole();
			switch (chave) {
				 // OPÇÃO PARA INSERIR UM NOVO ALUNO!
				case 1 : 
					System.out.println("Opção escolhida 1 - INSERIR");
					int rgm = menu.validandoRGM(abb);
					String nome = menu.validandoNome();
					abb.add(rgm, nome);
					txt.escreverNoArquivo(rgm + " " + nome);
					break;
				case 2 :
					System.out.println("Digite o RGM a ser removido.");
					chave = sc.nextInt();
					break;
				case 3 : 
					System.out.println("Opção escolhida 3 - PESQUISAR");
					NoAluno aluno = menu.procurarRgm(abb);
					if(aluno == null) System.out.println("Aluno não encontrado!");
					else System.out.println("Aluno encontrado!\n" + aluno);
					break;
				default : sair = false;
			}
			
		}
		System.out.println("APLICAÇÃO FINALIZADA, OBRIGADO!");
	    abb.mostrarArvore();
	    
	}
	
	public static void criarArvoreUsandoArquivo(ArvoreBinariaBusca abb, ArquivoTexto txt) throws NumberFormatException, IOException {
	    try {
	    	FileReader fr= new FileReader(txt.getNomeDoArquivo());    
	    	BufferedReader br=new BufferedReader(fr);  
	        
	        String data;
	        while ((data = br.readLine()) != null) {
	        	int rgm = Integer.parseInt(data.substring(0, data.indexOf(" ")));
	        	String nome = data.substring(data.indexOf(" "));
	          abb.add(rgm, nome);
	        }
	        br.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	

}
