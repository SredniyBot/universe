import javax.swing.*;
import java.awt.*;

public class Crs {
    public static int mX,mY;

    public static void pointer(Graphics g){

        Graphics2D g1 = (Graphics2D)g.create();
        g1.setColor(Color.BLUE);
        g1.fillOval(mX-10,mY-32,5,5);
        g1.setColor(Color.WHITE);
        g1.drawString(getIntersection(),mX,mY+30);
        g1.dispose();
    }
    private static String getIntersection(){
        String s="";
        for(int i=0;i<TeloCollection.l.size();i++ ){
            Telo l= TeloCollection.l.get(i);
            if(l.x-l.Size/2<mX-10&&l.y-l.Size/2<mY-32&&l.x+l.Size/2>mX-10&&l.y+l.Size/2>mY-32){
                s="Mass="+TeloCollection.l.get(i).m;
            }
        }
        return s;
    }
}
