public class AutoHTML {

	public static void main(String[] args) {
		
		String nomePasta = "PastaProjeto_" + Long.toString(System.currentTimeMillis());
		String nomeArquivo = "balela\\coiso.txt";
		String conteudoArquivo = "Este � o conte�do do arquivo. Nada mais que isto.";
		
		Utils.criaPasta(nomePasta);
		Utils.testeArr();
		Utils.testeString();
	}

}
