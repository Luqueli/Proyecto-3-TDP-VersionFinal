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

/**
 * Clase abstracta Visitor.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public abstract class Visitor 
{
	
	public void visit (Player e) {}
	public void visit (Proyectil_Player e) {}
	public void visit (Infectado_Alpha e) {}
	public void visit (Infectado_Beta e) {}
	public void visit (Proyectil_InfectadoA e) {}
	public void visit (Proyectil_InfectadoB e) {}
	public void visit (Cura e) {}
	public void visit (SuperArmaSanitariaPU e) {}
	public void visit (CuarentenaObligatoria e) {}
	
	// Metodo usado para que los zombies ataquen solo una vez al contacto con el player.
	public void setCooldown(boolean b) {}
	

}
