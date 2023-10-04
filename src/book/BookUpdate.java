package book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class BookUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField txtWriter,txtCompany,txtGrade,txtPrice,txtField;
	private JButton btnUpdate,btnBack;
	private JComboBox cbCategory;
	
	DAO dao = new DAO();
	BookUpdateVO bookUpdateVo = null;
	BookVO bvo = null;
	private JTextField txtPhoto;
	private JTextField txtPublication;
	
	public BookUpdate(String id, String rating, Object value) {
		setVisible(true);
		setSize(1000,790);
		setTitle("등록창");
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
		pn2.setBounds(0, 57, 984, 634);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 690, 984, 61);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
//		JLabel ------------------------------------------------------------------
		JLabel lbl1 = new JLabel("<" + value + ">");
		lbl1.setFont(new Font("굴림", Font.BOLD, 14));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(73, 0, 843, 58);
		pn1.add(lbl1);
		
		JLabel lbl2 = new JLabel("저자 :");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("굴림", Font.BOLD, 14));
		lbl2.setBounds(12, 93, 115, 33);
		pn2.add(lbl2);
		
		JLabel lbl3 = new JLabel("출판사 :");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 14));
		lbl3.setBounds(12, 156, 115, 33);
		pn2.add(lbl3);
		
		JLabel lbl6 = new JLabel("카테고리 :");
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl6.setFont(new Font("굴림", Font.BOLD, 14));
		lbl6.setBounds(12, 30, 115, 33);
		pn2.add(lbl6);
		
//		JTextField ------------------------------------------------------------------
		txtWriter = new JTextField();
		txtWriter.setBounds(139, 93, 284, 33);
		pn2.add(txtWriter);
		txtWriter.setColumns(10);
		
		txtCompany = new JTextField();
		txtCompany.setColumns(10);
		txtCompany.setBounds(139, 156, 284, 33);
		pn2.add(txtCompany);
		
		txtGrade = new JTextField();
		txtGrade.setColumns(10);
		txtGrade.setBounds(688, 93, 284, 33);
		pn2.add(txtGrade);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(688, 156, 284, 33);
		pn2.add(txtPrice);
		
		cbCategory = new JComboBox();
		cbCategory.setFont(new Font("굴림", Font.PLAIN, 14));
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"선택", "인문", "소설", "사전", "동화", "만화", "직접입력"}));
		cbCategory.setBounds(139, 30, 120, 33);
		pn2.add(cbCategory);
		
		txtField = new JTextField();
		txtField.setBounds(271, 30, 152, 33);
		pn2.add(txtField);
		txtField.setColumns(10);
		
		JLabel lbl1_1 = new JLabel("사진 등록 :");
		lbl1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lbl1_1.setBounds(12, 222, 115, 26);
		pn2.add(lbl1_1);
		
		txtPhoto = new JTextField();
		txtPhoto.setColumns(10);
		txtPhoto.setBounds(139, 223, 833, 26);
		pn2.add(txtPhoto);
		
		JLabel lblCnfvksdlf = new JLabel("출판일 :");
		lblCnfvksdlf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnfvksdlf.setFont(new Font("굴림", Font.BOLD, 14));
		lblCnfvksdlf.setBounds(573, 30, 94, 33);
		pn2.add(lblCnfvksdlf);
		
		JLabel lblCnfvksdlf_1 = new JLabel("평점 :");
		lblCnfvksdlf_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnfvksdlf_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblCnfvksdlf_1.setBounds(573, 93, 94, 33);
		pn2.add(lblCnfvksdlf_1);
		
		JLabel lblCnfvksdlf_1_1 = new JLabel("가격 :");
		lblCnfvksdlf_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnfvksdlf_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblCnfvksdlf_1_1.setBounds(573, 156, 94, 33);
		pn2.add(lblCnfvksdlf_1_1);
		
		JLabel lbl1_1_1 = new JLabel("줄거리 등록 ");
		lbl1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lbl1_1_1.setBounds(12, 269, 115, 26);
		pn2.add(lbl1_1_1);
		
		txtPublication = new JTextField();
		txtPublication.setColumns(10);
		txtPublication.setBounds(688, 30, 284, 33);
		pn2.add(txtPublication);
		
		JTextArea txtReview = new JTextArea();
		txtReview.setLineWrap(true);
		txtReview.setBounds(22, 305, 950, 297);
		pn2.add(txtReview);
		
//		다시 확인
		if(cbCategory.getSelectedItem().equals("직접입력")) {
			txtField.enable(true);
			txtField.setEditable(true);
		} else {
			txtField.enable(false);
			txtField.setEditable(false);
		}
		
		
		btnBack = new JButton("<");
		btnBack.setBounds(12, 10, 49, 38);
		pn1.add(btnBack);
		
		btnUpdate = new JButton("등록");
		btnUpdate.setBounds(868, 10, 104, 38);
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 14));
		pn3.add(btnUpdate);
		
//		-------------------------------------------------------------------------
//		JButton------------------------------------------------------------------
//		등록 버튼
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookname = value.toString();
				String category = cbCategory.getSelectedItem().toString();
				String company = txtCompany.getText();
				String writer = txtWriter.getText();
				String publication = txtPublication.getText();
				String grade = txtGrade.getText();
				String price = txtPrice.getText();
				String cover = txtPhoto.getText();
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
					bvo.setBookname(bookname);
					bvo.setCompany(company);
					bvo.setWriter(writer);
					bvo.setPublication(publication);
					bvo.setPrice(Integer.parseInt(price));
					bvo.setGrade(grade);
					bvo.setCover(cover);
					bvo.setReview(review);
					int res = dao.bookNewUpdate(bvo);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "등록 실패");
					} else {
						res = dao.bookUpdateDelete(bookname);
						if (res == 0) {
							JOptionPane.showMessageDialog(null, "오류");
						} else {
							JOptionPane.showMessageDialog(null, "등록 성공");
							dispose();
							new SuperPage(id, rating);
						}
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
