package Visitor;

import Entidades.Player;


public class visitor_ProyInfectA extends Visitor {

	private int daño;

	public visitor_ProyInfectA(int d) {
		daño = d;
	}

	public void visit(Player e) {
		e.recibirDaño(daño);
	}
}
