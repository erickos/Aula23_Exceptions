import java.io.*;
import java.util.ArrayList;
import java.lang.NumberFormatException;


/**
 * Classe para calculadora de expressões com dois operandos e um operador( + - * / ).
 * 
 * @author Erick de Oliveira Silva
 * @version 2017.10.18
 */
public class Calculadora
{
	// coleção com os operadores válidos
	private String[] operators = new String[] {"-","+","/","*"};
	

	/**
	 * Calcula o valor da expressao
	 *
	 * @param      expressao  Expressão a ser calculada
	 *
	 * @return     { description_of_the_return_value }
	 */
	public double calcular( String expressao )
	{
		// resgata qual o operador presente na expressão
		String operacao = getOperador( expressao );
		// vetor para guardar os operandos
		String[] splitted_expressao;

		// operandos
		double op1 = 0;
		double op2 = 0;
		
		// se a expressão for válida, então calcula o resultado
		if( ehExpressao( expressao ) )
		{
			if( operacao.equals("+") )
			{
				// necessita das duas contra barras para splitar pelo simbolo '+'
				splitted_expressao = expressao.split("\\+");
				op1 = Double.parseDouble(splitted_expressao[0]);
				op2 = Double.parseDouble(splitted_expressao[1]);
				return soma( op1, op2 );

			} else if( operacao.equals("-") )
			{   
				splitted_expressao = expressao.split("-");
				op1 = Double.parseDouble(splitted_expressao[0]);
				op2 = Double.parseDouble(splitted_expressao[1]);
			   	return subtracao( op1, op2 );

			} else if( operacao.equals("*") )
			{  		   
				// necessita das duas contra barras para splitar pelo simbolo '+'
				splitted_expressao = expressao.split("\\*");
				op1 = Double.parseDouble(splitted_expressao[0]);
				op2 = Double.parseDouble(splitted_expressao[1]);
				return multiplicacao( op1, op2 );   
			} else 
			{
				splitted_expressao = expressao.split("/");
				op1 = Double.parseDouble(splitted_expressao[0]);
				op2 = Double.parseDouble(splitted_expressao[1]);
				return divisao( op1, op2 );
			}
		}

		// retorno padrão
		return Double.MAX_VALUE;
	}
	
	/**
	 * Resgata o operador presente na expressão
	 *
	 * @param      expressao  A expressão a ser analisada
	 *
	 * @return     O operador
	 */
	private String getOperador( String expressao )
	{
		for( String operador : operators )
		{
			if (expressao.contains(operador)) 
			{
                return operador;
            }
		}
		
		return "erro";
	}
	
	/**
	 * Dado uma string, verifica se ela é um número válido
	 *
	 * @param      numero  Representação numerica de um numero
	 *
	 * @return     true se 'numero' for um número válido, falso caso contrário
	 */
	private boolean ehNumero( String numero )
	{
			// tenta converter, se levantar exceção então não é numero
			try
			{
				double operando = Double.parseDouble( numero );
				return true;
			}catch ( NumberFormatException e )
			{
				return false;
			}
	}
	
    /**
     * Verifica se uma String é uma expressão válida 
     *
     * @param      expressao  Expressão a ser analisada
     *
     * @return     true caso 'expressao' seja uma expressão válida, falso caso contrário
     */
    public boolean ehExpressao( String expressao )
    {
    		// caso seja linha em branco
            if(expressao.isEmpty())
            {
            	return false;
            }
            
            // resgata o operador
            String operador = getOperador( expressao );

            // verifica se é válido
            if( operador.equals("erro") )
            {
            	return false;
            } else 
            {
            	// divide a expressão com base no operador
            	String[] splitted_expressao = expressao.split( "\\"+operador );

            	// se dividir em mais ou menos de 2 operandos então não é uma expressão válida nesta calculadora
            	if( splitted_expressao.length != 2 )
            	{
            		return false;
            	}  // se forem 2 operandos, porém com qualquer um dos dois inválidos então não é uma expressão válida
				else if( !( ehNumero( splitted_expressao[0] ) && ehNumero( splitted_expressao[1] ) ) )
            	{
            		return false;
            	}
            	
            }

            // se possuir um operador e os operandos forem numeros, então 
            return true;
    }
	
    /**
	 * Soma dois números double
	 *
	 * @param      a     Primeiro número
	 * @param      b     Segundo número
	 *
	 * @return     Soma entre a e b
	 */
	private double soma( double a, double b )
	{
		return a+b;
	}

	/**
	 * Subtração de dois números double
	 *
	 * @param      a     Número do qual será subtraído o valor
	 * @param      b     Número subtraido de a
	 *
	 * @return     Subtração de b em a 
	 */
	private double subtracao( double a, double b )
	{
		return a-b;
	}

	/**
	 * Multiplica dois números souble
	 *
	 * @param      a     Primeiro número
	 * @param      b     Segundo número
	 *
	 * @return     Multiplicação entre a e b
	 */
	private double multiplicacao( double a, double b )
	{
		return a*b;
	}

	/**
	 * Divisão entre dois números double
	 *
	 * @param      a     Dividendo da divisão
	 * @param      b     Divisor da divisão
	 *
	 * @return     Divisão de a por b
	 */
	private double divisao( double a, double b )
	{
		// se b for 0 lança uma DivisaoPorZeroException, senão retorna o valor da divisão
		if( b == 0 )
		{
			throw new DivisaoPorZeroException( "Operacao invalida, divisao por zero" );
		} else 
		{
			return a/b;
		}
	}
}


