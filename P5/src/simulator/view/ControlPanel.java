package simulator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class ControlPanel extends JPanel implements SimulatorObserver {
// ...
	private Controller _ctrl;
	private boolean _stopped;
	
	JFrame frame;
	
	JSpinner pasos;
	
	JTextField dTime;
	
	JButton file, gLaw, play, stop, close;
	
	
	ControlPanel(Controller ctrl) 
	{
		_ctrl = ctrl;
		_stopped = true;
		initGUI();
		_ctrl.addObserver(this);
	}
	private void initGUI() 
	{
		// TODO build the tool bar by adding buttons, etc.
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(400, 100);
		
		frame.setVisible(true);
		
		
		file = new JButton();
		file.setIcon(new ImageIcon("resources/icons/open.png"));
		file.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser fileChooser = new JFileChooser();
						int seleccion = fileChooser.showOpenDialog(frame);
						
					}
					
			
				});
		
		gLaw = new JButton();
		gLaw.setIcon(new ImageIcon("resources/icons/physics.png"));
		
		play = new JButton();
		play.setIcon(new ImageIcon("resources/icons/run.png"));
		
		stop = new JButton();
		stop.setIcon(new ImageIcon("resources/icons/stop.png"));
		
		close = new JButton();
		close.setIcon(new ImageIcon("resources/icons/exit.png"));
		
		
		
	}
		// other private/protected methods
		// ...
	private void run_sim(int n) 
	{
		if ( n>0 && !_stopped ) 
		{
			try
			{
				_ctrl.run(1);
			}
			catch (Exception e)
			{
				// TODO show the error in a dialog box
				
				// TODO enable all buttons
				_stopped = true;
				return;
			}
			SwingUtilities.invokeLater( new Runnable() 
			{
				@Override
				public void run()
				{
					run_sim(n-1);
				}
			});
		}
		else
		{
			_stopped = true;
			// TODO enable all buttons
		}
	}
		// SimulatorObserver methods
		// ...
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {
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
}

