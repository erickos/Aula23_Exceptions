 
import java.io.*;
import java.util.ArrayList;
import java.lang.*;


/**
 * Classe principal para execução
 * 
 * @author Erick de Oliveira Silva
 * @version 2017.10.18
 */
public class Main
{   
	public static void main(String[] args)
	{
			// coleção com os resultados, em forma de String, das operacoes
	    	ArrayList<String> resultados = new ArrayList<String>();
			// resgata o nome do arquivo
            String arquivo = args[0];
                
            try 
            {
            	// lê o arquivo
                BufferedReader leitor = new BufferedReader( new FileReader(arquivo) );
                
                // salva a primeira linha para começar a leitur
                String linha = leitor.readLine();
                // instacia uma nova calculadora para operar
                Calculadora calc = new Calculadora();

                // enquanto não chegar no final do arquivo
                while( linha != null )
                {
                	// tira os espaços em branco
                	linha.trim();
                	// verifica se a linha é uma expressao vaĺida
                	if( calc.ehExpressao(linha) )
                	{
                		try
                		{
                			// tenta realizar o calculo que pode ser uma divisão por 0.
                			String result = String.format( "%.2f", calc.calcular(linha) );
                			// caso consiga calcular, adiciona à colecao de 
                    		resultados.add( result );
                		} catch( DivisaoPorZeroException e )
                		{
                			// caso ocorra divisao por 0, entao não é possivel calcular
                			resultados.add( "não foi possivel calcular ");
                		}
                	} else 
                	{
                		// caso a expressão esteja fora do padrão
                		resultados.add( "não foi possivel calcular" );
                	}
                	
                	// após a analise e calculo, lê a próxima linha
                	linha = leitor.readLine();
                }

                // fecha o arquivo
                leitor.close();
            } catch ( FileNotFoundException e ) 
            {
                System.out.println(e.getMessage());
            } catch ( IOException e )
            {
            	System.out.println(e.getMessage());
            }
            
            // salvar a saida
            try
            {
            	// escreve as linhas no arquivo	
            	FileWriter escritor = new FileWriter("resultados.txt");
              	int i = 0; // contador

              	// contador lê da linha 0 à linha (n-1) da coleção
              	while( i < resultados.size() )
            	{
            		// escreve no arquivo
            		escritor.write(resultados.get(i)+"\n");
            		i++;
            	}
            	// fecha e salva
            	escritor.close();
            } catch (IOException e)
            {
            	System.out.println(e.getMessage());
            }
                
	}
}