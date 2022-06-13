
public class NoAluno {
	
	private int rgm;
	private String nome;
	NoAluno esquerda;
	NoAluno direita;
	
	NoAluno(int value, String nome) {
		this.rgm = value;
		this.nome = nome;
		esquerda = null;
		direita = null;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getRgm() {
		return this.rgm;
	}
	
	public void setRgm(int rgm) {
		this.rgm = rgm;
	}
	
	@Override
	public String toString() {
		return "(Nome: " + this.nome + "- RGM: " + this.rgm + ")";
	}

}
