package y_JTable;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import xDatabase.InsaDAO;
import xDatabase.InsaVO;

@SuppressWarnings("serial")
public class T1 extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	
//	Vector<String> title = null;
//	Vector<String> vData = null;
	Vector title, vData;
	DefaultTableModel dtm;
	 	
//	xDatabase 패키지의 InsaDAO 클래스 참조 (import)
	InsaDAO dao = new InsaDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T1 frame = new T1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public T1() {
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 94);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(12, 51, 77, 31);
		pn1.add(btnExit);
		
		JButton btnNewWindow = new JButton("새 창에 선택값 띄우기");
		btnNewWindow.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewWindow.setBounds(12, 10, 244, 31);
		pn1.add(btnNewWindow);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 93, 584, 256);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 560, 236);
//		pn2.add(scrollPane);
//		
//		tbl = new JTable();
//		scrollPane.setViewportView(tbl);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 347, 584, 94);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("JTable에서 선택된 값을 출력합니다.");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 16));
		lblMsg.setBounds(12, 10, 560, 74);
		pn3.add(lblMsg);
		
/*		JTable 설계하기 
			- 부제목과 데이터를 Vector 타입으로 준비한다.
 */
//		1. 부제목을 Vector타입으로 준비
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
//		2. 데이터를 Vector타입으로 준비 - DB에서 가져온다.
		vData = dao.getInsaList();
		
//		3. DB에서 가져온 자료를 DefaultTableModel을 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title);
		
//		4. DefaultTableModel에 담긴 Vector형식의 자료와 타이틀로 JTable 을 생성시켜준다.
		tbl = new JTable(dtm);
		
//		5. 자료가 담긴 Table으로 JScrollPane 생성시에 함께 담아서 생성
		sp =new JScrollPane(tbl);
		sp.setBounds(12, 10, 560, 236);
		
//		6. JScrollPane을 패널에 올려준다.
		pn2.add(sp);
		
//		--------------------------------------------------------------------    //
//		table안의 셀을 클릭할때 선택된 입력 정보 가져오기
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row  = tbl.getSelectedRow();
				int col = tbl.getSelectedColumn();
				
				Object value = tbl.getValueAt(row, col);    // object type임
				lblMsg.setText("row : " + row + ", col : " + col + ", value : " + value);
			}
		});
		
//		새 창에 선택된 행의 정보 출력하기
		btnNewWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsaVO vo = new InsaVO();
				int row  = tbl.getSelectedRow();
				
				vo.setIdx((int)tbl.getValueAt(row, 0));
				vo.setName(tbl.getValueAt(row, 1).toString());
				vo.setAge((int)tbl.getValueAt(row, 2));
				vo.setGender(tbl.getValueAt(row, 3).toString());
				vo.setIpsail(tbl.getValueAt(row, 4).toString().substring(0,10));
				
				new InsaSearch(vo);
			}
		});
		
		//		닫기 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "창을 닫았습니다");
				dispose();
			}
		});
		
	}
}
