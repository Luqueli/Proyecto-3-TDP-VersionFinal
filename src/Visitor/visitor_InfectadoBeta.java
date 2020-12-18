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
	private int da�oCuerpoACuerpo;
	private boolean cooldown;
	
	
	//Constructor
	public visitor_InfectadoBeta(int d) 
	{
		da�oCuerpoACuerpo = d;
		cooldown = false;
	}
	
	/**
	 * Recibe el da�o el infectado beta
	 */
	public void visit(Player e) 
	{
		if(!cooldown) 
		{
			e.recibirDa�o(da�oCuerpoACuerpo);
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
