package Temporizadores;

import Juego.Logica;

/**
 * Clase TempPowerUpCO. Implementacion del temporizador PowerUpCO.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class TempPowerUpCO extends Temporizador
{
	private boolean activado;
	
	
	//Constructor
	public TempPowerUpCO(int tl) 
	{
		tiempoLimite = tl;
		activado = false;
	}

	/**
	 * Actualiza el contador y el estado de los infectados
	 */
	public void actualizar(Logica l) 
	{
		contador++;
		if (!activado)
		{
			l.ParalizarInfectados();
			activado = true;
		}
		if (contador >= tiempoLimite) 
		{
			l.DesparalizarInfectados();
			l.getPlayer().setTemp(null);
		}
	}
}
