import javax.swing.JFrame;

public class Prog {
public static int width=1600,height=900;
	public static void main(String[] args) {
		JFrame w = new JFrame();
		w.setSize(width,height);
		//w.setResizable(false);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		w.add(p, 0);
		w.setAlwaysOnTop(true);
		w.addMouseListener(p);
		w.setAlwaysOnTop(true);
		w.addMouseWheelListener(p);
		w.setResizable(false);
		w.setVisible(true);
	}

}
