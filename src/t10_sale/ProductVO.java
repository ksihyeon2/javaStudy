package t10_sale;

public class ProductVO {
	private int idx;
	private String pname;
	private int price;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getpName() {
		return pname;
	}
	public void setpName(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductVO [idx=" + idx + ", pname=" + pname + ", price=" + price + "]";
	}
}
