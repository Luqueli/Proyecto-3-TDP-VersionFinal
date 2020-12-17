package Armas;

import States.Normal_State;
import States.State_Arma;

public class ArmaSanitaria extends Arma{
	public ArmaSanitaria() {
		state=new Normal_State();
	}

	public int getDa�o() {
		return state.getDa�o();
	}
	
	public void cambiarEstado(State_Arma sa) {
		state=sa;
	}
	
	
}
