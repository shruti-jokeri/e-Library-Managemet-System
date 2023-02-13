package library.BO;

public class ViewAll {

		private int id;
		private String name,degree,phone,doi,dor,bookname;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDoi() {
			return doi;
		}
		public void setDoi(String doi) {
			this.doi = doi;
		}
		public String getDor() {
			return dor;
		}
		public void setDor(String dor) {
			this.dor = dor;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public ViewAll(int id, String name, String degree, String phone, String doi, String dor, String bookname) {
			super();
			this.id = id;
			this.name = name;
			this.degree = degree;
			this.phone = phone;
			this.doi = doi;
			this.dor = dor;
			this.bookname = bookname;
		}
		
		public ViewAll() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "ViewAll [id=" + id + ", name=" + name + ", degree=" + degree + ", phone=" + phone + ", doi=" + doi
					+ ", dor=" + dor + ", bookname=" + bookname + "]";
		}
		
}
