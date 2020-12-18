package Entidades;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Juego.GUI;
import Juego.Logica;
import Juego.Pos;
import States.InfectAlphaVeloz_State;
import States.NormalInfectA_State;
import States.State_Infectado;
import Visitor.Visitor;
import Visitor.visitor_InfectadoAlpha;

/**
 * Clase Infectado_Alpha. Implementacion de un infectado Alpha.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class Infectado_Alpha extends Infectado {

	// Constructor
	public Infectado_Alpha() {
		state = new NormalInfectA_State();
		dañoCAC = 23;
		dañoProyVirus = 15;
		carga_viral = 80;
		pos = new Pos((int) Math.floor(Math.random() * (700 - 1) + 1), 0);
		label = new JLabel(new ImageIcon(GUI.class.getResource("/GifsEImagenes/ZCaminataA.gif")));
		label.setBounds(pos.getX(), pos.getY(), 56, 86);
		hitBox = new Rectangle(pos.getX(), pos.getY(), label.getBounds().width, label.getBounds().height);
		reposoDeDisparo = 0;
		visitor = new visitor_InfectadoAlpha(dañoCAC);
	}

	/**
	 * La entidad se reporta con su visitor parametrizado.
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Recibe el daño decrementando la carga viral
	 * 
	 * @param d daño
	 */
	public void recibirDaño(int d) {
		carga_viral = carga_viral - d;
	}

	/**
	 * Retorna el label
	 */
	public JLabel getLabel() {
		return label;
	}

	public void accionar(Logica l) {
		reposoDeDisparo++;
		if (carga_viral <= 20) {
			state = new InfectAlphaVeloz_State();
		}

		if (this.carga_viral <= 0) {
			Entidad nuevo_PU = super.sueltaEntidad(this.pos);
			if (nuevo_PU != null) {
				l.agregarEntidadAA(nuevo_PU);
			}
			l.agregarEntidadAE(this);
		} else {
			state.accionar(l, reposoDeDisparo, pos, hitBox, fabProy, label, dañoProyVirus, visitor);
			if (reposoDeDisparo >= 40) {
				reposoDeDisparo = 0;
			}
		}
	}

	/**
	 * Retorna la posicion del label en el eje x
	 * 
	 * @return posicion del label en el eje x
	 */
	public int getPosX() {
		return pos.getX();
	}

	/**
	 * Retorna la posicion del label en el eje y
	 * 
	 * @return posicion del label en el eje y
	 */
	public int getPosY() {
		return pos.getY();
	}

	/**
	 * Retorna el hitbox
	 * 
	 * @return hitBox
	 */
	public Rectangle getHitBox() {
		return hitBox;
	}

	/**
	 * Retorna el visitor
	 * 
	 * @return visitor
	 */
	public Visitor getVisitor() {
		return visitor;
	}

	/**
	 * Setea el estado a State_Infectado
	 */
	public void setState(State_Infectado si) {
		state = si;
	}

	/**
	 * Setea el estado a estado normal.
	 */
	public void setDefaultState() {
		state = new NormalInfectA_State();
	}

}
