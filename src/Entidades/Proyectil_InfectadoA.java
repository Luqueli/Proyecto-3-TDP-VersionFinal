package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;
import Visitor.visitor_ProyInfectA;

/**
 * Clase Proyectil_InfectadoA. Implementacion del proyectil de un infectado alpha.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class Proyectil_InfectadoA extends Proyectil {

	// Constructor
	public Proyectil_InfectadoA(Pos p, int d) {
		pos = p;
		daño = d;
		label = new JLabel(new ImageIcon(Proyectil_InfectadoA.class.getResource("/GifsEImagenes/Proyectil_InfectadoA.gif")));
		label.setBounds(p.getX(), p.getY(), 16, 32);
		hitBox = new Rectangle(p.getX(), p.getY(), label.getBounds().width, label.getBounds().height);
		posYDeInicio = pos.getY();
		rangoDeAlcance = 180;
		velocidad = 8;
		borrar = false;
		visitor = new visitor_ProyInfectA(daño);
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

	public void accionar(Logica l) {
		if (borrar || pos.getY() >= 600 || pos.getY() - posYDeInicio >= rangoDeAlcance) {
			l.agregarEntidadAE(this);
		} else {
			pos.actPosY(velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
		}
	}

	/**
	 * Retorna el label
	 * 
	 * @return label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * Retorna el hitBox
	 * 
	 * @return hitBox
	 */
	public Rectangle getHitBox() {
		return hitBox;
	}

	/**
	 * La entidad se reporta con su visitor parametrizado
	 */
	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	 * Retorna el visitor
	 * 
	 * @return visitor
	 */
	public Visitor getVisitor() {
		return visitor;
	}

	public void eliminar() {
		borrar = true;
	}
}
