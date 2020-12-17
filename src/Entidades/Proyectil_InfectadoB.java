package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.GUI;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;
import Visitor.visitor_ProyInfectB;

public class Proyectil_InfectadoB extends Proyectil{
	private int posYDeInicio;
	private int rangoDeAlcance;
	
	public Proyectil_InfectadoB(Pos p, int d){
		pos=p;
		daño=d;
		label=new JLabel(new ImageIcon(Proyectil_InfectadoB.class.getResource("/GifsEImagenes/Proyectil_InfectadoB.gif")));
		label.setBounds(p.getX(), p.getY() , 16, 32);
		hitBox=new Rectangle(p.getX(),p.getY(),label.getBounds().width,label.getBounds().height);
		posYDeInicio=pos.getY();
		rangoDeAlcance=220;
		velocidad=10;
		borrar= false;
		visitor=new visitor_ProyInfectB(daño);
	}
	
	public int getPosX() {
		return pos.getX();
	}

	public int getPosY() {
		return pos.getY();
	}

	
	public void accionar(Logica l) {
		if(borrar || pos.getY()>=600 || pos.getY()-posYDeInicio>=rangoDeAlcance) {
			l.agregarEntidadAE(this);
		}
		else {
			pos.actPosY(velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
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
