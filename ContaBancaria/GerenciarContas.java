import java.util.ArrayList;
/**
 * Classe para gerenciar contas.
 * 
 * @author Erick de Oliveira Silva
 * @version 2017.10.17
 */
public class GerenciarContas
{
	// Coleção de contas bancarias.
	private ArrayList< ContaBancaria > contas;

	/**
	 * Construtor padrão.
	 */
	public GerenciarContas()
	{
		// Inicializa a coleção
		contas = new ArrayList< ContaBancaria >();
	}

	/**
	 * Armazena uma conta na coleção
	 *
	 * @param      conta  A conta para ser armazenada
	 */
	public void armazenarConta( ContaBancaria conta )
	{
		contas.add( conta );
	}

	/**
	 * Remove uma conta com base no seu numero de conta.
	 *
	 * @param      numeroConta  O numero da conta a ser removida
	 */
	public void removerConta( int numeroConta )
	{
		for( ContaBancaria current : contas )
		{
			// Procura a conta na coleção pelo numero
			if( current.getConta() == numeroConta )
			{
				// Resgata o indice do objeto na coleção
				int indice = contas.indexOf( current );
				System.out.println( "Removendo conta do cliente : " + current.getNome() );
				
				// Remove de acordo com o indice
				contas.remove( indice );
				break;
			}
		}
	}

	/**
	 * Deposita o valor em uma conta, de numero igual ao numeroConta, presente na coleçao
	 *
	 * @param      numeroConta  O numero da conta
	 * @param      valor        O valor a ser depositado
	 */
	public void depositarConta( int numeroConta, double valor )
	{
		for( ContaBancaria current : contas )
		{
			// Procura a conta na coleção pelo numero
			if( current.getConta() == numeroConta )
			{
				// Tenta depositar o valor, caso valor < 0 irá lançar a PaarametroException
				try 
				{
					current.depositar( valor );
					break;
				} catch ( ParametroException e )
				{
					System.out.println( e.getMessage() );
				}
			}
		}
	}

	/**
	 * Saca o valor em uma conta, de numero igual ao numeroConta, presente na coleçao.
	 *
	 * @param      numeroConta  O numero da conta
	 * @param      valor        O valor a ser sacado
	 */
	public void sacarConta( int numeroConta, double valor )
	{
		for( ContaBancaria current : contas )
		{	
			// Procura a conta na coleção pelo numero
			if( current.getConta() == numeroConta )
			{
				// Tenta sacar o valor, caso valor < 0 ou valor < saldo disponivel lança uma ParametroException
				try
				{
					current.sacar( valor );
					break;
				} catch( ParametroException e )
				{
					System.out.println( e.getMessage() );
				}
			}
		}
	}

	/**
	 * Mostra o extrato da conta com numero igual a numeroConta
	 *
	 * @param      numeroConta  O numero da conta
	 */
	public void extratoConta( int numeroConta )
	{
		for( ContaBancaria current : contas )
		{	
			// Procura a conta na coleção pelo numero
			if( current.getConta() == numeroConta )
			{
				current.extrato();
				break;
			}
		}
	}

}