package States;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Factorys.Proyectil_Factory;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;

/**
 * Clase abstracta State_Infectado.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public abstract class State_Infectado {
	protected int velocidad;

	public abstract void accionar(Logica l, int rd, Pos pos, Rectangle hitBox, Proyectil_Factory pf, JLabel label,
			int dañoProyVirus, Visitor visitor);
}
