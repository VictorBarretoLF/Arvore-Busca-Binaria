import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTexto {
	
	private String nomeDoArquivo;
	
	ArquivoTexto(String nomeDoArquivo) {
		String fileName = nomeDoArquivo;
		try {
			File myObj = new File(fileName);
			myObj.createNewFile();
			this.nomeDoArquivo = nomeDoArquivo;
		} catch (IOException e) {
			System.out.println("Um erro aconteceu");
			e.printStackTrace();
		} 
		
	}
	
	public void escreverNoArquivo(String texto) {
	    try {
	        FileWriter myWriter = new FileWriter(this.nomeDoArquivo, true);
	        myWriter.write(texto + "\n");
	        myWriter.close();
	        System.out.println("Dados escritos com sucesso!");
	      } catch (IOException e) {
	        System.out.println("Um erro aconteceu!!!!!!");
	        e.printStackTrace();
	      }
	}
	
	public String getNomeDoArquivo() {
		return this.nomeDoArquivo;
	}

}
