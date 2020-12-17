package Factorys;

import Entidades.Proyectil;
import Entidades.Proyectil_InfectadoA;
import Entidades.Proyectil_InfectadoB;
import Entidades.Proyectil_Player;
import Juego.Pos;

public class Proyectil_Factory {
	
	public Proyectil_Factory() {
		//Empty
	}
	
	public Proyectil crearProyectil_Player(Pos p,int d) {
		return new Proyectil_Player(p,d); 
	}
	
	public Proyectil crearProyectil_InfectadoA(Pos p,int d) {
		return new Proyectil_InfectadoA(p,d);
	}
	
	public Proyectil crearProyectil_InfectadoB(Pos p,int d) {
		return new Proyectil_InfectadoB(p,d);
	}
}
