package festaBanheiro;

public class Banheiro {
	
	public void numero1()
	{	
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " Está batendo na porta...");
		
		synchronized (this) 
		{
			System.out.println(name+" Entrou agora...");
			System.out.println(name+" Tá mijando");
			try 
			{
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println(name+" Tá saindo");			
		}
	}
	
	public void numero2()
	{
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " Está batendo na porta...");
		
		synchronized (this) 
		{			
			System.out.println(name+" Entrou agora...");
			System.out.println(name+" Tá cagando");
			try 
			{
				Thread.sleep(10000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println(name+" Tá saindo");			
		}
	}
}
