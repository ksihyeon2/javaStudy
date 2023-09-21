package SwingEx1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test2 extends JFrame{
	private JPanel pn1;
	
	public Test2() {
		setTitle("연습");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Test2 t2 = new Test2();
				t2.setVisible(true);
			}
		});
	}
}
