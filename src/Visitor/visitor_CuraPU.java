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

public class visitor_CuraPU extends Visitor{
	
	private int cura;
	
	public visitor_CuraPU(int c) {
		cura=c;
	}
	
	public void visit(Player e) {
		e.recibirCura(cura);
	}
}
