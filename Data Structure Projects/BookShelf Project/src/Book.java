
public class Book implements Cloneable{
	private String title;
	private String author;
	private String borrower;
	private int condition;
	
	public Book(String title, String author, int condition) {
		this.title = title;
		this.author = author;
		this.condition = condition;
		this.borrower = "";
	}


	public boolean equals(Object obj) {
		return(this == obj);
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getBorrower() {
		return borrower;
	}


	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}


	public int getCondition() {
		return condition;
	}


	public void setCondition(int condition) {
		this.condition = condition;
	}
	
	public Object Clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
