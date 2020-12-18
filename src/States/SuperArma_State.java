package States;

/**
 * Clase SuperArma_State. Implementacion del estado super arma.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class SuperArma_State extends State_Arma 
{
	
	//Constructor
	public SuperArma_State()
	{
		dañoDeArma = 29;
	}
		
	/**
	 * Retorna el daño
	 * @return daño
	 */
	public int getDaño() 
	{
		return dañoDeArma;
	}
	
}
