package book;

public class memberVO {
	private int idx;
	private String id;
	private String pw;
	private String name;
	private int age;
	private String email;
	private String phonenum;
	private String address;
	private String entry;
	
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	@Override
	public String toString() {
		return "memberVO [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", email=" + email
				+ ", phonenum=" + phonenum + ", address=" + address + ", entry=" + entry + "]";
	}
	
}
