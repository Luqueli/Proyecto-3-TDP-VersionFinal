package States;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Entidades.Entidad;
import Factorys.Proyectil_Factory;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;

/**
 * Clase InfectAlphaVelozState. Implementacion del estado InfectAlphaVeloz.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class InfectAlphaVeloz_State extends State_Infectado {

	// Constructor
	public InfectAlphaVeloz_State() {
		velocidad = 6;
	}

	/**
	 * Retorna la velocidad
	 * 
	 * @return velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}

	public void accionar(Logica l, int reposoDeDisparo, Pos pos, Rectangle hitBox, Proyectil_Factory fabProy,
			JLabel label, int dañoProyVirus, Visitor visitor) {
		if (pos.getY() >= 600) {
			pos.actPosY(-pos.getY() - label.getBounds().height);
			hitBox.setLocation(pos.getX(), pos.getY());
			visitor.setCooldown(false);
		} else {
			pos.actPosY(velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
			if (reposoDeDisparo >= 40) {
				Entidad e = fabProy.crearProyectil_InfectadoA(
						new Pos(pos.getX() + label.getBounds().width / 2, pos.getY() + label.getBounds().height),
						dañoProyVirus);
				l.agregarEntidadAA(e);
			}
		}
	}

}
