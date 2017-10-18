
/**
 * Classe representando uma conta bancaria, uma conta possui nome do dono, numero da conta e saldo atual.
 * 
 * @author Erick de Oliveira Silva
 * @version 2017.10.17
 */
public class ContaBancaria
{
	// O nome do dono da conta
	private String nome;
	// O numero da conta
	private int conta;
	// O saldo atual da conta
	private double saldo;

	public ContaBancaria( String nome 
						, int 	 conta
						, double saldo_inicial )
	{
		this.nome = nome;
		this.conta = conta;
		saldo = saldo_inicial;
	}

	/**
	 * Resgata o numero da conta
	 *
	 * @return     O numero da conta.
	 */
	public int getConta()
	{
		return conta;
	}

	/**
	 * Imprime o extrato da conta
	 */
	public void extrato()
	{
		System.out.println( "\tExtrato" );
		System.out.println( "Nome: " + this.nome );
		System.out.println( "Numero da conta: " + this.conta );
		System.out.printf(  "Saldo atual: R$ %.2f\n\n", this.saldo );
	}

	/**
	 * Saca um valor da conta
	 *
	 * @param      valor               O valor a ser sacado
	 *
	 * @throws     ParametroException  se valor for negativo ou se valor > saldo
	 */
	public void sacar( double valor ) throws ParametroException
	{
		if( valor < 0 )
		{
			throw new ParametroException( "Parametro invalido: valor negativo" );
		} else if ( valor > saldo )
		{
			throw new ParametroException( "Parametro invalido: valor solicitado maior que o saldo disponivel");
		} else if ( valor <= saldo )
		{
			saldo -= valor;
			System.out.printf( "Sacado: R$ %.2f\n", valor );
			System.out.printf( "Novo Saldo: R$ %.2f\n\n", saldo );
		}

	}

	/**
	 * Deposita um valor na conta
	 *
	 * @param      valor               O valor a ser depositado
	 *
	 * @throws     ParametroException  se valor for negativo
	 */
	public void depositar( double valor ) throws ParametroException
	{ 
		if ( valor < 0 )
		{
			throw new ParametroException( "Parametro invalido: valor negativo" );
		} else 
		{
			saldo += valor;
			System.out.printf( "Depositado: R$ %.2f\n", valor );
			System.out.printf( "Novo Saldo: R$ %.2f\n\n", saldo );
		}
	}
}