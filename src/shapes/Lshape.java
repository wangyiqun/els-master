package shapes;

public class Lshape extends Shape{
	public Lshape(boolean lr) {
		if (lr) {
		int[][] value= {
				{0,1,0},
				{0,1,0},
				{0,1,1},
				};
		super.value=value;
		}else {
			int[][] value= {
					{0,1,0},
					{0,1,0},
					{1,1,0},
					};
			super.value=value;
		}
		super.xuanzX=1;
		super.xuanzY=1;
	}
}
