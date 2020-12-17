package Entidades;

import javax.swing.JLabel;

import Juego.Pos;

public abstract class PowerUp extends Entidad{
	protected JLabel label;
	protected Pos pos;
	protected boolean borrar;
	protected int velocidadDeCaida; //en segs
	
}
