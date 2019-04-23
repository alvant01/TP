package simulator.view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.swing.*;

import simulator.control.Controller;
import simulator.model.Body;

public class ControlPanel extends JPanel{
// ...
	private Controller _ctrl;
	private boolean _stopped;
	JPanel panel;
	
	
	JSpinner pasos;
	
	JTextField dTime;
	
	JButton file, gLaw, play, stop, close;
	
	
	ControlPanel(Controller ctrl) 
	{
		_ctrl = ctrl;
		_stopped = true;
		initGUI();
	}
	private void initGUI() 
	{
		// TODO build the tool bar by adding buttons, etc.
		panel = new JPanel(new FlowLayout());
		
		pasos = new JSpinner();

		
		pasos.setValue(_ctrl.getPasos());
		//dTime.setText(Double.toString(_ctrl.getPs().getTiempoActual()));
		
		file = new JButton();
		file.setLocation(0, 0);
		file.setSize(120, 30);
		file.setIcon(new ImageIcon("resources/icons/open.png"));
		
		file.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser fileChooser = new JFileChooser();
						int seleccion = fileChooser.showOpenDialog(new JPanel());
						if (seleccion == JFileChooser.APPROVE_OPTION)
						{
						   File fichero = fileChooser.getSelectedFile();
						   InputStream sFichero = null;
						   try 
						   {
							   sFichero = new FileInputStream(fichero);
							   _ctrl.reset();
						   }
						   catch (FileNotFoundException e) 
						   {
							   e.printStackTrace();
						   }

						}	
					}
				});
		this.add(file);
		
		gLaw = new JButton();

		gLaw.setLocation(5,5);
		gLaw.setSize(120, 30);
		gLaw.setIcon(new ImageIcon("resources/icons/physics.png"));
		gLaw.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				//_ctrl.getGravityLawsFactory().getInfo();
			}
		});
		this.add(gLaw);
				
				
				
		play = new JButton();
		play.setIcon(new ImageIcon("resources/icons/run.png"));
		play.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				_stopped = false;
				gLaw.setEnabled(false);
				file.setEnabled(false);
				run_sim((Integer)pasos.getValue());
			}
		});
		this.add(play);
		
		stop = new JButton();
		stop.setIcon(new ImageIcon("resources/icons/stop.png"));
		stop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				_stopped = true;
				gLaw.setEnabled(true);
				file.setEnabled(true);
				run_sim((Integer)pasos.getValue());
			}
		});
		this.add(stop);
		
		this.add(pasos);
		
		//this.add(dTime);
		
		close = new JButton();
		close.setIcon(new ImageIcon("resources/icons/exit.png"));
		close.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				JPanel salir = new JPanel(new FlowLayout());
				if (JOptionPane.showConfirmDialog(salir, "Desea salir") == 0)
					System.exit(0);
					
			}
		});
		this.add(close, BorderLayout.AFTER_LAST_LINE);
		
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
				JOptionPane.showMessageDialog(new JPanel(), "Se ha producido un error durante la ejecucion","Error", JOptionPane.ERROR_MESSAGE);
				// TODO enable all buttons
				gLaw.setEnabled(true);
				file.setEnabled(true);
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
			// TODO enable all buttons
			gLaw.setEnabled(true);
			file.setEnabled(true);
		}
	}
	
	
	// SimulatorObserver methods
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc)
	{
		dTime.setText(Double.toString(time));
	}
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) 
	{
		dTime.setText(Double.toString(time));
		
	}
	public void onBodyAdded(List<Body> bodies, Body b) 
	{
		
		
	}
	public void onAdvance(List<Body> bodies, double time) 
	{
		dTime.setText(Double.toString(time));
		
	}
	public void onDeltaTimeChanged(double dt) 
	{
		dTime.setText(Double.toString(dt));
		
	}
	public void onGravityLawChanged(String gLawsDesc) {
		
	}
}

