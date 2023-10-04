package book;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.security.MessageDigestSpi;
import java.awt.event.ActionEvent;

public class BookPay extends JFrame {

	private JPanel contentPane;
	private JTextField txtPoint,txtNum,txtAddress;
	private JButton btnPoint,btnBuy,btnBack,btnSelfPoint;
	private JLabel lblName,lblBookName,lblWriter,lblBookPrice,lblNewLabel_2,lblTotal,lblItem;
	private ButtonGroup bntGroup = new ButtonGroup();
	
	DAO dao = new DAO();
	MemberVO mvo = null;
	BookVO bvo = null;
	MypageVO mypagevo = null;
	int res = 0;
	int totpoint = 0;

	public BookPay(int item, Object value, String id) {
		setVisible(true);
		setBounds(100, 100, 450, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 434, 52);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 53, 434, 545);
		contentPane.add(pn2);
		pn2.setLayout(null);

		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 597, 434, 62);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
//		JLabel     -----------------------------------------------------------
		JLabel lblNewLabel = new JLabel("주문/결제");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 0, 291, 52);
		pn1.add(lblNewLabel);
		
		JLabel lbl1 = new JLabel("주문자");
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1.setFont(new Font("굴림", Font.BOLD, 14));
		lbl1.setBounds(34, 10, 79, 35);
		pn2.add(lbl1);

		JLabel lbl2 = new JLabel("배송지");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("굴림", Font.BOLD, 14));
		lbl2.setBounds(34, 55, 79, 43);
		pn2.add(lbl2);
		
		JLabel lbl3 = new JLabel("결제 수단");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 14));
		lbl3.setBounds(34, 108, 79, 35);
		pn2.add(lbl3);
		
		JLabel lbl4 = new JLabel("현금 영수증");
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setFont(new Font("굴림", Font.BOLD, 14));
		lbl4.setBounds(12, 145, 96, 35);
		pn2.add(lbl4);

		JLabel lbl5 = new JLabel("포인트");
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl5.setFont(new Font("굴림", Font.BOLD, 14));
		lbl5.setBounds(12, 228, 96, 35);
		pn2.add(lbl5);	
		
		JLabel lbl6 = new JLabel("주문 정보");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("굴림", Font.BOLD, 14));
		lbl6.setBounds(12, 319, 410, 35);
		pn2.add(lbl6);

		JLabel lbl7 = new JLabel("제목 :");
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl7.setFont(new Font("굴림", Font.BOLD, 14));
		lbl7.setBounds(12, 364, 96, 35);
		pn2.add(lbl7);

		JLabel lbl8 = new JLabel("저자 :");
		lbl8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl8.setFont(new Font("굴림", Font.BOLD, 14));
		lbl8.setBounds(12, 409, 96, 35);
		pn2.add(lbl8);
		
		JLabel lbl9 = new JLabel("가격 :");
		lbl9.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl9.setFont(new Font("굴림", Font.BOLD, 14));
		lbl9.setBounds(44, 454, 64, 35);
		pn2.add(lbl9);

		JLabel lbl10 = new JLabel("수량 :");
		lbl10.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl10.setFont(new Font("굴림", Font.BOLD, 14));
		lbl10.setBounds(244, 455, 96, 35);
		pn2.add(lbl10);
		
		JLabel lbl11 = new JLabel("총 결제 금액");
		lbl11.setFont(new Font("굴림", Font.BOLD, 16));
		lbl11.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl11.setBounds(12, 489, 153, 46);
		pn2.add(lbl11);
	
//		JComboBox     -----------------------------------------------------------
		JComboBox cbPay = new JComboBox();
		cbPay.setFont(new Font("굴림", Font.PLAIN, 14));
		cbPay.setModel(new DefaultComboBoxModel(new String[] {"선택", "계좌이체/무통장입금", "신용/체크카드", "휴대폰"}));
		cbPay.setBounds(125, 105, 177, 40);
		pn2.add(cbPay);
		
//		JComboBox에 저장되어 있는 배송지 입력하기
		mvo = dao.memberSearch(id);
		String address = mvo.getAddress();
		
		JComboBox cbAddress = new JComboBox();
		cbAddress.setModel(new DefaultComboBoxModel(new String[] {address ,"배송지 변경"}));
		cbAddress.setFont(new Font("굴림", Font.PLAIN, 14));
		cbAddress.setBounds(125, 55, 177, 40);
		pn2.add(cbAddress);
		
//		JRadioButton ----------------------------------------------------------
		JRadioButton rdYes = new JRadioButton("신청");
		rdYes.setBounds(125, 151, 79, 23);
		bntGroup.add(rdYes);
		pn2.add(rdYes);
		
		JRadioButton rdNo = new JRadioButton("미신청");
		rdNo.setSelected(true);
		rdNo.setBounds(208, 151, 79, 23);
		bntGroup.add(rdNo);
		pn2.add(rdNo);
	
//		JLabel       ---------------------------------------------------------
//		JLabel 입력값 저장
		
		mvo = dao.memberSearch(id);
		bvo = dao.BookSearch(value.toString());
		int point = mvo.getPoint();
		int price =bvo.getPrice();
		String name = mvo.getName();
		int tot = bvo.getPrice() * item;

		lblName = new JLabel(mvo.getName());
		lblName.setBounds(125, 10, 152, 35);
		pn2.add(lblName);
		
		lblBookName = new JLabel(bvo.getBookname());
		lblBookName.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookName.setBounds(125, 364, 297, 35);
		pn2.add(lblBookName);
		
		lblWriter = new JLabel(bvo.getWriter());
		lblWriter.setHorizontalAlignment(SwingConstants.LEFT);
		lblWriter.setBounds(125, 410, 297, 35);
		pn2.add(lblWriter);
		
		lblBookPrice = new JLabel(bvo.getPrice()+" 원");
		lblBookPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookPrice.setBounds(125, 454, 124, 35);
		pn2.add(lblBookPrice);
		
		lblNewLabel_2 = new JLabel("잔여 포인트 : " + point);
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(125, 273, 136, 23);
		pn2.add(lblNewLabel_2);
		
		lblTotal = new JLabel(tot+"");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(260, 489, 108, 46);
		pn2.add(lblTotal);

		lblItem = new JLabel(item+"");
		lblItem.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem.setBounds(352, 455, 57, 35);
		pn2.add(lblItem);
		
//		JTextField       ---------------------------------------------------------
		txtPoint = new JTextField();
		txtPoint.setText(0+"");
		txtPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPoint.setBounds(125, 228, 177, 35);
		pn2.add(txtPoint);
		txtPoint.setColumns(10);
		
		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setEnabled(false);
		txtNum.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNum.setColumns(10);
		txtNum.setBounds(125, 180, 177, 35);
		pn2.add(txtNum);
		
		txtAddress = new JTextField(address);
		txtAddress.setEnabled(false);
		txtAddress.setBounds(314, 55, 108, 40);
		pn2.add(txtAddress);
		txtAddress.setColumns(10);
		
//		JButton       ---------------------------------------------------------
		btnPoint = new JButton("모두 사용");
		btnPoint.setBounds(314, 267, 108, 35);
		pn2.add(btnPoint);
		
		btnBack = new JButton("<");
		btnBack.setBounds(12, 7, 55, 42);
		pn1.add(btnBack);
		
		btnSelfPoint = new JButton("사용하기");
		btnSelfPoint.setBounds(314, 228, 108, 35);
		pn2.add(btnSelfPoint);
		
		btnBuy = new JButton("결제하기");
		btnBuy.setFont(new Font("굴림", Font.BOLD, 18));
		btnBuy.setBounds(0, 0, 434, 62);
		pn3.add(btnBuy);
		
//		---------------------------------------------------------------
//		배송지 변경 선택시 입력값
		cbAddress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbAddress.getSelectedItem().equals("배송지 변경")) {
					String changeAddress = JOptionPane.showInputDialog(null, "변경하실 배송지 주소를 입력하세요");
					txtAddress.setText(changeAddress);
				} else {
					txtAddress.setText(address);
				}
			}
		});
		
//		현금 영수증 번호 신청/미신청 처리
		rdYes.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNum.enable(true);
				txtNum.setEditable(true);
				txtNum.setText(mvo.getPhonenum());
			} 
		});
		
		rdNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNum.enable(false);
				txtNum.setEditable(false);
			}
		});
		
//		JButton       ---------------------------------------------------------
//		포인트 모두 사용 버튼
		btnPoint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bvo = dao.BookSearch(value+"");
				totpoint = mvo.getPoint();
				int price = bvo.getPrice();
				txtPoint.setText(totpoint+"");
				int tot = (price * item) - totpoint;
				lblTotal.setText(tot+"");
			}
		});
		
//		포인트 직접 사용 버튼
		btnSelfPoint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				totpoint = Integer.parseInt(txtPoint.getText());
				if(totpoint > point) {
					JOptionPane.showMessageDialog(null, "현재 잔여 포인트를 확인하세요");
					txtPoint.setText(point+"");
				}
				bvo = dao.BookSearch(value+"");
				int price = bvo.getPrice();
				int tot = (price * item) - totpoint;
				lblTotal.setText(tot+""); 
			}
		});
			
//		결제 버튼
		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbPay.getSelectedItem().equals("선택")) {
					JOptionPane.showMessageDialog(null, "결제 수단을 선택해주세요");
				} else {
					int ans = JOptionPane.showInternalConfirmDialog(null, "구매 하시겠습니까?","구매창",JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						res = dao.buyList(id,value,item);
						if(res == 0) {
							JOptionPane.showMessageDialog(null, "구매에 실패하셨습니다.\n다시 시도해주세요.");
						} else {
							res = dao.ChangePoint(totpoint,id);
							if( res == 0) {
								JOptionPane.showMessageDialog(null, "포인트 차감 오류");
							} else {
								int addpoint = 1000 * item;
								res = dao.setmemberPoint(addpoint+"",id);
								if(res != 0) {
									JOptionPane.showMessageDialog(null, "구매 완료 되었습니다.\n감사합니다.\n(포인트 추가 : "+addpoint+")");
									dispose();
								}
							}
						}
					}
				}
			}
		});
		
//		뒤로 가기 버튼
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
