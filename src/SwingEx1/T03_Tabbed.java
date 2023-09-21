package SwingEx1;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_Tabbed extends JFrame{
	private JTabbedPane tabbedPane;
	private JPanel pnTab1, pnTab2, pnTab3, pnTab4, pnTab5;
	
	public T03_Tabbed() {
		setTitle("TabButton 연습");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);    // 크기 고정
		
		add(getTabbedPane(), BorderLayout.CENTER);
	}
	
	private JTabbedPane getTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.addTab("탭1", getPnTab1());     // (이름, Panel)
		tabbedPane.addTab("탭2", getPnTab2());     // (이름, Panel)
		tabbedPane.addTab("탭3", getPnTab3());     // (이름, Panel)
		tabbedPane.addTab("탭4", getPnTab4());     // (이름, Panel)
		tabbedPane.addTab("탭5", getPnTab5());     // (이름, Panel)
		return tabbedPane;
	}

	private JPanel getPnTab5() {
		pnTab5 = new JPanel();
		JLabel lblImg = new JLabel();    // 해당 메소드에서만 사용 후 버리기 위해서 여기다가 생성함
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/흑흑흑흑흑.jpeg")));
		pnTab5.add(lblImg);
		return pnTab5;
	}
	
	private JPanel getPnTab4() {
		pnTab4 = new JPanel();
		JLabel lblImg = new JLabel();    // 해당 메소드에서만 사용 후 버리기 위해서 여기다가 생성함
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/흑흑흑흑.png")));
		pnTab4.add(lblImg);
		return pnTab4;
	}
	
	private JPanel getPnTab3() {
		pnTab3 = new JPanel();
		JLabel lblImg = new JLabel();    // 해당 메소드에서만 사용 후 버리기 위해서 여기다가 생성함
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/흑흑흑.jpg")));
		pnTab3.add(lblImg);
		return pnTab3;
	}
	
	private JPanel getPnTab2() {
		pnTab2 = new JPanel();
		JLabel lblImg = new JLabel();    // 해당 메소드에서만 사용 후 버리기 위해서 여기다가 생성함
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/흑흑.jpeg")));
		pnTab2.add(lblImg);
		return pnTab2;
	}

	private JPanel getPnTab1() {
		pnTab1 = new JPanel();
		JLabel lblImg = new JLabel();    // 해당 메소드에서만 사용 후 버리기 위해서 여기다가 생성함
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/흑.png")));
		pnTab1.add(lblImg);
		return pnTab1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T03_Tabbed t03 = new T03_Tabbed();
				t03.setVisible(true);
			}
		});
	}
}
