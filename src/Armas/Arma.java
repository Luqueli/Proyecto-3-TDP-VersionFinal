package Armas;

import States.State_Arma;

public abstract class Arma {
	protected int daño;
	protected State_Arma state;
	
	public abstract void cambiarEstado(State_Arma sa);
	public abstract int getDaño();
}
