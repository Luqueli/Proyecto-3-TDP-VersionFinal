package Visitor;

import Entidades.CuarentenaObligatoria;
import Entidades.Cura;
import Entidades.Infectado_Alpha;
import Entidades.Infectado_Beta;
import Entidades.Player;
import Entidades.Proyectil_InfectadoA;
import Entidades.Proyectil_InfectadoB;
import Entidades.Proyectil_Player;
import Entidades.SuperArmaSanitariaPU;

public class visitor_ProyInfectA extends Visitor{
	
	private int da�o;
	
	public visitor_ProyInfectA(int d) {
		da�o=d;
	}
	
	
	public void visit(Player e) {
		e.recibirDa�o(da�o);
	}
}
