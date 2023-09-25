package xDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class InsaList extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	private ButtonGroup bntGroup = new ButtonGroup();
	private JButton btnConditon,btnList,btnExit,btnNameAsc,btnNameDesc,btnIpsailAsc,btnIpsailDesc,btnGenderSearch;
	private JComboBox cbCondition;
	
@SuppressWarnings("rawtypes")

	Vector title, vData;
	DefaultTableModel dtm;

	InsaDAO dao = new InsaDAO();
	private JTextField txtCondition;

	@SuppressWarnings("unchecked")
	public InsaList() {
		setVisible(true);
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 46, 584, 327);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 371, 584, 70);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		btnExit = new JButton("종 료");
		btnExit.setBounds(495, 22, 77, 31);
		pn2.add(btnExit);
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		
		btnNameAsc = new JButton("성명 오름차순");
		btnNameAsc.setFont(new Font("굴림", Font.PLAIN, 14));
		btnNameAsc.setBounds(338, 10, 133, 22);
		pn2.add(btnNameAsc);
		
		btnNameDesc = new JButton("성명 내림차순");
		btnNameDesc.setFont(new Font("굴림", Font.PLAIN, 14));
		btnNameDesc.setBounds(338, 42, 131, 22);
		pn2.add(btnNameDesc);
		
		btnIpsailAsc = new JButton("입사일 오름차순");
		btnIpsailAsc.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIpsailAsc.setBounds(181, 10, 145, 22);
		pn2.add(btnIpsailAsc);
		
		btnIpsailDesc = new JButton("입사일 내림차순");
		btnIpsailDesc.setFont(new Font("굴림", Font.PLAIN, 14));
		btnIpsailDesc.setBounds(181, 42, 145, 22);
		pn2.add(btnIpsailDesc);
//		1
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
//		2
		vData = dao.getInsaList();
//		3
		dtm = new DefaultTableModel(vData, title);
		
//		4. DefaultTableModel에 담긴 Vector형식의 자료와 타이틀로 JTable 을 생성시켜준다.
		tbl = new JTable(dtm);
		
//		5. 자료가 담긴 Table으로 JScrollPane 생성시에 함께 담아서 생성
		sp =new JScrollPane(tbl);
		sp.setBounds(12, 10, 560, 307);
//		6
		pn1.add(sp);
		
//		JTable안의 셀 내용을 가운데 정렬하고 0열의 크기를 50픽셀로 조정
		tableCellAlign(tbl);
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
//		---------------------------------------------------------------------   //
		JRadioButton rdMale = new JRadioButton("남 자");
		rdMale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdMale.setBounds(26, 10, 60, 23);
		bntGroup.add(rdMale);
		pn2.add(rdMale);
		
		JRadioButton rdFeMale = new JRadioButton("여 자");
		rdFeMale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdFeMale.setBounds(90, 10, 60, 23);
		bntGroup.add(rdFeMale);
		pn2.add(rdFeMale);
		
		btnGenderSearch = new JButton("성별 검색");
		btnGenderSearch.setBounds(36, 42, 114, 22);
		pn2.add(btnGenderSearch);
		
		JPanel lbl3 = new JPanel();
		lbl3.setBounds(0, 0, 584, 51);
		contentPane.add(lbl3);
		lbl3.setLayout(null);
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("굴림", Font.PLAIN, 14));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(12, 10, 113, 27);
		lbl3.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(137, 10, 113, 27);
		lbl3.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnConditon = new JButton("검색");
		btnConditon.setBounds(262, 10, 71, 27);
		lbl3.add(btnConditon);
		
		btnList = new JButton("전체 검색");
		btnList.setBounds(345, 10, 91, 27);
		lbl3.add(btnList);
//		--------------------------------------------------------------------    //
//		남자 라디오 버튼 클릭시 조회
//		rdMale.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				vData = dao.getGender("gender", "남자");
//				dtm.setDataVector(vData, title);
//			}
//		});
		
//		전체 조회 버튼 클릭시 실행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList();
				dtm.setDataVector(vData, title);
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
//		조건 검색 클릭
		btnConditon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getConditionProcess();
			}
		});
		
//		조건 검색 항목 선택 후 조건에 필요한 검색어를 입력 후 Enter키를 누르면 바로 검색 실행처리
		txtCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					getConditionProcess();
				}
			}
		});
		
//		성별 라디오 버튼으로 성별을 선택 후 성별 버튼 클릭시 해당 자료만 검색처리 후 출력
		btnGenderSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if(rdMale.isSelected()) {
					gender = "남자";
				} else {
					gender = "여자";
				}
				vData = dao.getGender(gender);
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
//		입사일 오름차순
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail","a");
				dtm.setDataVector(vData, title);
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail","d");
				dtm.setDataVector(vData, title);
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
//		성명 오름차순
		btnNameAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData	= dao.getNameAscList("name","a");
				dtm.setDataVector(vData, title);   // 값, 제목
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});		
		
//		성명 내림차순
		btnNameDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData	= dao.getNameAscList("name","d");
				dtm.setDataVector(vData, title); 
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
//		table안의 셀을 클릭할때 선택된 입력 정보 가져오기
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row  = tbl.getSelectedRow();
				int col = tbl.getSelectedColumn();
				
				Object value = tbl.getValueAt(row, col); 
			}
		});
		
//		조건 검색 콤보박스 안의 항목을 변경할때마다 자동으로 커서를 입력 텍스트 필드로 이동시키고자 할 경우
		cbCondition.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtCondition.requestFocus();
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
	
// 정렬 처리
	private void tableCellAlign(JTable tbl) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();   // 새로 다시 가공한다는 명령어
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);    // 수평 정렬
		
		TableColumnModel tcm = tbl.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

//	조건 검색 항목 선택 후 조건 입력 필드에서 조건 입력 후 Enter키를 누르거나 버튼 클릭하면 수행처리 할 내용
	protected void getConditionProcess() {
		String cbCondi = cbCondition.getSelectedItem().toString();
		String txtCondi = txtCondition.getText();
		
		if(txtCondi.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색하실 내용을 입력하세요.");
			txtCondition.requestFocus();
			return;
		} 
		if(cbCondi.equals("성명")) {
			vData = dao.getConditionSearch("name",txtCondi);
		} else if(cbCondi.equals("나이")) {
			if(!Pattern.matches("^[0-9]*$", txtCondi)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
				txtCondition.requestFocus();
			} else {
				vData = dao.getConditionSearch("age",txtCondi);
			}
		} else if(cbCondi.equals("성별")) {
			vData = dao.getConditionSearch("gender", txtCondi);
		} else if (cbCondi.equals("입사일")) {
			vData = dao.getConditionSearch("ipsail", txtCondi);
		}
		dtm.setDataVector(vData, title);
		tableCellAlign(tbl);
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
	}
}
