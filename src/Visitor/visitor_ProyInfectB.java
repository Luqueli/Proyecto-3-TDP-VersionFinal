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

public class visitor_ProyInfectB extends Visitor{
	private int daño;
	
	public visitor_ProyInfectB(int d) {
		daño=d;
	}
	
	
	public void visit(Player e) {
		e.recibirDaño(daño);
	}
}
