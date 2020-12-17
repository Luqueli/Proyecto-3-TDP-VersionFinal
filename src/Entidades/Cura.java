package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;
import Visitor.visitor_CuraPU;

public class Cura extends PowerUp {
	private int cantDeCura;
	
	public Cura(Pos p) {
		cantDeCura=20;
		pos=new Pos (p.getX(),p.getY());
		label=new JLabel(new ImageIcon(Cura.class.getResource("/GifsEImagenes/ImagenPUCura.png")));
		label.setBounds(pos.getX(),pos.getY(),23,23);
		hitBox=new Rectangle(pos.getX(),pos.getY(),label.getBounds().width,label.getBounds().height);
		borrar=false;
		velocidadDeCaida=4;
		visitor= new visitor_CuraPU(cantDeCura);
	}
	
	public Visitor getVisitor() {
		return visitor;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Rectangle getHitBox() {
		return hitBox;
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

}
