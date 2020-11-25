import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GraphController implements MouseListener, MouseMotionListener,
	ChangeListener, ActionListener {
	
	GraphView panel;
	SidePanel buttons;
	
	private static boolean dragging;
	private static int prevX, prevY;
	private String currentObject = "vertex";
	private Vertex currentVertex;
	private Edge currentEdge;
	private ArrayList<Coordinate> currentPoints;
	
	public GraphController(GraphView panel, SidePanel buttons) {
		this.buttons = buttons;
		buttons.getVertex().addChangeListener(this);
		buttons.getEdge().addChangeListener(this);
		buttons.getRemove().addChangeListener(this);
		
		this.panel = panel;
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	public void stateChanged(ChangeEvent e) {
		JButton source = (JButton) e.getSource();
		if(source.getModel().isPressed()) {
			if(source.getText().equals("Vertex")) {
				currentObject = "vertex";
			}
			else if (source.getText().equals("Edge")) {
				currentPoints = new ArrayList<Coordinate>();
				currentObject = "edge";
			}
			else if (source.getText().equals("Remove")) {
				currentObject = "remove";
			}
		
			
			System.out.println(currentObject);
			panel.repaint();
		}
		
	}

	
	public void mouseDragged(MouseEvent e) {
		
		if(currentObject.equals("edge") && dragging) {
			currentPoints.add(new Coordinate(e.getX(),e.getY()));
		}
		else if(currentObject.equals("vertex") && dragging) {
			if((currentVertex = panel.findVertex(e.getX(), e.getY())) != null) {
				currentVertex.setX(e.getX());
				currentVertex.setY(e.getY());
				currentVertex.setSelected(true);
				panel.repaint();
			}
		}
		else if(currentObject.equals("remove") && dragging) {
			Coordinate currCoord = new Coordinate(e.getX(), e.getY());
			if (panel.findEdge(currCoord) != null) {
				panel.getEdges().remove(panel.findEdge(currCoord));
				System.out.println("Edge Removed: (" + currCoord);
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
		panel.requestFocusInWindow();
	}

	public void mouseClicked(MouseEvent e) {
		
		
	}

	public void mousePressed(MouseEvent e) {
		dragging = true;
		prevX = e.getX();
		prevY = e.getY();
		int currX = e.getX();
		int currY = e.getY(); 
		if(currentObject.equals("vertex")) {
			if(panel.findVertex(currX, currY) == null) {
				panel.getVerticies().add(new Vertex(currX, currY));
				System.out.println("Vertex Coordinates: (" + currX + "," + currY + ")");
			}
			
		}
		else if (currentObject.equals("remove")) {
			if(panel.findVertex(currX, currY) != null) {
				panel.getVerticies().remove(panel.findVertex(currX, currY)); //replace with try-catch later
				System.out.println("Vertex Removed: (" + currX + "," + currY + ")");
			}
			
		}
		panel.repaint();
	}

	public void mouseReleased(MouseEvent e) {
		dragging = false;

		if(currentObject.equals("edge")) {
			panel.getEdges().add(new Edge(currentPoints));
			currentPoints = new ArrayList<Coordinate>();

		}
	
		
		if(currentVertex != null) {
			currentVertex.setSelected(false);
		}
		panel.repaint();

	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	

}
