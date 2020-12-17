package Entidades;

import javax.swing.JLabel;

import Factorys.PowerUP_Factory;
import Factorys.Proyectil_Factory;
import Juego.Pos;
import States.State_Infectado;

public abstract class Infectado extends Entidad {
	protected static Proyectil_Factory fabProy = new Proyectil_Factory();
	protected static PowerUP_Factory fabPowerUp = new PowerUP_Factory();
	protected int carga_viral;
	protected int velocidad;
	protected int dañoCAC;//Daño cuerpo a cuerpo
	protected Pos pos;
	protected JLabel label;
	protected int reposoDeDisparo;
	protected int dañoProyVirus;
	protected State_Infectado state;
	
	
	/*
	 * Genera una power up al azar, si no se genera nada devuelve nulo.
	 */
	public PowerUp sueltaEntidad(Pos p) {
		int random= (int) Math.floor(Math.random()*(11-1)+1);
		if(random==1 || random==2 || random==3 ) {
			return fabPowerUp.crearCura(p);
		}
		if(random==4 || random==5) {
			return fabPowerUp.crearSuperArmaSanitaria(p);
		}
		if(random==6) {
			return fabPowerUp.crearPOCO(p);
		}
		return null;
	}
}
