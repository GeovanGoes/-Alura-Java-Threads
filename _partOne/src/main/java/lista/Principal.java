package lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {
	public static void main(String[] args) throws InterruptedException {
		
		
		 Lista lista = new Lista();
		 for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				String name = Thread.currentThread().getName();
				for (int j = 0; j < 10; j++) {
					lista.adicionaElemento("Thread "+ name + " inserindo" + j);
				}
			}, String.valueOf(i)).start();
		}
		
		new Thread(new Runnable() 
		{	
			@Override
			public void run() 
			{				
				synchronized (lista) 
				{
					if (!lista.estaCheia())
					{	
						try 
						{
							System.out.println("Agurdando a lista ficar cheia.");
							lista.wait();
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					for (int i = 0; i < lista.tamanho(); i++) 
					{
						System.out.println( i+" - "+lista.pegaElemento(i));
					}	
				}	
			}
		}).start();
		
		//List<String> lista = Collections.synchronizedList(new ArrayList<String>());
		
	/*	List<String> lista = new Vector();
		
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				String name = Thread.currentThread().getName();
				for (int j = 0; j < 100; j++) {
					lista.add("Thread "+ name + " inserindo" + j);
				}
			}, String.valueOf(i)).start();
		}
		
		for (int i = 0; i < lista.size(); i++) 
		{
			System.out.println(lista.get(i));
		}*/
		
		
	}
}
