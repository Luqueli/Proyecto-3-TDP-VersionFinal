package Visitor;

import Entidades.Player;


public class visitor_ProyInfectA extends Visitor {

	private int da�o;

	public visitor_ProyInfectA(int d) {
		da�o = d;
	}

	public void visit(Player e) {
		e.recibirDa�o(da�o);
	}
}
