
public class Bookshelf {
	private Book[] books;
	private int count;
	final int CAPACITY = 21;

	public Bookshelf() {
		Book[] books = new Book[CAPACITY];
	}

	public int numBooks() {
		int count = 0;
		for (int i = 1; i <= 20; i++) {
			if (books[i] != null)
				count++;
		}

		return count;
	}

	// need exception
	public Book getBook(int index) {
		return books[index];
	}
	
	public Book removeBook(int index) throws CloneNotSupportedException {
		//Clones the object that needs to be returned since it will be erased 
		Book temp = (Book)books[index].Clone();
		
		for(int i = index; i < CAPACITY-1; i++) {
			books[i] = books[i+1];
		}
		
		//delete last element
		books[CAPACITY-1] = null;
		
		return temp;
	}
	
	public void addBook(int index, Book book) throws CloneNotSupportedException {
		for(int i = CAPACITY-1; i >= index; i--) {
			books[i] = books[i-1];
		}
		
		//shift everything to the right and get insert in the index
		books[index] = new Book(book.getTitle(),book.getAuthor(),book.getCondition());
		count++;
	}
	
	public void swapBooks(int index1, int index2) throws CloneNotSupportedException {
		Book temp = (Book)books[index1].Clone();
		books[index1] = (Book)books[index2].Clone();
		books[index2] = temp;
	}
	
	
}
