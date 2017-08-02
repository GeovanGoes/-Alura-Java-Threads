package buscanomes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Principal 
{
	public static void main(String[] args) 
	{
		String nome = "da";
		Thread assinaturas1 = new Thread(() -> {			
			try 
			{
				
				String nomeArquivo = "assinaturas1.txt";
				Scanner scanner = new Scanner(new File(nomeArquivo));
				
				int linha = 1 ;
				
				while (scanner.hasNextLine()) 
				{
					String nextLine = scanner.nextLine();

					if(nextLine.toUpperCase().contains(nome.toUpperCase()))
					{
						System.out.println(nomeArquivo + " - " + linha + " - " +  nextLine);
					}
					linha++;
				}
			} 
			catch (FileNotFoundException e) 
			{
				throw new RuntimeException(e);
			}			
		}, "assinaturas1");
		
		
		Thread assinaturas2 = new Thread(() -> {
			try 
			{
				
				String nomeArquivo = "assinaturas2.txt";
				Scanner scanner = new Scanner(new File(nomeArquivo));
				
				int linha = 1 ;
				
				while (scanner.hasNextLine()) 
				{
					String nextLine = scanner.nextLine();
					
					if(nextLine.toUpperCase().contains(nome.toUpperCase()))
					{
						System.out.println(nomeArquivo + " - " + linha + " - " +  nextLine);
					}
					linha++;
				}
			} 
			catch (FileNotFoundException e) 
			{
				throw new RuntimeException(e);
			}			
		}, "assinaturas2");
		
		
		Thread autores = new Thread(() -> {			
			try 
			{
				
				String nomeArquivo = "autores.txt";
				Scanner scanner = new Scanner(new File(nomeArquivo));
				
				int linha = 1 ;
				
				while (scanner.hasNextLine()) 
				{
					String nextLine = scanner.nextLine();
					
					if(nextLine.toUpperCase().contains(nome.toUpperCase()))
					{
						System.out.println(nomeArquivo + " - " + linha + " - " +  nextLine);
					}
					linha++;
				}
			} 
			catch (FileNotFoundException e) 
			{
				throw new RuntimeException(e);
			}			
		}, "autores");
		
		assinaturas1.start();
		autores.start();
		assinaturas2.start();
	}
}
