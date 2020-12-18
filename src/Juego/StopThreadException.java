package Juego;

/**
 * Clase StopThreadException. Implementacion de la excepcion StopThreadException.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class StopThreadException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	//Constructor
	public StopThreadException(String msg) 
	{
		super(msg);
	}
}
