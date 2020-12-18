package Factorys;

import Entidades.CuarentenaObligatoria;
import Entidades.Cura;
import Entidades.PowerUp;
import Entidades.SuperArmaSanitariaPU;
import Juego.Pos;

/**
 * Clase PowerUP_Factory. Implementacion del factory del powerUP.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class PowerUP_Factory 
{
	
	//Constructor
	public PowerUP_Factory() 
	{
		//Nada
	}
	
	/**
	 * Crea y retorna una cuarentenaObligatoria
	 * @param p
	 * @return cuarentenaObligataoria
	 */
	public PowerUp crearPOCO(Pos p)
	{
		return new CuarentenaObligatoria(p);
	}
	
	/**
	 * Crea y retorna una cura
	 * @param p
	 * @return cura
	 */
	public PowerUp crearCura(Pos p) 
	{
		return new Cura(p);
	}
	
	/**
	 * Crea y retorna una super arma sanitaria
	 * @param p
	 * @return super arma sanitaria
	 */
	public PowerUp crearSuperArmaSanitaria(Pos p) 
	{
		return new SuperArmaSanitariaPU(p);
	}
}
