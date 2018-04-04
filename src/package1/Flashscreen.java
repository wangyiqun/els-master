package package1;

import javax.swing.JPanel;

public class Flashscreen  implements Runnable{
	JPanel panel;
	public Flashscreen(JPanel panel) {
		this.panel=panel;
		Thread a=new Thread(this);
		a.setName("flashscreen");
		a.start();
	}
	@Override
	public void run() {
		while(true) {
			panel.repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}
