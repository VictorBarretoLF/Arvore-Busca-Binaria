import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MeuMenu {
	
	public void mostrarMenu() {
		System.out.println("Escolha uma das op��es.");
		System.out.println("1 - INSERIR - forne�a o RGM e o Nome.");
		System.out.println("2 - REMOVER - forne�a o RGM a ser removido.");
		System.out.println("3 - PESQUISAR - forne�a o RGM a ser pesquisado.");
		System.out.println("4 - ESVAZIAR - apaga todos os dados e arquivos.");
		System.out.println("5 - EXIBIR A �RVORE");
		System.out.println("0 - SAIR");
	}
	
	public void apagarConsole() throws InterruptedException, IOException {
		 for(int i = 0; i < 50; i++) System.out.println();
	}
	
	public int validandoRGM(ArvoreBinariaBusca abb) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Digite o RGM do aluno");
		
		while(true) {
			try {
				int rgm = Integer.parseInt(br.readLine());
				// checa se o rgm j� existe de acordo com a �rvore
				if (checarRgmExistente(abb, rgm)) continue;
				System.out.println("RGM v�lido!");
				TimeUnit.SECONDS.sleep(5);
				apagarConsole();
				return rgm;
			} catch(NumberFormatException e) {
				System.out.println("Formato de RGM inv�lido!");
			}
		}
	}
	
	// recebe uma arvore e um rgm para verificar se o rgm existe ou n�o naquela arvore.
	private boolean checarRgmExistente(ArvoreBinariaBusca abb, int rgm) {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		if(abb.encontrarRGM(rgm)) {
			System.out.println("Esse rgm j� existe, digite um novo:");
			return true;
		}
		return false;
	}
	
	public String validandoNome() throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String nome = br.readLine();
		return nome;
	}

}
