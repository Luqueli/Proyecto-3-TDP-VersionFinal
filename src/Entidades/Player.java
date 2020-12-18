package Entidades;

import java.awt.Rectangle;
import Armas.Arma;
import Armas.ArmaSanitaria;
import Factorys.Proyectil_Factory;
import Juego.Logica;
import Juego.Pos;
import States.State_Arma;
import Temporizadores.Temporizador;
import Visitor.Visitor;
import Visitor.visitor_Player;

/**
 * Clase Player. Implementacion de un jugador.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class Player extends Entidad
{
	
	protected int vida;
	private Arma arma;
	private Proyectil_Factory fabProy;
	private Temporizador tempPowerUp;
	
	
	//Constructor
	public Player() 
	{
		tempPowerUp = null;
		arma = new ArmaSanitaria();
		vida = 100;
		velocidad = 9;
		pos = new Pos(400,457);
		fabProy = new Proyectil_Factory();
		hitBox = new Rectangle(pos.getX(),pos.getY(),56,104);
	}
	
	/**
	 * Mueve a la izquierda el label
	 * @return la posicion del label en el eje x
	 */
	public int moverIzq()
	{
		if (pos.getX() >= velocidad) 
		{
			pos.actPosX(-velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
		}	
		return pos.getX();
	}
	
	/**
	 * Mueve a la derecha el label
	 * @return la posicion del label en el eje x
	 */
	public int moverDer() 
	{
		if (pos.getX() <= 744-velocidad) 
		{
			pos.actPosX(velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
		}
		return pos.getX();
	}
	
	/**
	 * Se encarga de generar el disparo
	 * @param p Pos
	 */
	public Entidad disparar(Pos p) 
	{
			return fabProy.crearProyectil_Player(p,arma.getDaño());
	}
	
	/**
	 * Se encarga de cambiar el estado del arma.
	 * @param sp State_Arma
	 */
	public void cambiarEstadoDeArma(State_Arma sp) 
	{
		arma.cambiarEstado(sp);;
	}
	
	/**
	 * La entidad se reporta con el visitor parametrizado.
	 */
	public void  accept(Visitor v) 
	{
		v.visit(this);
	}
	
	/**
	 * Recibe el daño decrementado la vida.
	 * @param d daño
	 */
	public void recibirDaño(int d) 
	{
		vida = vida - d;
	}
	/**
	 * Como las acciones que realiza el player dependen del Jugador (no maquina)
	 * el accionar es utilizado para el funcionamiento de powerUps.
	 */
	public void accionar(Logica l) 
	{
		if ( tempPowerUp != null)
		{
			tempPowerUp.actualizar(l);
		}
	}

	/**
	 * Retorna la posicion del label en el eje x.
	 * @return posicion del label en el eje x
	 */
	public int getPosX()
	{
		return pos.getX();
	}
 
	/**
	 * Retorna la posicion del label en el eje y
	 * @return posicion del label en el eje y
	 */
	public int getPosY() 
	{
		return pos.getY();
	}

	/**
	 * Retorna el hitBox
	 * @return hitBox
	 */
	public Rectangle getHitBox()
	{
		return hitBox;
	}

	/**
	 * Retorna un nuevo visitor jugador
	 * @return nuevo visitor jugador.
	 */
	public Visitor getVisitor()
	{
		return new visitor_Player();
	}
	
	/**
	 * Indica si el jugador murio o no.
	 * @return true en caso afirmativo, false en caso contrario.
	 */
	public boolean PlayerMurio()
	{
		boolean muerto = false;
		if ( vida <= 0) 
		{
			muerto = true;
		}
		return muerto;
	}
	
	/**
	 * Se encarga de recibir la cura y aumentar la vida del jugador.
	 * @param d cura
	 */
	public void recibirCura(int d)
	{
		if (vida < 100) 
		{
			vida = vida + d;
			if (vida > 100) 
			{
				vida = 100;
			}
		}
	}
	
	/**
	 * Setea el temporizador
	 */
	public void setTemp(Temporizador t) 
	{
		tempPowerUp=t;
	}

	/**
	 * Retorna la vida del jugador
	 * @return vida
	 */
	public int getVida()
	{
		return vida;
	}
}
