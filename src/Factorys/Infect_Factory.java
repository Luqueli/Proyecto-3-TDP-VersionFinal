package Factorys;

import Entidades.Infectado;
import Entidades.Infectado_Alpha;
import Entidades.Infectado_Beta;

public class Infect_Factory {
	
	public Infect_Factory() {
		//empty
	}
	
	public Infectado create_InfectadoAlpha() {
		return new Infectado_Alpha();
	}
	
	public Infectado create_InfectadoBeta() {
		return new Infectado_Beta();
	}
	
}
