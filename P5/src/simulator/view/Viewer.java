package simulator.view;

import java.awt.BorderLayout;
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

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;
import simulator.misc.Vector;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class Viewer extends JComponent implements SimulatorObserver {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ...
	private int _centerX;
	private int _centerY;
	private double _scale;
	private List<Body> _bodies;
	private boolean _showHelp;
	
	Viewer(Controller ctrl)
	{
		initGUI();
		ctrl.addObserver(this);
	}
	
	private void initGUI()
	{
// TODO add border with title
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2),"Bodies",TitledBorder.LEFT, TitledBorder.TOP));
		
		//Border boder = BorderFactory.createTitledBorder("Viewer");
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.setBorder(boder);
		
		_bodies = new ArrayList<>();
		_scale = 1.0;
		_showHelp = true;
		addKeyListener(new KeyListener() {
			// ...
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyChar()) 
				{
					case '-':
						_scale = _scale * 1.1;
						break;
					case '+':
						_scale = Math.max(1000.0, _scale / 1.1);
					break;
					case '=':
						autoScale();
					break;
					case 'h':
						_showHelp = !_showHelp;
					break;
					default:
				}
				repaint();
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
			// ...
			@Override
			public void mouseEntered(MouseEvent e) {
				requestFocus();
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
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
@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gr.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		//use ’gr’ to draw not ’g’
		//calculate the center
		_centerX = getWidth() / 2;
		_centerY = getHeight() / 2;
		//TODO draw a cross at center
		gr.setColor(Color.red);
		gr.drawLine(_centerX + 2, _centerY, _centerX - 2, _centerY);
		gr.drawLine(_centerX, _centerY + 2, _centerX , _centerY- 2);
		
		gr.setColor(Color.blue);
		
		//TODO draw bodies
		
		for(int i = 0; i < this._bodies.size(); i++)
		{
			Vector pos = this._bodies.get(i).getPosition();
			
			
			int x = _centerX + (int) (pos.coordinate(0)/_scale);
			gr.fillOval( _centerX + (int) (pos.coordinate(0)/_scale),  _centerY - (int) (pos.coordinate(1)/_scale), 10, 10);
		}
		//TODO draw help if _showHelp is true
		if(_showHelp)
		{
			gr.setColor(Color.red);
			String help = "h: toggle help +: zoom-in -: zoom-out =: fit";
			String help2 = "Scaling ratio: " + _scale;
			gr.drawString(help, this.getAlignmentX() +3, this.getAlignmentY() + 25);
			gr.drawString(help2, this.getAlignmentX() +3, this.getAlignmentY() + 40);
		}
	}
	//other private/protected methods	
	//...
	private void autoScale() {
		double max = 1.0;
		for (Body b : _bodies) {
			Vector p = b.getPosition();
			for (int i = 0; i < p.dim(); i++)
				max = Math.max(max,Math.abs(b.getPosition().coordinate(i)));
		}
		double size = Math.max(1.0, Math.min((double) getWidth(),(double) getHeight()));
		_scale = max > size ? 4.0 * max / size : 1.0;
	}

	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
		_bodies = bodies;
		
		autoScale();
		repaint();
		
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {
		_bodies = bodies;
		
		autoScale();
		repaint();
		
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		_bodies = bodies;
		
		autoScale();
		repaint();
		
	}

	@Override
	public void onAdvance(List<Body> bodies, double time) {
		
		repaint();
		
	}

	@Override
	public void onDeltaTimeChanged(double dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGravityLawChanged(String gLawsDesc) {
		// TODO Auto-generated method stub
		
	}
	//SimulatorObserver methods
	//...
}