package Entidades;

import javax.swing.JLabel;

import Juego.Pos;

public abstract class Proyectil extends Entidad{
	protected Pos pos;
	protected int velocidad=15;
	protected JLabel label;
	protected int daño;
	protected boolean borrar;
}
