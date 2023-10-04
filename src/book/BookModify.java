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
import java.util.Locale.Category;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class BookModify extends JFrame {

	private JPanel contentPane;
	private JTextField txtWriter,txtCompany,txtGrade,txtPrice,txtCategory,txtCover,txtPublication;
	private JButton btnBack,btnUpdate,btnDelete;

	DAO dao = new DAO();
	BookVO bvo = null;
	
	public BookModify(String id, String rating, Object value) {
		setVisible(true);
		setSize(1000,790);
		setTitle("수정창");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		

//		JPanel ------------------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 984, 58);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 58, 984, 634);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 690, 984, 61);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
//		JLabel ------------------------------------------------------------------
		JLabel lbl1 = new JLabel("<"+value+"> 수정");
		lbl1.setBounds(73, 0, 843, 58);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("굴림", Font.BOLD, 14));
		pn1.add(lbl1);
		
		JLabel lbl2 = new JLabel("저자 :");
		lbl2.setBounds(12, 93, 115, 33);
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl2);
		
		JLabel lbl3 = new JLabel("출판사 :");
		lbl3.setBounds(12, 156, 115, 33);
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl3);
		
		JLabel lbl4 = new JLabel("사진 등록 :");
		lbl4.setBounds(12, 222, 115, 26);
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setFont(new Font("굴림", Font.BOLD, 16));
		pn2.add(lbl4);
		
		JLabel lbl5 = new JLabel("출판일 :");
		lbl5.setBounds(573, 30, 94, 33);
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl5.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl5);
		
		JLabel lbl6 = new JLabel("카테고리 :");
		lbl6.setBounds(12, 30, 115, 33);
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl6.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl6);

		JLabel lbl7 = new JLabel("평점 :");
		lbl7.setBounds(573, 93, 94, 33);
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl7.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl7);
		
		JLabel lbl8 = new JLabel("가격 :");
		lbl8.setBounds(573, 156, 94, 33);
		lbl8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl8.setFont(new Font("굴림", Font.BOLD, 14));
		pn2.add(lbl8);

		JLabel lbl9 = new JLabel("줄거리 등록 ");
		lbl9.setBounds(12, 269, 115, 26);
		lbl9.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl9.setFont(new Font("굴림", Font.BOLD, 16));
		pn2.add(lbl9);
		
//		JTextField ------------------------------------------------------------------
		bvo = dao.BookSearch(value.toString());
		txtWriter = new JTextField();
		txtWriter.setText(bvo.getWriter());
		txtWriter.setBounds(139, 93, 284, 33);
		txtWriter.setColumns(10);
		pn2.add(txtWriter);
		
		txtCompany = new JTextField();
		txtCompany.setText(bvo.getCompany());
		txtCompany.setBounds(139, 156, 284, 33);
		txtCompany.setColumns(10);
		pn2.add(txtCompany);
		
		txtGrade = new JTextField();
		txtGrade.setText(bvo.getGrade());
		txtGrade.setBounds(688, 93, 284, 33);
		txtGrade.setColumns(10);
		pn2.add(txtGrade);
		
		txtPrice = new JTextField();
		txtPrice.setText(bvo.getPrice()+"");
		txtPrice.setBounds(688, 156, 284, 33);
		txtPrice.setColumns(10);
		pn2.add(txtPrice);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(271, 30, 152, 33);
		txtCategory.setColumns(10);
		pn2.add(txtCategory);
		
		txtCover = new JTextField();
		txtCover.setText(bvo.getCover());
		txtCover.setBounds(139, 223, 833, 26);
		txtCover.setColumns(10);
		pn2.add(txtCover);
		
		txtPublication = new JTextField();
		txtPublication.setText(bvo.getPublication());
		txtPublication.setBounds(688, 30, 284, 33);
		txtPublication.setColumns(10);
		pn2.add(txtPublication);

		JComboBox cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"선택", "인문", "소설", "사전", "동화", "만화", "직접입력"}));
		cbCategory.setBounds(139, 30, 120, 33);
		cbCategory.setFont(new Font("굴림", Font.PLAIN, 14));
		pn2.add(cbCategory);
		
		JTextArea txtReview = new JTextArea();
		txtReview.setText(bvo.getReview());
		txtReview.setLineWrap(true);
		txtReview.setBounds(22, 305, 950, 297);
		pn2.add(txtReview);

		btnBack = new JButton("<");
		btnBack.setBounds(12, 10, 49, 38);
		pn1.add(btnBack);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(756, 10, 104, 38);
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 14));
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 14));
		btnDelete.setBounds(868, 10, 104, 38);
		pn3.add(btnDelete);
		
//		-----------------------------------------------------------------------------		
//		JButton ------------------------------------------------------------------
//		뒤로 가기 버튼
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SuperPage(id, rating);
			}
		});
		
//		수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String category = cbCategory.getSelectedItem().toString();
				String company = txtCompany.getText();
				String writer = txtWriter.getText();
				String publication = txtPublication.getText();
				String grade = txtGrade.getText();
				String price = txtPrice.getText();
				String cover = txtCover.getText();
				String review = txtReview.getText();		
				if(category.equals("선택")) {
					JOptionPane.showMessageDialog(null, "카테고리를 설정해주세요");
					cbCategory.requestFocus();
				} else if(company.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "출판사를 입력하세요");
					txtCompany.requestFocus();
				} else if (writer.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "저자를 입력하세요");
					txtWriter.requestFocus();
				} else if(publication.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "출판일을 입력하세요");
					txtPublication.requestFocus();
				} else if(grade.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "평점을 입력하세요");
					txtGrade.requestFocus();
				} else if(txtPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "가격을 입력하세요");
					txtPrice.requestFocus();
				} else if(cover.trim().equals("")) {
					cover = "default";
				} else if(review.trim().equals("")) {
					review = "default";
				} else {
					bvo = new BookVO();
					bvo.setCategory(category);
					bvo.setBookname(value.toString());
					bvo.setCompany(company);
					bvo.setWriter(writer);
					bvo.setPublication(publication);
					bvo.setPrice(Integer.parseInt(price));
					bvo.setGrade(grade);
					bvo.setCover(cover);
					bvo.setReview(review);
					int res = dao.bookModify(bvo);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "수정 실패");
					} else {
						JOptionPane.showMessageDialog(null, "수정 성공");
						dispose();
						new SuperPage(id, rating);
					}
				}
			}
		});
		
//		삭제 버튼
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int res = dao.bookDelete(value);
				if(res == 0) {
					JOptionPane.showMessageDialog(null, "삭제 실패");
				} else {
					JOptionPane.showMessageDialog(null, "삭제 성공");
					dispose();
					new SuperPage(id, rating);
				}
			}
		});
	}
}
