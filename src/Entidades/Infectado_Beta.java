package Entidades;

import java.awt.Rectangle;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factorys.PowerUP_Factory;
import Factorys.Proyectil_Factory;
import Juego.GUI;
import Juego.Logica;
import Juego.Pos;
import States.NormalInfectB_State;
import States.State_Infectado;
import Visitor.Visitor;
import Visitor.visitor_InfectadoBeta;

public class Infectado_Beta extends Infectado {
	
	public Infectado_Beta(){
		state=new NormalInfectB_State();
		carga_viral=110;
		dañoCAC=19;
		dañoProyVirus=12;
		velocidad=1;
		pos=new Pos((int) Math.floor(Math.random()*(745-1)+1),(int) Math.floor(Math.random()*(86-1)+1));
		label = new JLabel(new ImageIcon(GUI.class.getResource("/GifsEImagenes/ZCaminataB.gif")));
		label.setBounds(pos.getX(), pos.getY(), 56, 86);
		hitBox= new Rectangle(pos.getX(),pos.getY(),label.getBounds().width,label.getBounds().height);
		reposoDeDisparo=0;
		visitor=new visitor_InfectadoBeta(dañoCAC);
		//el tiempo que espera para volver a disparar podria ser random propio de cada objeto con un atributo
	}
	
	public void  accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void recibirDaño(int d) {
		carga_viral=carga_viral-d;
	}

	public JLabel getLabel() {
		return label;
	}
	
	public void accionar(Logica l) {
		reposoDeDisparo++;
		if(this.carga_viral<=0) {
			Entidad nuevo_PU = super.sueltaEntidad(this.pos);
			if(nuevo_PU!=null) {
				l.agregarEntidadAA(nuevo_PU);
			}
			l.agregarEntidadAE(this);
		}
		else {
			state.accionar(l, reposoDeDisparo, pos, hitBox, fabProy, label, dañoProyVirus,visitor);
			if(reposoDeDisparo>=35) {//equivalente a decir If(disparo){...}
				reposoDeDisparo=0;
			}
		}
	}

	public int getPosX() {
		return pos.getX();
	}

	public int getPosY() {
		return pos.getY();
	}

	public Rectangle getHitBox() {
		return hitBox;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setState(State_Infectado si) {
		state=si;
	}

	public void setDefaultState() {
		state=new NormalInfectB_State();
	}
}
