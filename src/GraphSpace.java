import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphSpace {
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Graph View");
		GraphView mainPanel = new GraphView();
		SidePanel sidePanel = new SidePanel();
		GraphController listener = new GraphController(mainPanel, sidePanel);
		JPanel content = new JPanel();
		
		content.setLayout(new BorderLayout());
		content.add(sidePanel, BorderLayout.EAST);
		content.add(mainPanel, BorderLayout.CENTER);
		window.setContentPane(content);
		
		
		window.setSize(700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		mainPanel.requestFocusInWindow();
	}
}
