package package1;

import java.util.Random;

import shapes.IShape;
import shapes.Lshape;
import shapes.MyShape;
import shapes.NShape;
import shapes.OShape;
import shapes.Shape;
import shapes.TShape;
public class ShapeFactory {
	public static Shape cShape() {
		Random rand = new Random();
		int i = rand.nextInt(7);
		Shape shape = null;
		if (i == 0) {
			shape = new Lshape(true);
		} else if (i == 1) {
			shape = new OShape();
		} else if (i == 2) {
			shape = new NShape(true);
		} else if (i == 3) {
			shape = new TShape();
		} else if (i == 4) {
			shape = new IShape();
		}else if(i==5) {
			shape = new Lshape(false);
		}else if(i==6) {
			shape = new NShape(false);
		}
		//else if(i==7) {
			//shape = new MyShape();
		//}
		return shape;
	}
	public static Shape iShape() {
		return new IShape();
	}
}
