package book;

public class BookVO {
	private int idx;
	private String category;
	private String bookname;
	private String company;
	private String writer;
	private String publication;
	private int	price;
	private String grade;
	private String review;
	private String cover;
	
	int getIdx() {
		return idx;
	}
	void setIdx(int idx) {
		this.idx = idx;
	}
	String getCategory() {
		return category;
	}
	void setCategory(String category) {
		this.category = category;
	}
	String getBookname() {
		return bookname;
	}
	void setBookname(String bookname) {
		this.bookname = bookname;
	}
	String getCompany() {
		return company;
	}
	void setCompany(String company) {
		this.company = company;
	}
	String getWriter() {
		return writer;
	}
	void setWriter(String writer) {
		this.writer = writer;
	}
	String getPublication() {
		return publication;
	}
	void setPublication(String publication) {
		this.publication = publication;
	}
	int getPrice() {
		return price;
	}
	void setPrice(int price) {
		this.price = price;
	}
	String getGrade() {
		return grade;
	}
	void setGrade(String grade) {
		this.grade = grade;
	}
	String getReview() {
		return review;
	}
	void setReview(String review) {
		this.review = review;
	}
	String getCover() {
		return cover;
	}
	void setCover(String cover) {
		this.cover = cover;
	}
	@Override
	public String toString() {
		return "BookVO [idx=" + idx + ", category=" + category + ", bookname=" + bookname + ", company=" + company
				+ ", writer=" + writer + ", publication=" + publication + ", price=" + price + ", grade=" + grade
				+ ", review=" + review + ", cover=" + cover + "]";
	}
}
