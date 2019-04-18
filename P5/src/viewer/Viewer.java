package viewer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import simulator.control.Controller;
import simulator.misc.Vector;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class Viewer extends JComponent implements SimulatorObserver {
	
	private static final int _WIDTH = 1000;
	private static final int _HEIGHT = 1000; 
	
	// Anhadir constantes para los colores 
	
	private int _centerX;  //posicion centro
	private int _centerY;
	private double _scale;  
	private List<Body> _bodies;  //lista actual de cuerpo, hay que actualizarla cada vez que cambia de estado el simulador
	private boolean _showHelp;
	
	public Viewer() {
		
		this._centerX = 0;
		this._centerY = 0;
		this._scale = 0;
		this._showHelp = false;
		
		Color blanco = new Color(255, 255, 255); 		// blanco
		Color negro = new Color(0, 0, 0);				// negro
		Color rojo = new Color(255, 0, 0);				// rojo
		Color verde = new Color(0, 255, 0);				// verde
		Color azul = new Color(0, 0, 255);				// azul
		Color amarillo = new Color(255, 255, 0);		// amarillo
		Color anaranjado = new Color(255, 200, 0);		// anaranjado
		Color gris = new Color(128, 128, 128);			// gris
		
		
	}
	
	Viewer(Controller ctrl) {
		initGUI();
		ctrl.addObserver(this);
		}

	private void initGUI() {
		// TODO add border with title
		//Suma border con title
		//this.listBodies = new ArrayList<Body>();
		
		this._bodies = new ArrayList<Body>();
		this._scale = 1.0;
		this._showHelp = true;
		
		addKeyListener(new KeyListener() {
			
			//completar con metodos de la interfaz
			
			/*
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyChar()) {
				case ’-’: _scale = _scale * 1.1;
				break;
				case ’+’: _scale = Math.max(1000.0, _scale / 1.1);
				break;
				case ’=’: autoScale();
				break;
				case ’h’: _showHelp = !_showHelp;
				break;
				default:
				}
				repaint();
				}
				});
				*/

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				switch (arg0.getKeyChar()){
				//case ’-’: _scale = _scale * 1.1;
				case '-': _scale = (_scale * 1.1);
				
				
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
/*
	private void addMouseListener(MouseListener mouseListener) {
		// TODO Auto-generated method stub
		
	}
*/

	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
		// TODO Auto-generated method stub

		// i want se
		
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt,
			String gLawsDesc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdvance(List<Body> bodies, double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDeltaTimeChanged(double dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGravityLawChanged(String gLawsDesc) {
		// TODO Auto-generated method stub

	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		gr.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	
	// Usa ’gr’ para dibujar, no ’g’
	_centerX = getWidth() / 2;
	_centerY = getHeight() / 2; 
	
	// Dibuja una cruz en el centro
	// Dibuja los bodies
	// Dibuja help si _showHelp es true
	
		if (this._showHelp == true){
		
			//Dibuja help
		
		}
	
	}
	
	// Añade otros metodos
	private void autoScale() {
		double max = 1.0;
	
		for (Body b : _bodies) {
			Vector p = b.getPosition();
			
			for (int i = 0; i < p.dim(); i++)
				max = Math.max(max,
				Math.abs(b.getPosition().coordinate(i)));
			}
		
		double size = Math.max(1.0, Math.min((double) getWidth(),
		(double) getHeight()));
		_scale = max > size ? 4.0 * max / size : 1.0;
	} 
	
	
}
