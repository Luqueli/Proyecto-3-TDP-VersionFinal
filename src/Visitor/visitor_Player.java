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

public class visitor_Player extends Visitor {
	
	public visitor_Player() {
		//Vacio
	}
	
	public void visit(Proyectil_InfectadoA e) {
		e.eliminar();
	}

	public void visit(Proyectil_InfectadoB e) {
		e.eliminar();
	}

	public void visit(Cura e) {
		e.eliminar();
	}

	public void visit(SuperArmaSanitariaPU e) {
		e.eliminar();
	}

	public void visit(CuarentenaObligatoria e) {
		e.eliminar();	
	}

	
}
