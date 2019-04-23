package simulator.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;

public class BodiesTable extends JPanel {
	
	private JScrollPane sp;
	private JTable table;
	
	BodiesTable(Controller ctrl) 
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2),"Bodies",TitledBorder.LEFT, TitledBorder.TOP));
		// TODO complete
		BodiesTableModel tM = new BodiesTableModel(ctrl);
		
		sp = new JScrollPane();
		table = new JTable(tM);
		
		
		sp.setViewportView(table);
		
		this.add(sp);
		
		
	}
}
