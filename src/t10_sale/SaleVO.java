package t10_sale;

public class SaleVO {
	private int idx;
	private String sName;
	private int ea;
	private String sDate;
	
	private int salePrice;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	
	@Override
	public String toString() {
		return "SaleVO [idx=" + idx + ", sName=" + sName + ", ea=" + ea + ", sDate=" + sDate + ", salePrice=" + salePrice
				+ "]";
	}
}
