package Factorys;

import Entidades.Infectado;
import Entidades.Infectado_Alpha;
import Entidades.Infectado_Beta;

/**
 * Clase Infect_Factory. Implementacion del factory de un infectado.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */
public class Infect_Factory
{
	
	//Constructor
	public Infect_Factory() 
	{
		//Nada
	}
	
	/**
	 * Crea un nuevo infectado Alpha
	 * @return Infectado alpha
	 */
	public Infectado create_InfectadoAlpha()
	{
		return new Infectado_Alpha();
	}
	
	/**
	 * Retorna un nuevo infectado Beta
	 * @return Infectado Alpha
	 */
	public Infectado create_InfectadoBeta() 
	{
		return new Infectado_Beta();
	}
	
}
