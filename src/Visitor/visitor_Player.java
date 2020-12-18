package Visitor;

import Entidades.CuarentenaObligatoria;
import Entidades.Cura;
import Entidades.Proyectil_InfectadoA;
import Entidades.Proyectil_InfectadoB;
import Entidades.SuperArmaSanitariaPU;

/**
 * Clase visitor_Player. Implementacion del jugador.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class visitor_Player extends Visitor 
{
	
	//Constructor
	public visitor_Player() 
	{
		//Nada
	}
	
	public void visit(Proyectil_InfectadoA e) {
		e.eliminar();
	}

	public void visit(Proyectil_InfectadoB e) {
		e.eliminar();
	}

	public void visit(Cura e) {
		e.eliminar();
	}

	public void visit(SuperArmaSanitariaPU e) {
		e.eliminar();
	}

	public void visit(CuarentenaObligatoria e) {
		e.eliminar();	
	}

	
}
