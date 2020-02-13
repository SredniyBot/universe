import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class Telo {
	public int m;
	public int Size=10;
	public double vx,vy,x,y;

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
	int w=Panel.width();
	int h=Panel.height();
	g.setColor(c(m));
	if(System.currentTimeMillis()%10==0) {
		t.add(new Point((int)x,(int)y));
	}
	if(TeloCollection.sled) {
		t.draw(g,c(m));
	}
	g.fillOval((int)(x- Size /2), (int)(y- Size /2), Size, Size);
	if(x+ Size+Panel.transX <0&&y+ Size+Panel.transY <0) {
		g.fillRect(-Panel.transX, -Panel.transY, 10, 10);
	}else if(x- Size >w&&y- Size >h) {
		g.fillRect(w-25, h-50, 30, 50);
	}else if(x- Size >w&&y+ Size+Panel.transY <0) {
		g.fillRect(w-25,-Panel.transY, 30, 10);
	}else if(x+ Size+Panel.transX <0&&y- Size >h) {
		g.fillRect(-Panel.transX, h-50, 10, 50);
	}else if(x+ Size+Panel.transX <0) {
		g.fillRect(-Panel.transX, (int)y, 10, 1);
	}else if(y+ Size+Panel.transY <0) {
		g.fillRect((int)x, -Panel.transY, 1, 10);
	}else if(x- Size >w) {
		g.fillRect(w-40,(int)y, 30, 1);
	}else if(y- Size >h) {
		g.fillRect((int)x,  h-50, 1, 50);
	}
}

	private static Color c(int Size){
		return  new Color((Size-TeloCollection.minSize)*255/(TeloCollection.maxSize-TeloCollection.minSize),
				255-(Size-TeloCollection.minSize)*255/(TeloCollection.maxSize-TeloCollection.minSize),0);//Arduino map
	}


}
