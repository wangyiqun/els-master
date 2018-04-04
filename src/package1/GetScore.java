package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GetScore {
	public static volatile int score=0;
	public static void setScore(int score) {
		if(score<1){
			return;
		}
		GetScore.score += score+(score-1);
	}
	public static void display(Graphics p) {
		
		p.setColor(Color.green);
		p.setFont(new Font(null, 2, 20));
		p.drawString("your score:"+score, 20, 60);
	}
}
