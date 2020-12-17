package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.GUI;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;
import Visitor.visitor_Player;
import Visitor.visitor_ProyPlayer;

public class Proyectil_Player extends Proyectil {
	
	public Proyectil_Player(Pos p, int d) {
		pos=p;
		daño=d;
		label=new JLabel(new ImageIcon(GUI.class.getResource("/GifsEImagenes/Proyectil_Player.gif")));
		label.setBounds(pos.getX(), pos.getY(), 6, 34);
		velocidad=15;
		hitBox=new Rectangle(p.getX(),p.getY(),label.getBounds().width,label.getBounds().height);
		borrar=false;
		visitor=new visitor_ProyPlayer(daño);
	}


	public int getPosX() {
		return pos.getX();
	}

	
	public int getPosY() {
		return pos.getY();
	}

	public void accionar(Logica l) {
		if(borrar || pos.getY()<=0-label.getBounds().height) {
			l.agregarEntidadAE(this);
		}
		else {
			pos.actPosY(-velocidad);
			hitBox.setLocation(pos.getX(),pos.getY());
		}
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public Rectangle getHitBox() {
		return hitBox;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void eliminar() {
		borrar=true;
	}
}
