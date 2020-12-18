package States;

/**
 * Clase Normal_State. Implementacion del estado normal.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class Normal_State extends State_Arma
{

	//Constructor
	public Normal_State() 
	{
		dañoDeArma = 22;
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
