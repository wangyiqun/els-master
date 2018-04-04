package package1;
import javax.swing.JOptionPane;
import shapes.Shape;
public class FlowControll implements Runnable {
	Shape shape1, shape2;
	Shape shapeTemp;
	boolean thredWait=false;
	private int i=0;
	Thread thread=new Thread(this);
	public FlowControll(Shape s,Shape d) {
		shape1 = s;
		shape2 = d;
	}
	public void start() {
		thread.setName("fc");
		if(!thread.isAlive())
			{
				thread.start();
			}
	}
	public void pause(){
		thredWait=true;
	}
	public synchronized void continue1(){
		thredWait=false;
		this.notify();
	}
	@Override
	public void run() {
		while (!Box.getInstance().deadIs()) {
			i++;
			synchronized (this){
				if(thredWait){
				try {
				this.wait();
				} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			}
			if (!shape1.hitIsDown()) {
				shape1.down();
			} else {
				shape1.addShapeForBox();
				Box.getInstance().xiaoChu();
				synchronized (Shape.class) {
					shape1.copy(shape2);
					if(i==5){
						shape2.copy(ShapeFactory.iShape());
						i=0;
					}else{
						shape2.copy(ShapeFactory.cShape());
					}
				}
			}
			try {
				Thread.sleep(shape1.downv);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Game Over");
	}
}
