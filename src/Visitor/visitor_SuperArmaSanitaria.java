package Visitor;

import Entidades.Player;
import States.SuperArma_State;
import Temporizadores.TempPowerUpSA;

/**
 * Clase visitor_SuperArmaSanitaria. Implementacion del visitor del super arma sanitaria.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class visitor_SuperArmaSanitaria extends Visitor
{
	
	private int tdd; // Tiempo de duracion del power up
	
	
	//Constructor
	public visitor_SuperArmaSanitaria(int t) 
	{
		tdd = t;
	}
	
	/**
	 * Cambia el estado del arma sel jugador y setea el temporizador.
	 */
	public void visit(Player e) 
	{
		e.cambiarEstadoDeArma(new SuperArma_State());
		e.setTemp(new TempPowerUpSA(tdd,e));
	}
}
