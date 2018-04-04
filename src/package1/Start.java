package package1;

import java.awt.Color;

import shapes.Shape;

public class Start {
	public static void main(String[] args) {
		Shape shape1=ShapeFactory.cShape();
		Shape shape2=ShapeFactory.cShape();
		FlowControll fl = new FlowControll(shape1,shape2);
		Draw aDraw = new Draw(shape1, shape2);
		aDraw.addKeyListener(shape1);
		aDraw.setBackground(Color.white);
		new World(aDraw,fl,shape1);
		new Flashscreen(aDraw);

	}

}
