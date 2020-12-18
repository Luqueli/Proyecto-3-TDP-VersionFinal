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
	 * Retorna el daño generado
	 * 
	 * @return daño generado
	 */
	public int getDaño() {
		return state.getDaño();
	}

	/**
	 * Cambia de estado Normal_State normal a State_Arma
	 */
	public void cambiarEstado(State_Arma sa) {
		state = sa;
	}

}
