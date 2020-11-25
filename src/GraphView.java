import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GraphView extends JPanel {
	
	
	private static final long serialVersionUID = 5923359125919559944L;
	
	private static ArrayList<Vertex> verticies = new ArrayList<Vertex>();
	private static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public GraphView() {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < edges.size(); i++) {
			edges.get(i).draw(g);
		}
		for(int i = 0; i < verticies.size(); i++) {
			verticies.get(i).draw(g);
		}
	}
	
	public ArrayList<Vertex> getVerticies() {
		return verticies;
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public Edge findEdge(Coordinate p) {
		for(int i = 0; i < edges.size(); i++) {
			if(edges.get(i).contains(p))
				return edges.get(i);
		}
		
		return null;
	}
	
	public Vertex findVertex(int x, int y) {
		for(int i = 0; i < verticies.size(); i++) {
			if(verticies.get(i).contains(x, y)) 
				return verticies.get(i);
		}
		
		return null;
	}
}
