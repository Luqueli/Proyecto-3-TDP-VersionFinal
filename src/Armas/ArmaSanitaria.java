package Armas;

import States.NormalArma_State;
import States.State_Arma;
/**
 * Clase ArmaSanitaria
 * Implementacion del arma sanitaria.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class ArmaSanitaria extends Arma {

	// Constructor
	/**
	 * Inicia su estado normal.
	 */
	public ArmaSanitaria() {
		state = new NormalArma_State();
	}

	/**
	 * Retorna el da�o generado
	 * 
	 * @return da�o generado
	 */
	public int getDa�o() {
		return state.getDa�o();
	}

	/**
	 * Cambia de estado Normal_State normal a State_Arma
	 */
	public void cambiarEstado(State_Arma sa) {
		state = sa;
	}

}
