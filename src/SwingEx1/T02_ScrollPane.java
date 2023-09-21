package SwingEx1;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_ScrollPane extends JFrame{
	private JLabel lblImage;
	private JScrollPane scrollPane;
	
	public T02_ScrollPane() {
		setTitle("ScrollPane 연습");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		add(getScrollPane(), BorderLayout.CENTER);
	}
	
	private JScrollPane getScrollPane() {
		scrollPane = new JScrollPane(getLblImage());    // JscrollPane에 그림을 포함하고 있는 Label을 올려준다.
		return scrollPane;
	}

//	JLabel 생성 (JLabel 생성과 동시에 그림 넣기)
	private JLabel getLblImage() {
		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon(getClass().getResource("./images/흑.png")));
		return lblImage;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T02_ScrollPane t02 = new T02_ScrollPane();
				t02.setVisible(true);
			}
		});
	}
}
