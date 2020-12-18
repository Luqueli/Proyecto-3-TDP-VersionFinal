package Visitor;

import Entidades.Infectado_Alpha;
import Entidades.Infectado_Beta;
/**
 * Clase visitor_ProyPlayer Implementacion del visitor del proyectil del jugador.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class visitor_ProyPlayer extends Visitor
{
	private int daño;
	
	
	//Constructor
	public visitor_ProyPlayer(int d) 
	{
		daño = d;
	}
	
	/**
	 * El infectado alpha recibe el daño
	 */
	public void visit(Infectado_Alpha e)
	{
		e.recibirDaño(daño);	
	}

	/**
	 * El infectado beta recibe el daño
	 */
	public void visit(Infectado_Beta e)
	{
		e.recibirDaño(daño);
	}
}
