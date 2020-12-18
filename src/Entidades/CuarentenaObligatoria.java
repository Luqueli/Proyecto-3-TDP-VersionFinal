package Entidades;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;
import Visitor.visitor_COPU;
/**
 * Clase CuarentenaObligatoria. 
 * Implementacion del comportamiento de la CuarentenaObligatoria
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class CuarentenaObligatoria extends PowerUp
{
	
	private int  tiempoDeDuracion;
	
	//Constructor
	public CuarentenaObligatoria(Pos p) 
	{
		pos = new Pos(p.getX(),p.getY());
		label = new JLabel(new ImageIcon(CuarentenaObligatoria.class.getResource("/GifsEImagenes/ImagenPUCO.png")));
		label.setBounds(pos.getX(),pos.getY(),23,23);
		hitBox = new Rectangle(pos.getX(),pos.getY(),label.getBounds().width,label.getBounds().height);
		borrar=false;
		velocidad = 4;
		tiempoDeDuracion = 100; // 1 seg = 13 int
		visitor = new visitor_COPU(tiempoDeDuracion);
	}
	
	public void accionar(Logica l)
	{
		if(borrar || pos.getY()>=600) 
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
	 * Retorna el visitor
	 * @return visitor
	 */
	public Visitor getVisitor() 
	{
		return visitor;
	}
    /**
     * La entidad se reporta con el visitor pasado por parametro
     */
	public void accept(Visitor v )
	{
		v.visit(this);
	}
	/**
	 * Returna el label
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
	
	public Rectangle getHitBox()
	{
		return hitBox;
	}
}
