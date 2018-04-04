package package1;

import java.awt.Color;
import java.awt.Graphics;

public class Box {
	public int[][] box = new int[10][20];
	private Box() {
		
	}
	public void init() {
		box = new int[10][20];
	}
	public boolean deadIs() {
		for(int i=0;i<box.length;i++) {
			if(box[i][0]==1) {
				return true;
			}
		}
		return  false;
	}
	public void draw(Graphics pen) {
		pen.setColor(Color.green);
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] == 1) {
					pen.fillOval(i * Something.PIXEL + Something.GAMEX, 
							j * Something.PIXEL + Something.GAMEY, 
							Something.PIXEL,Something.PIXEL);
				}
			}
		}
	}
	public static Box getInstance() {
		return InnerBox.aBox;
	};
	private static class InnerBox {
		private static Box aBox = new Box();
	}
	private void pingYi(int num,int start){
		for(int i=start;i<-1;i--){
			for(int j=0;j<box.length;j++){
				box[j][i]=box[j][i-num];
			}
		}
		
	}
	/**
	 * 消除组成的一行
	 * 00
	 * 01
	 * 02
	 */
	public void xiaoChu() {
		int temp = 0;// 求每行的和
		int temp2 = 0;// 不许消除的行向下平移多少位
		int score=0;//消除了多少行
		for (int j = 19; j > -1; j--) {
			temp = 0;
			for (int i = 0; i < box.length; i++) {
				temp += box[i][j];
			}
			if(temp!=10){
				if(temp2==0&&temp==0){
					break;
				}
				if(temp2!=0){
					// 平移
					for (int k = j; k > -1; k--) {
						for (int ii = 0; ii < box.length; ii++) {
							box[ii][k + temp2] = box[ii][k];
						}
					}
					score+=temp2;
					temp2 = 0;// 初始化
					j = 0;
				}
			}else {
				temp2 += 1;// 需要消除的行加一
			}
		}
		GetScore.setScore(score);
	}
}
