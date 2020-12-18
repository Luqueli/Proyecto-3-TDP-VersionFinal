package Visitor;


import Entidades.Player;
import Entidades.Proyectil_Player;


/**
 * Clase  visitor_InfectadoAlpha. Implementacion del visitor del infectado alpha.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class visitor_InfectadoAlpha extends Visitor {
	private int da�oCuerpoACuerpo;
	private boolean cooldown;

	// Constructor
	public visitor_InfectadoAlpha(int d) {
		da�oCuerpoACuerpo = d;
		cooldown = false;
	}

	/**
	 * Reciibe el da�o el infectado
	 */
	public void visit(Player e) {
		if (!cooldown) {
			e.recibirDa�o(da�oCuerpoACuerpo);
			cooldown = true;
		}
	}

	public void visit(Proyectil_Player e) {
		e.eliminar();
	}

	/**
	 * Setea el cooldown
	 */
	public void setCooldown(boolean b) {
		cooldown = b;
	}
}
