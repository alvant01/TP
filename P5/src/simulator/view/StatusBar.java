package simulator.view;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class StatusBar extends JPanel implements SimulatorObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ...
	private JLabel _currTime; // for current time
	private JLabel _currLaws; // for gravity laws
	private JLabel _numOfBodies; // for number of bodies
	StatusBar(Controller ctrl) {
		
		_currTime = new JLabel();
		_currLaws = new JLabel();
		_numOfBodies = new JLabel();
		
		_currTime.setText("Time: " + Double.toString(ctrl.getPs().getTiempoActual()));
		_currLaws.setText("Laws: " + ctrl.getPs().getLeyesGravedad().toString());
		_numOfBodies.setText("Bodies: " +Integer.toString(ctrl.getPs().getListBodies().size()));
		
		initGUI();
		ctrl.addObserver(this);
	}
	private void initGUI() {
		this.setLayout( new FlowLayout( FlowLayout.LEFT ));
		this.setBorder( BorderFactory.createBevelBorder( 1 ));
		// TODO complete the code to build the tool bar
		this.add(_currTime);
		this.add(_numOfBodies);
		this.add(_currLaws);
		
		
		
		
	}
	// other private/protected methods
	// ...
	// SimulatorObserver methods
	// ...
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {
		_currLaws.setText(gLawsDesc);
		
		
	}
	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		_numOfBodies.setText(Integer.toString(bodies.size())); 
		
	}
	@Override
	public void onAdvance(List<Body> bodies, double time) {
		_currTime.setText(Double.toString(time));
		
	}
	@Override
	public void onDeltaTimeChanged(double dt) {
		_currTime.setText(Double.toString(dt));
		
	}
	@Override
	public void onGravityLawChanged(String gLawsDesc) {
		_currLaws.setText(gLawsDesc);
		
	}
}