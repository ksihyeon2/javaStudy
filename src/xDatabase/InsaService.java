package xDatabase;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;

//	오늘 날짜 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance();
		vo.setStrYY(cal.get(Calendar.YEAR) + ""); 
		vo.setStrMM(cal.get(Calendar.MONTH+1) + ""); 	 // 달은 무조건 한 달 적게 나오므로 1을 더해줘야함
		vo.setStrDD(cal.get(Calendar.DATE) + ""); 		
		return vo;
	}
}
