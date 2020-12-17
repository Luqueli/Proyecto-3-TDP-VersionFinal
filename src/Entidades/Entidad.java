package Entidades;

import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JLabel;

import Juego.Logica;
import States.State_Infectado;
import Visitor.Visitor;

public abstract class Entidad {
	protected Rectangle hitBox;
	protected Visitor visitor;
	protected JLabel label;
	
	public void setState(State_Infectado estado) {}
	
	public void setDefaultState() {}
	
	public Visitor getVisitor() {
		return null;
	}
	public void accept(Visitor v) {}
	public Rectangle getHitBox() {
		return null;
	}
	public void accionar(Logica l) {};
	
	public JLabel getLabel() {
		return null;
	}
	public  int getPosX() {
		return 0;
	}
	public int getPosY() {
		return 0;
	}
}
