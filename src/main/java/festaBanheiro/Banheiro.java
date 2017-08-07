package festaBanheiro;

public class Banheiro {
	
	private boolean ehSujo = true;
	
	public void numero1()
	{	
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " Está batendo na porta...");
		
		synchronized (this) 
		{
			System.out.println(name+" Entrou agora...");
			
			while(ehSujo)
			{
				esperaLaFora(name);
			}
			
			System.out.println(name+" Tô mijando");
			dormeUmPouco(5000);
			this.ehSujo = true;
			System.out.println(name+" Tô saindo");			
		}
	}

	private void dormeUmPouco(long millis) {
		try 
		{
			Thread.sleep(millis);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	private void esperaLaFora(String name) {
		System.out.println(name + " eca, banheiro ta sujo!");
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void numero2()
	{
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " Está batendo na porta...");
		
		synchronized (this) 
		{			
			System.out.println(name+" Entrou agora...");
			
			while(ehSujo)
			{
				esperaLaFora(name);
			}
			
			System.out.println(name+" Tô cagando");
			dormeUmPouco(10000);
			this.ehSujo = true;
			System.out.println(name+" Tô saindo");			
		}
	}
	
	public void limpa()
	{
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " Está batendo na porta...");
		
		synchronized (this) 
		{
			System.out.println(name+" Entrou agora...");
			
			if(ehSujo)
			{
				System.out.println("Limpando o banheiro");
				this.ehSujo = false;
				dormeUmPouco(13000);			
			}
			else
			{
				System.out.println(name + " não está sujo!");
			}
			
			this.notifyAll();
			
			System.out.println(name+" Tô saindo");			
		}
	}
}
