import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SidePanel extends JPanel {
	
	private static final long serialVersionUID = 2701381741751403138L;
	private JButton vertex = new JButton("Vertex");
	private JButton edge = new JButton("Edge");
	private JButton remove = new JButton("Remove");
	
	public SidePanel() {
		this.setLayout(new GridLayout(3, 1));
		this.add(vertex, 0);
		this.add(edge, 1);
		this.add(remove, 2);
	}
	
	public JButton getVertex() {
		return vertex;
	}
	
	public JButton getEdge() {
		return edge;
	}
	
	public JButton getRemove() {
		return remove;
	}

}
