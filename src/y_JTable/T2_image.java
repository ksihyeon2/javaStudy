package y_JTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T2_image extends JFrame {

	private JPanel contentPane;
	private ButtonGroup btnGroup  = new ButtonGroup();
	private JRadioButton rdImg1,rdImg2,rdImg3,rdImg4,rdImg5,rdImg6;
	private JLabel lblInfor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T2_image frame = new T2_image();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public T2_image() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 67);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		rdImg1 = new JRadioButton("그림 1");
		rdImg1.setFont(new Font("굴림", Font.BOLD, 14));
		rdImg1.setBounds(48, 21, 74, 23);
		btnGroup.add(rdImg1);
		pn1.add(rdImg1);
		
		rdImg2 = new JRadioButton("그림 2");
		rdImg2.setFont(new Font("굴림", Font.BOLD, 14));
		rdImg2.setBounds(170, 21, 74, 23);
		btnGroup.add(rdImg2);
		pn1.add(rdImg2);
		
		rdImg3 = new JRadioButton("그림 3");
		rdImg3.setFont(new Font("굴림", Font.BOLD, 14));
		rdImg3.setBounds(292, 21, 74, 23);
		btnGroup.add(rdImg3);
		pn1.add(rdImg3);
		
		rdImg4 = new JRadioButton("그림 4");
		rdImg4.setFont(new Font("굴림", Font.BOLD, 14));
		rdImg4.setBounds(414, 21, 74, 23);
		btnGroup.add(rdImg4);
		pn1.add(rdImg4);
		
		rdImg5 = new JRadioButton("그림 5");
		rdImg5.setFont(new Font("굴림", Font.BOLD, 14));
		rdImg5.setBounds(536, 21, 74, 23);
		btnGroup.add(rdImg5);
		pn1.add(rdImg5);
		
		rdImg6 = new JRadioButton("그림 6");
		rdImg6.setFont(new Font("굴림", Font.BOLD, 14));
		rdImg6.setBounds(658, 21, 74, 23);
		btnGroup.add(rdImg6);
		pn1.add(rdImg6);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 494, 784, 67);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 14));
		btnExit.setBounds(694, 24, 78, 33);
		pn3.add(btnExit);
		
		JButton btnInfor = new JButton("그림 정보 출력");
		btnInfor.setFont(new Font("굴림", Font.BOLD, 14));
		btnInfor.setBounds(12, 24, 142, 33);
		pn3.add(btnInfor);
		
		lblInfor = new JLabel("");
		lblInfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor.setBounds(153, 10, 530, 47);
		pn3.add(lblInfor);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 65, 784, 430);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(0, 0, 784, 430);
		pn2.add(lblImage);
		
//		그림 1 라디오 버튼을 클릭하면 처리할 내용
		rdImg1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {   // 동작이 발생하면 1, 발생하지 않으면 0
					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/1.png")));					
				}
			}
		});
//		그림 2 라디오 버튼을 클릭하면 처리할 내용
		rdImg2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {   // 동작이 발생하면 1, 발생하지 않으면 0
					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/2.png")));					
				}
			}
		});
//		그림 3 라디오 버튼을 클릭하면 처리할 내용
		rdImg3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {   // 동작이 발생하면 1, 발생하지 않으면 0
					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/3.jpeg")));					
				}
			}
		});
//		그림 4 라디오 버튼을 클릭하면 처리할 내용
		rdImg4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {   // 동작이 발생하면 1, 발생하지 않으면 0
					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/4.jpg")));					
				}
			}
		});
//		그림 5 라디오 버튼을 클릭하면 처리할 내용
		rdImg5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {   // 동작이 발생하면 1, 발생하지 않으면 0
					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/5.png")));					
				}
			}
		});
//		그림 6 라디오 버튼을 클릭하면 처리할 내용
		rdImg6.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {   // 동작이 발생하면 1, 발생하지 않으면 0
					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/6.jpeg")));					
				}
			}
		});
		
//		---------------------------------------------------------------------
//		그림 정보 출력 버튼
		btnInfor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			  String photo = "그림을 클릭하면 해당 그림 파일의 정보가 출력 됩니다.";
				if(lblImage.getIcon() != null) {
			  	photo = lblImage.getIcon().toString();
			  }
			  lblInfor.setText(photo);
			}
		});
		
//		출력된 그림의 정보를 출력할때
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String photo = "그림을 클릭하면 해당 그림 파일의 정보가 출력 됩니다.";
					if(lblImage.getIcon() != null) {
				  	photo = lblImage.getIcon().toString();
				  }
				  lblInfor.setText(photo);
				}
		});
		
//		종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "창을 닫습니다");
				System.exit(0);
			}
		});
	}

}
