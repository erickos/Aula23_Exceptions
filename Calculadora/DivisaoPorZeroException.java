/**
 * Exception for signaling divisao por zero errors.
 */
public class DivisaoPorZeroException extends RuntimeException
{
	public DivisaoPorZeroException( String msg )
	{
		super( msg );
	}
}