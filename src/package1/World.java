package package1;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import shapes.Shape;
public class World {
	JFrame frame;
	private JButton button;
	private JButton stop;
	private Draw draw;
	private FlowControll fc;
	private Shape shape;
	public World(Draw draw,FlowControll fc,Shape shape) {
		this.draw=draw;
		this.fc=fc;
		this.shape=shape;
		frame = new JFrame("俄罗斯方块");
		frame.setBounds(Something.WINDOWX, Something.WINDOWY, Something.WIDTHs,
		 Something.HEIGHTs);
		
		initButton();
		initStop();
		draw.add(button);
		draw.add(stop);
		frame.add(draw);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private void initButton() {
		button=new JButton("开始游戏");
		button.setBounds(Something.SMALLX, Something.SMALLY+Something.SMALLHEIGHT, 40, 10);
		button.setBackground(Color.MAGENTA);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			 	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Box.getInstance().init();
				shape.init();
				GetScore.score=0;
				fc.start();
				draw.requestFocus(true);
			}
		});
	}
	private void initStop() {
		stop=new JButton("暂停");
		stop.setBackground(Color.yellow);
		stop.setBounds(Something.SMALLX, Something.SMALLY+Something.SMALLHEIGHT+60, 40, 10);
		stop.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				stop.setBackground(Color.yellow);
				fc.continue1();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			 	stop.setBackground(Color.green);
				fc.pause();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
