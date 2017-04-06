//import Book;
package library;


import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

//import java.lang.Exceptions;

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
		if(this.bookCollection.containsKey(title) &&this.bookCollection.get(title).size() > 0 ) {//find if book title exists
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
	public void saveLibrary(){
		try{
			File saveFile = new File("Library.csv");
			//String line = "yea";
			String delimiter = ",";
			BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
			for(String title: this.bookCollection.keySet()){
				//writer.write(title + "\n");
				for(Book book: this.bookCollection.get(title)){
					writer.write(book.getTitle() + delimiter + book.getAuthor() + delimiter + book.getYear() + delimiter + book.getType()+ "\n" );
				}
			}
			writer.close();
		}
		catch( Exception e){

		}
	}
	public void loadLibrary(){
		try{
			File saveFile = new File("Library.csv");
			BufferedReader reader = new BufferedReader(new FileReader(saveFile));
			String line;
			String delimiter = ",";
			Book bookToLoad = null;
			//int i;
			/*book attributes*/
			//String[] bookAttributes ;
			while((line = reader.readLine()) != null){
				System.out.println(line);
				String[] bookAttributes = line.split(delimiter);
				//System.out.println(bookAttributes[0] + bookAttributes[1] + bookAttributes[2] +bookAttributes[3] );
				//instantiate
				bookToLoad = new Book(bookAttributes[0], bookAttributes[1],bookAttributes[2],bookAttributes[3] );
				System.out.println(bookToLoad.getTitle() + " added to library");
				this.addBook(bookToLoad);
			}reader.close();
		}
		catch(Exception e){
			e.printStackTrace();
			//System.out.println("error");
		}
	}
}
