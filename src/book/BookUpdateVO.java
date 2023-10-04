package book;

public class BookUpdateVO {
	private int idx;
	private String id;
	private String name;
	private String bookname;
	private String situation;

	int getIdx() {
		return idx;
	}
	void setIdx(int idx) {
		this.idx = idx;
	}
	String getId() {
		return id;
	}
	void setId(String id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getBookname() {
		return bookname;
	}
	void setBookname(String bookname) {
		this.bookname = bookname;
	}
	String getSituation() {
		return situation;
	}
	void setSituation(String situation) {
		this.situation = situation;
	}
	@Override
	public String toString() {
		return "BookUpdateVO [idx=" + idx + ", id=" + id + ", name=" + name + ", bookname=" + bookname + ", situation="
				+ situation + "]";
	}
}
