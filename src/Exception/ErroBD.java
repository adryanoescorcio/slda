package Exception;


/**
 * Classe que captura as Exception da App.
 *<br>Obs.: Não implementado.
 *
 * @author Adryano Escorcio
 * @version 1.0
 **/
@SuppressWarnings("serial")
public class ErroBD extends Exception {

	public ErroBD(String string, Exception e) {
		super(string);
	}

}
