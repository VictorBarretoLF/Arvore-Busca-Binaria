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
		NoAluno aluno;
		txt.criarArvoreUsandoArquivo(abb);
			    
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
					System.out.println("Opção escolhida 3 - REMOVER UM NÓ");
					aluno = menu.procurarRgm(abb);
					if(aluno == null) System.out.println("Aluno não encontrado!");
					else {
						System.out.println("Aluno removido com sucesso!!!\n" + aluno);
						abb.deletar(aluno.rgm);
					}
//					txt.apagarDadosDoArquivo();
					txt.reescreverAposDeletar(abb);
					break;
				case 3 : 
					System.out.println("Opção escolhida 3 - PESQUISAR");
					aluno = menu.procurarRgm(abb);
					if(aluno == null) System.out.println("Aluno não encontrado!");
					else System.out.println("Aluno encontrado!\n" + aluno);
					break;
				case 4 :
					System.out.println("Opção escolhida 4 - ESVAZIAR ÁRVORE");
					break;
				case 5 :
					System.out.println("Opção escolhida 5 - EXIBIR A ÁRVORE");
					menu.mostrarArvore(abb);
					break;
				default : sair = false;
			}
			
		}
		System.out.println("APLICAÇÃO FINALIZADA, OBRIGADO!");
	    
	}
	
}
