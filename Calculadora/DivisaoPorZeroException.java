/**
 * Classe para exceções de divisões por zero.
 * 
 * @author Erick de Oliveira Silva
 * @version 2017.10.18
 */
public class DivisaoPorZeroException extends RuntimeException
{
	/**
	 * Controi a exceção
	 *
	 * @param      msg   Mensagem descrevendo a exceção
	 */
	public DivisaoPorZeroException( String msg )
	{
		super( msg );
	}
}