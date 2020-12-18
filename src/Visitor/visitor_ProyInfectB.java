package Visitor;

import Entidades.Player;


/**
 * Clase visitor_ProyInfectB Implementacion del visitor del pryectil infectado beta.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class visitor_ProyInfectB extends Visitor {
	private int da�o;

	// Constructor
	public visitor_ProyInfectB(int d) {
		da�o = d;
	}

	/**
	 * 
	 */
	public void visit(Player e) {
		e.recibirDa�o(da�o);
	}
}
