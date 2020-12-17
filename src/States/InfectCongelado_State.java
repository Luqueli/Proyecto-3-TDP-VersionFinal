package States;

import java.awt.Rectangle;

import javax.swing.JLabel;

import Entidades.Entidad;
import Factorys.Proyectil_Factory;
import Juego.Logica;
import Juego.Pos;
import Visitor.Visitor;

public class InfectCongelado_State extends State_Infectado{
	
	public void accionar(Logica l, int rd, Pos pos, Rectangle hitBox, Proyectil_Factory pf, JLabel label, int dañoProyVirus,Visitor visitor) {
		//vacio porque en este esatado el infectado debe quedar congelado 
		//y este metopdo solo se encarga del movimiento y los disparos
	}
}

