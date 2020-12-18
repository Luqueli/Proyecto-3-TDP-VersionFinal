package Visitor;

import Entidades.Player;
import Entidades.Proyectil_Player;

/**
 * Clase visitor_InfectadoBeta. Implementacion del visitor del infectado beta.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class visitor_InfectadoBeta extends Visitor
{
	private int dañoCuerpoACuerpo;
	private boolean cooldown;
	
	
	//Constructor
	public visitor_InfectadoBeta(int d) 
	{
		dañoCuerpoACuerpo = d;
		cooldown = false;
	}
	
	/**
	 * Recibe el daño el infectado beta
	 */
	public void visit(Player e) 
	{
		if(!cooldown) 
		{
			e.recibirDaño(dañoCuerpoACuerpo);
			cooldown=true;
		}
	}

	public void visit(Proyectil_Player e)
	{
		e.eliminar();
	}
	
	/**
	 * Setea el cooldown
	 */
	public void setCooldown(boolean b) 
	{
		cooldown=b;
	}
}
