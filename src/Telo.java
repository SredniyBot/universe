import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class Telo {
	public int m;
	public int Size=10;
	public double vx,vy,x,y;
	public static boolean sled =true;
	public static long millis;
	Traectory t;
	public RoundRectangle2D.Double rect;
Telo(int m,double x,double y,double vx,double vy){
	Point p = new Point((int)x,(int)y);
	t =new Traectory(p);
	this.x=x;
	this.y=y;
	this.vx=vx;
	this.m=m;
	this.vy=vy;
	rect=new RoundRectangle2D.Double(x,y,Size,Size,Size,Size);
}

public void update() {
	x+=vx;
	y+=vy;
	rect.setRoundRect(x,y,Size,Size,Size,Size);
}

public void draw(Graphics g) {
	g.setColor(c(m));
	if(sled) {
		if(System.currentTimeMillis()%10==0) {
			t.add(new Point((int)x,(int)y));
		}
		t.draw(g,c(m));
	}
	g.fillOval((int)(x- Size /2), (int)(y- Size /2), Size, Size);
	if(x+ Size <0&&y+ Size <0) {
		g.fillRect(0, 0, 10, 10);
	}else if(x- Size >Prog.width&&y- Size >Prog.height) {
		g.fillRect(Prog.width-25, Prog.height-50, 30, 50);
	}else if(x- Size >Prog.width&&y+ Size <0) {
		g.fillRect(Prog.width-25,0, 30, 10);
	}else if(x+ Size <0&&y- Size >Prog.height) {
		g.fillRect(0, Prog.height-50, 10, 50);
	}else if(x+ Size <0) {
		g.fillRect(0, (int)y, 10, 1);
	}else if(y+ Size <0) {
		g.fillRect((int)x, 0, 1, 10);
	}else if(x- Size >Prog.width) {
		g.fillRect(Prog.width-40,(int)y, 30, 1);	
	}else if(y- Size >Prog.height) {
		g.fillRect((int)x,  Prog.height-50, 1, 50);
	}
}

	private static Color c(int Size){
		return  new Color((Size-TeloCollection.minSize)*255/(TeloCollection.maxSize-TeloCollection.minSize),
				255-(Size-TeloCollection.minSize)*255/(TeloCollection.maxSize-TeloCollection.minSize),0);//Arduino map
	}


}
