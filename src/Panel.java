import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener,MouseWheelListener {

	private static final long serialVersionUID = 1L;
public static double plusx,plusy,plusx1,plusy1;
public static boolean move=false;
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1600, 900);
		
		TeloCollection.paint(g);
		TeloCollection.update();
		repaint();
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		plusx1 =e.getX();
		plusy1=e.getY();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		plusx=e.getX()-plusx1;
		plusy=e.getY()-plusy1;
		if(e.getButton()==1) {
			TeloCollection.move(plusx, plusy);
			plusx=0;
			plusx1=0;
			plusy=0;
			plusy1=0;
		}
		if(e.getButton()==3) {
			TeloCollection.move(plusx*10, plusy*10);
			plusx=0;
			plusx1=0;
			plusy=0;
			plusy1=0;
		}
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	//System.out.println(e.getWheelRotation());
	
	
	//TeloCollection.resize(e.getWheelRotation()*-10, e.getX(), e.getY());
	}
	
}
