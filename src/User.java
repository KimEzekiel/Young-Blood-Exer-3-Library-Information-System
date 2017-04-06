import library.Book;
import library.Library;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class User{
  ///attributes///
  private String name;
  private String password;
  ArrayList<Book> borrowedBooks;
  private Library myLibrary;

  ///constants///


  ///constructor///
  public User(String name, String password, Library libName){
    this.name = name;
    this.password = password;
    this.borrowedBooks = new ArrayList<Book>();
    this.myLibrary = libName;
  }

  ///methods///
  public void borrowBook(String bookTitle){
    /*1
    put in borrowedBooks
    remove book from library
    */
    Book bookToBorrow = this.myLibrary.lendBook(bookTitle);
    if(bookToBorrow != null){//if input bookTitle is in the library's list of books
	 this.borrowedBooks.add(bookToBorrow);//abb book to user's list of borrowedBooks
	 System.out.println("Book was successfully borrowed! ^_^ ^_^ ^_^");
    }
    else{
	 System.out.println("Book not found in the library! T_T T_T T_T");
    }

  }
  public void returnBook(String bookTitle){
    Book bookFound = null;
    for (Book bookName : this.borrowedBooks){
	 if(bookName.getTitle().equals(bookTitle)){
	   bookFound = bookName;
	   break;
		}
    }
    if (bookFound != null){
	    this.myLibrary.returnToShelf(bookFound);
	    this.borrowedBooks.remove(this.borrowedBooks.indexOf(bookFound));
    	}
  }


  ///setters///
  public void setName(String name){
    this.name = name;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public void setMyLibrary(Library myLibrary){
    this.myLibrary = myLibrary;
  }

  ///getters///
  public String getName(){
    return this.name;
  }
  public String getPassWord(){
    return this.password;
  }
  public Library getMyLibrary(){
    return this.myLibrary;
  }
  public void showBorrowedBooks(){
    for(Book book: this.borrowedBooks){
	    book.showAllInfo();
    }
}
     /*file I/O*/
     public void saveBorrowedBooks(){
          try{
               File saveFile = new File("saves/libraries/BorrowedBooks.csv");
               //String line = "yea";
               String delimiter = ",";
               BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
               for(Book book: this.borrowedBooks){
                    //writer.write(title + "\n");
                    writer.write(book.getTitle() + delimiter + book.getAuthor() + delimiter + book.getYear() + delimiter + book.getType()+ delimiter+book.getId() +"\n" );
               }
               writer.close();
          }
          catch( Exception e){

          }

     }
     public void loadBorrowedBooks(){
          try{
               File saveFile = new File("saves/libraries/BorrowedBooks.csv");
               BufferedReader reader = new BufferedReader(new FileReader(saveFile));
               String line;
               String delimiter = ",";
               Book bookToLoad = null;
               //int i;
               /*book attributes*/
               //String[] bookAttributes ;
               while((line = reader.readLine()) != null){
                    //System.out.println(line);
                    String[] bookAttributes = line.split(delimiter);
                    //System.out.println(bookAttributes[0] + bookAttributes[1] + bookAttributes[2] +bookAttributes[3] );
                    //instantiate
                    bookToLoad = new Book(bookAttributes[0], bookAttributes[1],bookAttributes[2],bookAttributes[3] );
                    bookToLoad.setId(bookAttributes[4]);
                    //System.out.println(bookToLoad.getTitle() + " added to user");
                    //this.addBook(bookToLoad);
                    this.borrowedBooks.add(bookToLoad);
               }reader.close();
          }
          catch(Exception e){
               System.out.println("No books to load :(");
               //System.out.println("error");
          }

     }
}
