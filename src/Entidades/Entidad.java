package Entidades;

import java.awt.Rectangle;

import javax.swing.JLabel;
import Juego.Pos;
import Juego.Logica;
import States.State_Infectado;
import Visitor.Visitor;
/**
 * Clase abstracta Entidad
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public abstract class Entidad {

	protected Rectangle hitBox;
	protected Visitor visitor;
	protected JLabel label;
	protected Pos pos;
	protected int velocidad;

	/**
	 * Setea el estado
	 * 
	 * @param estado
	 */
	public void setState(State_Infectado estado) {
	}

	/**
	 * Setea el estado como estadoDefault
	 */
	public void setDefaultState() {
	}

	/**
	 * Renotorna nulo
	 * 
	 * @return null
	 */

	public Visitor getVisitor() {
		return null;
	}

	/**
	 * La entidad se reporta con el visitor pasado por parametro
	 * 
	 * @param v visitor
	 */
	public void accept(Visitor v) {
	}

	/**
	 * Retorna nulo
	 * 
	 * @return null
	 */
	public Rectangle getHitBox() {
		return null;
	}

	public void accionar(Logica l) {
	};

	/**
	 * Retorna nulo
	 * 
	 * @return null
	 */
	public JLabel getLabel() {
		return null;
	}

	/**
	 * Retorna cero
	 * 
	 * @return 0
	 */
	public int getPosX() {
		return 0;
	}

	/**
	 * Retorna cero
	 * 
	 * @return 0
	 */
	public int getPosY() {
		return 0;
	}
}
