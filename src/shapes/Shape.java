package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import package1.Box;
import package1.Something;
import package1.*;
public class Shape implements KeyListener{
	public int xuanzX, xuanzY, downv = 500;
	public int[][] value;
	public int pointx = 2, pointy = -3;// 起始点
	Box box;
	private Color colorPen=ColorFactory.colorfactory();
	public Shape() {
		box = Box.getInstance();
	}
	public void init() {
		pointx = 2;
		pointy = -3;
	}
	/**
	 * 计算窗口在屏幕中实际位置 坐标（ 位置点+shape方块坐标） * pixel + 窗口起点坐标
	 * 
	 * @param x
	 *            位置点横坐标
	 * @param y
	 *            位置点纵坐标
	 * @param c
	 *            shape每个小方块横坐标
	 * @param b
	 *            shape每个小方块纵坐标
	 * @param z
	 *            大小图形 =true 大
	 * @return 在屏幕中实际位置
	 */
	private int[] getWindowPoint(int x, int y, int c, int b, boolean z) {
		if (z) {
			int a[] = { (x + c) * Something.PIXEL + Something.GAMEX, (y + b) * Something.PIXEL + Something.GAMEY };
			return a;
		} else {
			int a[] = { (x + c) * Something.PIXEL + Something.SMALLX, (y + b) * Something.PIXEL + Something.SMALLY };
			return a;
		}
	}

	/**
	 * 碰撞检测,旋转前检查
	 * 
	 * @param a，b
	 *            位置点横纵坐标 tt 旋转后shape坐标
	 * @return hit true
	 */
	private boolean hitIsxz(int a, int b, int[][] tt) {
		for (int i = 0; i < tt.length; i++) {
			for (int j = 0; j < tt[i].length; j++) {
				if (tt[i][j] == 1) {
					if (i + a < 0 || i + a > 9 || j + b < 0 || j + b > 19) {
						return true;
					}
					if (box.box[i + a][j + b] == 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 左右移动
	 * 
	 * @param i
	 *            左右
	 */
	private void move(int i) {
		int x = pointx;
		int y = pointy;
		if (i == 0) {
			x = x - 1;
		} else if (i == 1) {
			x = x + 1;
		}
		if (!hitIsxz(x, y, value)) {
			pointx = x;
		}
	}

	/**
	 * 绘画 同步
	 * 
	 * @param pen
	 */
	public void display(Graphics pen) {
		pen.setColor(colorPen);
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value[i].length; j++) {
				if (value[i][j] == 1) {
					pen.fillOval(getWindowPoint(pointx, pointy, i, j, true)[0],
							getWindowPoint(pointx, pointy, i, j, true)[1], Something.PIXEL, Something.PIXEL);
						
				}
			}
		}

	}

	/**
	 * 绘制小的
	 * 
	 * @param pen
	 */
	public void displaySmall(Graphics pen) {
		pen.setColor(colorPen);
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value[i].length; j++) {
				if (value[i][j] == 1) {
					pen.fillOval(getWindowPoint(0, 0, i, j, false)[0], getWindowPoint(0, 0, i, j, false)[1],
							Something.PIXEL, Something.PIXEL);
				}
			}
		}

	}
	/**
	 * 旋转
	 */
	public void xuanZhuan() {
		int[][] temp = new int[value.length][value[0].length];
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value[i].length; j++) {
				if (value[i][j] == 1) {
					temp[j - xuanzY + xuanzX][xuanzX - i + xuanzY] = 1;
				}
			}
		}
		if (!hitIsxz(pointx, pointy, temp)) {
			for (int k = 0; k < value.length; k++) {
				System.arraycopy(temp[k], 0, value[k], 0, value[k].length);
			}
		}
	};
	/**
	 * 下降
	 */
	public void down() {
		pointy += 1;
	}
	/**
	 * 下落完成加入盒子
	 */
	public void addShapeForBox() {
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value[i].length; j++) {
				if (value[i][j] == 1) {
					box.box[i + pointx][j + pointy] = 1;
				}
			}
		}
	}
	public void copy(Shape shape2) {
		pointx = shape2.pointx;
		pointy = shape2.pointy;
		xuanzX=shape2.xuanzX;
		xuanzY=shape2.xuanzY;
		value=shape2.value;
		colorPen=shape2.colorPen;
	}
	/**
	 * 下落碰撞检测
	 * 
	 * @return 碰撞 true
	 */
	public boolean hitIsDown() {
		if(pointy<0) return false;
		for (int j = 0; j < value.length; j++) {
			for (int i = value[j].length - 1; i > -1; i--) {
				if (value[j][i] == 1) {
					if ((pointy + i + 1) == 20) {
						return true;
					}
					if (box.box[pointx + j][pointy + i + 1] == 1) {
						return true;
					} else
						break;
				}
			}
		}
		return false;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downv = 70;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			move(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			move(1);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(value.length!=2)
			xuanZhuan();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downv = 500;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
