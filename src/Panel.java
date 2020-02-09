import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener,MouseMotionListener,MouseWheelListener, KeyListener {

	private static final long serialVersionUID = 1L;
private static double plusx,plusy,plusx1,plusy1;
private static boolean StoppedTime=false;
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1600, 900);
		TeloCollection.paint(g);
		if(!StoppedTime){
			TeloCollection.update();
		}
		Crs.pointer(g);
		repaint();
		}


	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) { }
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

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==' '){
			StoppedTime=!StoppedTime;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Crs.mX= e.getX();
		Crs.mY=e.getY();
	}
}
