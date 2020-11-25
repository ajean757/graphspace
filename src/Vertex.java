import java.awt.Color;
import java.awt.Graphics;

public class Vertex {
	
	private int x;
	private int y;
	private int degree;
	private boolean isSelected;
	
	public static final int RADIUS = 25;
	
	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
		this.degree = 0;
		this.isSelected = false;
	}
	
	public void draw(Graphics g) {
		if(isSelected) {
			//draws larger circle with +3 highlight radius
			g.setColor(Color.CYAN);
			g.fillOval((x-28), (y-28), (RADIUS + 3) * 2, (RADIUS + 3) * 2);
			g.setColor(Color.black);
			g.fillOval((x-25), (y-25), (RADIUS * 2), (RADIUS * 2));
	
		}
		else {
			g.setColor(Color.black);
			g.fillOval((x-25), (y-25), (RADIUS * 2), (RADIUS * 2));
		}
		
		g.drawString(""+degree, (x-25), (y-25));
	
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y =y;
	}
	
	public void setDegree(int degree) {
		this.degree = degree;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public boolean contains(int currX, int currY) {
		double xrel = Math.abs(x - currX);
		double yrel = Math.abs(y - currY);
		
		double bound = (xrel * xrel) + (yrel * yrel);
		
		return bound <= (RADIUS * RADIUS);
	

	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
