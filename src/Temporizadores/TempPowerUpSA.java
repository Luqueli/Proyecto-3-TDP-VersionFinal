package Temporizadores;

import Entidades.Player;
import Juego.Logica;
import States.Normal_State;

public class TempPowerUpSA extends Temporizador{
	private Player p;
	
	public TempPowerUpSA(int tl, Player e) {
		tiempoLimite=tl;
		p=e;
	}

	public void actualizar(Logica l) {
		contador++;
		if(contador>=tiempoLimite) {
			p.cambiarEstadoDeArma(new Normal_State());
			p.setTemp(null);
		}
	}
}
