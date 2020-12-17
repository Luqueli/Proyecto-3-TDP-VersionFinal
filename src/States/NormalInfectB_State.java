package States;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Entidades.Entidad;
import Entidades.Infectado_Beta;
import Factorys.Proyectil_Factory;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;

public class NormalInfectB_State extends State_Infectado{

	private int velocidad;
	
	public NormalInfectB_State(){
		velocidad=2;
	}
	
	public void accionar(Logica l, int reposoDeDisparo, Pos pos, Rectangle hitBox, Proyectil_Factory fabProy, JLabel label, int dañoProyVirus,Visitor visitor) {
		if(pos.getY()>=600) {
			pos.actPosY(-pos.getY()-label.getBounds().height);
			hitBox.setLocation(pos.getX(),pos.getY());
			visitor.setCooldown(false);
		}
		else {
			pos.actPosY(velocidad);
			hitBox.setLocation(pos.getX(),pos.getY());
			if(reposoDeDisparo>=35) {
				Entidad e= fabProy.crearProyectil_InfectadoB(new Pos(pos.getX()+label.getBounds().width/2,pos.getY()+label.getBounds().height),dañoProyVirus);
				l.agregarEntidadAA(e);
			}
		}
	}
	
}
