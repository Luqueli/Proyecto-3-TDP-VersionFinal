package Juego;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import Entidades.Entidad;
import Entidades.Infectado;
import Factorys.Infect_Factory;

public class Nivel {
	private int nivel;
	private int oleada;
	private Infect_Factory fabInfect;
	
	public Nivel() {
		nivel=1;
		oleada=1;
		fabInfect=new Infect_Factory();
	}
	
	public void pasarOleada() {
		if(oleada==2) {
			nivel++;
			oleada=1;
		}
		else {
			oleada++;
		}
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public Collection<Infectado> getEntidadesDeOleada(){
		Collection<Infectado> enemigos= new CopyOnWriteArrayList<Infectado>();
		switch(nivel) {
			
			case 1 : crearZombAlpha(1*oleada,enemigos);
					 crearZombBeta(4*oleada,enemigos);
					 break;
					 
			case 2 : crearZombAlpha(8*oleada,enemigos);
			 		 crearZombBeta(10*oleada,enemigos);
			 		 break;
		}
		return enemigos;
	}
	
	
	private void crearZombAlpha(int n, Collection<Infectado> enemigos) {
		for(int i=0; i<n; i++) {
			Infectado e= fabInfect.create_InfectadoAlpha();
			enemigos.add(e);
		}
	}
	
	private void crearZombBeta(int n,Collection<Infectado> enemigos) {
		for(int i=0; i<n; i++) {
			enemigos.add(fabInfect.create_InfectadoBeta());
		}
	}
	
	
}
