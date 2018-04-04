package package1;

import java.awt.Color;
import java.util.Random;

public class ColorFactory {
	public static Color colorfactory() {
		Color[] cs= {Color.blue,Color.ORANGE,Color.red,Color.pink,Color.darkGray};
		return cs[new Random().nextInt(cs.length)];
	}

}
