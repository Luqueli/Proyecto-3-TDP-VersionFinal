package Temporizadores;

import Juego.Logica;

public class TempPowerUpCO extends Temporizador{
	private boolean activado;
	
	public TempPowerUpCO(int tl) {
		tiempoLimite=tl;
		activado=false;
	}

	public void actualizar(Logica l) {
		contador++;
		if(!activado) {
			l.ParalizarInfectados();
			activado=true;
		}
		if(contador>=tiempoLimite) {
			l.DesparalizarInfectados();
			l.getPlayer().setTemp(null);
		}
	}
}
