package Entidades;

import java.awt.Rectangle;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factorys.Proyectil_Factory;
import Juego.GUI;
import Juego.Logica;
import Juego.Pos;
import States.InfectAlphaVeloz_State;
import States.NormalInfectA_State;
import States.State_Infectado;
import Visitor.Visitor;
import Visitor.visitor_InfectadoAlpha;

public class Infectado_Alpha extends Infectado{
	
	
	public Infectado_Alpha() {
		state= new NormalInfectA_State();
		dañoCAC=23;
		dañoProyVirus=15;
		carga_viral= 66;
		pos=new Pos((int) Math.floor(Math.random()*(700-1)+1),0); 
		label = new JLabel(new ImageIcon(GUI.class.getResource("/GifsEImagenes/ZCaminataA.gif")));
		label.setBounds(pos.getX(),pos.getY(),56,86);
		hitBox= new Rectangle(pos.getX(),pos.getY(),label.getBounds().width,label.getBounds().height);
		reposoDeDisparo=0;
		visitor=new visitor_InfectadoAlpha(dañoCAC);
		//el tiempo que espera para volver a disparar podria ser random propio de cada objeto con un atributo
	}
	
	public void accept(Visitor visitor) {
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
		if(carga_viral<=20) {
			state= new InfectAlphaVeloz_State();
		}
		if(this.carga_viral<=0) {
			Entidad nuevo_PU = super.sueltaEntidad(this.pos);
			if(nuevo_PU!=null) {
				l.agregarEntidadAA(nuevo_PU);
			}
			l.agregarEntidadAE(this);
		}
		else {
			state.accionar(l, reposoDeDisparo,pos,hitBox,fabProy,label,dañoProyVirus,visitor);
			if(reposoDeDisparo>=40) {
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
		state=new NormalInfectA_State();
	}

	
}
