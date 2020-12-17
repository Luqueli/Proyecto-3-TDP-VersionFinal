package Entidades;

import java.awt.Rectangle;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Armas.Arma;
import Armas.ArmaSanitaria;
import Factorys.Proyectil_Factory;
import Juego.Logica;
import Juego.Pos;
import States.Normal_State;
import States.State_Arma;
import Temporizadores.Temporizador;
import Visitor.Visitor;
import Visitor.visitor_Player;

public class Player extends Entidad{
	protected int vida;
	protected int velocidad;
	private Arma arma;
	private Pos pos;
	private Proyectil_Factory fabProy;
	private Temporizador tempPowerUp;
	
	public Player() {
		tempPowerUp=null;
		arma=new ArmaSanitaria();
		vida=100;
		velocidad=9;
		pos=new Pos(400,457);
		fabProy=new Proyectil_Factory();
		hitBox= new Rectangle(pos.getX(),pos.getY(),56,104);
	}
	
	public int moverIzq() {
		if(pos.getX()>=velocidad) {
			pos.actPosX(-velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
		}	
		return pos.getX();
	}
	
	public int moverDer() {
		if(pos.getX()<=744-velocidad) {
			pos.actPosX(velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
		}
		return pos.getX();
	}
	
	public Entidad disparar(Pos p) {
			return fabProy.crearProyectil_Player(p,arma.getDaño());
	}
	
	public void cambiarEstadoDeArma(State_Arma sp) {
		arma.cambiarEstado(sp);;
	}
	
	public void  accept(Visitor v) {
		v.visit(this);
	}
	
	public void recibirDaño(int d) {
		vida=vida-d;
	}
	/*
	 * Como las acciones que realiza el player dependen del Jugador (no maquina)
	 * el accionar es utilizado para el funcionamiento de powerUps.
	 * 
	 */
	public void accionar(Logica l) {
		if(tempPowerUp!=null) {
			tempPowerUp.actualizar(l);
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
		return new visitor_Player();
	}
	
	public boolean PlayerMurio() {
		if(vida<=0) {
			return true;
		}
		return false;
	}
	
	public void recibirCura(int d) {
		if(vida<100) {
			vida=vida+d;
			if(vida>100) {
				vida=100;
			}
		}
	}
	
	public void setTemp(Temporizador t) {
		tempPowerUp=t;
	}
	
	public int getVida() {
		return vida;
	}
}
