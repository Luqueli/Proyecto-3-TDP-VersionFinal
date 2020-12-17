package Juego;

public class Ejecucion implements Runnable {
	public GUI miGui;
	
	public Ejecucion(GUI g) {
		miGui=g;
	}
	
	public void run() {
		try {
			miGui.iniciarJuego();
			while(true) {
				Thread.sleep(50);
					miGui.actualizarGUI();
			}
		}
		catch (InterruptedException | StopThreadException e) {
			System.out.print(e.getMessage());
		}
	}
}
