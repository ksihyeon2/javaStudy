	package book;

public class MypageVO {
	private int idx;
	private String id;
	private String bookname;
	private int item;
	private int price;
	
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
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int pricetot) {
		this.price = pricetot;
	}
	@Override
	public String toString() {
		return "shoppingVO [idx=" + idx + ", id=" + id + ", bookname=" + bookname + ", item=" + item + ", pricetot="
				+ price + "]";
	}
}
