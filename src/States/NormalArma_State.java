package States;

/**
 * Clase Normal_State. Implementacion del estado normal.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class NormalArma_State extends State_Arma {

	// Constructor
	public NormalArma_State() {
		da�oDeArma = 22;
	}

	/**
	 * Retorna el da�o
	 * 
	 * @return da�o
	 */
	public int getDa�o() {
		return da�oDeArma;
	}

}
