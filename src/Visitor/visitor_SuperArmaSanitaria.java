package Visitor;

import Entidades.CuarentenaObligatoria;
import Entidades.Cura;
import Entidades.Entidad;
import Entidades.Infectado_Alpha;
import Entidades.Infectado_Beta;
import Entidades.Player;
import Entidades.Proyectil_InfectadoA;
import Entidades.Proyectil_InfectadoB;
import Entidades.Proyectil_Player;
import Entidades.SuperArmaSanitariaPU;
import States.SuperArma_State;
import Temporizadores.TempPowerUpSA;
import Temporizadores.Temporizador;

public class visitor_SuperArmaSanitaria extends Visitor {
	
	private int tdd;//tiempo de duracion del power up
	
	public visitor_SuperArmaSanitaria(int t) {
		tdd=t;
	}
	
	public void visit(Player e) {
		e.cambiarEstadoDeArma(new SuperArma_State());
		e.setTemp(new TempPowerUpSA(tdd,e));
	}
}
