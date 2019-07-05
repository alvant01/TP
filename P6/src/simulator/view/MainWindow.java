package simulator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import simulator.control.Controller;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ...
	Controller _ctrl;
	ControlPanel cp;
	StatusBar sb;
	//añadir tabla de cuerpos
	Viewer view;
	Viewer view1;
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
		view1 = new Viewer(_ctrl);
		bt = new BodiesTable(_ctrl);
		
		JFrame mainFrame = new JFrame();		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setSize(800, 600);
		
		mainFrame.setVisible(true);
		
		
		mainFrame.setContentPane(mainPanel);
		
		mainPanel.setVisible(true);
		
		
		// TODO complete this method to build the GUI
		
		
		cp.setPreferredSize(new Dimension(600,50));
		sb.setPreferredSize(new Dimension(600,50));
		mainPanel.add(cp, BorderLayout.PAGE_START);
		mainPanel.add(sb, BorderLayout.PAGE_END);
		
		JPanel panel2 = new JPanel();
		
		
		panel2.setPreferredSize(new Dimension(600,300));
		
		panel2.setLayout(new GridLayout(2,1));
		
		//JPanel panel3 = new JPanel();
		
		view.setPreferredSize(new Dimension(600,150));
		bt.setPreferredSize(new Dimension(600,150));
		
		
		panel2.add(bt, BorderLayout.PAGE_START);
		panel2.add(view, BorderLayout.PAGE_END);
		
		mainPanel.add(panel2, BorderLayout.CENTER);
		
		//panel3.add(bt);
		//bt.setPreferredSize(panel2.getMinimumSize());
		
		
		

	}
	// other private/protected methods
	// ...
}
