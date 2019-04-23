package simulator.view;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simulator.control.Controller;

public class MainWindow extends JFrame {
	// ...
	Controller _ctrl;
	ControlPanel cp;
	StatusBar sb;
	//añadir tabla de cuerpos
	Viewer view;
	BodiesTable bt;
	
	public MainWindow(Controller ctrl) {
		super("Physics Simulator");
		_ctrl = ctrl;
		initGUI();
	}
	private void initGUI() {
		
		
		cp = new ControlPanel(_ctrl);
		sb = new StatusBar(_ctrl);
		view = new Viewer(_ctrl);
		bt = new BodiesTable(_ctrl);
		
		JFrame mainFrame = new JFrame();		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setSize(600, 400);
		
		mainFrame.setVisible(true);
		
		
		mainFrame.setContentPane(mainPanel);
		
		mainPanel.setVisible(true);
		
		
		// TODO complete this method to build the GUI
		mainPanel.add(cp, BorderLayout.PAGE_START);
		mainPanel.add(sb, BorderLayout.PAGE_END);
		
		JPanel panel2 = new JPanel();
		
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		
		mainPanel.add(panel2, BorderLayout.CENTER);
		
		
		//panel2.add(bt, BorderLayout.PAGE_START);
		
		panel2.add(view,BorderLayout.PAGE_END);
		
		

	}
	// other private/protected methods
	// ...
}
