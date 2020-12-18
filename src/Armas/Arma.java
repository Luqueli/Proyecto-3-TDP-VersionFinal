package Armas;

import States.State_Arma;

/**
 * Clase abstracta Arma
 * Implementacion del arma.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 */
public abstract class Arma {
	protected int daño;
	protected State_Arma state;

	public abstract void cambiarEstado(State_Arma sa);

	public abstract int getDaño();
}
