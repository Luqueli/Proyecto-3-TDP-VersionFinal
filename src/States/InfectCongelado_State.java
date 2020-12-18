package States;

import java.awt.Rectangle;

import javax.swing.JLabel;
import Factorys.Proyectil_Factory;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;

/**
 * Clase InfectCongelado_State. Implementacion del estado InfectCongelado.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class InfectCongelado_State extends State_Infectado {

	public void accionar(Logica l, int rd, Pos pos, Rectangle hitBox, Proyectil_Factory pf, JLabel label,
			int dañoProyVirus, Visitor visitor) {
		// Vacio ya que el al estar el infectado congelado no hace nada
	}
}

