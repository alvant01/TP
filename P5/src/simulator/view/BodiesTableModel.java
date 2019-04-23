package simulator.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class BodiesTableModel extends AbstractTableModel implements SimulatorObserver {
// ...
	private List<Body> _bodies;
	
	
	private String[] nomColumnas = {"id", "Mass", "Position", "Velocity", "Acceleration"};
	
	private int numColum = 5;
	
	Object[][] rowData;
	
	
	BodiesTableModel(Controller ctrl) 
	{
		_bodies = new ArrayList<>();
		
		_bodies = ctrl.getPs().getListBodies();
		
		rowData = new Object[numColum][nomColumnas.length];
		for (int i = 0; i < _bodies.size(); i++)
		{
			rowData[i][0] = _bodies.get(i).getId();
			rowData[i][1] = _bodies.get(i).getMass();
			rowData[i][2] = _bodies.get(i).getMass();
			rowData[i][3] = _bodies.get(i).getVelocity();
			rowData[i][4] = _bodies.get(i).getAcceleration();
		}
		
		
		ctrl.addObserver(this);
	}
	@Override
	public int getRowCount() {
		return numColum; 
	}
	@Override
	public int getColumnCount() {
	 return _bodies.size();
	}
	@Override
	public String getColumnName(int column) {
		return nomColumnas[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			return rowData[rowIndex][columnIndex];
	}
	// SimulatorObserver methods
	// ...
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {
		_bodies = bodies;
		fireTableStructureChanged();
		
	}
	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		_bodies = bodies;
		fireTableStructureChanged();
		
	}
	@Override
	public void onAdvance(List<Body> bodies, double time) {
		_bodies = bodies;
		fireTableStructureChanged();
		
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
