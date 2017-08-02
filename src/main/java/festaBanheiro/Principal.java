package festaBanheiro;


public class Principal 
{
	public static void main(String[] args) 
	{
		
		Banheiro banheiro = new Banheiro();
		
		convidado2(banheiro);
		convidado1(banheiro);
		convidado4(banheiro);
		convidado3(banheiro);
	}
	
	
	public static void convidado1(Banheiro banheiro)
	{
		new Thread(() -> 
		{			
			banheiro.numero1();
		}, "João").start();
	}
	
	public static void convidado2(Banheiro banheiro)
	{
		new Thread(() -> 
		{			
			banheiro.numero2();
		}, "Pedro").start();
	}
	
	public static void convidado3(Banheiro banheiro)
	{
		new Thread(() -> 
		{			
			banheiro.numero2();
		}, "Ana").start();
	}
	
	public static void convidado4(Banheiro banheiro)
	{
		new Thread(() -> 
		{			
			banheiro.numero1();
		}, "Maria").start();
	}
}
