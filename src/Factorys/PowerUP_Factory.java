package Factorys;

import Entidades.CuarentenaObligatoria;
import Entidades.Cura;
import Entidades.PowerUp;
import Entidades.SuperArmaSanitariaPU;
import Juego.Pos;

public class PowerUP_Factory {
	
	public PowerUP_Factory() {
		//vacio
	}
	
	public PowerUp crearPOCO(Pos p){
		return new CuarentenaObligatoria(p);
	}
	
	public PowerUp crearCura(Pos p) {
		return new Cura(p);
	}
	
	public PowerUp crearSuperArmaSanitaria(Pos p) {
		return new SuperArmaSanitariaPU(p);
	}
}
