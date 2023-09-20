package Swing3_Layout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_FlowLayout extends JFrame {
	private JButton btnOK, btnExit, btnAnwer1, btnAnwer2, btnAnwer3, btnInput;
	private JLabel lblName;
	
	public T01_FlowLayout() {
		setTitle("FlowLayout 연습");
		setSize(400, 300);
		setLocationRelativeTo(null);   // 프레임을 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 창 닫기
		setResizable(false);    // 프레임의 크기 고정
		
		setLayout(new FlowLayout());
		
//		add 하면 JFrame에 올라감
		add(getBtnOK()); 
		add(getBtnExit());
		add(getBtnAnwer1());
		add(getBtnAnwer2());
		add(getBtnAnwer3());
		add(getBtnInput());
		
		add(getLblName());
		
//		---------------------------------------------------   //
		
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("성명 입력창","성명을 입력하세요");
				JOptionPane.showMessageDialog(null, "성명 : " + name);
				lblName.setText("성명 : " + name);
				System.out.println("성명 : " + name);
			}
		});
		
		btnAnwer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			옵션이 'YES_NO_CANCEL_OPTION'인 경우는 '예(0)/아니오(1)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 진행하시겠습니까?", "선택", JOptionPane.YES_NO_CANCEL_OPTION);
				if (ans == 0) {
					JOptionPane.showConfirmDialog(null, "작업을 계속 진행합니다.","진행창",JOptionPane.INFORMATION_MESSAGE);
				} else if (ans == 1) {
					JOptionPane.showConfirmDialog(null, "작업을 종료 합니다.","종료창",JOptionPane.WARNING_MESSAGE);
					dispose();
				}	else {
					JOptionPane.showConfirmDialog(null, "취소합니다.","취소창",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnAnwer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			옵션이 'YES_NO_OPTION'인 경우는 '예(0)/아니오(1)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 진행하시겠습니까?", "선택", JOptionPane.YES_NO_OPTION);
				if (ans == 0) {
					JOptionPane.showConfirmDialog(null, "작업을 계속 진행합니다.","진행창",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showConfirmDialog(null, "작업을 종료 합니다.","종료창",JOptionPane.WARNING_MESSAGE);
					dispose();
				}
			}
		});
		
		btnAnwer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				옵션이 'OK_CANCEL_OPTION'인 경우는 '확인(0)/취소(2)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "버튼을 선택하세요", "선택", JOptionPane.OK_CANCEL_OPTION);
				if (ans == 0) {
					JOptionPane.showConfirmDialog(null, "확인 버튼을 누르셨습니다.","확인창",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showConfirmDialog(null, "취소 버튼을 누르셨습니다.","취소창",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "확인 버튼을 누르셨습니다.","확인창",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "작업을 종료합니다.");     // 종료시 메세지 띄우기
//				JOptionPane.showMessageDialog(null, "작업을 종료합니다.", "종료창", JOptionPane.PLAIN_MESSAGE);     // 종료시 메세지 띄우기
				JOptionPane.showMessageDialog(null, "작업을 종료합니다.", "종료창", JOptionPane.WARNING_MESSAGE);     // 종료시 메세지 띄우기
				System.exit(0);
			}
		});
	}
	
	private JLabel getLblName() {
		lblName = new JLabel();
		return lblName;
	}

	private JButton getBtnInput() {
		btnInput = new JButton("입력");
		return btnInput;
	}

	private JButton getBtnAnwer3() {
		btnAnwer3 = new JButton("진행2");
		return btnAnwer3;
	}

	private JButton getBtnAnwer2() {
		btnAnwer2 = new JButton("진행1");
		return btnAnwer2;
	}

	private JButton getBtnAnwer1() {
		btnAnwer1 = new JButton("확인");
		return btnAnwer1;
	}

	private JButton getBtnExit() {
			btnExit = new JButton("종료");
		return btnExit;
	}

	private JButton getBtnOK() {     // 타입을 JButton 타입으로 변경해줌. (변경 안해도 상관은 없음)
		if(btnOK == null) {
//			btnOK = new JButton("확인");
			btnOK = new JButton();
			btnOK.setText("확인");
		}
		
		return btnOK;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T01_FlowLayout t01 = new T01_FlowLayout();
				t01.setVisible(true);
			}
		});
	}
}
