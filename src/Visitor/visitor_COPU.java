package Visitor;

import Entidades.Player;
import Temporizadores.TempPowerUpCO;

/**
 * Clase visitor_COPU. Implementacion del visitor de cuarentena obligatoria.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class visitor_COPU extends Visitor
{
	private int tiempoDeDuracion;
	
	
	//Construtor
	public visitor_COPU(int td) 
	{
		tiempoDeDuracion=td;
	}
	
	/**
	 * Setea el temporizador de la cuarentena obligatoria.
	 */
	public void visit(Player e) {
		e.setTemp(new TempPowerUpCO(tiempoDeDuracion));
	}
}
