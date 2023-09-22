package WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class T03_1 {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;
	private JButton btnInput, btnUpdate, btnSearch, btnList, btnDelete, btnExit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T03_1 window = new T03_1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public T03_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.PINK);
		pn1.setBounds(0, 0, 459, 63);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회  원  가  입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setBounds(12, 10, 445, 41);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.PINK);
		pn2.setBounds(0, 60, 459, 201);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성   명   :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("굴림", Font.BOLD, 20));
		lblName.setBounds(12, 46, 146, 43);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나   이   :");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("굴림", Font.BOLD, 20));
		lblAge.setBounds(12, 117, 146, 43);
		pn2.add(lblAge);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.BOLD, 20));
		txtName.setBounds(196, 46, 208, 43);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.BOLD, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(196, 117, 208, 43);
		pn2.add(txtAge);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.PINK);
		pn3.setBounds(0, 257, 459, 264);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("입   력");
		btnInput.setFont(new Font("굴림", Font.BOLD, 18));
		btnInput.setBounds(51, 23, 154, 50);
		pn3.add(btnInput);
		
		btnUpdate = new JButton("수   정");
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 18));
		btnUpdate.setBounds(254, 23, 154, 50);
		pn3.add(btnUpdate);
		
		btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.BOLD, 18));
		btnList.setBounds(254, 94, 154, 50);
		pn3.add(btnList);
		
		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("굴림", Font.BOLD, 18));
		btnDelete.setBounds(51, 166, 154, 50);
		pn3.add(btnDelete);
		
		btnExit = new JButton("창닫기");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(254, 166, 154, 50);
		pn3.add(btnExit);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 18));
		btnSearch.setBounds(51, 94, 154, 50);
		pn3.add(btnSearch);
		
//		=======================================================    //
//		입력버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String name = txtName.getText().trim();
				String name = txtName.getText().trim();
				String age = txtAge.getText();
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요.");
					if(Pattern.matches("^[0-9]*$", name)) {
						txtName.requestFocus();    // 커서를 txtName쪽으로 설정						
					}
				} else if(age.equals("") || !Pattern.matches("^[0-9]*$", age)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
						txtAge.requestFocus();    // 커서를 txtName쪽으로 설정					
					}	else {
					JOptionPane.showMessageDialog(null, "성명 : " + name + "\n나이 : " + age);
				}
			}
		});
		
//		수정버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "수정버튼을 클릭하셨습니다.");
			}
		});
		
//		개별조회버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "개별조회버튼을 클릭하셨습니다.");
			}
		});
		
//		전체조회버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "전체조회버튼을 클릭하셨습니다.");
			}
		});
		
//		삭제버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "삭제버튼을 클릭하셨습니다.");
			}
		});
		
//		종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "작업을 종료합니다.");
				System.exit(0);
			}
		});
	}
}
