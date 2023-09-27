package book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Bookapplication extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	private JButton btnUpdate,btnClose;

	public Bookapplication(String id, String name) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(371,170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUpdate = new JButton("등록하기");
		btnUpdate.setBounds(246, 50, 97, 29);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("등록을 원하시는 책의 제목을 입력하세요.");
		lblNewLabel.setBounds(0, 10, 355, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(22, 48, 205, 33);
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);
		
		btnClose = new JButton("등록 종료");
		btnClose.setBounds(246, 92, 97, 29);
		contentPane.add(btnClose);
		
//		---------------------------------------------------------------     //
//		등록버튼
//		btnUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				bookUpdateVO vo = new bookUpdateVO();
//				DAO dao = new DAO();
//				String bookname = txtBookName.getText();
//				if(bookname.equals("")) {
//					JOptionPane.showMessageDialog(null, "원하시는 책 제목을 입력하세요");
//					txtBookName.requestFocus();
//				} else {
//					vo.setBookname(bookname);	
//					
//					vo = dao.BookSearch(bookname);
//					if(vo.getBookname() != null) {
//						JOptionPane.showMessageDialog(null, "해당 책이 존재합니다.");
//					} else {
//						vo.setId(id);
//						vo.setName(name);
//						vo.setBookname(bookname);
//						int res = dao.BookUpdate(vo);
//						if(res == 0) {
//							JOptionPane.showMessageDialog(null, "등록 신청 실패 \n다시 등록해주세요.");
//							txtBookName.requestFocus();
//						} else {
//							JOptionPane.showMessageDialog(null, "등록 신청 성공");
//							txtBookName.setText("");
//						}
//					}
//				}
//			}
//		});
//		
//		종료 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.sho
			}
		});
	}
}
