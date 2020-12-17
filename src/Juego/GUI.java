package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Entidad;

public class GUI extends JFrame implements KeyListener{
	
	private Thread h1;
	private Ejecucion ejec;
	private Logica logica;
	private boolean perdio;
	
	private JPanel contentPane;
	private JPanel areaDeJuego;
	
	private JButton btnReiniciar;
	
	private JLabel lblPlayer;
	private JLabel lblVidaPlayer;
	private JLabel lblNivel;
	
	private int ctrlDeDisparo;
	private int contDeDisparo;
	/*
	 * Lunch the aplication
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * 	
	 */
	
	
	public GUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		areaDeJuego=new JPanel();
		areaDeJuego.setBounds(0,0,800,600);
		areaDeJuego.setLayout(null);
		contentPane.add(areaDeJuego);
		areaDeJuego.setBackground(Color.BLACK);
		
		logica=new Logica();
		
		lblPlayer = new JLabel();
		lblPlayer.setIcon(new ImageIcon(GUI.class.getResource("/GifsEImagenes/quietoGif-unscreen.gif")));
		lblPlayer.setBounds(400, 457, 56, 104);
		areaDeJuego.add(lblPlayer);
		lblPlayer.setVisible(true);
		
		ctrlDeDisparo=7;//== a 1 seg de cooldown
		contDeDisparo=6;
		
		this.addKeyListener(this);
		
		lblVidaPlayer=new JLabel("VIDA: "+logica.getPlayer().getVida());
		lblVidaPlayer.setBounds(700, 0, 100, 70);
		areaDeJuego.add(lblVidaPlayer);
		lblVidaPlayer.setForeground(Color.GREEN);
		
		lblNivel=new JLabel("Nivel 1");
		lblNivel.setBounds(0, 0, 100, 70);
		areaDeJuego.add(lblNivel);
		lblNivel.setForeground(Color.YELLOW);
		
		perdio=false;
		
		ejec=new Ejecucion(this);
			
		h1=new Thread(ejec);
		h1.start();
	}

/////////////////////////////////////////////////////KEY_EVENTS//////////////////////////////////////////////////////////////////
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyChar()) {
			
			case 'd':	lblPlayer.setIcon(new ImageIcon(GUI.class.getResource("/GifsEImagenes/movDerGif-unscreen.gif")));
						lblPlayer.setBounds(logica.moverDer(),457, 56, 104);
						break;
					   
			case 'a': 	lblPlayer.setIcon(new ImageIcon(GUI.class.getResource("/GifsEImagenes/movIzqGif-unscreen.gif")));
						lblPlayer.setBounds(logica.moverIzq(),457, 56, 104);
						break;
			
			case KeyEvent.VK_SPACE :	if(contDeDisparo>=ctrlDeDisparo) {
											contDeDisparo=0;
											lblPlayer.setIcon(new ImageIcon(GUI.class.getResource("/GifsEImagenes/disparo.gif")));
											logica.disparar(new Pos(lblPlayer.getX()+lblPlayer.getBounds().width/2,424));
										}
										break;
				
		}
	}
	
	public void keyReleased(KeyEvent e) {
		lblPlayer.setIcon(new ImageIcon(GUI.class.getResource("/GifsEImagenes/quietoGif-unscreen.gif")));
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public void actualizarGUI() throws StopThreadException{
		contDeDisparo++;//Aumento contador en este metodo porque se mantiene corriendo constantemente
		
		
		//Agrego las nuevas entidades al panel de juego
		if(!logica.getEntidadesAA().isEmpty()) {
			for(Entidad e: logica.getEntidadesAA()) {
				areaDeJuego.add(e.getLabel());
				e.getLabel().setBounds(e.getPosX(), e.getPosY(),e.getLabel().getBounds().width,e.getLabel().getBounds().height);
			}
		}
		
		//Actualizo logicamente la coleccion de entidades a eliminar
		logica.actualizarColeccionEntidadesAA();
		
		//Hago que cada entidada haga su accion correspondiente y la actualizo graficamente
		for(Entidad e: logica.getEntidades()) {
			e.accionar(logica);
			if(!e.equals(logica.getPlayer())){
				e.getLabel().setBounds(e.getPosX(), e.getPosY(),e.getLabel().getWidth(), e.getLabel().getHeight());
			}
		}
		
		//Elimino graficamente las entidades que ya no estan
		for(Entidad e: logica.getEntidadesAE()) {
			e.getLabel().remove(areaDeJuego);
			e.getLabel().setIcon(null);
		}
		
		//Repaint que sirvio para arreglar bugs graficos
		this.repaint();
		
		//Elimino de la logica del juego las entidades muertas/salidas
		logica.actualizarColeccionEntidadesAE();
		
		//Para cada una de las entidades presentes en el juego chequeo sus colisiones.
		for(Entidad e: logica.getEntidades()){
			logica.colisionador(e);
		}
		
		//Actualizo el label de la vida actual del jugador
		lblVidaPlayer.setText("VIDA: "+logica.getPlayer().getVida());
		
		//Actualiza el label que indica el nivel actual
		lblNivel.setText("NIVEL "+ logica.getNivel());
		
		//Chequea si el player murio y finaliza la ejecocion del hilo.
		if(logica.getPlayer().PlayerMurio()) {
			JLabel lblGameOver=new JLabel("HAS MUERTO");
			lblGameOver.setBounds(350,0, 200, 50);
			areaDeJuego.add(lblGameOver);
			lblGameOver.setForeground(Color.RED);
			throw new StopThreadException("El jugador murio");
		}
		
		//Chequea si todos los infectados de la oleada actual fueron eliminados
		if(logica.getOleada().isEmpty()) {
			logica.sigOleada();
			if(logica.JuegoGando()) {
				JLabel lblWin= new JLabel("HAS GANADO");
				lblWin.setBounds(350, 200, 200, 50);
				areaDeJuego.add(lblWin);
				lblWin.setForeground(Color.BLUE);
				throw new StopThreadException("El jugador gano el juego");
			}
		}
	}
	
	public void iniciarJuego() {
		logica.iniciarOleada();
	}
}
