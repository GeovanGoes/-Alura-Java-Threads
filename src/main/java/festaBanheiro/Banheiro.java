package festaBanheiro;

public class Banheiro {
	
	public void numero1()
	{	
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " Est� batendo na porta...");
		
		synchronized (this) 
		{
			System.out.println(name+" Entrou agora...");
			System.out.println(name+" T� mijando");
			try 
			{
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println(name+" T� saindo");			
		}
	}
	
	public void numero2()
	{
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " Est� batendo na porta...");
		
		synchronized (this) 
		{			
			System.out.println(name+" Entrou agora...");
			System.out.println(name+" T� cagando");
			try 
			{
				Thread.sleep(10000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println(name+" T� saindo");			
		}
	}
}
