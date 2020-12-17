package Visitor;

import Entidades.CuarentenaObligatoria;
import Entidades.Cura;
import Entidades.Infectado;
import Entidades.Infectado_Alpha;
import Entidades.Infectado_Beta;
import Entidades.Player;
import Entidades.PowerUp;
import Entidades.Proyectil;
import Entidades.Proyectil_InfectadoA;
import Entidades.Proyectil_InfectadoB;
import Entidades.Proyectil_Player;
import Entidades.SuperArmaSanitariaPU;

public class visitor_InfectadoAlpha extends Visitor{
	private int dañoCuerpoACuerpo;
	private boolean cooldown;
	
	public visitor_InfectadoAlpha(int d) {
		dañoCuerpoACuerpo=d;
		cooldown=false;
	}
	
	public void visit(Player e) {
		if(!cooldown) {
			e.recibirDaño(dañoCuerpoACuerpo);
			cooldown=true;
		}
	}

	public void visit(Proyectil_Player e) {
		e.eliminar();
	}
	
	public void setCooldown(boolean b) {
		cooldown=b;
	}
}
