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
	
	
	
	public static void criaProjeto(String nomePastaProjeto, String nomeLegivel) {
		
		String conteudoHTML = "" +
				"<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"\t<meta charset=\"utf-8\" />\n" +
				"\n" +
				"\t<!--\n" +
				"\t    Customize the content security policy in the meta tag below as needed. Add 'unsafe-inline' to default-src to enable inline JavaScript.\n" +
				"\t    For details, see http://go.microsoft.com/fwlink/?LinkID=617521\n" +
				"\t-->\n" +
				"\t<meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'self' data: gap: https://ssl.gstatic.com 'unsafe-eval'; style-src 'self' 'unsafe-inline'; media-src *\">\n" +
				"\t<title>" + nomeLegivel + "</title>\n" +
				"\n" +
				"\t<!-- SQLitePers2 references -->\n" +
				"\t<link href=\"css/index.css\" rel=\"stylesheet\" />\n" +
				"</head>\n" +
				"<body>\n" +
				"\t<!-- Cordova reference, this is added to your app when it's built. -->\n" +
				"\t<script src=\"cordova.js\"></script>\n" +
				"\t<script src=\"scripts/platformOverrides.js\"></script>\n" +
				"\n" +
				"\t<script src=\"scripts/inicializacaoObjetos.js\"></script>\n" +
				"\t<script src=\"scripts/index.js\"></script>\n" +
				"\t<script src=\"scripts/funcoes.js\"></script>\n" +
				"\t<script src=\"scripts/assimilacaoEventos.js\"></script>\n" +
				"\n" +
				"</body>\n" +
				"</html>\n";

		
		String conteudoJS = "function olaMundo() { alert('Olá mundo') }";
		
		String conteudoCSS = "body {\n\n}";
		
		criaArquivo("Projetos\\" + nomePastaProjeto + "\\index.html", conteudoHTML);
		criaArquivo("Projetos\\" + nomePastaProjeto + "\\css\\style.css", conteudoCSS);
		criaArquivo("Projetos\\" + nomePastaProjeto + "\\js\\scripts.js", conteudoJS);
		
	}
	
}
