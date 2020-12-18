package Entidades;

import javax.swing.JLabel;


/**
 * Clase abstracta Proyectil.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public abstract class Proyectil extends Entidad {
	protected int da�o;
	protected boolean borrar;
	protected int posYDeInicio;
	protected int rangoDeAlcance;
}
