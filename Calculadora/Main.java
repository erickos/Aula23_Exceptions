 
import java.io.*;
import java.util.ArrayList;
import java.lang.*;


public class Main
{   
	public static void main(String[] args)
	{
	    	ArrayList<String> resultados = new ArrayList<String>();
			// resgata o nome do arquivo
            String arquivo = args[0];
                
            try 
            {
                BufferedReader leitor = new BufferedReader( new FileReader(arquivo) );
                
                String linha = leitor.readLine();
                Calculadora calc = new Calculadora();

                while( linha != null )
                {
                	linha.trim();
                	if( calc.ehExpressao(linha) )
                	{
                		try
                		{
                			String result = Double.toString( calc.calcular(linha) );
                    		resultados.add(linha + " = " + result);
                    		System.out.println(result);
                		} catch( DivisaoPorZeroException e )
                		{
                			System.out.println(e.getMessage());
                		}
                	} else 
                	{
                		resultados.add( linha + " = não foi possivel calcular" );
                	}
                	
                	linha = leitor.readLine();
                }
                leitor.close();
            } catch (FileNotFoundException e) 
            {
                System.out.println(e.getMessage());
            } catch (IOException e)
            {
            	System.out.println(e.getMessage());
            }
            
            // salvar a saida
            try
            {
            	// escreve as linhas no arquivo	
            	FileWriter escritor = new FileWriter("resultados.txt");
              	int i = 0;

              	while( i < resultados.size() )
            	{
            		escritor.write(resultados.get(i));
            		i++;
            	}
            } catch (IOException e)
            {
            	System.out.println(e.getMessage());
            }
                
	}
}