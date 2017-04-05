import java.util.ArrayList;
import library.Library;
import library.Book;
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
    for (Book bookName : borrowedBooks){
      if(bookName.getTitle().equals(bookTitle)){
        bookFound = bookName;
        break;
      }
    }
    if(bookFound != null ){
         this.myLibrary.returnToShelf(bookFound);
         this.borrowedBooks.remove(this.borrowedBooks.indexOf(bookFound));
    }
    else System.out.println("You don't have that book");
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
}
