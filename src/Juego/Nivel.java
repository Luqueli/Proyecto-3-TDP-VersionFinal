package Juego;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import Entidades.Infectado;
import Factorys.Infect_Factory;

/**
 * Clase Nivel. Implementacion del nivel del juego.
 * 
 * @author Lucas Bonetto
 * @author Boris de Prada
 * @author Giuliano Giannotti
 *
 */

public class Nivel 
{
	
	private int nivel;
	private int oleada;
	private Infect_Factory fabInfect;
	
	
	//Constructor
	public Nivel() 
	{
		nivel = 1;
		oleada = 1;
		fabInfect = new Infect_Factory();
	}
	
	/**
	 * Si se pasa de oleada se aumenta el nivel
	 */
	public void pasarOleada() 
	{
		if (oleada == 2) 
		{
			nivel++;
			oleada = 1;
		}
		else 
		{
			oleada++;
		}
	}
	
	/**
	 * Retorna el nivel
	 * @return nivel
	 */
	public int getNivel() 
	{
		return nivel;
	}
	
	/**
	 * Retorna les entidades de la oleada
	 * @return lista de entidades de la oleada
	 */
	public Collection<Infectado> getEntidadesDeOleada()
	{
		Collection<Infectado> enemigos = new CopyOnWriteArrayList<Infectado>();
		switch(nivel) 
		{
			
			case 1 : crearZombAlpha(1*oleada,enemigos);
					 crearZombBeta(4*oleada,enemigos);
					 break;
					 
			case 2 : crearZombAlpha(8*oleada,enemigos);
			 		 crearZombBeta(10*oleada,enemigos);
			 		 break;
		}
		return enemigos;
	}
	
	/**
	 * Crea zombies alpha
	 * @param n
	 * @param enemigos
	 */
	private void crearZombAlpha(int n, Collection<Infectado> enemigos) 
	{
		for(int i = 0; i < n; i++) 
		{
			Infectado e = fabInfect.create_InfectadoAlpha();
			enemigos.add(e);
		}
	}
	
	/**
	 * Crea zombies beta
	 * @param n
	 * @param enemigos
	 */
	private void crearZombBeta(int n,Collection<Infectado> enemigos)
	{
		for(int i = 0; i < n; i++) 
		{
			enemigos.add(fabInfect.create_InfectadoBeta());
		}
	}
	
	
}
