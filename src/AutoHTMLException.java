
public class AutoHTMLException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AutoHTMLException() {
		super();
	}
	
	public AutoHTMLException(String mensagem) {
		super(mensagem);
	}
	
	public AutoHTMLException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	public AutoHTMLException(Throwable causa) {
		super(causa);
	}
}
