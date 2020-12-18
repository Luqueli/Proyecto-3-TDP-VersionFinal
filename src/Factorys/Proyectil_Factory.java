package Factorys;

import Entidades.Proyectil;
import Entidades.Proyectil_InfectadoA;
import Entidades.Proyectil_InfectadoB;
import Entidades.Proyectil_Player;
import Juego.Pos;

/**
 * Clase Proyectil_Factory. Implementacion del factory de un proyectil.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class Proyectil_Factory {

	// Constructor
	public Proyectil_Factory() {
		// Nada
	}

	/**
	 * Crea y retorna un proyectil de jugador.
	 * 
	 * @param p
	 * @param d
	 * @return proyectil de jugador
	 */
	public Proyectil crearProyectil_Player(Pos p, int d) {
		return new Proyectil_Player(p, d);
	}

	/**
	 * Crea y retorna un proyectil de infectado alpha
	 * 
	 * @param p
	 * @param d
	 * @return proyectil de infectado alpha
	 */
	public Proyectil crearProyectil_InfectadoA(Pos p, int d) {
		return new Proyectil_InfectadoA(p, d);
	}

	/**
	 * Crea y retorna un proyectil de infectado beta.
	 * 
	 * @param p
	 * @param d
	 * @return proyectil de infectado beta
	 */
	public Proyectil crearProyectil_InfectadoB(Pos p, int d) {
		return new Proyectil_InfectadoB(p, d);
	}
}
