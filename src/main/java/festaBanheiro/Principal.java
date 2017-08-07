package festaBanheiro;


public class Principal 
{
	public static void main(String[] args) 
	{
		
		Banheiro banheiro = new Banheiro();
		
		convidado2(banheiro);
		convidado1(banheiro);
		convidado4(banheiro);
		limpeza(banheiro);
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
	
	public static void limpeza(Banheiro banheiro)
	{
		Thread limpe = new Thread(() -> 
		{
			while(true)
			{
				banheiro.limpa();
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Tia da Limpeza");
		limpe.setDaemon(true);
		limpe.setPriority(Thread.MAX_PRIORITY);
		limpe.start();
	}
	
	public static void convidado4(Banheiro banheiro)
	{
		new Thread(() -> 
		{			
			banheiro.numero1();
		}, "Maria").start();
	}
}
