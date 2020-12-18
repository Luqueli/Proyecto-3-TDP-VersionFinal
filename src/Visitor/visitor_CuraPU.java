package Visitor;

import Entidades.Player;

/**
 * Clase visitor_CuraPU. Implementacion del visitor de cura.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class visitor_CuraPU extends Visitor
{
	
	private int cura;
	
	
	//Constructor
	public visitor_CuraPU(int c) 
	{
		cura = c;
	}
	
	/**
	 * El curador recibe la cura
	 */
	public void visit(Player e) 
	{
		e.recibirCura(cura);
	}
}
