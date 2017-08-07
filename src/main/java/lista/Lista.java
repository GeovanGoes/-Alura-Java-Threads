package lista;

/***
 * 
 * @author root
 *
 */
public class Lista 
{
	
	private String [] elementos = new String [100];
	private int indice = 0 ;
	
	public synchronized void adicionaElemento(String elemento)
	{
		this.elementos[indice] = elemento;
		indice++;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(this.elementos.length == indice)
		{
			System.out.println("avisando a negada que a lista ta cheia...");
			this.notifyAll();
		}
	}
	
	public int tamanho ()
	{
		return this.elementos.length;
	}
	
	public String pegaElemento(int indice)
	{
		return this.elementos[indice];
	}

	public boolean estaCheia() {
		// TODO Auto-generated method stub
		return this.indice == tamanho();
	}

}
