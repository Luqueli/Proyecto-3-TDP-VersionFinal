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
	private int daño;

	// Constructor
	public visitor_ProyInfectB(int d) {
		daño = d;
	}

	/**
	 * 
	 */
	public void visit(Player e) {
		e.recibirDaño(daño);
	}
}
