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
import Temporizadores.TempPowerUpCO;

/*
 * visitor Cuarentena Obligatoria Power Up
 */
public class visitor_COPU extends Visitor{
	private int tiempoDeDuracion;
	
	public visitor_COPU(int td) {
		tiempoDeDuracion=td;
	}
	
	public void visit(Player e) {
		e.setTemp(new TempPowerUpCO(tiempoDeDuracion));
	}
}
