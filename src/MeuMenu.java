import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MeuMenu {
	
	public void mostrarMenu() {
		System.out.println("\nEscolha uma das opções.\n");
		System.out.println("1 - INSERIR - forneça o RGM e o Nome.");
		System.out.println("2 - REMOVER - forneça o RGM a ser removido.");
		System.out.println("3 - PESQUISAR - forneça o RGM a ser pesquisado.");
		System.out.println("4 - ESVAZIAR - apaga todos os dados e arquivos.");
		System.out.println("5 - EXIBIR A ÁRVORE");
		System.out.println("0 - SAIR");
	}
	
	public void mostrarArvore(ArvoreBinariaBusca abb) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1 - EXIBIR ÁRVORE E NÓS");
		System.out.println("2 - EXIBIR ÁRVORE PRÉ-ORDEM");
		System.out.println("3 - EXIBIR ÁRVORE PÓS-ORDEM");
		System.out.println("4 - EXIBIR ÁRVORE IN-ORDEM");
		int escolha = Integer.parseInt(br.readLine());
		switch (escolha) {
			case 1 : abb.mostrarArvore(); break;
			case 2 : abb.mostrarPreOrdem(); break;
			case 3 : abb.mostrarPosOrdem(); break;
			default :abb.mostrarEmOrdem(); break;
		}
	}
	
	public void apagarConsole() {
		 for(int i = 0; i < 50; i++) System.out.println();
	}
	
	private int validarRgmComoInteiro() throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
				int rgm = Integer.parseInt(br.readLine());
				return rgm;
			} catch (NumberFormatException e) {
				System.out.println("Formato de RGM inválido!");
				System.out.println("Digite o RGM do aluno");
			}
		}
		
	}
	
	public int validandoRGM(ArvoreBinariaBusca abb) throws IOException {
		System.out.println("Digite o RGM:");
		while(true) {
			int rgm = validarRgmComoInteiro();
			// checa se o rgm já existe de acordo com a árvore
			if (checarRgmExistente(abb, rgm)) {
				System.out.println("Esse rgm já existe, digite um novo:");
				continue;
			}
			System.out.println("RGM válido!");
			return rgm;
		}
	}
	
	// recebe uma arvore e um rgm para verificar se o rgm existe ou não naquela arvore.
	private boolean checarRgmExistente(ArvoreBinariaBusca abb, int rgm) {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		if(abb.encontrarRGM(rgm)) return true;
		return false;
	}
	
	public String validandoNome() throws IOException {
		System.out.println("Digite o nome:");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String nome = br.readLine();
		return nome;
	}
	
	public NoAluno procurarRgm(ArvoreBinariaBusca abb) throws IOException {
		System.out.println("Digite o rgm que deseja procurar:");
		int rgm = validarRgmComoInteiro();
		if(abb.encontrarAluno(rgm) != null) return abb.encontrarAluno(rgm);
		return null;
	}
	
}
