package WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class T04_ComboListBox extends JFrame {

	private JPanel contentPane;
	private JComboBox comboJob;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T04_ComboListBox frame = new T04_ComboListBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public T04_ComboListBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 292, 271);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("직 업 선 택");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 268, 34);
		pn1.add(lblNewLabel);
		
		comboJob = new JComboBox();
		comboJob.setFont(new Font("굴림", Font.BOLD, 16));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"회사원", "학생", "군인", "의사", "판사", "변호사", "프리랜서", "기타", "무직"}));
		comboJob.setBounds(12, 54, 268, 25);
		pn1.add(comboJob);
		
		JList listFood = new JList();
		listFood.setFont(new Font("굴림", Font.PLAIN, 14));
		listFood.setModel(new AbstractListModel() {
			String[] values = new String[] {"짜장면", "돈가스", "떡볶이", "피자", "햄버거", "파스타", "초밥", "제육덮밥", "마라탕", "탕수육", "짬뽕", "삼겹살", "도시락", "김밥", "샐러드", "음료수"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listFood.setBounds(12, 89, 268, 172);
		pn1.add(listFood);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(292, 0, 292, 271);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 53, 268, 208);
		pn2.add(scrollPane);
		
		JList listFood2 = new JList();
		listFood2.setFont(new Font("굴림", Font.PLAIN, 14));
		listFood2.setModel(new AbstractListModel() {
			String[] values = new String[] {"짜장면", "돈가스", "떡볶이", "피자", "햄버거", "파스타", "초밥", "제육덮밥", "마라탕", "탕수육", "짬뽕", "삼겹살", "도시락", "김밥", "샐러드", "음료수", "커피", "라면", "탕후루", "만두"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listFood2);
		
		JLabel lblFood = new JLabel("음 식 선 택");
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setFont(new Font("굴림", Font.BOLD, 18));
		lblFood.setBounds(12, 10, 268, 34);
		pn2.add(lblFood);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.LIGHT_GRAY);
		pn3.setBounds(0, 329, 584, 122);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("출  력  창");
		lblMsg.setFont(new Font("굴림", Font.BOLD, 18));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(12, 10, 279, 102);
		pn3.add(lblMsg);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(303, 10, 269, 102);
		pn3.add(scrollPane_1);
		
		JTextArea txtaMsg = new JTextArea();
		txtaMsg.setFont(new Font("굴림", Font.BOLD, 18));
		scrollPane_1.setViewportView(txtaMsg);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0, 267, 584, 62);
		contentPane.add(pn4);
		pn4.setLayout(null);
		
		JButton btnCombo = new JButton("Combo출력");
		btnCombo.setFont(new Font("굴림", Font.BOLD, 12));
		btnCombo.setBounds(34, 10, 104, 42);
		pn4.add(btnCombo);
		
		JButton btnList1 = new JButton("List출력1");
		btnList1.setFont(new Font("굴림", Font.BOLD, 12));
		btnList1.setBounds(201, 10, 93, 42);
		pn4.add(btnList1);
		
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "작업을 종료하겠습니다.");
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("굴림", Font.BOLD, 12));
		btnExit.setBounds(453, 10, 93, 42);
		pn4.add(btnExit);
		
		JButton btnList2 = new JButton("List출력2");
		btnList2.setFont(new Font("굴림", Font.BOLD, 12));
		btnList2.setBounds(290, 10, 93, 42);
		pn4.add(btnList2);
		
//		================================================    //
//		ComboBox 선택내용 출력 처리 버튼
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msa = comboJob.getSelectedItem().toString();
				lblMsg.setText(msa);
			}
		});
		
//		ListBox1 선택내용 출력 처리 버튼 (내용 하나 처리)
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaMsg.append(listFood2.getSelectedValue().toString() + "\n");
//				}
			}
		});
		
//		ListBox2 선택내용 출력 처리 버튼 (내용 여러개 처리)
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] foods = listFood2.getSelectedValuesList().toArray();
//				String food = "";
//				for(Object f : foods) {
//					food += f + "\n";
//					txtaMsg.setText(food);
//				}
				for(Object f : foods) {
					txtaMsg.append(f.toString() + "\n");
				}
			}
		});
	}
}
