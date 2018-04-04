package shapes;

public class IShape extends Shape{
	public IShape() {
		int[][] value= {
				{0,0,0,0,0,0},
				{0,0,1,0,0,0},
				{0,0,1,0,0,0},
				{0,0,1,0,0,0},
				{0,0,1,0,0,0},
				{0,0,0,0,0,0},
				};
		super.value=value;
		xuanzX=2;
		xuanzY=2;
	}
	@Override
	public void xuanZhuan() {
		super.xuanZhuan();
	}
}
