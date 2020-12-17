package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;
import Visitor.visitor_COPU;

public class CuarentenaObligatoria extends PowerUp{
	private int  tiempoDeDuracion;
	
	public CuarentenaObligatoria(Pos p) {
		pos=new Pos(p.getX(),p.getY());
		label=new JLabel(new ImageIcon(CuarentenaObligatoria.class.getResource("/GifsEImagenes/ImagenPUCO.png")));
		label.setBounds(pos.getX(),pos.getY(),23,23);
		hitBox=new Rectangle(pos.getX(),pos.getY(),label.getBounds().width,label.getBounds().height);
		borrar=false;
		velocidadDeCaida=4;
		tiempoDeDuracion=100; //1 seg=13 int
		visitor= new visitor_COPU(tiempoDeDuracion);
	}
	
	public void accionar(Logica l) {
		if(borrar || pos.getY()>=600) {
			l.agregarEntidadAE(this);
		}
		else {
			pos.actPosY(velocidadDeCaida);
			hitBox.setLocation(pos.getX(), pos.getY());
		}
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void accept(Visitor v ) {
		v.visit(this);
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public int getPosX() {
		return pos.getX();
	}
	
	public int getPosY() {
		return pos.getY();
	}
	
	public void eliminar() {
		borrar=true;
	}
	
	public Rectangle getHitBox() {
		return hitBox;
	}
}
