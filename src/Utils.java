import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.omg.CORBA.OBJECT_NOT_EXIST;

public class Utils {
	
	
	public static void criaArquivo(String caminhoArquivo, String conteudoArquivo) {
		
		// Joga uma exceção quando tenta se prover um valor com '\\' no início
		if (caminhoArquivo.charAt(0) == '\\' || caminhoArquivo.charAt(1) == '\\') {
			throw new AutoHTMLException("Não é permitido um caminho em que o primeiro caractere seja.");
		}
		
		// Joga uma exceção quando tenta se prover um valor com '\\' no final
		if (caminhoArquivo.charAt(caminhoArquivo.length() - 1) == '\\' || caminhoArquivo.charAt(caminhoArquivo.length() - 2) == '\\') {
			throw new AutoHTMLException("Foi fornecido um caminho. Deve ser um arquivo.");
		}
		
		String[] partesCaminho = caminhoArquivo.split("\\\\");
		String nomeArquivo = partesCaminho[partesCaminho.length - 1];
		String mkdirsString = caminhoArquivo.replaceAll(nomeArquivo + "$", "");
		File arquivo = new File(caminhoArquivo);
		
		try {	
			
			new File(mkdirsString).mkdirs();
			arquivo.createNewFile();
			FileWriter fWriter = new FileWriter(arquivo);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write(conteudoArquivo);
			bWriter.close();
			
		} catch (Exception e) {
			
			System.out.println("Falha na criação do arquivo: " + e.getMessage());
			
		}
	}
	
	
	
	public static void criaProjeto(String nomeProjeto) {
		
		String conteudoHTML = "<h1>oi mundo!</h1>";
		String conteudoJS = "function olaMundo() { alert('Olá mundo') }";
		String conteudoCSS = "body {\n\n}";
		
		criaArquivo("Projetos\\" + nomeProjeto + "\\index.html", conteudoHTML);
		criaArquivo("Projetos\\" + nomeProjeto + "\\css\\style.css", conteudoCSS);
		criaArquivo("Projetos\\" + nomeProjeto + "\\js\\scripts.js", conteudoJS);
		
	}
	
}
