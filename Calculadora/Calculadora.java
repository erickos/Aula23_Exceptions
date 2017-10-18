import java.io.*;
import java.util.ArrayList;
import java.lang.NumberFormatException;


/**
 * Class for calculadora.
 */
public class Calculadora
{
	private String[] operators = new String[] {"-","+","/","*"};
	

	public double calcular( String expressao )
	{
		String operacao = getOperador(expressao);
		String[] splitted_expressao;
		double op1 = 0;
		double op2 = 0;
		
		if( ehExpressao( expressao ) )
		{
			if( operacao.equals("+") )
			{
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

			} else if( operacao.equals("*"))
			{  		   
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

		return Double.MAX_VALUE;
	}
	
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
	
	private boolean ehNumero( String numero )
	{
			// tenta converter, se levantar exceção então não é numero
			try
			{
				double operando = Double.parseDouble(numero);
				return true;
			}catch (NumberFormatException e)
			{
				return false;
			}
	}
	
    public boolean ehExpressao( String expressao )
    {
    		// caso seja linha em branco
            if(expressao.isEmpty())
            {
            	return false;
            }
            
            String operador = getOperador(expressao);

            if( operador.equals("erro") )
            {
            	return false;
            } else 
            {
            	String[] splitted_expressao = expressao.split( "\\"+operador );
            	if( splitted_expressao.length != 2 )
            	{
            		return false;
            	} else if( !( ehNumero( splitted_expressao[0] ) && ehNumero( splitted_expressao[1] ) ) )
            	{
            		return false;
            	}
            	
            }

            // se possuir um operador e os operandos forem numeros, então 
            return true;
    }
	
    /**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	private double soma( double a, double b )
	{
		return a+b;
	}

	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	private double subtracao( double a, double b )
	{
		return a-b;
	}

	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	private double multiplicacao( double a, double b )
	{
		return a*b;
	}

	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	private double divisao( double a, double b )
	{
		if( b == 0 )
		{
			throw new DivisaoPorZeroException( "Operacao invalida, divisao por zero" );
		} else 
		{
			return a/b;
		}
	}
}


