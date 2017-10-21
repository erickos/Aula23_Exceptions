/**
 * Class for main.
 */
public class Main
{
	public static void main( String[] args )
	{
		ContaBancaria conta1 = new ContaBancaria( "Cliente1", 1, 100.00 );
		ContaBancaria conta2 = new ContaBancaria( "Cliente2", 2, 200.00 );

		GerenciarContas banco = new GerenciarContas();

		banco.armazenarConta( conta1 );
		banco.armazenarConta( conta2 );

		// Testando o Parametro exception
		banco.depositarConta( conta1.getConta(), -100.00 );
		banco.extratoConta( conta1.getConta() );
		banco.sacarConta( conta1.getConta(), 100.00 );
		banco.removerConta( conta1.getConta() );

		banco.extratoConta( conta2.getConta() );
		// Testando a exceção para saques inválidos
		banco.sacarConta( conta2.getConta(), 250.00 );
		banco.removerConta( conta2.getConta() );
	}
}