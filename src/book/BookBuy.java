package book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BookBuy extends JFrame {

	private JPanel contentPane;
	private JButton btnBuy;
	
	int item = 0;
	DAO dao = null;
	BookVO bvo = null;
	MypageVO mypagevo = null;

	public BookBuy(String id, Object value) {
		setVisible(true);
		setBounds(100, 100, 342, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

//		JPanel     -----------------------------------------------------------
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 326, 45);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 44, 326, 112);
		contentPane.add(pn2);
		pn2.setLayout(null);

		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 155, 326, 60);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
//		JLabel     -----------------------------------------------------------  
		JLabel lblBookName = new JLabel(value+"");
		lblBookName.setFont(new Font("굴림", Font.BOLD, 16));
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setBounds(0, 0, 326, 45);
		pn1.add(lblBookName);
		
		JLabel lblNewLabel = new JLabel("원하시는 수량을 선택하세요.");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 32, 214, 49);
		pn2.add(lblNewLabel);
		
//		JComboBox     -----------------------------------------------------------  
		JComboBox cbItem = new JComboBox();
		cbItem.setModel(new DefaultComboBoxModel(new String[] {"선택", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cbItem.setBounds(238, 32, 76, 48);
		pn2.add(cbItem);
		
		btnBuy = new JButton("구매하기");
		btnBuy.setBounds(176, 10, 138, 40);
		pn3.add(btnBuy);
		
		
//		-----------------------------------------------------------------------
//		수량 확인하기
		cbItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				item = Integer.parseInt(cbItem.getSelectedItem().toString());
			}
		});
		
//		JButton     -----------------------------------------------------------  
//		구매 버튼
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BookPay(item,value,id);
			}
		});
	}
}