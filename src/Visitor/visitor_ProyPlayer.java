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
	private int da�o;
	
	
	//Constructor
	public visitor_ProyPlayer(int d) 
	{
		da�o = d;
	}
	
	/**
	 * El infectado alpha recibe el da�o
	 */
	public void visit(Infectado_Alpha e)
	{
		e.recibirDa�o(da�o);	
	}

	/**
	 * El infectado beta recibe el da�o
	 */
	public void visit(Infectado_Beta e)
	{
		e.recibirDa�o(da�o);
	}
}
