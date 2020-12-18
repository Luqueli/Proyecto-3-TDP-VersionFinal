package Juego;

/**
 * Clase Ejecucion. Implementacion de la ejecucin del juego.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class Ejecucion implements Runnable {
	public GUI miGui;

	// Constructor
	public Ejecucion(GUI g) {
		miGui = g;
	}

	// Ejecuta la aplicacion
	public void run() {
		try {
			miGui.iniciarJuego();
			while (true) {
				Thread.sleep(50);
				miGui.actualizarGUI();
			}
		} catch (InterruptedException | StopThreadException e) {
			System.out.print(e.getMessage());
		}
	}
}
