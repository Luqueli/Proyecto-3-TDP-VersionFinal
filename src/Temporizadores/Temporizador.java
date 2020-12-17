package Temporizadores;

import Juego.Logica;

public abstract class Temporizador {
	protected int contador=0;
	protected int tiempoLimite;
	
	public abstract void actualizar(Logica l);
}
