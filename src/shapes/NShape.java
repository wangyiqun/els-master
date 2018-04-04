package shapes;

public class NShape extends Shape {
	public NShape(boolean lr) {
		if (lr) {
			int[][] value = { 	{ 0, 1, 0 }, 
								{ 0, 1, 1 }, 
								{ 0, 0, 1 } };
			super.value = value;
		} else {
			int[][] value = { 	{ 0, 1, 0 }, 
								{ 1, 1, 0 }, 
								{ 1, 0, 0 } };
			super.value = value;
		}
		
		xuanzX = 1;
		xuanzY = 1;
	}
}
