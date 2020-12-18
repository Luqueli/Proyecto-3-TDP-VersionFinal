package Temporizadores;

import Entidades.Player;
import Juego.Logica;
import States.Normal_State;

/**
 * Clase TempPowerUpSA. Implementacion del temporizador PowerUpSA.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class TempPowerUpSA extends Temporizador
{
	private Player p;
	
	
	//Constructor
	public TempPowerUpSA(int tl, Player e) 
	{
		tiempoLimite = tl;
		p = e;
	}

	/**
	 * Actualiza el contador y el estado del jugador
	 */
	public void actualizar(Logica l) 
	{
		contador++;
		if (contador >= tiempoLimite) 
		{
			p.cambiarEstadoDeArma(new Normal_State());
			p.setTemp(null);
		}
	}
}
