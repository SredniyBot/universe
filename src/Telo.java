import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.sql.Date;
import java.util.ArrayList;

public class Telo {
	public int m;
	public double vx,vy,x,y;
	public Color c;
	public static boolean sled =true;
	public static long millis;
	public ArrayList<Point> t=new ArrayList<>();
Telo(int m,double x,double y,double vx,double vy,Color c){
	Point p = new Point((int)x,(int)y);
	t.add(p);
	this.x=x;
	this.y=y;
	this.vx=vx;
	this.m=m;
	this.vy=vy;
	this.c=c;
}

public void update() {
	
	x+=vx;
	y+=vy;
}

public void draw(Graphics g) {
	g.setColor(c);
	if(sled) {
		if(System.currentTimeMillis()%10==0) {
			Point p = new Point((int)x,(int)y);
			t.add(p);
		}
		for(int i = 1;i<t.size();i++) {
			g.drawLine(t.get(i-1).x, t.get(i-1).y, t.get(i).x, t.get(i).y);
		}
	}
	g.fillOval((int)(x-m/2), (int)(y-m/2), m, m);
	if(x+m<0&&y+m<0) {
		g.fillRect(0, 0, 10, 10);
	}else if(x-m>Prog.width&&y-m>Prog.height) {
		g.fillRect(Prog.width-25, Prog.height-50, 30, 50);
	}else if(x-m>Prog.width&&y+m<0) {
		g.fillRect(Prog.width-25,0, 30, 10);
	}else if(x+m<0&&y-m>Prog.height) {
		g.fillRect(0, Prog.height-50, 10, 50);
	}else if(x+m<0) {
		g.fillRect(0, (int)y, 10, 1);
	}else if(y+m<0) {
		g.fillRect((int)x, 0, 1, 10);
	}else if(x-m>Prog.width) {
		g.fillRect(Prog.width-40,(int)y, 30, 1);	
	}else if(y-m>Prog.height) {
		g.fillRect((int)x,  Prog.height-50, 1, 50);
	}
	
	
	
}
}
