import java.awt.*;
import java.util.ArrayList;

public class Traectory {
    public ArrayList<Point> l =new ArrayList<>();
    Traectory(Point p){

    }
    public void draw(Graphics g,Color c){
        g.setColor(c);
        for(int i = 1; i< l.size(); i++) {
            g.drawLine(l.get(i-1).x, l.get(i-1).y, l.get(i).x, l.get(i).y);
        }
    }
    public void add(Point p){
        l.add(p);
    }
}
