
public class BookArray {
	private static Book[] libraryBooks;
	public static void main(String[] args) {
		libraryBooks = new Book[10];
		addBook(new Book("Fahrenheit 451"));
		addBook(new Book("The Thorn Birds"), 1);
		addBook(new Book("The Art of Computer Programming"), 5);
		addBook(new Book("Cracking the Coding Interview"),false);

		swapBook("The Thorn Birds", new Book("Dandelion Wine"));
		readAll(false);
	}
	
	public static void addBook(Book book) {
		libraryBooks[0] = book;
	}
	
	public static void addBook(Book book, int index) {
		try{
			libraryBooks[index] = book;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("There is no such place for the book!");
		}
	}
	
	public static void readAll(boolean excludeEmpty) {
		if(excludeEmpty) {
			for(int i=0; i<libraryBooks.length; i++) {
				if(libraryBooks[i]!=null)
					System.out.println(libraryBooks[i]);
				else 
					continue;
			}
		} else {
			for(int i=0; i<libraryBooks.length; i++) 
					System.out.println(libraryBooks[i]);
		}
	}
	
	public static void updateTitle(String newTitle, int index) {
		try {
			libraryBooks[index].setTitle(newTitle);
		}catch(NullPointerException e) {
			System.err.println("ELEMENT WITH INDEX "+ index + " IS EMPTY!");
		}	
	}
	public static void deleteBook(int index) {
		libraryBooks[index] = null;
	}
	
	public static void addBook(Book book, boolean atTheEnd) {
		if(atTheEnd) {
			try {
				for(int i= libraryBooks.length-1; i>=0; i--) { 
					if(libraryBooks[i] == null && libraryBooks[i-1]!=null ) {
						libraryBooks[i] = book;
						break;
					}
				}
			}catch(ArrayIndexOutOfBoundsException e) {  //in case array is empty(there is no books)
				libraryBooks[0] = book;
			}
			
		}else {
			for( int i= 0; i<libraryBooks.length; i++) 
				if(libraryBooks[i] == null) {
					libraryBooks[i] = book;
					break;
				}			
		}
	}
	
	public static int findByTitle(String title) {
		int i;
		for( i= 0; i<libraryBooks.length; i++) {
			if(libraryBooks[i]!=null && libraryBooks[i].getTitle().equals(title))
				return i;			
		}
		System.err.println("Boook wasn't found!");
		return -1;
	}
	
	public static void swapBook(String title, Book newBook) {
		int i = findByTitle(title);
		if(i != -1)
			addBook(newBook, i);
	}
}
	

