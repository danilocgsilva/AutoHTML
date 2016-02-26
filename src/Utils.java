import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.omg.CORBA.OBJECT_NOT_EXIST;

public class Utils {
	
	public static void criaPasta(String caminhoPasta) {
		try {
			new File(caminhoPasta).mkdirs();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	public static void criaArquivo(String caminhoArquivo, String conteudoArquivo) {
		
		if (caminhoArquivo.charAt(0) == '\\' || caminhoArquivo.charAt(1) == '\\') {
			throw new AutoHTMLException("Não é permitido um caminho em que o primeiro caractere seja.");
		}
		
		if (caminhoArquivo.charAt(caminhoArquivo.length() - 1) == '\\' || caminhoArquivo.charAt(caminhoArquivo.length() - 2) == '\\') {
			throw new AutoHTMLException("Foi fornecido um caminho. Deve ser um arquivo.");
		}
		
		String[] fragmentosCaminho = caminhoArquivo.split(caminhoArquivo);
		
		try {
			
			if (fragmentosCaminho.length > 1) {
				for (int i = 0; i < fragmentosCaminho.length - 2; i++) {
					
				}
			}
			
		} catch (Exception e) {
			
			System.out.println("Falha na criação do arquivo: " + e.getMessage());
			
		}
	}
	
	public static void testeArr() {
		String caminho1 = "danilo\\subpasta\\texto.txt";
		String caminho2 = "texto.txt";
		String caminho3 = "danilo\\subpasta\\";
		String caminho4 = "\\danilo\\subpasta\\";
		
		String[] frag1 = caminho1.split("\\\\");
		String[] frag2 = caminho2.split("\\\\");
		String[] frag3 = caminho3.split("\\\\");
		String[] frag4 = caminho4.split("\\\\");
		
		System.out.println("Elementos em frag1: " + frag1.length + ". Último elemento: " + frag1[frag1.length - 1] + ". Primeiro elemento: " + frag1[0]);
		System.out.println("Elementos em frag2: " + frag2.length + ". Último elemento: " + frag2[frag2.length - 1] + ". Primeiro elemento: " + frag2[0]);
		System.out.println("Elementos em frag3: " + frag3.length + ". Último elemento: " + frag3[frag3.length - 1] + ". Primeiro elemento: " + frag3[0]);
		System.out.println("Elementos em frag4: " + frag4.length + ". Último elemento: " + frag4[frag4.length - 1] + ". Primeiro elemento: " + frag4[0]);
		
	}
	
	public static void testeString() {
		String ovo = "DaniloSilva";
		System.out.println("Character na posição 1: " + ovo.charAt(0));
		System.out.println("Character na posição 2: " + ovo.charAt(1));
	}
	
}
