package book;

public class ShoppingVO {
	private int idx;
	private String id;
	private int point;
	private String buydate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	@Override
	public String toString() {
		return "mypageVO [idx=" + idx + ", id=" + id + ", point=" + point + ", buydate=" + buydate + "]";
	}
}
