package Temporizadores;

import Juego.Logica;

/**
 * Clase abstracta Temporizador. 
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public abstract class Temporizador {
	protected int contador = 0;
	protected int tiempoLimite;

	public abstract void actualizar(Logica l);
}
