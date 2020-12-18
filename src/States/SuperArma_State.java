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
		da�oDeArma = 29;
	}
		
	/**
	 * Retorna el da�o
	 * @return da�o
	 */
	public int getDa�o() 
	{
		return da�oDeArma;
	}
	
}
