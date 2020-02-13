import java.awt.Graphics;
import java.util.ArrayList;

public class TeloCollection {
public static double G=0.0667/10,vyo,vxo;
public static boolean sled =true;
public static int minSize,maxSize;
	static ArrayList<Telo> l = new ArrayList<Telo>();
	static ArrayList<Traectory> tr= new ArrayList<Traectory>();
	private static int[] m =	{200    ,10     ,10     ,20       };
	private static int[] x =	{600 ,700    ,400   ,900    };
	private static int[] y =	{500  ,500    ,500    ,500  };
	private static double[] vx ={0,0  ,0 ,0,0 };
	private static double[] vy ={0,-0.05,0.04,-0.03  };
	static {
		//Telo solnce = new Telo(20000000,-40000000,0, 0, 0,Color.YELLOW);
		//l.add(solnce);
		//Telo merkuriy = new Telo(3, 1300, 500, -0.005, -0.06,Color.DARK_GRAY);
		//l.add(merkuriy);
		for(int i =0;i<m.length;i++){
			Telo t = new Telo(m[i],x[i],y[i],vx[i],vy[i]);
			if(minSize>m[i]){
				minSize=m[i];
			}else if(maxSize<m[i]){
				maxSize=m[i];
			}
			l.add(t);
			tr.add(l.get(i).t);
		}

		//Telo o = new Telo(3, 2500, 500, -0.005, -0.04,Color.red);
		//l.add(o);
		//Telo ì = new Telo(30, 2000000000, 500000000, 0, 0,Color.GREEN);
		//l.add(ì);
	}
	
	public static void paint(Graphics g) {
		for(int i = 0;i<l.size();i++) {
			l.get(i).draw(g);
		}
	}
	public static void update() {
		for(int i = 0;i<l.size();i++) {

			for(int e = 0;e<l.size();e++) {
				if(i!=e) {
					if(Math.sqrt((l.get(i).x-l.get(e).x)*(l.get(i).x-l.get(e).x)+
							(l.get(i).y-l.get(e).y)*(l.get(i).y-l.get(e).y))
							<=l.get(i).Size /2+l.get(e).Size /2) {
						if(l.get(i).Size >=l.get(e).Size) {
							l.get(i).vx+=l.get(e).m *l.get(e).vx/l.get(i).m;
							l.get(i).vy+=l.get(e).m *l.get(e).vy/l.get(i).m;
							l.get(i).m+=l.get(e).m;
							if(l.get(i).m>maxSize){
								maxSize=l.get(i).m;
							}
							l.remove(e);
						}else {
							l.get(e).vx+=l.get(i).m *l.get(i).vx/l.get(e).m;
							l.get(e).vy+=l.get(i).m *l.get(i).vy/l.get(e).m;
							l.get(i).m+=l.get(e).m;
							l.remove(i);
						}
							i=0;
							e=0;

					}else {
						vyo=-(G*
								l.get(e).m *
											(l.get(i).y-l.get(e).y))/
								((-l.get(i).y+l.get(e).y)*(-l.get(i).y+l.get(e).y)
										+(-l.get(i).x+l.get(e).x)*(-l.get(i).x+l.get(e).x))
								/Math.sqrt(((l.get(i).y-l.get(e).y)*(l.get(i).y-l.get(e).y)+(l.get(i).x-l.get(e).x)*(l.get(i).x-l.get(e).x)));
						vxo=-(G*
								l.get(e).m *
											(l.get(i).x-l.get(e).x))/
								((-l.get(i).y+l.get(e).y)*(-l.get(i).y+l.get(e).y)+(-l.get(i).x+l.get(e).x)*(-l.get(i).x+l.get(e).x))
								/Math.sqrt(((l.get(i).y-l.get(e).y)*(l.get(i).y-l.get(e).y)+(l.get(i).x-l.get(e).x)*(l.get(i).x-l.get(e).x)));
						l.get(i).vx+=vxo;
						l.get(i).vy+=vyo;
					}
				}
				l.get(i).update();
			}
		}
		
	}
	
	
	public static void move(double mx,double my){
		for(int i = 0;i<l.size();i++) {
			l.get(i).x+=mx;
			l.get(i).y+=my;
			for(int e = 0;e<l.get(i).t.l.size();e++) {
			l.get(i).t.l.get(e).translate((int)mx,(int) my);
		}
	}
	
	
	}
	
	public static void resize(int r,double mx,double my) {
		if(r>0) {
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).Size > 10) {
					l.get(i).Size/=2;
					l.get(i).x/=2;
					l.get(i).y/=2;
					l.get(i).vx/=2;
					l.get(i).vy/=2;
					Panel.transX+=mx;
					Panel.transY+=my;
				}
			}
		}
	}



}