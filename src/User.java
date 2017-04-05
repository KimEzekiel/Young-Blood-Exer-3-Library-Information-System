import java.util.ArrayList;
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
    if(this.myLibrary.lendBook(bookTitle) != null){//if input bookTitle is in the library's list of books
      this.borrowedBooks.add(this.myLibrary.lendBook(bookTitle));//abb book to user's list of borrowedBooks
      System.out.println("Book was successfully borrowed! ^_^ ^_^ ^_^");
    }
    else{
      System.out.println("Book not found in the library! T_T T_T T_T");
    }

  }
  public returnBook(String bookTitle){
    Book bookFound = null;
    int i = 0;
    for (Book bookName : borrowedBooks){
      if(borrowedBooks.get(i).getTitle().equals(bookName)){
        bookFound = borrowedBooks.get(i);
        break;
      }
    }
    this.myLibrary.returnToShelf(bookFound);
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
    return this.myLibrary
  }
}
