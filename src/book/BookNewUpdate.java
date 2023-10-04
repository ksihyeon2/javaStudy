package book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class BookNewUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField txtWriter,txtCompany,txtGrade,txtPrice,txtCategory,txtCover,txtPublication;
	private JButton btnBack,btnUpdate,btnCheck;
	private JTextField txtBookname;
	
	DAO dao = new DAO();
	BookVO bvo = null;
	
	int Check = 0;

	public BookNewUpdate(String id, String rating) {
		setVisible(true);
		setSize(1000,790);
		setTitle("등록창");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 984, 58);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 57, 984, 634);
		contentPane.add(pn2);
		pn2.setLayout(null);

		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 690, 984, 61);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
//		JPanel     -----------------------------------------------------------
		JLabel lbl1 = new JLabel("새 책 등록하기");
		lbl1.setBounds(73, 0, 843, 58);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("굴림", Font.BOLD, 14));
		pn1.add(lbl1);
		
		JLabel lbl2 = new JLabel("저자 :");
		lbl2.setBounds(22, 88, 115, 33);
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl2);
		
		JLabel lbl3 = new JLabel("출판사 :");
		lbl3.setBounds(22, 146, 115, 33);
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl3);
		
		JLabel lbl4 = new JLabel("사진 등록 :");
		lbl4.setBounds(22, 262, 115, 26);
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setFont(new Font("굴림", Font.BOLD, 16));
		pn2.add(lbl4);
		
		JLabel lbl5 = new JLabel("책 소개 등록 ");
		lbl5.setBounds(22, 313, 115, 26);
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl5.setFont(new Font("굴림", Font.BOLD, 16));
		pn2.add(lbl5);
		
		JLabel lbl6 = new JLabel("카테고리 :");
		lbl6.setBounds(22, 30, 115, 33);
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl6.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl6);

		JLabel lbl7 = new JLabel("출판일 :");
		lbl7.setBounds(480, 88, 94, 33);
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl7.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl7);
		
		JLabel lbl8 = new JLabel("평점 :");
		lbl8.setBounds(480, 146, 94, 33);
		lbl8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl8.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl8);
		
		JLabel lbl9 = new JLabel("가격 :");
		lbl9.setBounds(43, 204, 94, 33);
		lbl9.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl9.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl9);
		
//		JTextField     -----------------------------------------------------------
		txtWriter = new JTextField();
		txtWriter.setBounds(149, 88, 284, 33);
		txtWriter.setColumns(10);
		pn2.add(txtWriter);
		
		txtCompany = new JTextField();
		txtCompany.setBounds(149, 146, 284, 33);
		txtCompany.setColumns(10);
		pn2.add(txtCompany);
		
		txtGrade = new JTextField();
		txtGrade.setBounds(585, 146, 284, 33);
		txtGrade.setColumns(10);
		pn2.add(txtGrade);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(149, 204, 284, 33);
		txtPrice.setColumns(10);
		pn2.add(txtPrice);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(281, 30, 152, 33);
		txtCategory.setColumns(10);
		pn2.add(txtCategory);
		
		
		txtCover = new JTextField();
		txtCover.setBounds(149, 262, 823, 26);
		txtCover.setColumns(10);
		pn2.add(txtCover);
		
		txtPublication = new JTextField();
		txtPublication.setBounds(586, 88, 284, 33);
		txtPublication.setColumns(10);
		pn2.add(txtPublication);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"선택", "인문", "소설", "사전", "동화", "만화", "직접입력"}));
		cbCategory.setBounds(149, 30, 120, 33);
		cbCategory.setFont(new Font("굴림", Font.PLAIN, 14));
		pn2.add(cbCategory);
		
		JLabel lblWpahr = new JLabel("제목 :");
		lblWpahr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWpahr.setFont(new Font("굴림", Font.BOLD, 14));
		lblWpahr.setBounds(480, 30, 94, 33);
		pn2.add(lblWpahr);
		
		txtBookname = new JTextField();
		txtBookname.setColumns(10);
		txtBookname.setBounds(585, 30, 284, 33);
		pn2.add(txtBookname);
		
		
		
//		JButton     -----------------------------------------------------------
		btnBack = new JButton("<");
		btnBack.setBounds(12, 10, 49, 38);
		pn1.add(btnBack);
		
		btnUpdate = new JButton("등록");
		btnUpdate.setBounds(868, 10, 104, 38);
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 14));
		pn3.add(btnUpdate);

		btnCheck = new JButton("등록 확인");
		btnCheck.setBounds(875, 30, 97, 33);
		pn2.add(btnCheck);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 349, 929, 275);
		pn2.add(scrollPane);
		
		JTextArea txtReview = new JTextArea();
		txtReview.setLineWrap(true);
		scrollPane.setViewportView(txtReview);
//		JButton     -----------------------------------------------------------
//		새 책 신청 버튼
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookname = txtBookname.getText();
				if(bookname.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "책 제목을 입력하세요");
					txtBookname.requestFocus();
				} else {
					bvo = dao.BookSearch(bookname);
					if(bvo.getBookname() != null) {
						JOptionPane.showMessageDialog(null, "해당 책은 이미 등록되어 있습니다.");
						txtBookname.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "등록 가능한 책입니다.");
						Check = 1;
					}
				}
			}
		});
		
//		등록 버튼
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String category = cbCategory.getSelectedItem().toString();
				String bookname = txtBookname.getText();
				String company = txtCompany.getText();
				String writer = txtWriter.getText();
				String publication = txtPublication.getText();
				int price = Integer.parseInt(txtPrice.getText());
				String grade = txtGrade.getText();
				String review;
				String cover;
				
				if(category.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "카테고리를 선택 또는 입력하세요");
					cbCategory.requestFocus();
				} else if(bookname.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "책 제목을 입력하세요");
					txtBookname.requestFocus();
				} else if(company.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "출판사를 입력하세요");
					txtCompany.requestFocus();
				} else if(writer.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "저자를 입력하세요");
					txtWriter.requestFocus();
				} else if(publication.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "출판일을 입력하세요");
					txtPublication.requestFocus();
				} else if(txtPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "가격을 입력하세요");
					txtPrice.requestFocus();
				} else if(grade.trim().equals("")) {
					grade = "deafual";
				} 
				
				if(txtReview.getText().trim().equals("")) {
					review = "deafual";
				} else {
					review = txtReview.getText();
				}
				
				if (txtCover.getText().trim().equals("")) {
					cover = "deafual";
				} else {
					cover = txtCover.getText();
				}
				
				if(Check == 0) {
					JOptionPane.showMessageDialog(null, "책 등록 가능 여부를 확인해주세요");
					btnCheck.requestFocus();
				} else {
					bvo = new BookVO();
					bvo.setCategory(category);
					System.out.println(category);
					bvo.setBookname(bookname);
					bvo.setCompany(company);
					bvo.setWriter(writer);
					bvo.setPublication(publication);
					bvo.setPrice(price);
					bvo.setGrade(grade);
					bvo.setReview(review);
					bvo.setCover(cover);
					int res = dao.bookNewUpdate(bvo);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "등록 오료");
					} else {
						JOptionPane.showMessageDialog(null, "등록 성공");
						dispose();
						new SuperPage(id, rating);
					}
				}
			}
		});
		
//		뒤로 가기 버튼
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SuperPage(id, rating);
			}
		});
	}
}
