package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;
import Visitor.visitor_CuraPU;
/**
 * Clase cura. Implementacion del comporamiento cura.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class Cura extends PowerUp 
{
	
	private int cantDeCura;
	
	//Constructor
	public Cura(Pos p)
	{
		cantDeCura = 20;
		pos =new Pos (p.getX(),p.getY());
		label = new JLabel(new ImageIcon(Cura.class.getResource("/GifsEImagenes/ImagenPUCura.png")));
		label.setBounds(pos.getX(),pos.getY(),23,23);
		hitBox = new Rectangle(pos.getX(),pos.getY(),label.getBounds().width,label.getBounds().height);
		borrar = false;
		velocidad = 4;
		visitor = new visitor_CuraPU(cantDeCura);
	}
	
	/**
	 * Retorna el visitor
	 * @return visitor
	 */
	public Visitor getVisitor() 
	{
		return visitor;
	}
    /**
     * La entidad se reporta en el visitor pasado por parametro.
     */
	public void accept(Visitor v) 
	{
		v.visit(this);
	}

	public Rectangle getHitBox()
	{
		return hitBox;
	}

	public void accionar(Logica l)
	{
		if (borrar || pos.getY() >= 600)
		{
			l.agregarEntidadAE(this);
		}
		else 
		{
			pos.actPosY(velocidad);
			hitBox.setLocation(pos.getX(), pos.getY());
		}
	}
	
	/**
	 * Retorna el label
	 * @return label
	 */
	public JLabel getLabel() 
	{
		return label;
	}
	
	/**
	 * Retorna la posicion del label en el eje x
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
	
	public void eliminar()
	{
		borrar = true;
	}

}
