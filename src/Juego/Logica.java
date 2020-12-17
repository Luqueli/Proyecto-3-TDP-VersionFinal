package Juego;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import Entidades.Entidad;
import Entidades.Infectado;
import Entidades.Player;
import Factorys.Infect_Factory;
import Factorys.Proyectil_Factory;
import States.InfectCongelado_State;

public class Logica{
	
	private Player player;
	private Collection<Entidad> entidades;
	private Collection<Entidad> entidadesAA;
	private Collection<Entidad> entidadesAE;
	private Collection<Infectado> oleada;
	private Nivel nivel;
	
	
	
	public Logica() {
		player=new Player();
		entidades=new CopyOnWriteArrayList<Entidad>();
		entidadesAA=new CopyOnWriteArrayList<Entidad>();
		entidadesAE=new CopyOnWriteArrayList<Entidad>();
		oleada= new CopyOnWriteArrayList<Infectado>();
		entidades.add(player);
		nivel= new Nivel();
	}
	
	public void DesparalizarInfectados() {
		for(Entidad e : entidades) {
			e.setDefaultState();
		}
	}
	
	public void ParalizarInfectados() {
		for(Entidad e : entidades) {
			e.setState(new InfectCongelado_State());
		}
	}
	
	///////////////////////////////////////////////////////////MOVIMIENTOS DEL PLAYER/////////////////////////////////////////////////////
	public int moverIzq() {
		return player.moverIzq();
	 
	}
	
	public int moverDer() {
		return player.moverDer();
	}
	
	/*
	 * Hace que el jugador produzca un disparo y lo agregue a la coleccion de entidades a agregar
	 */
	public void disparar(Pos p) {
		Entidad proyectil =player.disparar(p);
		entidadesAA.add(proyectil);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////GETS DE COLECCIONES//////////////////////////////////////////////////////////////
	public Collection<Entidad> getEntidades(){
		return entidades;
	}
	
	public Collection<Entidad> getEntidadesAE(){
		return entidadesAE;
	}
	
	public Collection<Entidad> getEntidadesAA(){
		return entidadesAA;
	}
	
	public Collection<Infectado> getOleada(){
		return oleada;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * Agrega a la Coleccion de entidades las entidads nuevas y luego limpia la cloeccion de entidades a agregar.
	 */
	public void actualizarColeccionEntidadesAA(){
		for(Entidad e : entidadesAA){
			entidades.add(e);
		}
		entidadesAA.removeAll(entidadesAA);
	}
	
	/*
	 * Remueve las entidades que deben ser eliminadas del juego y en 
	 * caso de que sea un infectado lo remueve de la Coleccion de infectados.
	 */
	public void actualizarColeccionEntidadesAE() {
		for(Entidad e : entidadesAE) {
			entidades.remove(e);
			if(oleada.contains(e)) {
				oleada.remove(e);
			}
		}
		entidadesAE.removeAll(entidadesAE);
	}
	
	/*
	 * Agrega una Entidad pasada por parametro a la coleccion de entidades a agregar.
	 */
	public void agregarEntidadAA(Entidad e){
		entidadesAA.add(e);
	}
	
	/*
	 * Controla si se produjo una colision entre alguna de todas las entidades presentes en el juego
	 * con la Entidad pasad por parametro. Ademas llama a realizar la accion correspondiente segun la colision.
	 */
	public void colisionador(Entidad e) {
		for(Entidad ent : entidades) {
			if(!e.equals(ent)) {
				if(e.getHitBox().intersects(ent.getHitBox())) {
					e.accept(ent.getVisitor());
				}
			}
		}
	}  
	
	
	/*
	 *Agrega una entidad a ser Eliminada (porque se destruyo sliendo del mapa,colisionando o muriendose) a las entidades del juego .
	 */
	public void agregarEntidadAE(Entidad e) {
		entidadesAE.add(e);
	}
	
	/*
	 * Retorna al jugador
	 */
	public Player getPlayer() {
		return player;
	}
	
	/*
	 * Agrega las entidades del arranque de oleada. 
	 */
	public void iniciarOleada() {
		for(Infectado e: nivel.getEntidadesDeOleada()) {
			entidadesAA.add(e);
			oleada.add(e);
		}
	}
	/*
	 * Este metodo carga logicamente la proxima oleada correspondiente y tambien actualiza el nivel
	 * 
	 */
	public void sigOleada(){
		nivel.pasarOleada();
		if(nivel.getNivel()<3) {
			for(Infectado e : nivel.getEntidadesDeOleada()) {
				entidadesAA.add(e);
				oleada.add(e);
			}
		}
	}
	
	public boolean JuegoGando() {
		if(nivel.getNivel()>=3) {
			return true;
		}
		return false;
	}
	
	public int getNivel() {
		return nivel.getNivel();
	}
}
