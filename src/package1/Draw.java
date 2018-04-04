package package1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import shapes.Shape;

public class Draw extends JPanel {
	Shape shape, shape2;

	public Draw(Shape shape, Shape shape2) {
		this.shape = shape;
		this.shape2 = shape2;
	
	}

	@Override
	public void paint(Graphics pen) {
		super.paint(pen);
		/*
		 * for(int i=0;i<20;i++) { pen.drawLine(Something.WINDOWX,
		 * Something.WINDOWY+i*30, Something.WINDOWX+Something.WINDOWWIDTH,
		 * Something.WINDOWY+i*30); } for(int i=0;i<10;i++) {
		 * pen.drawLine(Something.WINDOWX+i*30, Something.WINDOWY,
		 * Something.WINDOWX+i*30, Something.WINDOWY+Something.WINDOWHEIGHT); }
		 */
		pen.setColor(Color.black);
		pen.drawRect(Something.SMALLX, Something.SMALLY, Something.SMALLWIDTH, Something.SMALLHEIGHT);// 小窗口
		pen.drawRect(Something.GAMEX, Something.GAMEY, Something.WINDOWWIDTH, Something.WINDOWHEIGHT);// 大窗口
		synchronized (Shape.class) {
			shape.display(pen);
			shape2.displaySmall(pen);
		}

		Box.getInstance().draw(pen);
		GetScore.display(pen);
	}

}
