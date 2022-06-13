import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaBusca {
	
	private NoAluno raiz;
	
	private NoAluno addRecursivo(NoAluno atual, int valor, String nome) {
		if (atual == null) return new NoAluno(valor, nome);
		
		if (valor < atual.getRgm()) atual.esquerda = addRecursivo(atual.esquerda, valor, nome);
		else if (valor > atual.getRgm()) atual.direita = addRecursivo(atual.direita, valor, nome);
		else return atual;
		
		return atual;
	}
	
	public void add(int valor, String nome) {
		raiz = addRecursivo(raiz, valor, nome);
	}
	
	private boolean encontrarRgmRecursivo(NoAluno noAtual, int rgmProcurado) {
		if (noAtual == null) return false;
		if (rgmProcurado == noAtual.getRgm()) return true;
		
		return rgmProcurado < noAtual.getRgm()
				? encontrarRgmRecursivo(noAtual.esquerda, rgmProcurado)
				: encontrarRgmRecursivo(noAtual.direita, rgmProcurado);
	}
	
	public boolean encontrarRGM(int rgmProcurado) {
		return encontrarRgmRecursivo(raiz, rgmProcurado);
	}
	
	private NoAluno encontrarAlunoRecursivo(NoAluno noAtual, int rgmProcurado) {
		if (noAtual == null) return null;
		if (rgmProcurado == noAtual.getRgm()) return noAtual;
		
		return rgmProcurado < noAtual.getRgm() 
				? encontrarAlunoRecursivo(noAtual.esquerda, rgmProcurado)
				: encontrarAlunoRecursivo(noAtual.direita, rgmProcurado);
	}
	
	public NoAluno encontrarAluno(int rgmProcurado) {
		return encontrarAlunoRecursivo(raiz, rgmProcurado);
	}
	
	private NoAluno encontrarMenorValor(NoAluno atual) {
		return atual.esquerda == null ? atual : encontrarMenorValor(atual.esquerda);
	}
	
	private NoAluno deletarRecursivo(NoAluno atual, int rgmDeletar) {
		if (atual == null) {
			System.out.println("Aluno não encontrado! Nenhum nó deletado.");
			return null;
		}
		// casos para poder deletar o nó
		if (rgmDeletar == atual.getRgm()) {
			
			// o nó não possui nenhum filho
			if (atual.esquerda == null && atual.direita == null) return null;
			
			// o nó tem exatamente um unico filho
			if (atual.direita == null) return atual.esquerda;
			if (atual.esquerda == null) return atual.direita;
			
			NoAluno alunoMenorValor = encontrarMenorValor(atual.direita);
			int menorValor = alunoMenorValor.getRgm();
			atual.setRgm(menorValor);
			atual.setNome(alunoMenorValor.getNome());
			atual.direita = deletarRecursivo(atual.direita, menorValor);
			return atual;
		}
		
		if (rgmDeletar < atual.getRgm()) {
			atual.esquerda = deletarRecursivo(atual.esquerda, rgmDeletar);
			return atual;
		}
		
		atual.direita = deletarRecursivo(atual.direita, rgmDeletar);
		
		return atual;
	}
	
	public void deletar(int valor) {
		raiz = deletarRecursivo(raiz, valor);
	}
	
	private void mostrarEmOrdemRecursivo(NoAluno raiz) {
	    if (raiz != null) {
	    	mostrarEmOrdemRecursivo(raiz.esquerda);
	        System.out.println(raiz);
	        mostrarEmOrdemRecursivo(raiz.direita);
	    }
	}
	
	public void mostrarEmOrdem() {
		System.out.println("EXIBINDO IN-ORDEM");
		mostrarEmOrdemRecursivo(raiz);
	}
	
	private void mostrarPreOrdem(NoAluno raiz) {
	    if (raiz != null) {
	    	System.out.println(raiz);
	    	mostrarPreOrdem(raiz.esquerda);
	    	mostrarPreOrdem(raiz.direita);
	    }
	}
	
	private void dadosDaArvoreEmString(NoAluno raiz, List<String> li) {
		if (raiz != null) {
	    	li.add(raiz.getRgm() + " " + raiz.getNome() + "\n");
	    	dadosDaArvoreEmString(raiz.esquerda, li);
	    	dadosDaArvoreEmString(raiz.direita, li);
		}
	}
	
	public String dadosDaArvoreEmString() {
		ArrayList<String> lista = new ArrayList<String>();
		dadosDaArvoreEmString(raiz, lista);
		String dados = "";
		for(String usuario : lista) dados += usuario;
		return dados;
	}

	public void mostrarPreOrdem() {
		System.out.println("EXIBINDO PRÉ-ORDEM");
		mostrarPreOrdem(raiz);
	}
	
	private void mostrarPosOrdem(NoAluno raiz) {
		if(raiz != null) {
			mostrarPosOrdem(raiz.esquerda);
			mostrarPosOrdem(raiz.direita);
			System.out.println(raiz);
		}
	}
	
	public void mostrarPosOrdem() {
		System.out.println("EXIBINDO PÓS-ORDEM");
		mostrarPosOrdem(raiz);
	}
	
	private void mostrarArvoreRecursivo(NoAluno atual) {
		if (this.contador == 0) System.out.println("Raiz: " + atual);
		else System.out.println(atual);
		
		this.contador++;
		if (atual.esquerda != null) {
			System.out.print("\t".repeat(Math.max(0, contador)) + "|____> Nó esquerda: ");
			mostrarArvoreRecursivo(atual.esquerda);
		}
		
		if (atual.direita != null) {
			System.out.print("\t".repeat(Math.max(0, contador)) + "|____> Nó direita: ");
			mostrarArvoreRecursivo(atual.direita);
		}
		
		this.contador--;
	}
	
	private int contador = 0;
	public void mostrarArvore() {
		this.contador = 0;
		if(raiz == null) System.out.println("Árvore vazia.");
		else mostrarArvoreRecursivo(raiz);
	}

	private void esvaziarArvoreRecursivo(NoAluno raiz) {
		if(raiz != null) {
			esvaziarArvoreRecursivo(raiz.esquerda);
			esvaziarArvoreRecursivo(raiz.direita);
			this.raiz = null;
		}
	}
	
	public void esvaziarArvoreRecursivo() {
		esvaziarArvoreRecursivo(raiz);
	}
}
