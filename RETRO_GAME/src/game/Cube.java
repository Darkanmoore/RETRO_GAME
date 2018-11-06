package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Cube {
	
	private int x, y, w, h;
//	final static float dash1[] = {5.0f};
//    final static BasicStroke dashed =
//        new BasicStroke(1.0f,
//                        BasicStroke.CAP_BUTT,
//                        BasicStroke.JOIN_MITER,
//                        10.0f, dash1, 0.0f);

	
	public Cube(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void draw(java.awt.Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D.Double cube = new Rectangle2D.Double(x,y,w,h);
		g2d.setColor(Color.RED);
//		g2d.setStroke(dashed);
		g2d.fill(cube);
	}

}
