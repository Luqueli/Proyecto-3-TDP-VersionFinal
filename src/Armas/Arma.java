package Armas;

import States.State_Arma;

public abstract class Arma {
	protected int da�o;
	protected State_Arma state;
	
	public abstract void cambiarEstado(State_Arma sa);
	public abstract int getDa�o();
}
