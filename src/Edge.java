import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Edge {
	
	private ArrayList<Coordinate> points;
	
	public Edge() {
		points = new ArrayList<Coordinate>();
	}
	
	public Edge(ArrayList<Coordinate> points) {
		this.points = new ArrayList<Coordinate>();
		for(int i = 0; i < points.size(); i++) {
			this.points.add(points.get((i)));
		}
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		for(int i = 0; i < points.size()-1; i++) {
			Coordinate p1 = points.get(i);
			Coordinate p2 = points.get(i+1);
			g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}
	
	public boolean contains(Coordinate p) {
		 for(int i = 0; i < points.size(); i++) {
			 if(p.equals(points.get(i)))
				 return true;
			 
		 }
		 
		 return false;
	}
	public ArrayList<Coordinate> getPoints() {
		return points;
	}
	
	
}
