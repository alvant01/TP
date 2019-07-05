package simulator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;

public class BodiesTable extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//private JScrollPane sp;
	private JTable table;
	private BodiesTableModel tM;
	BodiesTable(Controller ctrl) 
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2),"Bodies",TitledBorder.LEFT, TitledBorder.TOP));
		// TODO complete
		tM = new BodiesTableModel(ctrl);

		//sp = new JScrollPane();
		table = new JTable(tM);
		
		
		//sp.setPreferredSize(new Dimension(600,50));
		this.add(table);
		
		
		//this.add(sp);
		
		
	}
}
