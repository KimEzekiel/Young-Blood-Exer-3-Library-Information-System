//import Book;
package library;
import java.util.ArrayList;
import java.util.HashMap;

public class Library{
	private HashMap<String, ArrayList<Book>> bookCollection;
	private String name;

	public Library(String name){
		bookCollection = new HashMap<String, ArrayList<Book>>();
		this.name = name;
	}

	public HashMap getBookCollection(){
		return this.bookCollection;
	}
	public String getName(){
		return this.name;
	}
	public void setName(){
		this.name = name;
	}
	//public
	//public Book getBook(){//returns book given a name, then removes it from
	//}
	public void showBookCollection(){
		for(String title: this.bookCollection.keySet()){
			System.out.println(title + ": " );
			System.out.println("In shelf: " +this.bookCollection.get(title).size() );
			//System.out.printl(this.bookCollection.get(title));
		}
	}


	public void addBook(Book newBook){
		//check if the newBook title exists in library
		if(!this.bookCollection.containsKey(newBook.getTitle())){	//if set of books with that title does not exists
			this.bookCollection.put(newBook.getTitle(), new ArrayList<Book>());
		}
		this.bookCollection.get(newBook.getTitle()).add(newBook);	//get array list of books with same title as newBook, add the newbook to the returned array list
		System.out.println(newBook.getTitle() + " has been added to the library.");
	}

	public Book lendBook(String title){
		Book bookToLend = null;
		if(this.bookCollection.containsKey(title)) {//find if book title exists
			bookToLend = this.bookCollection.get(title).get(this.bookCollection.get(title).size() -1);	//copy book
			this.bookCollection.get(title).remove(this.bookCollection.get(title).size() -1);//remove from library
		}return  bookToLend;
	}
	public void returnToShelf(Book returnedBook){
		if(!this.bookCollection.containsKey(returnedBook.getTitle())){ //return a book not previously added in the library
			this.addBook(returnedBook);
		}else{
			this.bookCollection.get(returnedBook.getTitle()).add(returnedBook);
		}
	}
}