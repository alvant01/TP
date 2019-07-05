package simulator.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class BodiesTableModel extends AbstractTableModel implements SimulatorObserver {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	// ...
	private List<Body> _bodies;
	
	
	private String[] nomColumnas = {"id", "Mass", "Position", "Velocity", "Acceleration"};	
	
	BodiesTableModel(Controller ctrl) 
	{
		_bodies = new ArrayList<>();
		
		_bodies = ctrl.getPs().getListBodies();
		
		ctrl.addObserver(this);
	}
	@Override
	public int getRowCount() {
		return _bodies.size(); 
	}
	@Override
	public int getColumnCount() {
	 return nomColumnas.length;
	}
	@Override
	public String getColumnName(int column) {
		return nomColumnas[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		if (columnIndex==0)
			return _bodies.get(rowIndex).getId();
		else if (columnIndex==1)
			return _bodies.get(rowIndex).getMass();
		else if (columnIndex==2)
			return _bodies.get(rowIndex).getPosition();
		else if (columnIndex==3)
			return _bodies.get(rowIndex).getVelocity();
		else if (columnIndex==4)
			return _bodies.get(rowIndex).getAcceleration();
		else return 0;
	}
	
	
	
	
	
	// SimulatorObserver methods
	// ...
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run()
			{
				_bodies = bodies;
				fireTableStructureChanged();
			}});
	}
	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run()
			{
		_bodies = bodies;
		fireTableStructureChanged();
			}});
	}
	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run()
			{
		_bodies = bodies;
		fireTableStructureChanged();
			}});
	}
	@Override
	public void onAdvance(List<Body> bodies, double time) {
		
		/*if (bodies.equals(_bodies))
		{
			System.out.println("no cambia");
		}
	
		_bodies = bodies;*/
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run()
			{
		fireTableStructureChanged();
			}});
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
