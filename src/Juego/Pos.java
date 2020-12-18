package Juego;

/**
 * Clase Pos. 
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class Pos {

	private int x;
	private int y;

	// Constructor
	public Pos(int e, int i) {
		x = e;
		y = i;
	}

	/**
	 * Actualiza el valor de x
	 * 
	 * @param n
	 */
	public void actPosX(int n) {
		x += n;
	}

	/**
	 * Actualiza el valor de y
	 * 
	 * @param n
	 */
	public void actPosY(int n) {
		y += n;
	}

	/**
	 * Retorna el valor de x
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Retorna el valor de y
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}
}
