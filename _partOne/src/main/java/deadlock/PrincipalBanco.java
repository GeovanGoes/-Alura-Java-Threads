package deadlock;

public class PrincipalBanco {

    public static void main(String[] args) {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        /***
         * Acesso ao banco
         */
        new Thread(() -> {
        	synchronized (tx) 
        	{
        		System.out.println("comecanco a gerenciar a tx");
        		tx.begin();
        		synchronized (pool) 
        		{
        			System.out.println("peguei a chave do pool");
        			pool.getConnection();
        			
        		}
        	}
        }, "acesso ao banco").start();
        
        
        /***
         * Procedures
         */
        new Thread(() -> {
        	synchronized (tx) 
        	{
				System.out.println("peguei a chave a tx");
				tx.begin();
				
				synchronized (pool) 
				{
					System.out.println("comecanco o pool");
					pool.getConnection();
				}
			}
        }, "procedure").start();
        
    }
}