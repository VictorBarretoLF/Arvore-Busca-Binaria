import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	
	public void criarArvoreUsandoArquivo(ArvoreBinariaBusca abb) throws NumberFormatException, IOException {
	    try {
	    	FileReader fr= new FileReader(this.nomeDoArquivo);    
	    	BufferedReader br=new BufferedReader(fr);  
	        
	        String data;
	        while ((data = br.readLine()) != null) {
	        	int rgm = Integer.parseInt(data.substring(0, data.indexOf(" ")));
	        	String nome = data.substring(data.indexOf(" "));
	        	abb.add(rgm, nome);
	        }
	        br.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("Um erro aconteceu!");
	        e.printStackTrace();
	      }
	}
	
	public void reescreverArquivo(ArvoreBinariaBusca abb) throws FileNotFoundException {
		apagarDadosDoArquivo();
		try {
	        FileWriter myWriter = new FileWriter(this.nomeDoArquivo, true);
	        myWriter.write(abb.dadosDaArvoreEmString());
	        myWriter.close();
		} catch (IOException e) {
	        System.out.println("Um erro aconteceu!!!!!!");
	        e.printStackTrace();
	     }
	}
	
	public void apagarDadosDoArquivo() throws FileNotFoundException {
		File file = new File(this.nomeDoArquivo);
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
	}

}
